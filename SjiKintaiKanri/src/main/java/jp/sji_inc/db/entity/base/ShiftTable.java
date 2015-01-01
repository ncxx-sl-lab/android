/**
 *
 */
package jp.sji_inc.db.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author z1j7663
 *
 */
@Entity
@Table(name="SHIFT_TABLE")
public class ShiftTable implements Serializable {

	/** 社員番号 */
	@Id
	@Column(name = "EMP_NO", length = 5)
	private String empNo;

	/** 勤務月 */
	@Id
	@Column(name = "KINTAI_MONTH", length = 6)
	private String kintaiMonth;

	/** ｼﾌﾄ番号 */
	@Id
	@Column(name = "SHIFT_NO", length = 2)
	private String shiftNo;

	/** 時刻 */
	@Id
	@Column(name = "TIME")
	private BigDecimal time;

	/** 通常 */
	@Column(name = "HOURS")
	private BigDecimal hours;

	/** 残業 */
	@Column(name = "OVER")
	private BigDecimal over;

	/** 深夜 */
	@Column(name = "LATE_OVER")
	private BigDecimal lateOver;

	/**
	 * @return empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo セットする empNo
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

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

	/**
	 * @return shiftNo
	 */
	public String getShiftNo() {
		return shiftNo;
	}

	/**
	 * @param shiftNo セットする shiftNo
	 */
	public void setShiftNo(String shiftNo) {
		this.shiftNo = shiftNo;
	}

	/**
	 * @return time
	 */
	public BigDecimal getTime() {
		return time;
	}

	/**
	 * @param time セットする time
	 */
	public void setTime(BigDecimal time) {
		this.time = time;
	}

	/**
	 * @return hours
	 */
	public BigDecimal getHours() {
		return hours;
	}

	/**
	 * @param hours セットする hours
	 */
	public void setHours(BigDecimal hours) {
		this.hours = hours;
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
