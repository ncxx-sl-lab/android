package jp.sji.kansai.android.demo.db.entity;

import java.io.Serializable;

/**
 * プロジェクト情報エンティティ
 * @author Hiroshi Tsuji
 *
 */
public class TProjectInfoEntity implements Serializable {

	/** カラム名　社員番号 */
	public static final String COLUMN_NAME_EMPLOYEE_NO = "EMPLOYEE_NO";

	/** カラム名　日付 */
	public static final String COLUMN_NAME_KINTAI_DATE = "KINTAI_DATE";

	/** カラム名　プロジェクト番号 */
	public static final String COLUMN_NAME_PROJECT_NO = "PROJECT_NO";

	/** カラム名　作業コード */
	public static final String COLUMN_NAME_WORK_CD = "WORK_CD";

	/** カラム名　勤怠管理者 */
	public static final String COLUMN_NAME_KINTAI_ADMIN_USER = "KINTAI_ADMIN_USER";

	/** カラム名　稼働時間（定時） */
	public static final String COLUMN_NAME_HOURS_WORKED_SCHEDULED_TIME = "HOURS_WORKED_SCHEDULED_TIME";

	/** カラム名　稼働時間（残業） */
	public static final String COLUMN_NAME_HOURS_WORKED_OVERTIME_WORK = "HOURS_WORKED_OVERTIME_WORK";

	/** カラム名　稼働時間（深夜） */
	public static final String COLUMN_NAME_HOURS_WORKED_MIDNIGHT = "HOURS_WORKED_MIDNIGHT";

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

	/** プロジェクト番号 */
	private String projectNo;

	/** 作業コード */
	private String workCd;

	/** 勤怠管理者 */
	private String kintaiAdminUser;

	/** 稼働時間（定時） */
	private String hoursWorkedScheduledTime;

	/** 稼働時間（残業） */
	private String hoursWorkedOvertimeWork;

	/** 稼働時間（深夜） */
	private String hoursWorkedMidnight;

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
	 * プロジェクト番号を取得します。
	 * @return プロジェクト番号
	 */
	public String getProjectNo() {
	    return projectNo;
	}

	/**
	 * プロジェクト番号を設定します。
	 * @param projectNo プロジェクト番号
	 */
	public void setProjectNo(String projectNo) {
	    this.projectNo = projectNo;
	}

	/**
	 * 作業コードを取得します。
	 * @return 作業コード
	 */
	public String getWorkCd() {
	    return workCd;
	}

	/**
	 * 作業コードを設定します。
	 * @param workCd 作業コード
	 */
	public void setWorkCd(String workCd) {
	    this.workCd = workCd;
	}

	/**
	 * 勤怠管理者を取得します。
	 * @return 勤怠管理者
	 */
	public String getKintaiAdminUser() {
	    return kintaiAdminUser;
	}

	/**
	 * 勤怠管理者を設定します。
	 * @param kintaiAdminUser 勤怠管理者
	 */
	public void setKintaiAdminUser(String kintaiAdminUser) {
	    this.kintaiAdminUser = kintaiAdminUser;
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
