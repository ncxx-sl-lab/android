/**
 *
 */
package jp.sji_inc.common;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @author kyon
 *
 */
public class DateUtil {

	public static final SimpleDateFormat SFD_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat SFD_YYYYMM = new SimpleDateFormat("yyyyMM");
	public static final SimpleDateFormat SFD_YYYYMMDD_SLASH = new SimpleDateFormat("yyyy/MM/dd");
	public static final SimpleDateFormat SFD_HHMM_COMMA = new SimpleDateFormat("HH:mm");

	/**
	 * 時刻からカレンダー取得
	 * @param hh_mm
	 * @return
	 */
	public static Calendar timeToCalender(String hh_mm) {
		try {
			Date d = SFD_HHMM_COMMA.parse(hh_mm);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			return cal;
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 曜日番号取得
	 * @return 曜日番号
	 */
	public static int getWdayNum(String yyyyMMdd) {
		try {
			Date d = DateUtil.SFD_YYYYMMDD.parse(yyyyMMdd);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			return cal.get(Calendar.DAY_OF_WEEK);
		} catch (ParseException e) {
			return -1;
		}
	}

	/**
	 * 休日判定
	 * @param yyyyMMdd
	 * @return
	 */
	public static boolean isHoliday(String yyyyMMdd) {
		int wday = DateUtil.getWdayNum(yyyyMMdd);
		if (wday == 1 || wday == 7) {
			return true;
		}
		return false;
	}

	/**
	 * 現在の勤怠月を取得する
	 * @return
	 */
	public static String getCurrentKintaiMonth() {
		return DateUtil.SFD_YYYYMM.format(new Date());
	}

	/**
	 * 現在の勤怠日を取得する
	 * @return
	 */
	public static String getCurrentKintaiDate() {
		return DateUtil.SFD_YYYYMMDD.format(new Date());
	}

	/**
	 * 時間を比較する
	 * 0 同じ
	 * 1  hh_mm1の方が時間進んでる
	 * -1 hh_mm2の方が時間進んでる
	 * @param hh_mm1
	 * @param hh_mm2
	 * @return
	 */
	public static int compareTo(String hh_mm1, String hh_mm2) {
		int ret = 0;
		BigDecimal d = DateUtil.getDiff(hh_mm1, hh_mm2);
		if (d.compareTo(BigDecimal.ZERO) > 0) {
			ret = 1;
		} else {
			ret = -1;
		}
		return ret;
	}

	/**
	 * 時間の差分を計算する
	 * @param d1
	 * @param d2
	 * @return h.mm
	 */
	public static BigDecimal getDiff(String hh_mm1, String hh_mm2) {
		int h1 = DateUtil.getHour(hh_mm1);
		int h2 = DateUtil.getHour(hh_mm2);
		int m1 = DateUtil.getMinitsu(hh_mm1);
		int m2 = DateUtil.getMinitsu(hh_mm2);
		BigDecimal ret = new BigDecimal((h1 - h2) + (double)(m1 - m2)/60);
		return ret;
	}

	/**
	 * 時間を15分単位で丸める
	 * @param hh_mm
	 * @return
	 */
	public static String getRoundedTime(String hh_mm) {
		if (StringUtil.isNull(hh_mm)) {
			return null;
		}
		int m = DateUtil.getMinitsu(hh_mm);
		m = ((int)(m / 15))*15;
		StringBuffer sb = new StringBuffer();
		sb.append(hh_mm.substring(0,2)).append(":").append(String.format("%02d", m));
		return sb.toString();
	}

	/**
	 * 時間文字列を数値に変換
	 * @param hh_mm
	 * @return
	 */
	public static double parse(String hh_mm) {
		int h = DateUtil.getHour(hh_mm);
		int m = DateUtil.getMinitsu(hh_mm);
		return h + (double)m / 60;
	}

	/**
	 * 数値から時間に変換
	 * @param h
	 * @return
	 */
	public static String parse(double h) {
		int ih = (int)h;
		double dm = (h - ih)*60;
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("%02d", ih)).append(":").append(String.format("%02d", (int)dm));
		return sb.toString();
	}

	/**
	 * 時間追加
	 * @param hh_mm
	 * @param num
	 * @return
	 */
	public static String add(String hh_mm, double num) {
		double org = DateUtil.parse(hh_mm);
		org += num;
		return DateUtil.parse(org);
	}

	/**
	 * シリアル値に変換
	 * @param hh_mm
	 * @return
	 */
	public static double getSerial(String hh_mm) {
		if (StringUtil.isNull(hh_mm)) {
			return -1;
		}
		double hour = DateUtil.getHour(hh_mm);
		double min = DateUtil.getMinitsu(hh_mm);
		return (hour / 24) + (min / 1440);
	}

	/**
	 * 時間取得
	 * @param hh_mm
	 * @return
	 */
	public static int getHour(String hh_mm) {
		return Integer.parseInt(hh_mm.substring(0,2));
	}

	/**
	 * 時間取得
	 * @param hh_mm
	 * @return
	 */
	public static int getMinitsu(String hh_mm) {
		return Integer.parseInt(hh_mm.substring(3,5));
	}

	/**
	 *
	 * @param yyyymm
	 * @return
	 */
	public static int getMonth(String yyyymm) {
		return Integer.parseInt(yyyymm.substring(4, 6));
	}
}
