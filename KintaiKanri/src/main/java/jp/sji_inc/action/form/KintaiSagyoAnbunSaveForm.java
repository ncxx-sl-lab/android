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
public class KintaiSagyoAnbunSaveForm implements Serializable {

	/** 社員番号 */
	private String empNo;

	/** 勤務日 */
	@NotNull
	@Pattern(regexp="^[0-9]{8}$")
	private String kintaiDate;

	/** 勤務日 */
	@NotNull
	private String sagyoCd;

	/** 通常 按分率 */
	@NotNull
	private BigDecimal normalAnbunRitu;

	/** 残業 按分率 */
	@NotNull
	private BigDecimal overAnbunRitu;

	/** 深夜 按分率 */
	@NotNull
	private BigDecimal lateOverAnbunRitu;

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
	 * @return normalAnbunRitu
	 */
	public BigDecimal getNormalAnbunRitu() {
		return normalAnbunRitu;
	}

	/**
	 * @param normalAnbunRitu セットする normalAnbunRitu
	 */
	public void setNormalAnbunRitu(BigDecimal normalAnbunRitu) {
		this.normalAnbunRitu = normalAnbunRitu;
	}

	/**
	 * @return overAnbunRitu
	 */
	public BigDecimal getOverAnbunRitu() {
		return overAnbunRitu;
	}

	/**
	 * @param overAnbunRitu セットする overAnbunRitu
	 */
	public void setOverAnbunRitu(BigDecimal overAnbunRitu) {
		this.overAnbunRitu = overAnbunRitu;
	}

	/**
	 * @return lateOverAnbunRitu
	 */
	public BigDecimal getLateOverAnbunRitu() {
		return lateOverAnbunRitu;
	}

	/**
	 * @param lateOverAnbunRitu セットする lateOverAnbunRitu
	 */
	public void setLateOverAnbunRitu(BigDecimal lateOverAnbunRitu) {
		this.lateOverAnbunRitu = lateOverAnbunRitu;
	}

}
