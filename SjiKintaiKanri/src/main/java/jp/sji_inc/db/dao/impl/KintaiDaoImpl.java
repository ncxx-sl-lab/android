package jp.sji_inc.db.dao.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.sji_inc.db.dao.KintaiDao;
import jp.sji_inc.db.entity.KintaiSum;
import jp.sji_inc.db.entity.base.Kintai;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class KintaiDaoImpl implements KintaiDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(KintaiDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	@Override
	public Kintai findById(String empNo, String kintaiDate) {
		List l = sessionFactory.getCurrentSession()
				.createQuery(" from Kintai where empNo=:empNo and kintaiDate=:kintaiDate")
				.setString("empNo", empNo)
				.setString("kintaiDate", kintaiDate)
				.list();
		return (Kintai) (l.isEmpty() ? null : l.get(0));
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Kintai> findByMonth(String empNo, String month) {
		List<Kintai> l = sessionFactory.getCurrentSession()
				.createCriteria(Kintai.class)
				.add(Restrictions.eq("empNo", empNo))
				.add(Restrictions.eq("kintaiMonth", month))
				.addOrder(Order.asc("kintaiDate"))
				.list();
		if (l.size() < 1) {
			this.addMonth(empNo, month);
			l = sessionFactory.getCurrentSession()
					.createCriteria(Kintai.class)
					.add(Restrictions.eq("empNo", empNo))
					.add(Restrictions.eq("kintaiMonth", month))
					.addOrder(Order.asc("kintaiDate"))
					.list();
		}
		return l;
	}

	@Override
	public Kintai findById(Kintai kintai) {
		return (Kintai) sessionFactory.getCurrentSession().get(Kintai.class, kintai);
	}

	@Transactional
	@Override
	public void addMonth(String empNo, String kintaiMonth) {
		try {
			SimpleDateFormat  sfdMonth = new SimpleDateFormat("yyyyMM");
			SimpleDateFormat  sfdDay = new SimpleDateFormat("yyyyMMdd");
			Date d = sfdMonth.parse(kintaiMonth);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			int matu = cal.getActualMaximum(Calendar.DATE);
			for (int i = 1; i < matu+1; i++) {
				String strM = sfdMonth.format(cal.getTime());
				String strD = sfdDay.format(cal.getTime());
				Kintai k = this.findById(empNo, strD);
				if (k == null) {
					k = new Kintai();
					k.setEmpNo(empNo);
					k.setKintaiDate(strD);
					k.setKintaiMonth(strM);
					this.save(k);
				}
				cal.add(Calendar.DATE, 1);
			}
		} catch (Exception e) {

		}
	}

	@Override
	public Kintai save(Kintai kintai) {
		return (Kintai) sessionFactory.getCurrentSession().save(kintai);
//		Transaction trans = sessionFactory.getCurrentSession().beginTransaction();
//		Kintai k = (Kintai) sessionFactory.getCurrentSession().save(kintai);
//		trans.commit();
//		return k;
	}

	@Override
	public Map<String, Kintai> findMapByMonth(String empNo, String month) {
		List<Kintai> kintaiList = this.findByMonth(empNo, month);
		Map<String, Kintai> map = new HashMap<String, Kintai>();
		for (Kintai kintai : kintaiList) {
			map.put(kintai.getKintaiDate(), kintai);
		}
		return map;
	}

	@Override
	public void saveOrUpdate(Kintai kintai) {
		sessionFactory.getCurrentSession().saveOrUpdate(kintai);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<KintaiSum> findKintaiSum(String empNo, String kintaiMonth) {
		StringBuffer sb = new StringBuffer();
		sb.append("select k.projectNo, ksa.sagyoCd ")
			.append(",sum(k.hours * ksa.normalAnbunRitu / 100) ")
			.append(",sum(k.overtime * ksa.overAnbunRitu / 100) ")
			.append(",sum(k.lateOvertime * ksa.lateOverAnbunRitu / 100) ")
			.append("from Kintai k left join k.kintaiSagyoAnbun as ksa ")
			.append("group by k.projectNo, ksa.sagyoCd");
		List l = sessionFactory.getCurrentSession()
						.createQuery(sb.toString())
						.list();

		List<KintaiSum> ret = new ArrayList<KintaiSum>();
		for (int i = 0; i < l.size(); i++) {
			Object[] o = (Object[])l.get(i);
			if (o[0] == null) {
				continue;
			}
			KintaiSum ks = new KintaiSum();
			ks.setProjectNo((String)o[0]);
			ks.setSagyoCd((String)o[1]);
			ks.setNormal((BigDecimal)o[2]);
			ks.setOver((BigDecimal)o[3]);
			ks.setLateOver((BigDecimal)o[4]);
			ret.add(ks);
		}
		return ret;
	}

}
