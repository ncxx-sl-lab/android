/**
 *
 */
package jp.sji_inc.action.form;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author z1j7663
 *
 */
public class KintaiHoursGridForm implements Serializable {

	/** 勤怠日 */
	private String kintaiDate;

	/** 作業ｺｰﾄﾞ */
	private String sagyoCd;

	/** 勤怠時間 */
	private BigDecimal anbunRitu;

	/**
	 * @return sagyoCd
	 */
	public String getSagyoCd() {
		return sagyoCd;
	}

	/**
	 * @param sagyoCd セットする sagyoCd
	 */
	public void setSagyoCd(String sagyoCd) {
		this.sagyoCd = sagyoCd;
	}

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

	/**
	 * @return anbunRitu
	 */
	public BigDecimal getAnbunRitu() {
		return anbunRitu;
	}

	/**
	 * @param anbunRitu セットする anbunRitu
	 */
	public void setAnbunRitu(BigDecimal anbunRitu) {
		this.anbunRitu = anbunRitu;
	}

}
