/**
 *
 */
package jp.sji_inc.db.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.sji_inc.common.DateUtil;
import jp.sji_inc.common.LabelBean;
import jp.sji_inc.db.dao.ShiftDao;
import jp.sji_inc.db.dao.ShiftTableDao;
import jp.sji_inc.db.entity.base.Shift;
import jp.sji_inc.db.entity.base.ShiftTable;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author z1j7663
 *
 */
@Repository
public class ShiftDaoImpl implements ShiftDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(ShiftDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ShiftTableDao shiftTableDao;

	@Override
	public Shift findById(Shift shift) {
		Object obj = sessionFactory.getCurrentSession().get(Shift.class, shift);
		return (Shift)obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shift> findAll(Order order) {
		List<Shift> l = sessionFactory.getCurrentSession().createCriteria(Shift.class).addOrder(order).list();
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shift> findByMonth(String empNo, String kintaiMonth) {
		List<Shift> l = sessionFactory.getCurrentSession()
				.createCriteria(Shift.class)
				.add(Restrictions.eq("empNo", empNo))
				.add(Restrictions.eq("kintaiMonth", kintaiMonth))
				.addOrder(Order.asc("shiftNo"))
				.list();
		if (l.size() < 1) {
			Shift shift = new Shift();
			shift.setEmpNo(empNo);
			shift.setKintaiMonth(kintaiMonth);
			shift.setShiftNo("1");
			shift.setStartTime("09:00");
			shift.setEndTime("17:45");
			shift.setHankyuKbn("12:00");
			shift.setRest1Start("12:00");
			shift.setRest1End("13:00");
			shift.setRest2Start("17:45");
			shift.setRest2End("18:00");
			this.saveOrUpdate(shift);

			l = sessionFactory.getCurrentSession()
					.createCriteria(Shift.class)
					.add(Restrictions.eq("empNo", empNo))
					.add(Restrictions.eq("kintaiMonth", kintaiMonth))
					.addOrder(Order.asc("shiftNo"))
					.list();
		}
		return l;
	}

	@Override
	public List<LabelBean> findCombo(String empNo, String kintaiMonth) {
		List<LabelBean> lb = new ArrayList<LabelBean>();
		List<Shift> l = this.findByMonth(empNo, kintaiMonth);
		for (Shift s : l) {
			lb.add(new LabelBean(s.getShiftNo() + " " + s.getStartTime() + "-" + s.getEndTime(), s.getShiftNo()));
		}
		return lb;
	}

	@Override
	public void saveOrUpdate(Shift shift) {
		this.setShift(shift);
		sessionFactory.getCurrentSession().saveOrUpdate(shift);
	}

	/**
	 * シフト時間を計算して値を設定する
	 * @param shift
	 */
	private void setShift(Shift shift) {

		String t = shift.getRest2End();
		t = DateUtil.add(t, 1.5);
		shift.setRest3Start(t);
		t = DateUtil.add(t, 0.5);
		shift.setRest3End(t);
		t = DateUtil.add(t, 2);
		shift.setRest4Start(t);
		t = DateUtil.add(t, 0.25);
		shift.setRest4End(t);
		t = DateUtil.add(t, 4.25);
		shift.setRest5Start(t);
		t = DateUtil.add(t, 0.5);
		shift.setRest5End(t);
		t = DateUtil.add(t, 5.5);
		shift.setRest6Start(t);
		t = DateUtil.add(t, 0.5);
		shift.setRest6End(t);

		shiftTableDao.saveOrUpdate(shift);
		ShiftTable st = shiftTableDao.findById(shift, shift.getEndTime());
		shift.setDayHours(DateUtil.parse(st.getHours().doubleValue()));
		BigDecimal hyoujun = new BigDecimal(7.75);
		shift.setTyouka(st.getHours().subtract(hyoujun));

	}

	@Override
	public void delete(Shift shift) {
		sessionFactory.getCurrentSession().delete(shift);
	}

}
