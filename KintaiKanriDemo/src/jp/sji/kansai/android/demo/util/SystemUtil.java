package jp.sji.kansai.android.demo.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;



public class SystemUtil {

	/**
	 * 判定対象文字列の空文字判定を行います。
	 *
	 * @param target
	 *            判定対象文字列
	 * @return true：判定対象文字列が空文字<br>
	 *         false：判定は対象文字列が空文字ではない
	 */
	public static boolean isEmpty(String target) {
		return target == null || "".equals(target);
	}

	/**
	 * 判定対象文字列が空文字でないことを判定します。
	 *
	 * @param target
	 *            判定対象文字列
	 * @return true：判定対象文字列が空文字ではない<br>
	 *         false：判定は対象文字列が空文字
	 */
	public static boolean isNotEmpty(String target) {
		return !isEmpty(target);
	}

	/**
	 * 対象文字列が変更されているかどうかを判定します。
	 * @param origValue
	 * @param targetVal
	 * @return
	 */
	public static boolean isChanged(String origValue, String targetVal) {

		boolean flg = false;

		if (origValue == null) {
			if (isNotEmpty(targetVal)) {
				flg = true;
			}
		} else {
			if (!origValue.equals(targetVal)) {
				flg = true;
			}
		}

		return flg;
	}

	public static boolean isDate(String target, String format) {
		if (isEmpty(target)) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(true);

		try {
			Date date = sdf.parse(target, new ParsePosition(0));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static String convDateToString(Date value, String format) {

		String str = "";

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			str = sdf.format(value);
		} catch(Exception e) {
			throw new IllegalArgumentException(e);
		}

		return str;
	}

	public static String convStrToStrDateFormat(String target, String formatFrom, String formatTo) {

		if (isEmpty(target) || !isDate(target, formatFrom)) {
			return "";
		}

		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(formatFrom);
		sdf.setLenient(true);

		try {
			Date date = sdf.parse(target, new ParsePosition(0));

			sdf = new SimpleDateFormat(formatTo);
			str = sdf.format(date);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

		return str;
	}

	/**
	 * 引数valueをDateへ変換します。
	 *
	 * @param value
	 *            変換対象の文字列。String配列を指定した場合は連続した文字列を作成する。
	 * @param format
	 *            引数の日付書式を指定(例：yyyyMMdd)
	 *
	 * @return Dateオブジェクト。日付と判断できない場合は null を返却。
	 */
	public static Date toDate(Object value, String format) {

//		if (ValidateUtil.isEmpty(value)) {
//			return null;
//		}

		String check = null;

		if (value instanceof String[]) {

			// String配列の場合は文字をくっつける
//			check = StringUtil.join(value, "");

		} else {
			check = value.toString();
		}

		SimpleDateFormat fmt = new SimpleDateFormat(format);
		fmt.setLenient(true);
		Date d = null;
		try {
			d = fmt.parse(check, new ParsePosition(0));
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

		// 元の日付と一致するかをチェックします
		fmt = new SimpleDateFormat(format);
		fmt.setLenient(true);
		try {
			if (fmt.format(d).equals(check)) {
				return d;
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

		return null;
	}
}
