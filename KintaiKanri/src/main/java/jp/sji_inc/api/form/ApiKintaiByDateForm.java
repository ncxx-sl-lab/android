package jp.sji_inc.api.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author kyon
 *
 */
public class ApiKintaiByDateForm {

	/** 社員番号 */
	@NotBlank
	@Pattern(regexp="^[0-9]{5}$")
	private String empNo;

	/** 勤怠日 */
	@NotBlank
	@Pattern(regexp="^[0-9]{8}$")
	private String kintaiDate;

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

}
