/**
 *
 */
package jp.sji_inc.db.entity;

import java.math.BigDecimal;

/**
 * @author z1j7663
 *
 */
public class KintaiSum {

	/** ﾌﾟﾛｼﾞｪｸﾄ番号 */
	private String projectNo;

	/** 作業ｺｰﾄﾞ */
	private String sagyoCd;

	/** 通常 */
	private BigDecimal normal;

	/** 残業 */
	private BigDecimal over;

	/** 深夜 */
	private BigDecimal lateOver;

	/**
	 * @return projectNo
	 */
	public String getProjectNo() {
		return projectNo;
	}

	/**
	 * @param projectNo セットする projectNo
	 */
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

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
	 * @return normal
	 */
	public BigDecimal getNormal() {
		return normal;
	}

	/**
	 * @param normal セットする normal
	 */
	public void setNormal(BigDecimal normal) {
		this.normal = normal;
	}

	/**
	 * @return over
	 */
	public BigDecimal getOver() {
		return over;
	}

	/**
	 * @param over セットする over
	 */
	public void setOver(BigDecimal over) {
		this.over = over;
	}

	/**
	 * @return lateOver
	 */
	public BigDecimal getLateOver() {
		return lateOver;
	}

	/**
	 * @param lateOver セットする lateOver
	 */
	public void setLateOver(BigDecimal lateOver) {
		this.lateOver = lateOver;
	}

}
