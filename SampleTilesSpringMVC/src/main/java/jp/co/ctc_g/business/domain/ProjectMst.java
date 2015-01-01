// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.domain;

import java.util.Date;

/**
 * @author z1j7663
 * @version 1.0.0
 *
 */
public class ProjectMst {

	/** プロジェクトコード */
	private String projectCode;

	/** プロジェクト名 */
	private String projectName;

	/** 開始期間 */
	private Date kikanStart;

	/** 終了期間 */
	private Date kikanEnd;

	/** 削除フラグ */
	private String delFlg;

	/** プロジェクト区分 */
	private String projectKbn;

	/**
	 * @return projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * @param projectCode セットする projectCode
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * @return projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName セットする projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return kikanStart
	 */
	public Date getKikanStart() {
		return kikanStart;
	}

	/**
	 * @param kikanStart セットする kikanStart
	 */
	public void setKikanStart(Date kikanStart) {
		this.kikanStart = kikanStart;
	}

	/**
	 * @return kikanEnd
	 */
	public Date getKikanEnd() {
		return kikanEnd;
	}

	/**
	 * @param kikanEnd セットする kikanEnd
	 */
	public void setKikanEnd(Date kikanEnd) {
		this.kikanEnd = kikanEnd;
	}

	/**
	 * @return delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg セットする delFlg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * @return projectKbn
	 */
	public String getProjectKbn() {
		return projectKbn;
	}

	/**
	 * @param projectKbn セットする projectKbn
	 */
	public void setProjectKbn(String projectKbn) {
		this.projectKbn = projectKbn;
	}

}
