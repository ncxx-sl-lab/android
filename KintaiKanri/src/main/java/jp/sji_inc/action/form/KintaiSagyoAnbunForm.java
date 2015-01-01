/**
 *
 */
package jp.sji_inc.action.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author z1j7663
 *
 */
public class KintaiSagyoAnbunForm implements Serializable {

	/** 勤務日 */
	@NotNull
	@Pattern(regexp="^[0-9]{8}$")
	private String kintaiDate;

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
