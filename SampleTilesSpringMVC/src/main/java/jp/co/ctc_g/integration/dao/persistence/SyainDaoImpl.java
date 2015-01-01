package jp.co.ctc_g.integration.dao.persistence;

import java.util.ArrayList;
import java.util.List;

import jp.co.ctc_g.business.dao.SyainDao;
import jp.co.ctc_g.business.domain.CmbBox;
import jp.co.ctc_g.business.domain.Syain;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SyainDaoImpl implements SyainDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Syain findLoginSyain(String syain_no) {
		@SuppressWarnings("unchecked")
		List<Syain> r = (List<Syain>) hibernateTemplate.find("from Syain where SyainNo = ? and DelFlg = '0'", syain_no);
		if (r.size() != 1)
			return null;
		return r.get(0);
	}

	public List<Syain> findSyain() {
		@SuppressWarnings("unchecked")
		List<Syain> l = (List<Syain>) hibernateTemplate.find("from Syain order by SyainNo");
		if (l.size() == 0)
			return null;
		return l;
//		return (List<Syain>)new ArrayList<Syain>(l);
	}

	public List<Syain> findTantoSyain(String syain_no) {
		@SuppressWarnings("unchecked")
		List<Syain> l = hibernateTemplate.find("from Syain where SyainNo = ? or DelFlg = '0' order by SyainNo",
				syain_no);
		if (l.size() == 0)
			return null;
		return l;
//		return (List<Syain>)new ArrayList<Syain>(l);
	}

	public List<Syain> findSyainLstBySearch(Syain syain) {
		// 注意！現状と削除フラグとOTLフラグの内容が変わる
		DetachedCriteria criteria = DetachedCriteria.forClass(Syain.class, "Syain");
		if (syain.getSyainNo() != null && syain.getSyainNo().trim().length() != 0)
			criteria.add(Restrictions.eq("SyainNo", syain.getSyainNo()));
		if (syain.getSyainName() != null && syain.getSyainName().trim().length() != 0)
			criteria.add(Restrictions.eq("SyainName", syain.getSyainName()));
		if (syain.getBushoName() != null && syain.getBushoName().trim().length() != 0)
			criteria.add(Restrictions.eq("Busho.BushoName", syain.getBushoName()));
		if (syain.getGroupCd() != null && syain.getGroupCd().trim().length() != 0)
			criteria.add(Restrictions.eq("Group.GroupCd", syain.getGroupCd()));
		if (syain.getKengenCd() != null && syain.getKengenCd().trim().length() != 0)
			criteria.add(Restrictions.eq("Kengen.KengenCd", syain.getKengenCd()));
		if (syain.getDelFlg() != null && syain.getDelFlg().trim().length() != 0)
			criteria.add(Restrictions.eq("DelFlg", syain.getDelFlg()));
		if (syain.getOtlFlg() != null && syain.getOtlFlg().trim().length() != 0)
			criteria.add(Restrictions.eq("OtlFlg", syain.getOtlFlg()));
		criteria.addOrder(Order.asc("SyainNo"));
		@SuppressWarnings("unchecked")
		List<Syain> l = hibernateTemplate.findByCriteria(criteria);
		if (l.size() == 0)
			return null;
		return l;
//		return (List<Syain>)new ArrayList<Syain>(l);
	}

	public Syain findSyainBySyainCd(String syain_no) {
		if (syain_no == null || syain_no == "")
			return null;
		@SuppressWarnings("unchecked")
		List<Syain> r = (List<Syain>) hibernateTemplate.find("from Syain where SyainNo = ?", syain_no);
		if (r.size() != 1)
			return null;
		return r.get(0);
	}

	public List<Syain> findSyainByProject(String pj_cd) {
		if (pj_cd == null || pj_cd == "")
			return null;
		@SuppressWarnings("unchecked")
		List<Syain> r = (List<Syain>) hibernateTemplate
				.find("from Syain where DelFlg = '0' and Group.GroupCd in (select s.GroupCode from ProjectSel as s where s.ProjectCode = ?) order by SyainNo",
						pj_cd);
		if (r.isEmpty())
			return null;
		return r;
//		return (List<Syain>)new ArrayList<Syain>(r);
	}

	public List<Syain> findSyainByGroup(String group_cd) {
		@SuppressWarnings("unchecked")
		List<Syain> l = hibernateTemplate.find("from Syain where Group.GroupCd = ? order by SyainNo", group_cd);
		if (l.size() == 0)
			return null;
		return l;
//		return (List<Syain>)new ArrayList<Syain>(l);
	}

	public int getSyainCount(String syain_no) {
		@SuppressWarnings("unchecked")
		List<Long> r = (List<Long>) hibernateTemplate.find("select count(SyainNo) from Syain where SyainNo = ?",
				syain_no);
		return r.get(0).intValue();
	}

	public int insert(Syain syain) {
		System.out.println(syain.getBushoCd());
		hibernateTemplate.save(syain);
		hibernateTemplate.flush();
		return 1; // 現状の戻り値不明
	}

	public int update(Syain syain, String kengen_flg) {

		@SuppressWarnings("unchecked")
		List<Syain> r = (List<Syain>) hibernateTemplate.find("from Syain where SyainNo = ? and DelFlg = '0'", syain.getSyainNo());
		if (r.size() != 1)
			return 0; // 現状の戻り値不明
		Syain syain_db = r.get(0);

		syain_db.setPassword(syain.getPassword());
		if (kengen_flg.equals("1")) { // 管理者のみ更新
			syain_db.setSyainName(syain.getSyainName());
			syain_db.setBushoCd(syain.getBushoCd());
			syain_db.setGroupCd(syain.getGroupCd());
			syain_db.setKengenCd(syain.getKengenCd());
			syain_db.setBusho(syain.getBusho());
			syain_db.setGroup(syain.getGroup());
			syain_db.setKengen(syain.getKengen());
			syain_db.setDelFlg(syain.getDelFlg());
			syain_db.setOtlFlg(syain.getOtlFlg());
		}
		hibernateTemplate.update(syain_db);
		hibernateTemplate.flush();
		return 1; // 現状の戻り値不明
	}

	public int delete(String syain_no) {
		Syain s = new Syain();
		s.setSyainNo(syain_no);
		hibernateTemplate.delete(s);
		hibernateTemplate.flush();
		return 1; // 現状の戻り値不明
	}

	public List<Syain> findSyainInfoBySyainNo(String syain_no) {
		if (syain_no == null || syain_no == "")
			return null;
		@SuppressWarnings("unchecked")
		List<Syain> r = (List<Syain>) hibernateTemplate.find("from Syain where SyainNo = ?", syain_no);
		if (r.size() != 1)
			return null;
		return r;
	}

	public List<CmbBox> findCmbBoxByGroup(String groupCd) {
		List<Syain> sl = this.findSyainByGroup(groupCd);
		List<CmbBox> l = new ArrayList<CmbBox>();
		l.add(new CmbBox("", ""));
		for (Syain s : sl) {
			CmbBox c = new CmbBox(s.getSyainNo(), s.getSyainName());
			l.add(c);
		}
		return l;
	}
}
