/**
 *
 */
package jp.sji_inc.db.dao;

import java.util.List;

import jp.sji_inc.db.entity.base.KintaiSagyoAnbun;

/**
 * @author z1j7663
 *
 */
public interface KintaiSagyoAnbunDao {

	/**
	 * 検索
	 * @param kintai 勤務時間エンティティ
	 * @return Kintai
	 */
	public KintaiSagyoAnbun findById(KintaiSagyoAnbun kintaiSagyoAnbun);


	/**
	 * 保存
	 * @param kintai 勤務時間エンティティ
	 * @return Kintai
	 */
	public KintaiSagyoAnbun save(KintaiSagyoAnbun kintaiSagyoAnbun);

	/**
	 * 保存or更新
	 * @param kintai 勤務時間エンティティ
	 */
	public void saveOrUpdate(KintaiSagyoAnbun kintaiSagyoAnbun);

	/**
	 * 削除
	 * @param kintaiSagyoAnbun
	 */
	public void delete(KintaiSagyoAnbun kintaiSagyoAnbun);

	/**
	 * 削除
	 * @param kintaiSagyoAnbunList
	 */
	public void delete(List<KintaiSagyoAnbun> kintaiSagyoAnbunList);

	/**
	 * 削除
	 * @param empNo
	 * @param kintaiDate
	 */
	public void delete(String empNo, String kintaiDate);
}
