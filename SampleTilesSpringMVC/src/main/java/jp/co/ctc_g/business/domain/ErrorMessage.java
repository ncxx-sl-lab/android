package jp.co.ctc_g.business.domain;

public class ErrorMessage{

	private String fieldName;
	private String message;
	
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}
	public String getFieldName() {
		return fieldName;
	}
	public String getMessage() {
		return message;
	}

}
