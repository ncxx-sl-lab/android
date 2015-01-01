// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.business.domain;

/**
 * @author z1j7663
 * @version 1.0.0
 *
 */
public class SagyoMst {

	/** 作業コード */
	private String sagyoCode;

	/** 作業名 */
	private String sagyoName;

	/** グループコード */
	private String groupCode;

	/**
	 * @return sagyoCode
	 */
	public String getSagyoCode() {
		return sagyoCode;
	}

	/**
	 * @param sagyoCode セットする sagyoCode
	 */
	public void setSagyoCode(String sagyoCode) {
		this.sagyoCode = sagyoCode;
	}

	/**
	 * @return sagyoName
	 */
	public String getSagyoName() {
		return sagyoName;
	}

	/**
	 * @param sagyoName セットする sagyoName
	 */
	public void setSagyoName(String sagyoName) {
		this.sagyoName = sagyoName;
	}

	/**
	 * @return groupCode
	 */
	public String getGroupCode() {
		return groupCode;
	}

	/**
	 * @param groupCode セットする groupCode
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

}
