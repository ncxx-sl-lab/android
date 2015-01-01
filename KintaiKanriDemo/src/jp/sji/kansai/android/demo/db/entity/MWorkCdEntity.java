package jp.sji.kansai.android.demo.db.entity;

import java.io.Serializable;

/**
 * 作業番号エンティティ
 *
 */
public class MWorkCdEntity implements Serializable {

	/** カラム名　作業番号 */
	public static final String COLUMN_NAME_WORK_CD = "WORK_CD";
	
	/** カラム名　作業名 */
	public static final String COLUMN_NAME_WORK_NAME = "WORK_NAME";
	
	/** 作業番号 */
	private String workCd;
	
	/** 作業名 */
	private String workName;
	
	/**
	 * 作業番号を取得します。
	 * @return 作業番号
	 */
	public String getWorkCd() {
	    return workCd;
	}

	/**
	 * 作業番号を設定します。
	 * @param workCd 作業番号
	 */
	public void setWorkCd(String workCd) {
	    this.workCd = workCd;
	}

	/**
	 * 作業名を取得します。
	 * @return 作業名
	 */
	public String getWorkName() {
	    return workName;
	}

	/**
	 * 作業名を設定します。
	 * @param workName 作業名
	 */
	public void setWorkName(String workName) {
	    this.workName = workName;
	}
}
