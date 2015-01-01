/**
 *
 */
package jp.sji_inc.db.dao.impl;

import jp.sji_inc.db.dao.KintaiHoursDao;
import jp.sji_inc.db.entity.base.KintaiHours;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author z1j7663
 *
 */
@Repository
public class KintaiHoursDaoImpl implements KintaiHoursDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(KintaiHoursDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public KintaiHours findById(KintaiHours kintaiHours) {
		return (KintaiHours)sessionFactory.getCurrentSession().get(KintaiHours.class, kintaiHours);
	}

	@Override
	public KintaiHours save(KintaiHours kintaiHours) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void saveOrUpdate(KintaiHours kintaiHours) {
		sessionFactory.getCurrentSession()
					.saveOrUpdate(kintaiHours);
	}

}
