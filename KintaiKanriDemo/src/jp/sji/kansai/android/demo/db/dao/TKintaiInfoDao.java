package jp.sji.kansai.android.demo.db.dao;

import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDD;
import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDDHHMISS_SLASH;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.sji.kansai.android.demo.db.entity.TKintaiInfoEntity;
import jp.sji.kansai.android.demo.util.DateUtil;
import jp.sji.kansai.android.demo.util.SystemUtil;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

/**
 * 勤怠情報Daoクラス
 * @author Hiroshi Tsuji
 *
 */
public class TKintaiInfoDao extends KintaiKanriDao {

	/** テーブル名 */
	private static final String TABLE_NAME = "T_KINTAI_INFO";
	/** プライマリキー */
	private static final String[] PRIMARY_KEY_COLUMN = {
		TKintaiInfoEntity.COLUMN_NAME_EMPLOYEE_NO
		,TKintaiInfoEntity.COLUMN_NAME_KINTAI_DATE
	};

	/**
	 * コンストラクタ
	 * @param context
	 */
	public TKintaiInfoDao(Context context) {
		super(context);
	}

	/**
	 * プライマリーキーを条件にデータを取得します
	 * @param employeeNo 社員番号
	 * @param kintaiDate 日付
	 * @return
	 */
	public TKintaiInfoEntity selectPK(String employeeNo, String kintaiDate) {

		String query
				= "SELECT "
				+ "    EMPLOYEE_NO "
				+ "    ,KINTAI_DATE "
				+ "    ,SHIFT_NO "
				+ "    ,START_TIME "
				+ "    ,END_TIME "
				+ "    ,SPECIAL_AFFAIRS "
				+ "    ,REST_NO "
				+ "    ,HOURS_WORKED_SCHEDULED_TIME "
				+ "    ,HOURS_WORKED_OVERTIME_WORK "
				+ "    ,HOURS_WORKED_MIDNIGHT "
				+ "    ,MEMO "
				+ "    ,LAST_UPDATE_TIME "
				+ "    ,LAST_UPDATE_USER "
				+ "    ,DATA_SYNC_KBN "
				+ "    ,DATA_DECISION_KBN "
				+ "FROM "
				+ "    T_KINTAI_INFO "
				+ "WHERE 1 = 1 "
				+ "AND EMPLOYEE_NO = ? "
				+ "AND KINTAI_DATE = ? ";

		// SQL実行
		Cursor cursor = super.selectNativeQuery(query, employeeNo, kintaiDate);
		TKintaiInfoEntity entity = null;

		if (cursor.moveToFirst()) {
			entity = new TKintaiInfoEntity();
			// 社員番号
			entity.setEmployeeNo(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_EMPLOYEE_NO)));
			// 日付
			entity.setKintaiDate(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_KINTAI_DATE)));
			// シフト番号
			entity.setShiftNo(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_SHIFT_NO)));
			// 開始時間
			entity.setStartTime(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_START_TIME)));
			// 終了時間
			entity.setEndTime(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_END_TIME)));
			// 特記事項
			entity.setSpecialAffairs(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_SPECIAL_AFFAIRS)));
			// 休暇番号
			entity.setRestNo(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_REST_NO)));
			// 稼働時間（定時）
			entity.setHoursWorkedScheduledTime(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_HOURS_WORKED_SCHEDULED_TIME)));
			// 稼働時間（残業）
			entity.setHoursWorkedOvertimeWork(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_HOURS_WORKED_OVERTIME_WORK)));
			// 稼働時間（深夜）
			entity.setHoursWorkedMidnight(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_HOURS_WORKED_MIDNIGHT)));
			// メモ
			entity.setMemo(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_MEMO)));
			// 最終更新日時
			entity.setLastUpdateTime(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_LAST_UPDATE_TIME)));
			// 最終更新者
			entity.setLastUpdateUser(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_LAST_UPDATE_USER)));
			// データ同期区分
			entity.setDataSyncKbn(cursor.getInt(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_DATA_SYNC_KBN)));
			// データ確定区分
			entity.setDataDecisionKbn(cursor.getInt(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_DATA_DECISION_KBN)));
		}
		cursor.close();
		return entity;
	}

	/**
	 * データの登録を行います
	 * @param entity
	 */
	public void insert(TKintaiInfoEntity entity) {

		Map<String, String> insertValuesMap = new HashMap<String, String>();
		// 社員番号
		insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_EMPLOYEE_NO, entity.getEmployeeNo());
		// 日付
		insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_KINTAI_DATE, entity.getKintaiDate());
		// シフト番号
		if (SystemUtil.isNotEmpty(entity.getShiftNo())) {
			insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_SHIFT_NO, entity.getShiftNo());
		}
		// 開始時間
		if (SystemUtil.isNotEmpty(entity.getStartTime())) {
			insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_START_TIME, entity.getStartTime());
		}
		// 終了時間
		if (SystemUtil.isNotEmpty(entity.getEndTime())) {
			insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_END_TIME, entity.getEndTime());
		}
		// 特記事項
		if (SystemUtil.isNotEmpty(entity.getSpecialAffairs())) {
			insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_SPECIAL_AFFAIRS, entity.getSpecialAffairs());
		}
		// 休暇番号
		if (SystemUtil.isNotEmpty(entity.getRestNo())) {
			insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_REST_NO, entity.getRestNo());
		}
		// 稼働時間（定時）
		if (SystemUtil.isNotEmpty(entity.getHoursWorkedScheduledTime())) {
			insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_HOURS_WORKED_SCHEDULED_TIME, entity.getHoursWorkedScheduledTime());
		}
		// 稼働時間（残業）
		if (SystemUtil.isNotEmpty(entity.getHoursWorkedOvertimeWork())) {
			insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_HOURS_WORKED_OVERTIME_WORK, entity.getHoursWorkedOvertimeWork());
		}
		// 稼働時間（深夜）
		if (SystemUtil.isNotEmpty(entity.getHoursWorkedMidnight())) {
			insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_HOURS_WORKED_MIDNIGHT, entity.getHoursWorkedMidnight());
		}
		// メモ
		if (SystemUtil.isNotEmpty(entity.getMemo())) {
			insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_MEMO, entity.getMemo());
		}
		// 最終更新日時
		insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_LAST_UPDATE_TIME, SystemUtil.convDateToString(DateUtil.getSysdate(), DATE_FORMAT_YYYYMMDDHHMISS_SLASH));
		// 最終更新者
		insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_LAST_UPDATE_USER, entity.getEmployeeNo());
		// データ更新区分
		insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_DATA_SYNC_KBN, "0");
		// データ確定区分
		insertValuesMap.put(TKintaiInfoEntity.COLUMN_NAME_DATA_DECISION_KBN, "0");

		super.insertQuery(TABLE_NAME, insertValuesMap);
	}

	/**
	 * プライマリーキーを条件に指定された値を更新します
	 * @param employeeNo 社員番号
	 * @param kintaiDate 日付
	 * @param updParamMap 更新値
	 * @return 更新件数
	 */
	public int updatePK(String employeeNo, String kintaiDate, Map<String, String> updParamMap) {
		int result = -1;
		if (updParamMap == null || updParamMap.isEmpty()) {
			Log.d(this.getClass().getName(), "Update値が指定されていません。");
			return result;
		}

		if (!updParamMap.containsKey(TKintaiInfoEntity.COLUMN_NAME_LAST_UPDATE_TIME)) {
			// 最終更新日時が設定されていなければ、最終更新日時を設定
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			updParamMap.put(TKintaiInfoEntity.COLUMN_NAME_LAST_UPDATE_TIME, sdf.format(calendar.getTime()));
		}

		if (!updParamMap.containsKey(TKintaiInfoEntity.COLUMN_NAME_LAST_UPDATE_USER)) {
			// 最終更新者が設定されていなければ、最終更新者を設定
			updParamMap.put(TKintaiInfoEntity.COLUMN_NAME_LAST_UPDATE_USER, employeeNo);
		}

		result = super.updateQuery(TABLE_NAME, updParamMap, super.createWhereClauseMap(PRIMARY_KEY_COLUMN, employeeNo, kintaiDate));
		return result;
	}

	/**
	 * プライマリーキーを条件にデータを削除します
	 * @param employeeNo 社員番号
	 * @param kintaiDate 日付
	 */
	public int deletePK(String employeeNo, String kintaiDate) {

		int result = -1;
		result = super.deleteQuery(TABLE_NAME, super.createWhereClauseMap(PRIMARY_KEY_COLUMN, employeeNo, kintaiDate));
		return result;
	}

	/**
	 * 指定された月の勤怠情報を取得します
	 * @param employeeNo 社員番号
	 * @param targetMonth 対象月(YYYYMM指定)
	 * @return
	 */
	public List<TKintaiInfoEntity> selKintaiInfoForMonth(String employeeNo, Date targetMonth) {

		String query
				= "SELECT "
				+ "    EMPLOYEE_NO "
				+ "    ,KINTAI_DATE "
				+ "    ,SHIFT_NO "
				+ "    ,START_TIME "
				+ "    ,END_TIME "
				+ "    ,SPECIAL_AFFAIRS "
				+ "    ,REST_NO "
				+ "    ,HOURS_WORKED_SCHEDULED_TIME "
				+ "    ,HOURS_WORKED_OVERTIME_WORK "
				+ "    ,HOURS_WORKED_MIDNIGHT "
				+ "    ,MEMO "
				+ "    ,LAST_UPDATE_TIME "
				+ "    ,LAST_UPDATE_USER "
				+ "    ,DATA_SYNC_KBN "
				+ "    ,DATA_DECISION_KBN "
				+ "FROM "
				+ "    T_KINTAI_INFO "
				+ "WHERE 1 = 1 "
				+ "AND EMPLOYEE_NO = ? "
				+ "AND KINTAI_DATE BETWEEN ? AND ?"
				+ "ORDER BY KINTAI_DATE ";

		Cursor cursor = super.selectNativeQuery(query
				, employeeNo
				, SystemUtil.convDateToString(DateUtil.getMonthFirstDate(targetMonth), DATE_FORMAT_YYYYMMDD)
				, SystemUtil.convDateToString(DateUtil.getMonthEndDate(targetMonth), DATE_FORMAT_YYYYMMDD));
		List<TKintaiInfoEntity> kintaiInfoEntityList = new ArrayList<TKintaiInfoEntity>();

		if (cursor.moveToFirst()) {
			do {
				TKintaiInfoEntity entity = new TKintaiInfoEntity();
				// 社員番号
				entity.setEmployeeNo(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_EMPLOYEE_NO)));
				// 日付
				entity.setKintaiDate(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_KINTAI_DATE)));
				// シフト番号
				entity.setShiftNo(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_SHIFT_NO)));
				// 開始時間
				entity.setStartTime(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_START_TIME)));
				// 終了時間
				entity.setEndTime(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_END_TIME)));
				// 特記事項
				entity.setSpecialAffairs(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_SPECIAL_AFFAIRS)));
				// 休暇番号
				entity.setRestNo(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_REST_NO)));
				// 稼働時間（定時）
				entity.setHoursWorkedScheduledTime(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_HOURS_WORKED_SCHEDULED_TIME)));
				// 稼働時間（残業）
				entity.setHoursWorkedOvertimeWork(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_HOURS_WORKED_OVERTIME_WORK)));
				// 稼働時間（深夜）
				entity.setHoursWorkedMidnight(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_HOURS_WORKED_MIDNIGHT)));
				// メモ
				entity.setMemo(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_MEMO)));
				// 最終更新日時
				entity.setLastUpdateTime(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_LAST_UPDATE_TIME)));
				// 最終更新者
				entity.setLastUpdateUser(cursor.getString(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_LAST_UPDATE_USER)));
				// データ同期区分
				entity.setDataSyncKbn(cursor.getInt(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_DATA_SYNC_KBN)));
				// データ確定区分
				entity.setDataDecisionKbn(cursor.getInt(cursor.getColumnIndex(TKintaiInfoEntity.COLUMN_NAME_DATA_DECISION_KBN)));

				kintaiInfoEntityList.add(entity);
			} while(cursor.moveToNext());
		}
		cursor.close();

		return kintaiInfoEntityList;
	}
}
