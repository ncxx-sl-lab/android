/**
 *
 */
package jp.sji_inc.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import jp.sji_inc.common.LabelBean;
import jp.sji_inc.db.dao.KyukaDao;
import jp.sji_inc.db.entity.base.Kyuka;

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
public class KyukaDaoImpl implements KyukaDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(KyukaDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Kyuka> findAll(Order order) {
		List<Kyuka> l = sessionFactory.getCurrentSession()
				.createCriteria(Kyuka.class)
				.addOrder(order)
				.list();
		return l;
	}

	@Override
	public List<LabelBean> findCombo() {
		List<LabelBean> lb = new ArrayList<LabelBean>();
		List<Kyuka> l = this.findAll(Order.asc("no"));
		for (Kyuka k : l) {
			lb.add(new LabelBean(k.getName(), k.getNo()));
		}
		return lb;
	}

}
