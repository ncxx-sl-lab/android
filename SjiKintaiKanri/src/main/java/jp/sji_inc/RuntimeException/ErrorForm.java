/**
 *
 */
package jp.sji_inc.RuntimeException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author z1j7663
 *
 */
public class ErrorForm implements Serializable {

	private List<ErrorMessage> errors = new ArrayList<ErrorMessage>();

	/**
	 * @return errors
	 */
	public List<ErrorMessage> getErrors() {
		return errors;
	}

	/**
	 * @param errors セットする errors
	 */
	public void setErrors(List<ErrorMessage> errors) {
		this.errors = errors;
	}

}
