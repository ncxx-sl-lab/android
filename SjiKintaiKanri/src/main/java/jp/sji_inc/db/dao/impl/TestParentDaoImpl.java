/**
 *
 */
package jp.sji_inc.db.dao.impl;

import java.util.List;

import jp.sji_inc.db.dao.TestParentDao;
import jp.sji_inc.db.entity.base.TestParent;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author z1j7663
 *
 */
@Repository
public class TestParentDaoImpl implements TestParentDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(TestParentDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void findById(TestParent testParent) {
		LOGGER.debug("★★★★★★findById called★★★★★★");
		// TODO 自動生成されたメソッド・スタブ
		//TestParent obj = (TestParent) sessionFactory.getCurrentSession().get(TestParent.class, 1);
		/*
		TestChild cObj = (TestChild) sessionFactory.getCurrentSession().get(TestParent.class, 1);
		LOGGER.debug(cObj.getcId());
		LOGGER.debug(cObj.getName());
		*/
		//List objList = sessionFactory.getCurrentSession().createQuery("from TestChild ").list();
		List objList = sessionFactory.getCurrentSession().createQuery("from TestParent tp left join tp.testChild as testChild ").list();

		int a = 0;
		int b = 0;
	}

}
