/**
 *
 */
package jp.sji_inc.db.dao;

import java.util.List;

import jp.sji_inc.common.LabelBean;
import jp.sji_inc.db.entity.base.Sagyo;

import org.hibernate.criterion.Order;

/**
 * @author z1j7663
 *
 */
public interface SagyoDao {

	/**
	 * 全件検索
	 * @param order
	 * @return
	 */
	public List<Sagyo> findAll(Order order);

	/**
	 * ｺﾝﾎﾞ検索
	 * @return
	 */
	public List<LabelBean> findCombo();
}
