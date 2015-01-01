package jp.sji.kansai.android.demo.manager.util;

import java.util.ResourceBundle;

import jp.sji.kansai.android.demo.manager.costants.AppConstants;
import android.content.Context;
import android.provider.Settings.Secure;

/**
 * システム用のユーティリティクラス
 */
public class SystemUtil {

	/**
	 * AndroidのデバイスIDを取得する。
	 *
	 * @param key キー
	 * @return プロパティの値
	 */
	public static String getDeviceId(Context context) {
		return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
	}

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
