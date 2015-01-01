package com.sample.ormlite.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * M_PROJECTテーブル　エンティティ
 * @author Hiroshi Tsuji
 *
 */
@DatabaseTable(tableName = "M_PROJECT")
public class MProjectEntity {

	/**
	 * コンストラクタ
	 */
	public MProjectEntity() {

	}

	/** プロジェクトコード */
	@DatabaseField(columnName = "PROJECT_CD", id = true)
	private String projectCd;

	/** 枝番 */
	@DatabaseField(columnName = "BRANCH_NO")
	private String branchNo;

	/** プロジェクト名 */
	@DatabaseField(columnName = "PROJECT_NAME")
	private String projectName;

	/** 有効月(開始) */
	@DatabaseField(columnName = "VALID_PERIOD_START")
	private String validPeriodStart;

	/** 有効月(終了) */
	@DatabaseField(columnName = "VALID_PERIOD_END")
	private String validPeriodEnd;

	/**
	 * プロジェクトコードを取得します。
	 * @return プロジェクトコード
	 */
	public String getProjectCd() {
	    return projectCd;
	}

	/**
	 * プロジェクトコードを設定します。
	 * @param projectCd プロジェクトコード
	 */
	public void setProjectCd(String projectCd) {
	    this.projectCd = projectCd;
	}

	/**
	 * 枝番を取得します。
	 * @return 枝番
	 */
	public String getBranchNo() {
	    return branchNo;
	}

	/**
	 * 枝番を設定します。
	 * @param branchNo 枝番
	 */
	public void setBranchNo(String branchNo) {
	    this.branchNo = branchNo;
	}

	/**
	 * プロジェクト名を取得します。
	 * @return プロジェクト名
	 */
	public String getProjectName() {
	    return projectName;
	}

	/**
	 * プロジェクト名を設定します。
	 * @param projectName プロジェクト名
	 */
	public void setProjectName(String projectName) {
	    this.projectName = projectName;
	}

	/**
	 * 有効月(開始)を取得します。
	 * @return 有効月(開始)
	 */
	public String getValidPeriodStart() {
	    return validPeriodStart;
	}

	/**
	 * 有効月(開始)を設定します。
	 * @param validPeriodStart 有効月(開始)
	 */
	public void setValidPeriodStart(String validPeriodStart) {
	    this.validPeriodStart = validPeriodStart;
	}

	/**
	 * 有効月(終了)を取得します。
	 * @return 有効月(終了)
	 */
	public String getValidPeriodEnd() {
	    return validPeriodEnd;
	}

	/**
	 * 有効月(終了)を設定します。
	 * @param validPeriodEnd 有効月(終了)
	 */
	public void setValidPeriodEnd(String validPeriodEnd) {
	    this.validPeriodEnd = validPeriodEnd;
	}

	@Override
	public String toString() {
		return
				"projectCd -> " + projectCd + "\n"
				+ "branchNo -> " + branchNo + "\n"
				+ "projectName -> " + projectName + "\n"
				+ "validPeriodStart -> " + validPeriodStart + "\n"
				+ "validPeriodEnd -> " + validPeriodEnd + "\n";
	}
}
