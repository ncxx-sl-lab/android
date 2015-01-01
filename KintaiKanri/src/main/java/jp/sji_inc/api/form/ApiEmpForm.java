package jp.sji_inc.api.form;

import javax.validation.constraints.Pattern;

import jp.sji_inc.db.entity.base.Emp;

/**
 *
 * @author kyon
 *
 */
public class ApiEmpForm extends Emp {

	/**
	 * @return empNo
	 */
	@Pattern(regexp="^[0-9]{5}$")
	@Override
	public String getEmpNo() {
		return super.getEmpNo();
	}

}
