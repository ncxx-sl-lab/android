/**
 *
 */
package jp.sji_inc.db.dao;

import jp.sji_inc.db.entity.base.ShiftDefault;

/**
 * @author z1j7663
 *
 */
public interface ShiftDefaultDao {

	/**
	 * プライマリー検索
	 * @param shiftDefault
	 * @return
	 */
	public ShiftDefault findById(String shiftNo);

}
