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
public class KintaiShiftSaveForm implements Serializable {

	/** 社員番号 */
	private String empNo;

	/** 勤務月 */
	@NotNull
	@Pattern(regexp="^[0-9]{6}$")
	private String kintaiMonth;

	/** 開始時間 */
	@NotNull
	@Pattern(regexp="^[0-9]{2}:[0-9]{2}$")
	private String startTime;

	/** 終業時間 */
	@NotNull
	@Pattern(regexp="^[0-9]{2}:[0-9]{2}$")
	private String endTime;

	/** 休暇1開始 */
	@NotNull
	@Pattern(regexp="^[0-9]{2}:[0-9]{2}$")
	private String rest1Start;

	/** 休暇1終了 */
	@NotNull
	@Pattern(regexp="^[0-9]{2}:[0-9]{2}$")
	private String rest1End;

	/** 休暇2開始 */
	@NotNull
	@Pattern(regexp="^[0-9]{2}:[0-9]{2}$")
	private String rest2Start;

	/** 休暇2終了 */
	@NotNull
	@Pattern(regexp="^[0-9]{2}:[0-9]{2}$")
	private String rest2End;

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

}
