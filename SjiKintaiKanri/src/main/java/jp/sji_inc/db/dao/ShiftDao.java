/**
 *
 */
package jp.sji_inc.db.dao;

import java.util.List;

import jp.sji_inc.common.LabelBean;
import jp.sji_inc.db.entity.base.Shift;

import org.hibernate.criterion.Order;

/**
 * @author z1j7663
 *
 */
public interface ShiftDao {

	/**
	 * 全件検索
	 * @param shift
	 * @return
	 */
	public List<Shift> findAll(Order order);

	/**
	 * 検索
	 * @param kintai シフトエンティティ
	 * @return Kintai
	 */
	public Shift findById(Shift shift);

	/**
	 * 月別検索
	 * @param empNo
	 * @param kintaiMonth
	 * @return
	 */
	public List<Shift> findByMonth(String empNo, String kintaiMonth);

	/**
	 * ｺﾝﾎﾞ用検索
	 * @param empNo
	 * @param kintaiMonth
	 * @return
	 */
	public List<LabelBean> findCombo(String empNo, String kintaiMonth);

	/**
	 * シフト保存・更新
	 * @param shift
	 */
	public void saveOrUpdate(Shift shift);

	/**
	 * 削除
	 * @param shift
	 */
	public void delete(Shift shift);

}
