/**
 *
 */
package jp.sji_inc.action.form;

import java.io.Serializable;


/**
 * @author kyon
 *
 */
public class KintaiForm implements Serializable {

	/** 社員番号 */
	private String empNo;

	/** 勤怠月 */
	private String kintaiMonth;

	/** データピッカー用 */
	private String datepickerDate;

	/** 勤怠管理者1 社員番号 */
	private String mgr1No;

	/** 勤怠管理者1 社員名 */
	private String mgr1Name;

	/** 勤怠管理者1 開始 */
	private String mgr1DateFrom;

	/** 勤怠管理者1 終了 */
	private String mgr1DateTo;

	/** 勤怠管理者2 社員番号 */
	private String mgr2No;

	/** 勤怠管理者2 社員名 */
	private String mgr2Name;

	/** 勤怠管理者2 開始 */
	private String mgr2DateFrom;

	/** 勤怠管理者2 終了 */
	private String mgr2DateTo;

	/** 当月ｼﾌﾄﾞｺﾝﾎﾞ */
	private String shiftGridCombo;

	/** ﾌﾟﾛｼﾞｪｸﾄｺﾝﾎﾞ */
	private String projectGridCombo;

	/** 作業ｺﾝﾎﾞ */
	private String sagyoGridCombo;

	/** 休暇ｺﾝﾎﾞ */
	private String kyukaGridCombo;

	/**
	 * @return kintaiMonth
	 */
	public String getKintaiMonth() {
		return kintaiMonth;
	}

	/**
	 * @param kintaiMonth セットする kintaiMonth
	 */
	public void setKintaiMonth(String kintaiMonth) {
		this.kintaiMonth = kintaiMonth;
	}

	/**
	 * @return shiftGridCombo
	 */
	public String getShiftGridCombo() {
		return shiftGridCombo;
	}

	/**
	 * @param shiftGridCombo セットする shiftGridCombo
	 */
	public void setShiftGridCombo(String shiftGridCombo) {
		this.shiftGridCombo = shiftGridCombo;
	}

	/**
	 * @return empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo セットする empNo
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return projectGridCombo
	 */
	public String getProjectGridCombo() {
		return projectGridCombo;
	}

	/**
	 * @param projectGridCombo セットする projectGridCombo
	 */
	public void setProjectGridCombo(String projectGridCombo) {
		this.projectGridCombo = projectGridCombo;
	}

	/**
	 * @return sagyoGridCombo
	 */
	public String getSagyoGridCombo() {
		return sagyoGridCombo;
	}

	/**
	 * @param sagyoGridCombo セットする sagyoGridCombo
	 */
	public void setSagyoGridCombo(String sagyoGridCombo) {
		this.sagyoGridCombo = sagyoGridCombo;
	}

	/**
	 * @return kyukaGridCombo
	 */
	public String getKyukaGridCombo() {
		return kyukaGridCombo;
	}

	/**
	 * @param kyukaGridCombo セットする kyukaGridCombo
	 */
	public void setKyukaGridCombo(String kyukaGridCombo) {
		this.kyukaGridCombo = kyukaGridCombo;
	}

	/**
	 * @return mgr1No
	 */
	public String getMgr1No() {
		return mgr1No;
	}

	/**
	 * @param mgr1No セットする mgr1No
	 */
	public void setMgr1No(String mgr1No) {
		this.mgr1No = mgr1No;
	}

	/**
	 * @return mgr1Name
	 */
	public String getMgr1Name() {
		return mgr1Name;
	}

	/**
	 * @param mgr1Name セットする mgr1Name
	 */
	public void setMgr1Name(String mgr1Name) {
		this.mgr1Name = mgr1Name;
	}

	/**
	 * @return mgr1DateFrom
	 */
	public String getMgr1DateFrom() {
		return mgr1DateFrom;
	}

	/**
	 * @param mgr1DateFrom セットする mgr1DateFrom
	 */
	public void setMgr1DateFrom(String mgr1DateFrom) {
		this.mgr1DateFrom = mgr1DateFrom;
	}

	/**
	 * @return mgr1DateTo
	 */
	public String getMgr1DateTo() {
		return mgr1DateTo;
	}

	/**
	 * @param mgr1DateTo セットする mgr1DateTo
	 */
	public void setMgr1DateTo(String mgr1DateTo) {
		this.mgr1DateTo = mgr1DateTo;
	}

	/**
	 * @return mgr2No
	 */
	public String getMgr2No() {
		return mgr2No;
	}

	/**
	 * @param mgr2No セットする mgr2No
	 */
	public void setMgr2No(String mgr2No) {
		this.mgr2No = mgr2No;
	}

	/**
	 * @return mgr2Name
	 */
	public String getMgr2Name() {
		return mgr2Name;
	}

	/**
	 * @param mgr2Name セットする mgr2Name
	 */
	public void setMgr2Name(String mgr2Name) {
		this.mgr2Name = mgr2Name;
	}

	/**
	 * @return mgr2DateFrom
	 */
	public String getMgr2DateFrom() {
		return mgr2DateFrom;
	}

	/**
	 * @param mgr2DateFrom セットする mgr2DateFrom
	 */
	public void setMgr2DateFrom(String mgr2DateFrom) {
		this.mgr2DateFrom = mgr2DateFrom;
	}

	/**
	 * @return mgr2DateTo
	 */
	public String getMgr2DateTo() {
		return mgr2DateTo;
	}

	/**
	 * @param mgr2DateTo セットする mgr2DateTo
	 */
	public void setMgr2DateTo(String mgr2DateTo) {
		this.mgr2DateTo = mgr2DateTo;
	}

	/**
	 * @return datepickerDate
	 */
	public String getDatepickerDate() {
		return datepickerDate;
	}

	/**
	 * @param datepickerDate セットする datepickerDate
	 */
	public void setDatepickerDate(String datepickerDate) {
		this.datepickerDate = datepickerDate;
	}


}
