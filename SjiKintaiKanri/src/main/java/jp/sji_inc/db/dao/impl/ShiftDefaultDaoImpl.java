/**
 *
 */
package jp.sji_inc.db.dao.impl;

import jp.sji_inc.db.dao.ShiftDefaultDao;
import jp.sji_inc.db.entity.base.ShiftDefault;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author z1j7663
 *
 */
@Repository
public class ShiftDefaultDaoImpl implements ShiftDefaultDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(ShiftDefaultDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ShiftDefault findById(String shiftNo) {
		return (ShiftDefault)sessionFactory.getCurrentSession()
				.get(ShiftDefault.class, shiftNo);
	}

}
