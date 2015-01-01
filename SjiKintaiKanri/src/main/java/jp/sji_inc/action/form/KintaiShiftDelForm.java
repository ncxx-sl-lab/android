/**
 *
 */
package jp.sji_inc.action.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author z1j7663
 *
 */
public class KintaiShiftDelForm {

	/** 社員番号 */
	private String empNo;

	/** 勤務月 */
	@NotNull
	@Pattern(regexp="^[0-9]{6}$")
	private String kintaiMonth;

	/** ｼﾌﾄ番号 */
	@NotNull
	@Pattern(regexp="^[2-4]{1}$")
	private String shiftNo;

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
	 * @return shiftNo
	 */
	public String getShiftNo() {
		return shiftNo;
	}

	/**
	 * @param shiftNo セットする shiftNo
	 */
	public void setShiftNo(String shiftNo) {
		this.shiftNo = shiftNo;
	}

}
