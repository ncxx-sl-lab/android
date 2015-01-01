/**
 *
 */
package jp.sji_inc.action.form;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jp.sji_inc.common.DateUtil;
import jp.sji_inc.db.entity.base.KintaiSagyoAnbun;
import jp.sji_inc.db.entity.base.Kyuka;
import jp.sji_inc.db.entity.base.Project;
import jp.sji_inc.db.entity.base.Shift;

/**
 * @author kyon
 *
 */
public class KintaiGridForm {

	/** 表示用デートフォーマット */
	private SimpleDateFormat sfd = new SimpleDateFormat("yyyy/MM/dd(E)");

	/** 勤務日 */
	private String kintaiDate;

	/** 開始時間 */
	private String startTime;

	/** 終了時間 */
	private String endTime;

	/** シフト */
	private String shiftNo;

	/** 特記事項 */
	private String tokkiJiko;

	/** 項目番号 */
	private String koumokuNo;

	/** 休暇未取得申請２ */
	private String kyukaMisyutokuSinsei2;

	/** 休暇未取得申請３ */
	private String kyukaMisyutokuSinsei3;

	/** 休暇未取得申請４ */
	private String kyukaMisyutokuSinsei4;

	/** 休暇未取得申請５ */
	private String kyukaMisyutokuSinsei5;

	/** 休暇未取得申請６ */
	private String kyukaMisyutokuSinsei6;

	/** プロジェクト番号 */
	private String projectNo;

	/** 作業コード */
	private String sagyoCd;

	/** 定時 */
	private BigDecimal hours;

	/** 残業 */
	private BigDecimal overtime;

	/** 深夜 */
	private BigDecimal lateOvertime;

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
	 * @param koumokuNo セットする koumokuNo
	 */
	public void setKoumokuNo(Kyuka kyuka) {
		if (kyuka != null) {
			this.koumokuNo = kyuka.getName();
		}
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
	 * ｼﾌﾄ設定
	 * @param shift
	 */
	public void setShiftNo(Shift shift) {
		if (shift != null) {
			this.setShiftNo(shift.getShiftNo() + " " + shift.getStartTime() + "-" + shift.getEndTime());
		}
	}

	/**
	 * ﾌﾟﾛｼﾞｪｸﾄ
	 * @param project
	 */
	public void setProjectNo(Project project) {
		if (project != null) {
			this.setProjectNo(project.getProjectName());
		}
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

	/**
	 * 勤務時間
	 * @param kintaiHoursList
	 */
	public void setSagyoCd(List<KintaiSagyoAnbun> kintaiSagyoAnbunList) {
		if (kintaiSagyoAnbunList != null) {
			StringBuffer sb = new StringBuffer();
			for (KintaiSagyoAnbun kh : kintaiSagyoAnbunList) {
				sb.append(kh.getSagyo().getSagyoName()).append(",");
			}
			if (kintaiSagyoAnbunList.size() > 0) {
				sb.setLength(sb.length()-1);
			}
			this.setSagyoCd(sb.toString());
		}
	}

	/**
	 * @return kintaiDateView
	 */
	public String getKintaiDateView() {
		try {
			if (kintaiDate != null) {
				Date d = DateUtil.SFD_YYYYMMDD.parse(kintaiDate);
				String str = sfd.format(d);
				return str;
			}
		} catch (Exception e) {
			return null;
		}
		return kintaiDate;
	}

	/**
	 * 休日フラグ
	 * @return
	 */
	public boolean isHoliday() {
		boolean ret = false;
		if (kintaiDate != null) {
			ret = DateUtil.isHoliday(kintaiDate);
		}
		return ret;
	}

}
