/**
 *
 */
package jp.sji_inc.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import jp.sji_inc.common.LabelBean;
import jp.sji_inc.db.dao.ProjectDao;
import jp.sji_inc.db.entity.base.Project;

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
public class ProjectDaoImpl implements ProjectDao {

	/** ロガー */
	private static final Logger LOGGER = Logger.getLogger(ProjectDaoImpl.class);

	/** セッション */
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findAll(Order order) {
		List<Project> l = sessionFactory.getCurrentSession()
				.createCriteria(Project.class)
				.addOrder(order)
				.list();
		return l;
	}

	@Override
	public List<LabelBean> findCombo() {
		List<LabelBean> lb = new ArrayList<LabelBean>();
		List<Project> l = this.findAll(Order.asc("projectNo"));
		for (Project p : l) {
			lb.add(new LabelBean(p.getProjectName(), p.getProjectNo()));
		}
		return lb;
	}

}
