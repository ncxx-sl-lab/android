/**
 *
 */
package jp.sji_inc.service;

import jp.sji_inc.action.form.JqGridForm;
import jp.sji_inc.action.form.KintaiCopyForm;
import jp.sji_inc.action.form.KintaiForm;
import jp.sji_inc.action.form.KintaiGridForm;
import jp.sji_inc.action.form.KintaiGridSaveForm;
import jp.sji_inc.action.form.KintaiMgrSaveForm;
import jp.sji_inc.action.form.KintaiMgrSearchForm;
import jp.sji_inc.action.form.KintaiSagyoAnbunSaveForm;
import jp.sji_inc.action.form.KintaiShiftDelForm;
import jp.sji_inc.action.form.KintaiShiftSaveForm;
import jp.sji_inc.db.entity.base.Kintai;

/**
 * @author kyon
 *
 */
public interface KintaiService {

	/**
	 * 勤怠初期表示
	 * @param kintaiForm
	 */
	public void kintaiShow(KintaiForm kintaiForm);

	/**
	 * 勤怠グリッド取得
	 * @param month 月
	 * @return JqGridForm
	 */
	public JqGridForm getKintaiGrid(String empNo, String month);

	/**
	 * 勤怠保存
	 * @param kintaiGridSaveForm
	 */
	public Kintai saveKintaiGrid(KintaiGridSaveForm kintaiGridSaveForm);

	/**
	 * 作業按分グリッド取得
	 * @param empNo
	 * @param kintaiDate
	 */
	public JqGridForm getKintaiSagyoAnbunGrid(String empNo, String kintaiDate);

	/**
	 * 作業按分保存
	 * @param kintaiSagyoAnbunSaveForm
	 */
	public void saveKintaiSagyoAnbunGrid(KintaiSagyoAnbunSaveForm kintaiSagyoAnbunSaveForm);


	/**
	 * ｼﾌﾄグリッド取得
	 * @param empNo
	 * @param kintaiMonth
	 */
	public JqGridForm getKintaiShiftGrid(String empNo, String kintaiMonth);

	/**
	 * ｼﾌﾄ保存
	 * @param kintaiShiftSaveForm
	 */
	public void saveKintaiShiftGrid(KintaiShiftSaveForm kintaiShiftSaveForm);

	/**
	 * ｼﾌﾄ削除
	 * @param kintaiShiftDelForm
	 */
	public void delKintaiShiftGrid(KintaiShiftDelForm kintaiShiftDelForm);

	/**
	 * 勤怠グリッド1行分取得
	 * @param kintai
	 * @return
	 */
	public KintaiGridForm kintaiGridFormRowMapper(Kintai kintai);

	/**
	 * 管理者保存
	 * @param kintaiMgrSaveForm
	 */
	public void saveMgr(KintaiMgrSaveForm kintaiMgrSaveForm);

	/**
	 * 管理者検索
	 * @param kintaiMgrSearchForm
	 * @return
	 */
	public JqGridForm searchMgr(KintaiMgrSearchForm kintaiMgrSearchForm);

	/**
	 * 勤怠コピー
	 * @param kintaiCopyForm
	 */
	public void copyKintai(KintaiCopyForm kintaiCopyForm);

}
