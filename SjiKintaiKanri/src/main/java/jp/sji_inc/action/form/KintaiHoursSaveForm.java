/**
 *
 */
package jp.sji_inc.action.form;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author z1j7663
 *
 */
public class KintaiHoursSaveForm implements Serializable {

	/** 社員番号 */
	private String empNo;

	/** 勤務日 */
	@NotNull
	@Pattern(regexp="^[0-9]{8}$")
	private String kintaiDate;

	/** 勤務日 */
	@NotNull
	private String sagyoCd;

	/** 勤務日 */
	@NotNull
	private BigDecimal hours;

	/**
	 * @return kintaiDate
	 */
	public String getKintaiDate() {
		return kintaiDate;
	}

	/**
	 * @param kintaiDate セットする kintaiDate
	 */
	public void setKintaiDate(String kintaiDate) {
		this.kintaiDate = kintaiDate;
	}

	/**
	 * @return sagyoCd
	 */
	public String getSagyoCd() {
		return sagyoCd;
	}

	/**
	 * @param sagyoCd セットする sagyoCd
	 */
	public void setSagyoCd(String sagyoCd) {
		this.sagyoCd = sagyoCd;
	}

	/**
	 * @return hours
	 */
	public BigDecimal getHours() {
		return hours;
	}

	/**
	 * @param hours セットする hours
	 */
	public void setHours(BigDecimal hours) {
		this.hours = hours;
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

}
