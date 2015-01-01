package com.sample.frontier.db.entity;

import java.io.Serializable;


/**
 * M_PROJECTテーブル　エンティティ
 * @author Hiroshi Tsuji
 *
 */
public class MProjectEntity implements Serializable {

	/** シリアルバージョンUID  */
	private static final long serialVersionUID = 9119610508292129488L;

	/**
	 * コンストラクタ
	 */
	public MProjectEntity() {
	}

	/** プロジェクトコード */
	private String projectCd;

	/** 枝番 */
	private String branchNo;

	/** プロジェクト名 */
	private String projectName;

	/** 有効月(開始) */
	private String validPeriodStart;

	/** 有効月(終了) */
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
