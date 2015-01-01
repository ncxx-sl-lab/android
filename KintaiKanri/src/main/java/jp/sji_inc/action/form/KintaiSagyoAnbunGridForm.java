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
public class KintaiSagyoAnbunGridForm implements Serializable {

	/** 勤怠日 */
	private String kintaiDate;

	/** 作業ｺｰﾄﾞ */
	private String sagyoCd;

	/** 通常 按分率 */
	private BigDecimal normalAnbunRitu;

	/** 残業 按分率 */
	private BigDecimal overAnbunRitu;

	/** 深夜 按分率 */
	private BigDecimal lateOverAnbunRitu;

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
	 * @return normalAnbunRitu
	 */
	public BigDecimal getNormalAnbunRitu() {
		return normalAnbunRitu;
	}

	/**
	 * @param normalAnbunRitu セットする normalAnbunRitu
	 */
	public void setNormalAnbunRitu(BigDecimal normalAnbunRitu) {
		this.normalAnbunRitu = normalAnbunRitu;
	}

	/**
	 * @return overAnbunRitu
	 */
	public BigDecimal getOverAnbunRitu() {
		return overAnbunRitu;
	}

	/**
	 * @param overAnbunRitu セットする overAnbunRitu
	 */
	public void setOverAnbunRitu(BigDecimal overAnbunRitu) {
		this.overAnbunRitu = overAnbunRitu;
	}

	/**
	 * @return lateOverAnbunRitu
	 */
	public BigDecimal getLateOverAnbunRitu() {
		return lateOverAnbunRitu;
	}

	/**
	 * @param lateOverAnbunRitu セットする lateOverAnbunRitu
	 */
	public void setLateOverAnbunRitu(BigDecimal lateOverAnbunRitu) {
		this.lateOverAnbunRitu = lateOverAnbunRitu;
	}

}