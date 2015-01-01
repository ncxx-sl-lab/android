/**
 *
 */
package jp.sji_inc.db.dao;

import java.util.List;
import java.util.Map;

import jp.sji_inc.db.entity.base.Shift;
import jp.sji_inc.db.entity.base.ShiftTable;

/**
 * @author z1j7663
 *
 */
public interface ShiftTableDao {

	/**
	 * 月別検索
	 * @param empNo
	 * @param kintaiMonth
	 * @return
	 */
	public List<ShiftTable> findByMonth(String empNo, String kintaiMonth, String shiftNo);


	/**
	 * 月別検索(キーのマップ)
	 * @param empNo
	 * @param kintaiMonth
	 * @param shiftNo
	 * @return
	 */
	public Map<String, ShiftTable> findByMonthMap(String empNo, String kintaiMonth, String shiftNo);

	/**
	 * 月別検索(キーのマップ)
	 * @param shift
	 * @return
	 */
	public Map<String, ShiftTable> findByMonthMap(Shift shift);

	/**
	 * プライマリー検索
	 * @param shiftTable
	 * @return
	 */
	public ShiftTable findById(ShiftTable shiftTable);

	/**
	 * プライマリー検索
	 * @param shiftTable
	 * @return
	 */
	public ShiftTable findById(ShiftTable shiftTable, String hh_mm);

	/**
	 * プライマリー検索
	 * @param shiftTable
	 * @return
	 */
	public ShiftTable findById(Shift shift, String hh_mm);

	/**
	 * シフト保存・更新
	 * @param shiftTable
	 */
	public void saveOrUpdate(ShiftTable shiftTable);

	/**
	 * シフト保存・更新
	 * @param shift
	 */
	public void saveOrUpdate(Shift shift);

}
