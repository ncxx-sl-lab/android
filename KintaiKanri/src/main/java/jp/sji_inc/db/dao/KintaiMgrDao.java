/**
 *
 */
package jp.sji_inc.db.dao;

import java.util.List;

import jp.sji_inc.db.entity.base.KintaiMgr;

/**
 * @author z1j7663
 *
 */
public interface KintaiMgrDao {

	/**
	 * シフト保存・更新
	 * @param shift
	 */
	public void saveOrUpdate(KintaiMgr kintaiMgr);

	/**
	 * 月別取得
	 * @param empNo
	 * @param kintaiMonth
	 * @return
	 */
	public List<KintaiMgr> findByMonth(String empNo, String kintaiMonth);

	/**
	 * プライマリー検索
	 * @param kintaiMgr
	 * @return
	 */
	public KintaiMgr findById(KintaiMgr kintaiMgr);

}
