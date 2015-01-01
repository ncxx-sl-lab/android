/**
 *
 */
package jp.sji_inc.action.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author z1j7663
 *
 */
public class KintaiMgrSaveForm implements Serializable {

	/** 社員番号 */
	private String empNo;

	/** 勤務月 */
	@NotNull
	@Pattern(regexp="^[0-9]{6}$")
	private String kintaiMonth;

	/** 管理者NO */
	@NotNull
	@Pattern(regexp="^[1-2]{1}$")
	private String no;

	/** 管理者社員番号 */
	private String mgrNo;

	/** 開始日 */
	private String dateFrom;

	/** 終了日 */
	private String dateTo;

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
	 * @return no
	 */
	public String getNo() {
		return no;
	}

	/**
	 * @param no セットする no
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * @return mgrNo
	 */
	public String getMgrNo() {
		return mgrNo;
	}

	/**
	 * @param mgrNo セットする mgrNo
	 */
	public void setMgrNo(String mgrNo) {
		this.mgrNo = mgrNo;
	}

	/**
	 * @return dateFrom
	 */
	public String getDateFrom() {
		return dateFrom;
	}

	/**
	 * @param dateFrom セットする dateFrom
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	/**
	 * @return dateTo
	 */
	public String getDateTo() {
		return dateTo;
	}

	/**
	 * @param dateTo セットする dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

}
