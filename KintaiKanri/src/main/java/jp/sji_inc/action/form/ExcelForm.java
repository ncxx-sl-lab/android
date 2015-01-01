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
public class ExcelForm {

	/** 勤務月 */
	@NotNull
	@Pattern(regexp="^[0-9]{6}$")
	private String kintaiMonth;

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

}
