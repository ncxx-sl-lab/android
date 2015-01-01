/**
 *
 */
package jp.sji_inc.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import jp.sji_inc.common.LabelBean;
import jp.sji_inc.db.dao.SagyoDao;
import jp.sji_inc.db.entity.base.Sagyo;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author z1j7663
 *
 */
@Repository
public class SagyoDaoImpl implements SagyoDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(SagyoDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Sagyo> findAll(Order order) {
		List<Sagyo> l = sessionFactory.getCurrentSession()
				.createCriteria(Sagyo.class)
				.addOrder(Order.asc("sagyoCd"))
				.list();
		return l;
	}

	@Override
	public List<LabelBean> findCombo() {
		List<LabelBean> lb = new ArrayList<LabelBean>();
		List<Sagyo> l = this.findAll(Order.asc("sagyoCd"));
		for (Sagyo s : l) {
			lb.add(new LabelBean(s.getSagyoName(), s.getSagyoCd()));
		}
		return lb;
	}

}
