/**
 *
 */
package jp.sji_inc.db.dao.impl;

import jp.sji_inc.db.dao.DeptDao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author z1j7663
 *
 */
public class DeptDaoImpl implements DeptDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(DeptDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

}
