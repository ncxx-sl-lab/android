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
@Table(name="SHIFT_DEFAULT")
public class ShiftDefault implements Serializable {

	/** ｼﾌﾄ番号 */
	@Id
	@Column(name = "SHIFT_NO", length = 6)
	private String shiftNo;

	/** 開始時間 */
	@Column(name = "START_TIME", length = 5)
	private String startTime;

	/** 終業時間 */
	@Column(name = "END_TIME", length = 5)
	private String endTime;

	/** 超過 */
	@Column(name = "TYOUKA")
	private BigDecimal tyouka;

	/** 1日 */
	@Column(name = "DAY_HOURS")
	private BigDecimal dayHours;

	/** 半休区分 */
	@Column(name = "HANKYU_KBN")
	private String hankyuKbn;

	/** 休暇1開始 */
	@Column(name = "REST1_START", length = 5)
	private String rest1Start;

	/** 休暇1終了 */
	@Column(name = "REST1_END", length = 5)
	private String rest1End;

	/** 休暇2開始 */
	@Column(name = "REST2_START", length = 5)
	private String rest2Start;

	/** 休暇2終了 */
	@Column(name = "REST2_END", length = 5)
	private String rest2End;

	/** 休暇3開始 */
	@Column(name = "REST3_START", length = 5)
	private String rest3Start;

	/** 休暇3終了 */
	@Column(name = "REST3_END", length = 5)
	private String rest3End;

	/** 休暇4開始 */
	@Column(name = "REST4_START", length = 5)
	private String rest4Start;

	/** 休暇4終了 */
	@Column(name = "REST4_END", length = 5)
	private String rest4End;

	/** 休暇5開始 */
	@Column(name = "REST5_START", length = 5)
	private String rest5Start;

	/** 休暇5終了 */
	@Column(name = "REST5_END", length = 5)
	private String rest5End;

	/** 休暇6開始 */
	@Column(name = "REST6_START", length = 5)
	private String rest6Start;

	/** 休暇6終了 */
	@Column(name = "REST6_END", length = 5)
	private String rest6End;

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
	 * @return startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime セットする startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime セットする endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return tyouka
	 */
	public BigDecimal getTyouka() {
		return tyouka;
	}

	/**
	 * @param tyouka セットする tyouka
	 */
	public void setTyouka(BigDecimal tyouka) {
		this.tyouka = tyouka;
	}

	/**
	 * @return dayHours
	 */
	public BigDecimal getDayHours() {
		return dayHours;
	}

	/**
	 * @param dayHours セットする dayHours
	 */
	public void setDayHours(BigDecimal dayHours) {
		this.dayHours = dayHours;
	}

	/**
	 * @return hankyuKbn
	 */
	public String getHankyuKbn() {
		return hankyuKbn;
	}

	/**
	 * @param hankyuKbn セットする hankyuKbn
	 */
	public void setHankyuKbn(String hankyuKbn) {
		this.hankyuKbn = hankyuKbn;
	}

	/**
	 * @return rest1Start
	 */
	public String getRest1Start() {
		return rest1Start;
	}

	/**
	 * @param rest1Start セットする rest1Start
	 */
	public void setRest1Start(String rest1Start) {
		this.rest1Start = rest1Start;
	}

	/**
	 * @return rest1End
	 */
	public String getRest1End() {
		return rest1End;
	}

	/**
	 * @param rest1End セットする rest1End
	 */
	public void setRest1End(String rest1End) {
		this.rest1End = rest1End;
	}

	/**
	 * @return rest2Start
	 */
	public String getRest2Start() {
		return rest2Start;
	}

	/**
	 * @param rest2Start セットする rest2Start
	 */
	public void setRest2Start(String rest2Start) {
		this.rest2Start = rest2Start;
	}

	/**
	 * @return rest2End
	 */
	public String getRest2End() {
		return rest2End;
	}

	/**
	 * @param rest2End セットする rest2End
	 */
	public void setRest2End(String rest2End) {
		this.rest2End = rest2End;
	}

	/**
	 * @return rest3Start
	 */
	public String getRest3Start() {
		return rest3Start;
	}

	/**
	 * @param rest3Start セットする rest3Start
	 */
	public void setRest3Start(String rest3Start) {
		this.rest3Start = rest3Start;
	}

	/**
	 * @return rest3End
	 */
	public String getRest3End() {
		return rest3End;
	}

	/**
	 * @param rest3End セットする rest3End
	 */
	public void setRest3End(String rest3End) {
		this.rest3End = rest3End;
	}

	/**
	 * @return rest4Start
	 */
	public String getRest4Start() {
		return rest4Start;
	}

	/**
	 * @param rest4Start セットする rest4Start
	 */
	public void setRest4Start(String rest4Start) {
		this.rest4Start = rest4Start;
	}

	/**
	 * @return rest4End
	 */
	public String getRest4End() {
		return rest4End;
	}

	/**
	 * @param rest4End セットする rest4End
	 */
	public void setRest4End(String rest4End) {
		this.rest4End = rest4End;
	}

	/**
	 * @return rest5Start
	 */
	public String getRest5Start() {
		return rest5Start;
	}

	/**
	 * @param rest5Start セットする rest5Start
	 */
	public void setRest5Start(String rest5Start) {
		this.rest5Start = rest5Start;
	}

	/**
	 * @return rest5End
	 */
	public String getRest5End() {
		return rest5End;
	}

	/**
	 * @param rest5End セットする rest5End
	 */
	public void setRest5End(String rest5End) {
		this.rest5End = rest5End;
	}

	/**
	 * @return rest6Start
	 */
	public String getRest6Start() {
		return rest6Start;
	}

	/**
	 * @param rest6Start セットする rest6Start
	 */
	public void setRest6Start(String rest6Start) {
		this.rest6Start = rest6Start;
	}

	/**
	 * @return rest6End
	 */
	public String getRest6End() {
		return rest6End;
	}

	/**
	 * @param rest6End セットする rest6End
	 */
	public void setRest6End(String rest6End) {
		this.rest6End = rest6End;
	}

}
