package jp.sji_inc.db.dao.impl;

import java.util.List;

import jp.sji_inc.common.StringUtil;
import jp.sji_inc.db.dao.EmpDao;
import jp.sji_inc.db.entity.base.Emp;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmpDaoImpl implements EmpDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(EmpDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from EmpEntity").list();
	}

	@Transactional(readOnly=true)
	@Override
	public Emp findById(String empNo) {
		return (Emp)sessionFactory.getCurrentSession().get(Emp.class, empNo);
	}

	@Override
	public void update(Emp emp) {
		sessionFactory.getCurrentSession().update(emp);
	}

	@Override
	public void save(Emp emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	@Override
	public void delete(Emp emp) {
		sessionFactory.getCurrentSession().delete(emp);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> aimaiSearch(String empNo, String empNameLast,
			String empNameFirst, String empNameLastFuriKana,
			String empNameFirstFuriKana, String email, String tel) {

		Criteria c = sessionFactory.getCurrentSession()
				.createCriteria(Emp.class);
		if (!StringUtil.isNull(empNo)) {
			c.add(Restrictions.like("empNo", "%"+empNo+"%"));
		}
		if (!StringUtil.isNull(empNameLast)) {
			c.add(Restrictions.like("empNameLast", "%"+empNameLast+"%"));
		}
		if (!StringUtil.isNull(empNameFirst)) {
			c.add(Restrictions.like("empNameFirst", "%"+empNameFirst+"%"));
		}
		if (!StringUtil.isNull(empNameLastFuriKana)) {
			c.add(Restrictions.like("empNameLastFuriKana", "%"+empNameLastFuriKana+"%"));
		}
		if (!StringUtil.isNull(empNameFirstFuriKana)) {
			c.add(Restrictions.like("empNameFirstFuriKana", "%"+empNameFirstFuriKana+"%"));
		}
		if (!StringUtil.isNull(email)) {
			c.add(Restrictions.like("email", "%"+email+"%"));
		}
		if (!StringUtil.isNull(tel)) {
			c.add(Restrictions.like("tel", "%"+tel+"%"));
		}

		List<Emp> l = c.addOrder(Order.asc("empNo")).list();

		return l;
	}

}
