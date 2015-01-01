package jp.sji.kansai.android.demo.db.entity;

import java.io.Serializable;

/**
 * 勤怠情報エンティティ
 * @author Hiroshi Tsuji
 *
 */
public class TKintaiInfoEntity implements Serializable {

	/** カラム名　社員番号 */
	public static final String COLUMN_NAME_EMPLOYEE_NO = "EMPLOYEE_NO";

	/** カラム名　日付 */
	public static final String COLUMN_NAME_KINTAI_DATE = "KINTAI_DATE";

	/** カラム名　シフト番号 */
	public static final String COLUMN_NAME_SHIFT_NO = "SHIFT_NO";

	/** カラム名　開始時間 */
	public static final String COLUMN_NAME_START_TIME = "START_TIME";

	/** カラム名　終了時間 */
	public static final String COLUMN_NAME_END_TIME = "END_TIME";

	/** カラム名　特記事項 */
	public static final String COLUMN_NAME_SPECIAL_AFFAIRS = "SPECIAL_AFFAIRS";

	/** カラム名　休暇番号 */
	public static final String COLUMN_NAME_REST_NO = "REST_NO";

	/** カラム名　稼働時間（定時） */
	public static final String COLUMN_NAME_HOURS_WORKED_SCHEDULED_TIME = "HOURS_WORKED_SCHEDULED_TIME";

	/** カラム名　稼働時間（残業） */
	public static final String COLUMN_NAME_HOURS_WORKED_OVERTIME_WORK = "HOURS_WORKED_OVERTIME_WORK";

	/** カラム名　稼働時間（深夜） */
	public static final String COLUMN_NAME_HOURS_WORKED_MIDNIGHT = "HOURS_WORKED_MIDNIGHT";

	/** カラム名　メモ */
	public static final String COLUMN_NAME_MEMO = "MEMO";

	/** カラム名　最終更新日時 */
	public static final String COLUMN_NAME_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";

	/** カラム名　最終更新者 */
	public static final String COLUMN_NAME_LAST_UPDATE_USER = "LAST_UPDATE_USER";

	/** カラム名　データ同期区分 */
	public static final String COLUMN_NAME_DATA_SYNC_KBN = "DATA_SYNC_KBN";

	/** カラム名　データ確定区分 */
	public static final String COLUMN_NAME_DATA_DECISION_KBN = "DATA_DECISION_KBN";

	/** 社員番号 */
	private String employeeNo;

	/** 日付 */
	private String kintaiDate;

	/** シフト番号 */
	private String shiftNo;

	/** 開始時間 */
	private String startTime;

	/** 終了時間 */
	private String endTime;

	/** 特記事項 */
	private String specialAffairs;

	/** 休暇番号 */
	private String restNo;

	/** 稼働時間（定時） */
	private String hoursWorkedScheduledTime;

	/** 稼働時間（残業） */
	private String hoursWorkedOvertimeWork;

	/** 稼働時間（深夜） */
	private String hoursWorkedMidnight;

	/** メモ */
	private String memo;

	/** 最終更新日時 */
	private String lastUpdateTime;

	/** 最終更新者 */
	private String lastUpdateUser;

	/** データ同期区分 */
	private Integer dataSyncKbn;

	/** データ確定区分 */
	private Integer dataDecisionKbn;

	/**
	 * 社員番号を取得します。
	 *
	 * @return 社員番号
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * 社員番号を設定します。
	 *
	 * @param employeeNo
	 *            社員番号
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * 日付を取得します。
	 *
	 * @return 日付
	 */
	public String getKintaiDate() {
		return kintaiDate;
	}

	/**
	 * 日付を設定します。
	 *
	 * @param serviceDate
	 *            日付
	 */
	public void setKintaiDate(String serviceDate) {
		this.kintaiDate = serviceDate;
	}

	/**
	 * シフト番号を取得します。
	 *
	 * @return シフト番号
	 */
	public String getShiftNo() {
		return shiftNo;
	}

	/**
	 * シフト番号を設定します。
	 *
	 * @param shiftNo
	 *            シフト番号
	 */
	public void setShiftNo(String shiftNo) {
		this.shiftNo = shiftNo;
	}

