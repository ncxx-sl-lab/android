/**
 *
 */
package jp.sji_inc.RuntimeException;



/**
 * @author z1j7663
 *
 */
public class ErrorMessage {

	/** フィールド */
	private String field;

	/** フィールド（論理） */
	private String fieldName;

	/** メッセージ */
	private String message;

	/**
	 * @return field
	 */
	public String getField() {
		return field;
	}

	/**
	 * コンストラクタ
	 * @param field フィールド
	 * @param message メッセージ
	 */
	public ErrorMessage(String field, String fieldName, String message) {
		this.field = field;
		this.fieldName = fieldName;
		this.message = message;
	}

	/**
	 * @param field セットする field
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName セットする fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
