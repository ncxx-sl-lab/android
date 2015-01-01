package jp.sji_inc.api.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author kyon
 *
 */
public class ApiKintaiByMonthForm {

	@NotBlank
	@Pattern(regexp="^[0-9]{5}$")
	private String empNo;

	@NotBlank
	@Pattern(regexp="^[0-9]{6}$")
	private String kintaiDate;

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getKintaiDate() {
		return kintaiDate;
	}

	public void setKintaiDate(String kintaiDate) {
		this.kintaiDate = kintaiDate;
	}

}