	/**
	 * 開始時間を取得します。
	 *
	 * @return 開始時間
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * 開始時間を設定します。
	 *
	 * @param startTime
	 *            開始時間
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 終了時間を取得します。
	 *
	 * @return 終了時間
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * 終了時間を設定します。
	 *
	 * @param endTime
	 *            終了時間
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * 特記事項を取得します。
	 *
	 * @return 特記事項
	 */
	public String getSpecialAffairs() {
		return specialAffairs;
	}

	/**
	 * 特記事項を設定します。
	 *
	 * @param specialAffairs
	 *            特記事項
	 */
	public void setSpecialAffairs(String specialAffairs) {
		this.specialAffairs = specialAffairs;
	}

	/**
	 * 休暇番号を取得します。
	 *
	 * @return 休暇番号
	 */
	public String getRestNo() {
		return restNo;
	}

	/**
	 * 休暇番号を設定します。
	 *
	 * @param restNo
	 *            休暇番号
	 */
	public void setRestNo(String restNo) {
		this.restNo = restNo;
	}

	/**
	 * 稼働時間（定時）を取得します。
	 *
	 * @return 稼働時間（定時）
	 */
	public String getHoursWorkedScheduledTime() {
		return hoursWorkedScheduledTime;
	}

	/**
	 * 稼働時間（定時）を設定します。
	 *
	 * @param hoursWorkedScheduledTime
	 *            稼働時間（定時）
	 */
	public void setHoursWorkedScheduledTime(String hoursWorkedScheduledTime) {
		this.hoursWorkedScheduledTime = hoursWorkedScheduledTime;
	}

	/**
	 * 稼働時間（残業）を取得します。
	 *
	 * @return 稼働時間（残業）
	 */
	public String getHoursWorkedOvertimeWork() {
		return hoursWorkedOvertimeWork;
	}

	/**
	 * 稼働時間（残業）を設定します。
	 *
	 * @param hoursWorkedOvertimeWork
	 *            稼働時間（残業）
	 */
	public void setHoursWorkedOvertimeWork(String hoursWorkedOvertimeWork) {
		this.hoursWorkedOvertimeWork = hoursWorkedOvertimeWork;
	}

	/**
	 * 稼働時間（深夜）を取得します。
	 *
	 * @return 稼働時間（深夜）
	 */
	public String getHoursWorkedMidnight() {
		return hoursWorkedMidnight;
	}

	/**
	 * 稼働時間（深夜）を設定します。
	 *
	 * @param hoursWorkedMidnight
	 *            稼働時間（深夜）
	 */
	public void setHoursWorkedMidnight(String hoursWorkedMidnight) {
		this.hoursWorkedMidnight = hoursWorkedMidnight;
	}

	/**
	 * メモを取得します。
	 * @return メモ
	 */
	public String getMemo() {
	    return memo;
	}

	/**
	 * メモを設定します。
	 * @param memo メモ
	 */
	public void setMemo(String memo) {
	    this.memo = memo;
	}

	/**
	 * 最終更新日時を取得します。
	 *
	 * @return 最終更新日時
	 */
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * 最終更新日時を設定します。
	 *
	 * @param lastUpdateTime
	 *            最終更新日時
	 */
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * 最終更新者を取得します。
	 *
	 * @return 最終更新者
	 */
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	/**
	 * 最終更新者を設定します。
	 *
	 * @param lastUpdateUser
	 *            最終更新者
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	/**
	 * データ同期区分を取得します。
	 *
	 * @return データ同期区分
	 */
	public Integer getDataSyncKbn() {
		return dataSyncKbn;
	}

	/**
	 * データ同期区分を設定します。
	 *
	 * @param dataSyncKbn
	 *            データ同期区分
	 */
	public void setDataSyncKbn(Integer dataSyncKbn) {
		this.dataSyncKbn = dataSyncKbn;
	}

	/**
	 * データ確定区分を取得します。
	 *
	 * @return データ確定区分
	 */
	public Integer getDataDecisionKbn() {
		return dataDecisionKbn;
	}

	/**
	 * データ確定区分を設定します。
	 *
	 * @param dataDecisionKbn
	 *            データ確定区分
	 */
	public void setDataDecisionKbn(Integer dataDecisionKbn) {
		this.dataDecisionKbn = dataDecisionKbn;
	}
}
