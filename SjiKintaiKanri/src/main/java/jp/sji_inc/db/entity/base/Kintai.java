package jp.sji_inc.db.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="KINTAI")
public class Kintai implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3456641167438699116L;

	/** 社員番号 */
	@Id
	@Column(name = "EMP_NO", length = 5)
	private String empNo;

	/** 勤務日 */
	@Id
	@Column(name = "KINTAI_DATE", length = 8)
	private String kintaiDate;

	/** 勤務月 */
	@Column(name = "KINTAI_MONTH", length = 6, nullable = false)
	private String kintaiMonth;

	/** 開始時間 */
	@Column(name = "START_TIME", length=5)
	private String startTime;

	/** 終了時間 */
	@Column(name = "END_TIME", length=5)
	private String endTime;

	/** 開始時間（内部計算用) */
	@Column(name = "START_TIME_ROUND", length=5)
	private String startTimeRound;

	/** 終了時間（内部計算用) */
	@Column(name = "END_TIME_ROUND", length=5)
	private String endTimeRound;

	/** ｼﾌﾄ番号 */
	@Column(name = "SHIFT_NO", nullable=false, length = 2, columnDefinition="char(2) default ''")
	private String shiftNo = "";

	/** 勤務時間(通算) */
	@Column(name = "HOURS_SUM")
	private BigDecimal hoursSum;

	/** 遅刻時間 */
	@Column(name = "LATE_TIME")
	private BigDecimal lateTime;

	/** 早退時間 */
	@Column(name = "LEAVE_EARLY_TIME")
	private BigDecimal leaveEarlyTime;

	/** 勤務時間(通算) */
	@Column(name = "HOURS")
	private BigDecimal hours;

	/** 勤務時間(残業普通) */
	@Column(name = "OVERTIME")
	private BigDecimal overtime;

	/** 勤務時間(残業普通) */
	@Column(name = "LATE_OVERTIME")
	private BigDecimal lateOvertime;

	/** 特記事項 */
	@Column(name = "TOKKI_JIKO")
	private String tokkiJiko;

	/** 休暇未取得申請２ */
	@Column(name = "KYUKA_MISYUTOKU_SINSEI_2")
	private String kyukaMisyutokuSinsei2;

	/** 休暇未取得申請３ */
	@Column(name = "KYUKA_MISYUTOKU_SINSEI_3")
	private String kyukaMisyutokuSinsei3;

	/** 休暇未取得申請４ */
	@Column(name = "KYUKA_MISYUTOKU_SINSEI_4")
	private String kyukaMisyutokuSinsei4;

	/** 休暇未取得申請５ */
	@Column(name = "KYUKA_MISYUTOKU_SINSEI_5")
	private String kyukaMisyutokuSinsei5;

	/** 休暇未取得申請６ */
	@Column(name = "KYUKA_MISYUTOKU_SINSEI_6")
	private String kyukaMisyutokuSinsei6;

	/** 項目番号 */
	@Column(name = "KOUMOKU_NO", length=2)
	private String koumokuNo;

	/** ﾌﾟﾛｼﾞｪｸﾄ番号 */
	@Column(name = "PROJECT_NO")
	private String projectNo;

	/** ｼﾌﾄ */
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="EMP_NO", referencedColumnName="EMP_NO", insertable=false, updatable=false),
		@JoinColumn(name="KINTAI_MONTH", referencedColumnName="KINTAI_MONTH", insertable=false, updatable=false),
		@JoinColumn(name="SHIFT_NO", referencedColumnName="SHIFT_NO", insertable=false, updatable=false)
	})
	private Shift shift;

	/** 休暇 */
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="KOUMOKU_NO", referencedColumnName="NO", insertable=false, updatable=false)
	private Kyuka kyuka;

	/** ﾌﾟﾛｼﾞｪｸﾄ */
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="EMP_NO", referencedColumnName="EMP_NO", insertable=false, updatable=false),
		@JoinColumn(name="PROJECT_NO", referencedColumnName="PROJECT_NO", insertable=false, updatable=false)
	})
	private Project project;

	/** 作業按分 */
	@OneToMany
	@OrderBy(value = "SAGYO_CD")
	@JoinColumns({
		@JoinColumn(name="EMP_NO", referencedColumnName="EMP_NO", insertable=false, updatable=false),
		@JoinColumn(name="KINTAI_DATE", referencedColumnName="KINTAI_DATE", insertable=false, updatable=false)
	})
	private List<KintaiSagyoAnbun> kintaiSagyoAnbun;

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
	 * @return tokkiJiko
	 */
	public String getTokkiJiko() {
		return tokkiJiko;
	}

	/**
	 * @param tokkiJiko セットする tokkiJiko
	 */
	public void setTokkiJiko(String tokkiJiko) {
		this.tokkiJiko = tokkiJiko;
	}

	/**
	 * @return koumokuNo
	 */
	public String getKoumokuNo() {
		return koumokuNo;
	}

	/**
	 * @param koumokuNo セットする koumokuNo
	 */
	public void setKoumokuNo(String koumokuNo) {
		this.koumokuNo = koumokuNo;
	}

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
	 * @return shift
	 */
	public Shift getShift() {
		return shift;
	}

	/**
	 * @param shift セットする shift
	 */
	public void setShift(Shift shift) {
		this.shift = shift;
	}

	/**
	 * @return project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project セットする project
	 */
	public void setProject(Project project) {
		this.project = project;
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
	 * @return kintaiSagyoAnbun
	 */
	public List<KintaiSagyoAnbun> getKintaiSagyoAnbun() {
		return kintaiSagyoAnbun;
	}

	/**
	 * @param kintaiSagyoAnbun セットする kintaiSagyoAnbun
	 */
	public void setKintaiSagyoAnbun(List<KintaiSagyoAnbun> kintaiSagyoAnbun) {
		this.kintaiSagyoAnbun = kintaiSagyoAnbun;
	}

	/**
	 * @return overtime
	 */
	public BigDecimal getOvertime() {
		return overtime;
	}

	/**
	 * @param overtime セットする overtime
	 */
	public void setOvertime(BigDecimal overtime) {
		this.overtime = overtime;
	}

	/**
	 * @return lateOvertime
	 */
	public BigDecimal getLateOvertime() {
		return lateOvertime;
	}

	/**
	 * @param lateOvertime セットする lateOvertime
	 */
	public void setLateOvertime(BigDecimal lateOvertime) {
		this.lateOvertime = lateOvertime;
	}

	/**
	 * @return lateTime
	 */
	public BigDecimal getLateTime() {
		return lateTime;
	}

	/**
	 * @param lateTime セットする lateTime
	 */
	public void setLateTime(BigDecimal lateTime) {
		this.lateTime = lateTime;
	}

	/**
	 * @return leaveEarlyTime
	 */
	public BigDecimal getLeaveEarlyTime() {
		return leaveEarlyTime;
	}

	/**
	 * @param leaveEarlyTime セットする leaveEarlyTime
	 */
	public void setLeaveEarlyTime(BigDecimal leaveEarlyTime) {
		this.leaveEarlyTime = leaveEarlyTime;
	}

	/**
	 * @return kyuka
	 */
	public Kyuka getKyuka() {
		return kyuka;
	}

	/**
	 * @param kyuka セットする kyuka
	 */
	public void setKyuka(Kyuka kyuka) {
		this.kyuka = kyuka;
	}

	/**
	 * @return hoursSum
	 */
	public BigDecimal getHoursSum() {
		return hoursSum;
	}

	/**
	 * @param hoursSum セットする hoursSum
	 */
	public void setHoursSum(BigDecimal hoursSum) {
		this.hoursSum = hoursSum;
	}

	/**
	 * @return startTimeRound
	 */
	public String getStartTimeRound() {
		return startTimeRound;
	}

	/**
	 * @param startTimeRound セットする startTimeRound
	 */
	public void setStartTimeRound(String startTimeRound) {
		this.startTimeRound = startTimeRound;
	}

	/**
	 * @return endTimeRound
	 */
	public String getEndTimeRound() {
		return endTimeRound;
	}

	/**
	 * @param endTimeRound セットする endTimeRound
	 */
	public void setEndTimeRound(String endTimeRound) {
		this.endTimeRound = endTimeRound;
	}

	/**
	 * @return kyukaMisyutokuSinsei2
	 */
	public String getKyukaMisyutokuSinsei2() {
		return kyukaMisyutokuSinsei2;
	}

	/**
	 * @param kyukaMisyutokuSinsei2 セットする kyukaMisyutokuSinsei2
	 */
	public void setKyukaMisyutokuSinsei2(String kyukaMisyutokuSinsei2) {
		this.kyukaMisyutokuSinsei2 = kyukaMisyutokuSinsei2;
	}

	/**
	 * @return kyukaMisyutokuSinsei3
	 */
	public String getKyukaMisyutokuSinsei3() {
		return kyukaMisyutokuSinsei3;
	}

	/**
	 * @param kyukaMisyutokuSinsei3 セットする kyukaMisyutokuSinsei3
	 */
	public void setKyukaMisyutokuSinsei3(String kyukaMisyutokuSinsei3) {
		this.kyukaMisyutokuSinsei3 = kyukaMisyutokuSinsei3;
	}

	/**
	 * @return kyukaMisyutokuSinsei4
	 */
	public String getKyukaMisyutokuSinsei4() {
		return kyukaMisyutokuSinsei4;
	}

	/**
	 * @param kyukaMisyutokuSinsei4 セットする kyukaMisyutokuSinsei4
	 */
	public void setKyukaMisyutokuSinsei4(String kyukaMisyutokuSinsei4) {
		this.kyukaMisyutokuSinsei4 = kyukaMisyutokuSinsei4;
	}

	/**
	 * @return kyukaMisyutokuSinsei5
	 */
	public String getKyukaMisyutokuSinsei5() {
		return kyukaMisyutokuSinsei5;
	}

	/**
	 * @param kyukaMisyutokuSinsei5 セットする kyukaMisyutokuSinsei5
	 */
	public void setKyukaMisyutokuSinsei5(String kyukaMisyutokuSinsei5) {
		this.kyukaMisyutokuSinsei5 = kyukaMisyutokuSinsei5;
	}

	/**
	 * @return kyukaMisyutokuSinsei6
	 */
	public String getKyukaMisyutokuSinsei6() {
		return kyukaMisyutokuSinsei6;
	}

	/**
	 * @param kyukaMisyutokuSinsei6 セットする kyukaMisyutokuSinsei6
	 */
	public void setKyukaMisyutokuSinsei6(String kyukaMisyutokuSinsei6) {
		this.kyukaMisyutokuSinsei6 = kyukaMisyutokuSinsei6;
	}

}
