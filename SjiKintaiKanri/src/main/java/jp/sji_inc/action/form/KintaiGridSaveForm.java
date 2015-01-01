/**
 *
 */
package jp.sji_inc.action.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import jp.sji_inc.db.entity.base.Kintai;

/**
 * @author kyon
 *
 */
public class KintaiGridSaveForm extends Kintai {

	/**
	 * @return kintaiDate
	 */
	@NotNull
	@Pattern(regexp="^[0-9]{8}$")
	@Override
	public String getKintaiDate() {
		return super.getKintaiDate();
	}

	/**
	 * @return startTime
	 */
	@Pattern(regexp="^(?:[0-3]{1}[0-9]{1}:[0-5]{1}[0-9]{1})*$")
	@Override
	public String getStartTime() {
		return super.getStartTime();
	}

	/**
	 * @return endTime
	 */
	@Pattern(regexp="^(?:[0-3]{1}[0-9]{1}:[0-5]{1}[0-9]{1})*$")
	@Override
	public String getEndTime() {
		return super.getEndTime();
	}

}
