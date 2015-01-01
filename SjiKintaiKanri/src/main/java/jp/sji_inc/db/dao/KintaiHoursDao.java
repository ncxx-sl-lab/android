/**
 *
 */
package jp.sji_inc.db.dao;

import jp.sji_inc.db.entity.base.KintaiHours;

/**
 * @author z1j7663
 *
 */
public interface KintaiHoursDao {

	/**
	 * 検索
	 * @param kintai 勤務時間エンティティ
	 * @return Kintai
	 */
	public KintaiHours findById(KintaiHours kintaiHours);


	/**
	 * 保存
	 * @param kintai 勤務時間エンティティ
	 * @return Kintai
	 */
	public KintaiHours save(KintaiHours kintaiHours);

	/**
	 * 保存or更新
	 * @param kintai 勤務時間エンティティ
	 */
	public void saveOrUpdate(KintaiHours kintaiHours);
}
