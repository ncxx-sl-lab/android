/**
 *
 */
package jp.sji_inc.db.dao;

import jp.sji_inc.db.entity.base.ExcelTemplate;

/**
 * @author z1j7663
 *
 */
public interface ExcelTemplateDao {

	/**
	 * エクセルテンプレート取得
	 * @param kintaiMonth
	 * @return
	 */
	public ExcelTemplate findById(String kintaiMonth);

}
