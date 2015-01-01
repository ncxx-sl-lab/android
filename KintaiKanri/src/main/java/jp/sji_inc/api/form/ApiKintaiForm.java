/**
 *
 */
package jp.sji_inc.api.form;

import javax.validation.constraints.Pattern;

import jp.sji_inc.db.entity.base.Kintai;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author kyon
 *
 */
public class ApiKintaiForm extends Kintai {

	/**
	 * @return empNo
	 */
	@NotBlank
	@Pattern(regexp="^[0-9]{5}$")
	@Override
	public String getEmpNo() {
		return super.getEmpNo();
	}

	/**
	 * @return kintaiDate
	 */
	@Pattern(regexp="^[0-9]{8}$")
	@Override
	public String getKintaiDate() {
		return super.getKintaiDate();
	}

}
