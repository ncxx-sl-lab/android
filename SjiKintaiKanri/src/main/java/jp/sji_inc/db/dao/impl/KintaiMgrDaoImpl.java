/**
 *
 */
package jp.sji_inc.db.dao.impl;

import java.util.List;

import jp.sji_inc.db.dao.KintaiMgrDao;
import jp.sji_inc.db.entity.base.KintaiMgr;

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
public class KintaiMgrDaoImpl implements KintaiMgrDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(KintaiMgrDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(KintaiMgr kintaiMgr) {
		sessionFactory.getCurrentSession().saveOrUpdate(kintaiMgr);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KintaiMgr> findByMonth(String empNo, String kintaiMonth) {
		List<KintaiMgr> l = sessionFactory.getCurrentSession()
				.createCriteria(KintaiMgr.class)
				.add(Restrictions.eq("empNo", empNo))
				.add(Restrictions.eq("kintaiMonth", kintaiMonth))
				.addOrder(Order.asc("no"))
				.list();
		return l;
	}

	@Override
	public KintaiMgr findById(KintaiMgr kintaiMgr) {
		return (KintaiMgr)sessionFactory.getCurrentSession().get(KintaiMgr.class, kintaiMgr);
	}

}
