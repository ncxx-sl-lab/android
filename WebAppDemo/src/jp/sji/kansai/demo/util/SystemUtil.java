package jp.sji.kansai.demo.util;

import java.util.ResourceBundle;

import jp.sji.kansai.demo.constants.AppConstants;
/**
 * システム用のユーティリティクラス
 */
public class SystemUtil {

	/**
	 * プロパティの値を取得する。
	 *
	 * @param key キー
	 * @return プロパティの値
	 */
	public static String getProperty(String key) {

		ResourceBundle rb = ResourceBundle.getBundle(AppConstants.APP_PROP_NAME);
		String value = rb.getString(key);

		return value;
	}
}
