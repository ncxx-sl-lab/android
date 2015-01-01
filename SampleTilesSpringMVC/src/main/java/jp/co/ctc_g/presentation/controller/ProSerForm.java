// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.presentation.controller;

import java.util.List;

import jp.co.ctc_g.business.domain.CmbBox;
import jp.co.ctc_g.business.domain.ErrorMessage;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 */
public class ProSerForm {

	/** Ajax用エラーフラグ */
	private boolean valErrFlag = false;

	/** Ajax用エラー */
	private List<ErrorMessage> valErrMsgList = null;

	/** プロジェクト区分 */
	private List<CmbBox> pjkbnList;

	/** 顧客マスタ */
	private List<CmbBox> kokyakuList;

	/** プロジェクトコード */
	private String inputPjCd;

	/** プロジェクト名 */
	private String inputPjName;

	/** 期間（From) */
	private String inputStartDate;

	/** 期間（To) */
	private String inputEndDate;

	/** プロジェクト区分 */
	private String inputPjKbn;

	/** 顧客コード */
	private String inputKokyakuCode;

	/** 検索結果 */
	private String pjListJsonString;

	/** 選択行ID */
	private String selectedRowId;

	/** Gridページ */
	private String gridPage;

	/**
	 * @return valErrFlag
	 */
	public boolean isValErrFlag() {
		return valErrFlag;
	}

	/**
	 * @param valErrFlag セットする valErrFlag
	 */
	public void setValErrFlag(boolean valErrFlag) {
		this.valErrFlag = valErrFlag;
	}

	/**
	 * @return valErrMsgList
	 */
	public List<ErrorMessage> getValErrMsgList() {
		return valErrMsgList;
	}

	/**
	 * @param valErrMsgList セットする valErrMsgList
	 */
	public void setValErrMsgList(List<ErrorMessage> valErrMsgList) {
		this.valErrMsgList = valErrMsgList;
	}

	/**
	 * @return pjkbnList
	 */
	public List<CmbBox> getPjkbnList() {
		return pjkbnList;
	}

	/**
	 * @param pjkbnList セットする pjkbnList
	 */
	public void setPjkbnList(List<CmbBox> pjkbnList) {
		this.pjkbnList = pjkbnList;
	}

	/**
	 * @return kokyakuList
	 */
	public List<CmbBox> getKokyakuList() {
		return kokyakuList;
	}

	/**
	 * @param kokyakuList セットする kokyakuList
	 */
	public void setKokyakuList(List<CmbBox> kokyakuList) {
		this.kokyakuList = kokyakuList;
	}

	/**
	 * @return inputPjCd
	 */
	public String getInputPjCd() {
		return inputPjCd;
	}

	/**
	 * @param inputPjCd セットする inputPjCd
	 */
	public void setInputPjCd(String inputPjCd) {
		this.inputPjCd = inputPjCd;
	}

	/**
	 * @return inputPjName
	 */
	public String getInputPjName() {
		return inputPjName;
	}

	/**
	 * @param inputPjName セットする inputPjName
	 */
	public void setInputPjName(String inputPjName) {
		this.inputPjName = inputPjName;
	}

	/**
	 * @return inputStartDate
	 */
	public String getInputStartDate() {
		return inputStartDate;
	}

	/**
	 * @param inputStartDate セットする inputStartDate
	 */
	public void setInputStartDate(String inputStartDate) {
		this.inputStartDate = inputStartDate;
	}

	/**
	 * @return inputEndDate
	 */
	public String getInputEndDate() {
		return inputEndDate;
	}

	/**
	 * @param inputEndDate セットする inputEndDate
	 */
	public void setInputEndDate(String inputEndDate) {
		this.inputEndDate = inputEndDate;
	}

	/**
	 * @return inputPjKbn
	 */
	public String getInputPjKbn() {
		return inputPjKbn;
	}

	/**
	 * @param inputPjKbn セットする inputPjKbn
	 */
	public void setInputPjKbn(String inputPjKbn) {
		this.inputPjKbn = inputPjKbn;
	}

	/**
	 * @return inputKokyakuCode
	 */
	public String getInputKokyakuCode() {
		return inputKokyakuCode;
	}

	/**
	 * @param inputKokyakuCode セットする inputKokyakuCode
	 */
	public void setInputKokyakuCode(String inputKokyakuCode) {
		this.inputKokyakuCode = inputKokyakuCode;
	}

	/**
	 * @return selectedRowId
	 */
	public String getSelectedRowId() {
		return selectedRowId;
	}

	/**
	 * @param selectedRowId セットする selectedRowId
	 */
	public void setSelectedRowId(String selectedRowId) {
		this.selectedRowId = selectedRowId;
	}

	/**
	 * @return pjListJsonString
	 */
	public String getPjListJsonString() {
		return pjListJsonString;
	}

	/**
	 * @param pjListJsonString セットする pjListJsonString
	 */
	public void setPjListJsonString(String pjListJsonString) {
		this.pjListJsonString = pjListJsonString;
	}

	/**
	 * @return gridPage
	 */
	public String getGridPage() {
		return gridPage;
	}

	/**
	 * @param gridPage セットする gridPage
	 */
	public void setGridPage(String gridPage) {
		this.gridPage = gridPage;
	}

}
