package jp.sji_inc.db.dao;

import java.util.List;
import java.util.Map;

import jp.sji_inc.db.entity.KintaiSum;
import jp.sji_inc.db.entity.base.Kintai;

public interface KintaiDao {

	/**
	 *
	 * @param empNo
	 * @param kintaiDate
	 * @return
	 */
	public Kintai findById(String empNo, String kintaiDate);

	/**
	 * 検索
	 * @param kintai 勤怠エンティティ
	 * @return Kintai
	 */
	public Kintai findById(Kintai kintai);

	/**
	 * 検索 月別
	 * @param empNo
	 * @param month
	 * @return
	 */
	public List<Kintai> findByMonth(String empNo, String month);

	/**
	 * 検索 月別　（日別のマップで取得）
	 * @param empNo
	 * @param month
	 * @return
	 */
	public Map<String, Kintai> findMapByMonth(String empNo, String month);

	/**
	 * 月分追加
	 * @param empNo
	 * @param kintaiMonth
	 */
	public void addMonth(String empNo, String kintaiMonth);

	/**
	 * 保存
	 * @param kintai 勤怠エンティティ
	 * @return Kintai
	 */
	public Kintai save(Kintai kintai);

	/**
	 * 保存or更新
	 * @param kintai
	 */
	public void saveOrUpdate(Kintai kintai);

	/**
	 * 勤怠合計時間取得
	 * @param empNo
	 * @param kintaiMonth
	 * @return
	 */
	public List<KintaiSum> findKintaiSum(String empNo, String kintaiMonth);
}
