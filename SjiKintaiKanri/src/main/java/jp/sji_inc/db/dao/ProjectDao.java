/**
 *
 */
package jp.sji_inc.db.dao;

import java.util.List;

import jp.sji_inc.common.LabelBean;
import jp.sji_inc.db.entity.base.Project;

import org.hibernate.criterion.Order;

/**
 * @author z1j7663
 *
 */
public interface ProjectDao {

	/**
	 * 全件検索
	 * @return
	 */
	public List<Project> findAll(Order order);

	/**
	 * ｺﾝﾎﾞ用検索
	 * @param empNo
	 * @param kintaiMonth
	 * @return
	 */
	public List<LabelBean> findCombo();

}
