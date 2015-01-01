package jp.sji.kansai.android.demo.db.dao;

import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.sji.kansai.android.demo.db.entity.TProjectInfoEntity;
import jp.sji.kansai.android.demo.util.DateUtil;
import jp.sji.kansai.android.demo.util.SystemUtil;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class TProjectInfoDao extends KintaiKanriDao {

	/** テーブル名 */
	private static final String TABLE_NAME = "T_PROJECT_INFO";

	/** プライマリキー */
	private static final String[] PRIMARY_KEY_COLUMN = {
		TProjectInfoEntity.COLUMN_NAME_EMPLOYEE_NO
		,TProjectInfoEntity.COLUMN_NAME_KINTAI_DATE
		,TProjectInfoEntity.COLUMN_NAME_PROJECT_NO
		,TProjectInfoEntity.COLUMN_NAME_WORK_CD
	};

	/**
	 * コンストラクタ
	 * @param context
	 */
	public TProjectInfoDao(Context context) {
		super(context);
	}

	/**
	 * プライマリーキーを条件にデータを取得します
	 * @param employeeNo 社員番号
	 * @param kintaiDate 日付
	 * @return
	 */
	public TProjectInfoEntity selectPK(String employeeNo, String kintaiDate, String projectNo, String workCd) {

		String query
				= "SELECT "
				+ "    EMPLOYEE_NO "
				+ "    ,KINTAI_DATE "
				+ "    ,PROJECT_NO "
				+ "    ,WORK_CD "
				+ "    ,KINTAI_ADMIN_USER "
				+ "    ,HOURS_WORKED_SCHEDULED_TIME "
				+ "    ,HOURS_WORKED_OVERTIME_WORK "
				+ "    ,HOURS_WORKED_MIDNIGHT "
				+ "    ,LAST_UPDATE_TIME "
				+ "    ,LAST_UPDATE_USER "
				+ "    ,DATA_SYNC_KBN "
				+ "    ,DATA_DECISION_KBN "
				+ "FROM "
				+ "    T_PROJECT_INFO "
				+ "WHERE 1 = 1 "
				+ "AND EMPLOYEE_NO = ? "
				+ "AND KINTAI_DATE = ? "
				+ "AND PROJECT_NO = ? "
				+ "AND WORK_CD = ? ";

		// SQL実行
		Cursor cursor = super.selectNativeQuery(query, employeeNo, kintaiDate, projectNo, workCd);
		TProjectInfoEntity entity = null;

		if (cursor.moveToFirst()) {
			entity = new TProjectInfoEntity();
			// 社員番号
			entity.setEmployeeNo(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_EMPLOYEE_NO)));
			// 日付
			entity.setKintaiDate(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_KINTAI_DATE)));
			// プロジェクトNo
			entity.setProjectNo(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_PROJECT_NO)));
			// 作業コード
			entity.setWorkCd(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_WORK_CD)));
			// 勤怠管理者
			entity.setKintaiAdminUser(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_KINTAI_ADMIN_USER)));
			// 稼働時間（定時）
			entity.setHoursWorkedScheduledTime(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_SCHEDULED_TIME)));
			// 稼働時間（残業）
			entity.setHoursWorkedOvertimeWork(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_OVERTIME_WORK)));
			// 稼働時間（深夜）
			entity.setHoursWorkedMidnight(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_MIDNIGHT)));
			// 最終更新日時
			entity.setLastUpdateTime(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_LAST_UPDATE_TIME)));
			// 最終更新者
			entity.setLastUpdateUser(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_LAST_UPDATE_USER)));
			// データ同期区分
			entity.setDataSyncKbn(cursor.getInt(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_DATA_SYNC_KBN)));
			// データ確定区分
			entity.setDataDecisionKbn(cursor.getInt(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_DATA_DECISION_KBN)));
		}
		cursor.close();
		return entity;
	}
	/**
	 * データの登録を行います
	 * @param entity
	 */
	public void insert(TProjectInfoEntity entity) {

		Map<String, String> insertValuesMap = new HashMap<String, String>();
		// 社員番号
		insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_EMPLOYEE_NO, entity.getEmployeeNo());
		// 日付
		insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_KINTAI_DATE, entity.getKintaiDate());
		// プロジェクト番号
		insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_PROJECT_NO, entity.getProjectNo());
		// 作業コード
		insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_WORK_CD, entity.getWorkCd());
		// 勤怠管理者
		if (SystemUtil.isNotEmpty(entity.getKintaiAdminUser())) {
			insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_KINTAI_ADMIN_USER, entity.getKintaiAdminUser());
		}
		// 稼働時間（定時）
		if (SystemUtil.isNotEmpty(entity.getHoursWorkedScheduledTime())) {
			insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_SCHEDULED_TIME, entity.getHoursWorkedScheduledTime());
		}
		// 稼働時間（残業）
		if (SystemUtil.isNotEmpty(entity.getHoursWorkedOvertimeWork())) {
			insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_OVERTIME_WORK, entity.getHoursWorkedOvertimeWork());
		}
		// 稼働時間（深夜）
		if (SystemUtil.isNotEmpty(entity.getHoursWorkedMidnight())) {
			insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_MIDNIGHT, entity.getHoursWorkedMidnight());
		}
		// 最終更新日時
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_LAST_UPDATE_TIME, sdf.format(calendar.getTime()));
		// 最終更新者
		insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_LAST_UPDATE_USER, entity.getEmployeeNo());
		// データ更新区分
		insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_DATA_SYNC_KBN, "0");
		// データ確定区分
		insertValuesMap.put(TProjectInfoEntity.COLUMN_NAME_DATA_DECISION_KBN, "0");

		super.insertQuery(TABLE_NAME, insertValuesMap);
	}

	/**
	 * プライマリーキーを条件に指定された値を更新します
	 * @param employeeNo 社員番号
	 * @param kintaiDate 日付
	 * @param projectNo プロジェクト番号
	 * @param workCd 作業コード
	 * @param updParamMap
	 * @return 更新件数
	 */
	public int updatePK(String employeeNo, String kintaiDate, String projectNo, String workCd, Map<String, String> updParamMap) {
		int result = -1;
		if (updParamMap == null || updParamMap.isEmpty()) {
			Log.d(this.getClass().getName(), "Update値が指定されていません。");
			return result;
		}

		if (!updParamMap.containsKey(TProjectInfoEntity.COLUMN_NAME_LAST_UPDATE_TIME)) {
			// 最終更新日時が設定されていなければ、最終更新日時を設定
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			updParamMap.put(TProjectInfoEntity.COLUMN_NAME_LAST_UPDATE_TIME, sdf.format(calendar.getTime()));
		}

		if (!updParamMap.containsKey(TProjectInfoEntity.COLUMN_NAME_LAST_UPDATE_USER)) {
			// 最終更新者が設定されていなければ、最終更新者を設定
			updParamMap.put(TProjectInfoEntity.COLUMN_NAME_LAST_UPDATE_USER, employeeNo);
		}

		result = super.updateQuery(TABLE_NAME, updParamMap
				, super.createWhereClauseMap(PRIMARY_KEY_COLUMN, employeeNo, kintaiDate, projectNo, workCd));
		return result;
	}

	/**
	 * プライマリーキーを条件にデータを削除します
	 * @param employeeNo 社員番号
	 * @param kintaiDate 対象日
	 */
	public int deletePK(String employeeNo, String kintaiDate, String projectNo, String workCd) {

		int result = -1;

		result = super.deleteQuery(TABLE_NAME, super.createWhereClauseMap(PRIMARY_KEY_COLUMN, employeeNo, kintaiDate, projectNo, workCd));
		return result;
	}

	/**
	 * 指定された日のプロジェクト情報を取得します
	 * @param employeeNo 社員番号
	 * @param targetDate 対象日
	 * @return
	 */
	public List<TProjectInfoEntity> selProjectInfoForDayList(String employeeNo, Date targetDate) {

		String query
				= "SELECT "
				+ "    PROJECT_NO "
				+ "    ,WORK_CD "
				+ "    ,HOURS_WORKED_SCHEDULED_TIME "
				+ "    ,HOURS_WORKED_OVERTIME_WORK "
				+ "    ,HOURS_WORKED_MIDNIGHT "
				+ "FROM "
				+ "    T_PROJECT_INFO "
				+ "WHERE 1 = 1 "
				+ "AND EMPLOYEE_NO = ? "
				+ "AND KINTAI_DATE = ? "
				+ "ORDER BY PROJECT_NO,WORK_CD ";

		Cursor cursor = super.selectNativeQuery(query, employeeNo, SystemUtil.convDateToString(targetDate, DATE_FORMAT_YYYYMMDD));
		List<TProjectInfoEntity> projectInfoEntityList = new ArrayList<TProjectInfoEntity>();

		if (cursor.moveToFirst()) {
			do {
				TProjectInfoEntity entity = new TProjectInfoEntity();
				entity = new TProjectInfoEntity();
				// プロジェクトNo
				entity.setProjectNo(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_PROJECT_NO)));
				// 作業コード
				entity.setWorkCd(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_WORK_CD)));
				// 稼働時間（定時）
				entity.setHoursWorkedScheduledTime(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_SCHEDULED_TIME)));
				// 稼働時間（残業）
				entity.setHoursWorkedOvertimeWork(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_OVERTIME_WORK)));
				// 稼働時間（深夜）
				entity.setHoursWorkedMidnight(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_MIDNIGHT)));

				projectInfoEntityList.add(entity);
			} while(cursor.moveToNext());
		}
		cursor.close();

		return projectInfoEntityList;
	}

	/**
	 * 指定された月のプロジェクト情報のサマリを取得します
	 * @param employeeNo 社員番号
	 * @param targetDate 対象月
	 * @return
	 */
	public List<TProjectInfoEntity> selProjectInfoForMonthSummaryList(String employeeNo, Date targetDate) {

		String query
				= "SELECT "
				+ "    PROJECT_NO "
				+ "    ,WORK_CD "
				+ "    ,SUM(HOURS_WORKED_SCHEDULED_TIME) AS HOURS_WORKED_SCHEDULED_TIME "
				+ "    ,SUM(HOURS_WORKED_OVERTIME_WORK) AS HOURS_WORKED_OVERTIME_WORK "
				+ "    ,SUM(HOURS_WORKED_MIDNIGHT) AS HOURS_WORKED_MIDNIGHT "
				+ "FROM "
				+ "    T_PROJECT_INFO "
				+ "WHERE 1 = 1 "
				+ "AND EMPLOYEE_NO = ? "
				+ "AND KINTAI_DATE BETWEEN ? AND ? "
				+ "GROUP BY PROJECT_NO,WORK_CD "
				+ "ORDER BY PROJECT_NO,WORK_CD ";

		Cursor cursor = super.selectNativeQuery(query
				, employeeNo
				, SystemUtil.convDateToString(DateUtil.getMonthFirstDate(targetDate), DATE_FORMAT_YYYYMMDD)
				, SystemUtil.convDateToString(DateUtil.getMonthEndDate(targetDate), DATE_FORMAT_YYYYMMDD));
		List<TProjectInfoEntity> projectInfoEntityList = new ArrayList<TProjectInfoEntity>();

		if (cursor.moveToFirst()) {
			do {
				TProjectInfoEntity entity = new TProjectInfoEntity();
				entity = new TProjectInfoEntity();
				// プロジェクトNo
				entity.setProjectNo(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_PROJECT_NO)));
				// 作業コード
				entity.setWorkCd(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_WORK_CD)));
				// 稼働時間（定時）
				entity.setHoursWorkedScheduledTime(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_SCHEDULED_TIME)));
				// 稼働時間（残業）
				entity.setHoursWorkedOvertimeWork(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_OVERTIME_WORK)));
				// 稼働時間（深夜）
				entity.setHoursWorkedMidnight(cursor.getString(cursor.getColumnIndex(TProjectInfoEntity.COLUMN_NAME_HOURS_WORKED_MIDNIGHT)));

				projectInfoEntityList.add(entity);
			} while(cursor.moveToNext());
		}
		cursor.close();

		return projectInfoEntityList;
	}
}
