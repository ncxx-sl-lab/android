/**
 *
 */
package jp.sji_inc.common;

/**
 * @author z1j7663
 *
 */
public class LabelBean {

	/** 表示項目 */
	private String label;

	/** 値 */
	private String value;

	/**
	 * コンストラクタ
	 * @param label
	 * @param value
	 */
	public LabelBean(String label, String value) {
		this.label = label;
		this.value = value;
	}

	/**
	 * @return label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label セットする label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value セットする value
	 */
	public void setValue(String value) {
		this.value = value;
	}


}
