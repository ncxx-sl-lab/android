/**
 *
 */
package jp.sji_inc.db.dao.impl;

import java.util.List;

import jp.sji_inc.db.dao.ExcelTemplateDao;
import jp.sji_inc.db.entity.base.ExcelTemplate;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author z1j7663
 *
 */
@Repository
public class ExcelTemplateDaoImpl implements ExcelTemplateDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(ExcelTemplateDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public ExcelTemplate findById(String kintaiMonth) {
		List<ExcelTemplate> l = sessionFactory.getCurrentSession()
			.createCriteria(ExcelTemplate.class)
			.add(Restrictions.le("kintaiMonthFrom", kintaiMonth))
			.add(Restrictions.ge("kintaiMonthTo", kintaiMonth))
			.list();
		return (l.isEmpty() ? null : l.get(0));
	}

}
