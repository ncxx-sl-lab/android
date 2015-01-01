package jp.sji.kansai.android.demo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jp.sji.kansai.android.demo.costants.AppConstants;

public class DateUtil {

	/**
	 * 現在日時を取得します。
	 * @return
	 */
	public static Date getSysdate() {
		Calendar cal = new GregorianCalendar();
		return cal.getTime();
	}

	public static int getDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	public static int getDayOfWeek(int year, int month, int day) {
		Calendar cal = new GregorianCalendar(year, month, day);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 現在の曜日を取得します。
	 * 取得出来なかった場合は空文字を返却します。
	 * @return 曜日
	 */
	public static String getStrDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		return DateUtil.getStrDayOfWeek(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 指定された年月日から曜日を取得します。<br>
	 * 取得出来なかった場合は空文字を返却します。
	 *
	 * @param year
	 *            年(YYYY)
	 * @param month
	 *            月(MM)
	 * @param day
	 *            日(DD)
	 * @return 曜日
	 */
	public static String getStrDayOfWeek(int year, int month, int day) {
		Calendar cal = new GregorianCalendar(year, month - 1, day);
		return DateUtil.getStrDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
	}

	public static String getStrDayOfWeek(Date value) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(value);
		return getStrDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
	}

	public static String getStrDayOfWeek(String value) {
		SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.DATE_FORMAT_YYYYMMDD);

		Date date = null;
		Calendar cal = new GregorianCalendar();

		try {
			date = sdf.parse(value);
		} catch(Exception e) {
			throw new IllegalArgumentException(e);
		}

		cal.setTime(date);
		return DateUtil.getStrDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
	}

	public static String getStrDayOfWeek(int value) {
		String strDayOfWeek = "";
		switch(value) {
			case Calendar.SUNDAY :
				strDayOfWeek = "日";
				break;
			case Calendar.MONDAY :
				strDayOfWeek = "月";
				break;
			case Calendar.TUESDAY:
				strDayOfWeek = "火";
				break;
			case Calendar.WEDNESDAY :
				strDayOfWeek = "水";
				break;
			case Calendar.THURSDAY:
				strDayOfWeek = "木";
				break;
			case Calendar.FRIDAY:
				strDayOfWeek = "金";
				break;
			case Calendar.SATURDAY:
				strDayOfWeek = "土";
			break;
		}

		return strDayOfWeek;

	}

	/**
	 * 引数で指定された日付から増減月を足したものを返す
	 *
	 * @param inDate 基準日付
	 * @param addParam 増減月
	 * @return Date 基準日付 + 増減月
	 */
	public static Date addMonth(Date inDate, int addParam) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(inDate);

		calendar.add(GregorianCalendar.MONTH, addParam);

		return calendar.getTime();

	}

	/**
	 * 引数で指定された日付から増減月を足したものを返す
	 *
	 * @param dt 基準日付
	 * @param addParam 増減月
	 * @param type 日付書式(例：yyyyMMdd)
	 * @return String 基準日付 + 増減月
	 */
//	public static String addMonth(String dt, int addParam, String type) {
//
//		Date retDate = ConvertUtil.toDate(dt, type);
//
//		return FormatUtil.formatDate(addMonth(retDate, addParam), type);
//	}

	/**
	 * 引数で指定された日付から増減日を足したものを返す
	 *
	 * @param inDate 基準日付
	 * @param addParam 増減日
	 * @return Date 基準日付 + 増減日
	 */
	public static Date addDate(Date inDate, int addParam) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(inDate);

		calendar.add(GregorianCalendar.DATE, addParam);

		return calendar.getTime();

	}

	/**
	 * 引数で指定された日付から増減日を足したものを返す
	 *
	 * @param dt 基準日付
	 * @param addParam 増減日
	 * @param type 日付書式(例：yyyyMMdd)
	 * @return String 基準日付 + 増減日
	 */
//	public static String addDate(String dt, int addParam, String type) {
//
//		Date retDate = ConvertUtil.toDate(dt, type);
//
//		return FormatUtil.formatDate(addDate(retDate, addParam), type);
//	}

	/**
	 * 引数で指定された年月の初日を返す
	 *
	 * @param date 任意の日付
	 * @return Date 月初の日付
	 */
	public static Date getMonthFirstDate(Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		// 初日をカレンダーに設定
		calendar.set(Calendar.DATE, 1);

		return calendar.getTime();
	}

	/**
	 * 引数で指定された年月の末日を返す
	 *
	 * @param date 任意の日付
	 * @return Date 月末の日付
	 */
	public static Date getMonthEndDate(Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		// 末日を取得
		int last = calendar.getActualMaximum(Calendar.DATE);

		// 末日をカレンダーに設定
		calendar.set(Calendar.DATE, last);

		return calendar.getTime();
	}
}
