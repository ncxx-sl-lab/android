package jp.sji.kansai.android.demo.db.entity;

import java.io.Serializable;

/**
 * プロジェクト番号マスタエンティティ
 *
 */
public class MProjectNoEntity implements Serializable {

	/** カラム名 有効月 */
	public static final String COLUMN_NAME_VALID_MONTH = "VALID_MONTH";
	
	/** カラム名 プロジェクト番号 */
	public static final String COLUMN_NAME_PROJECT_NO = "PROJECT_NO";
	
	/** カラム名 プロジェクト名 */
	public static final String COLUMN_NAME_PROJECT_NAME = "PROJECT_NAME";
	
	/** 有効月 */
	private String validMonth;
	
	/** プロジェクト番号 */
	private String projectNo;
	
	/** プロジェクト名 */
	private String projectName;
	
	/**
	 * 有効月を取得します。
	 * @return 有効月
	 */
	public String getValidMonth() {
	    return this.validMonth;
	}
	
	/**
	 * 有効月を設定します。
	 * @param validMonth 有効月
	 */
	public void setValidMonth(String validMonth) {
	    this.validMonth = validMonth;
	}
	
	/**
	 * プロジェクト番号を取得します。
	 * @return プロジェクト番号
	 */
	public String getProjectNo() {
	    return this.projectNo;
	}
	
	/**
	 * プロジェクト番号を設定します。
	 * @param projectNo プロジェクト番号
	 */
	public void setProjectNo(String projectNo) {
	    this.projectNo = projectNo;
	}
	
	/**
	 * プロジェクト名を取得します。
	 * @return プロジェクト名
	 */
	public String getProjectName() {
	    return this.projectName;
	}
	
	/**
	 * プロジェクト名を設定します。
	 * @param projectName プロジェクト名
	 */
	public void setProjectName(String projectName) {
	    this.projectName = projectName;
	}
}
