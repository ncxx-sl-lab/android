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
public class KintaiCopyForm {

	/** 社員番号 */
	private String empNo;

	/** コピー元日付 */
	@NotNull
	@Pattern(regexp="^[0-9]{8}$")
	private String orgKintaiDate;

	/** コピー先日付 */
	@NotNull
	@Pattern(regexp="^[0-9]{8}$")
	private String dstKintaiDate;

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
	 * @return orgKintaiDate
	 */
	public String getOrgKintaiDate() {
		return orgKintaiDate;
	}

	/**
	 * @param orgKintaiDate セットする orgKintaiDate
	 */
	public void setOrgKintaiDate(String orgKintaiDate) {
		this.orgKintaiDate = orgKintaiDate;
	}

	/**
	 * @return dstKintaiDate
	 */
	public String getDstKintaiDate() {
		return dstKintaiDate;
	}

	/**
	 * @param dstKintaiDate セットする dstKintaiDate
	 */
	public void setDstKintaiDate(String dstKintaiDate) {
		this.dstKintaiDate = dstKintaiDate;
	}

}
