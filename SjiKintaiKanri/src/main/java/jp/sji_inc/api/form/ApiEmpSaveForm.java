package jp.sji_inc.api.form;

import javax.validation.constraints.Pattern;


/**
 *
 * @author kyon
 *
 */
public class ApiEmpSaveForm extends ApiEmpForm {

//	/**
//	 * @return empName
//	 */
//	@Override
//	@Size(max = 20)
//	public String getEmpName() {
//		return super.getEmpName();
//	}
//
	/**
	 * @return deptNo
	 */
	@Override
	@Pattern(regexp="^[0-9]{5}$")
	public String getDeptNo() {
		return super.getDeptNo();
	}



}
