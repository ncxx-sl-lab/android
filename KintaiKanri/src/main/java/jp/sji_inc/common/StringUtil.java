package jp.sji_inc.common;

import java.util.List;

public class StringUtil {

	/**
	 * NULLチェック
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if (str == null) {
			return true;
		}
		str = str.replaceAll(" ", "");
		if (str.length() == 0) {
			return true;
		}
		str = str.replaceAll("　", "");
		if (str.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * グリッド用ｺﾝﾎﾞに変換する
	 * @param l
	 * @return
	 */
	public static String cmbJqGridComboString(List<LabelBean> l) {
		StringBuffer sb = new StringBuffer();
		sb.append(":;");
		for (LabelBean lb : l) {
			sb.append(lb.getValue()).append(":")
				.append(StringUtil.escapeJqGridCombo(lb.getLabel())).append(";");
		}
		sb.setLength(sb.length()-1);
		return sb.toString();
	}

	/**
	 * jqGridのｺﾝﾎﾞ用エスケープ
	 * @param str
	 * @return
	 */
	public static String escapeJqGridCombo(String str) {
		if (StringUtil.isNull(str)) {
			return "";
		}
		return str.replaceAll(":", "\\\\:");
	}

	/**
	 *
	 * @param name
	 * @return
	 */
	public static String[] NameSprit(String name) {
		if (StringUtil.isNull(name)) {
			return new String[]{"",""};
		}
		String ttmp = name.replaceAll("　", " ");
		ttmp = ttmp.replaceAll("[\\s]+", " ");
		String [] tmp = ttmp.split(" ");
		String[] tmp2 = null;
		if (tmp.length > 1) {
			tmp2 = new String[]{tmp[0], tmp[1]};
		} else {
			tmp2 = new String[]{tmp[0], null};
		}
		return tmp2;
	}

	/**
	 * NULLだったら空文字返す
	 * @param str
	 * @return
	 */
	public static String nullToString(String str) {
		if (StringUtil.isNull(str)) {
			return "";
		}
		return str;
	}
}
