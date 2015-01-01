package jp.sji.kansai.android.demo.manager.util;

import jp.sji.kansai.android.demo.manager.costants.PropertyConstants;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * C2DMサーバーと情報のやりとりを行うクラス<br>
 * (受信する情報には、registrationIDの登録・解除結果、プッシュされたメッセージがある)
 */
public class C2DMManager {

	/** 登録情報を保存するプリファレンスの名前 */
	public static final String PREF_NAME_REGISTRATION_INFO = "registrationInfo";

	/** プレファレンスに保存するregistration IDのキー */
	public static final String PREF_KEY_REGISTRATION_ID = "registrationId";

	/** プレファレンスに保存する社員番号のキー */
	public static final String PREF_KEY_EMP_NO = "empNo";

	/** プレファレンスに保存するプッシュ通知の送信対象の社員番号のキー */
	public static final String PREF_KEY_SEND_EMP_NO = "sendEmpNo";

	/**
	 * C2DMサーバーにAndroid端末を登録する。
	 *
	 * @param context コンテキスト
	 */
	public static void register(Context context) {

		// インテントを作成する
		Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
		intent.setPackage("com.google.android.gsf");
		intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
		intent.putExtra("sender", PropertyConstants.GOOGLE_ACCOUNT);

		// Android端末を登録するサービスを開始する
		context.startService(intent);
	}

	/**
	 * C2DMサーバーからAndroid端末の登録を解除する。
	 *
	 * @param context コンテキスト
	 */
	public static void unregister(Context context) {

		// インテントを作成する
		Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
		intent.setPackage("com.google.android.gsf");
		intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));

		// Android端末の登録を解除するサービスを開始する
		context.startService(intent);
	}

	/**
	 * 登録情報を保存したプリファレンスを取得する。
	 *
	 * @param context コンテキスト
	 */
	private static SharedPreferences getRegistrationInfoPreferences(Context context) {
		return context.getSharedPreferences(PREF_NAME_REGISTRATION_INFO, Context.MODE_PRIVATE);
	}

	/**
	 * 端末に保存したC2DMの設定情報をクリアする。
	 *
	 * @param context コンテキスト
	 */
	public static void clearC2dmInfo(Context context) {
		C2DMManager.clearRegistrationId(context);
		C2DMManager.clearEmpNo(context);
	}

	/**
	 * 端末に保存したregistration IDを取得する。<br>
	 * ※未登録時は空文字を返却する。
	 *
	 * @param context コンテキスト
	 * @return registration ID
	 */
	public static String getRegistrationId(Context context) {
		SharedPreferences pref = getRegistrationInfoPreferences(context);
        String registrationId = pref.getString(PREF_KEY_REGISTRATION_ID, "");
        return registrationId;
	}

	/**
	 * C2DMサーバーより返却されたregistration IDを端末に保存する。
	 *
	 * @param context コンテキスト
	 * @param registrationId registration ID
	 */
	public static void saveRegistrationId(Context context, String registrationId) {
		SharedPreferences pref = getRegistrationInfoPreferences(context);
		Editor editor = pref.edit();
		editor.putString(PREF_KEY_REGISTRATION_ID, registrationId);
		editor.commit();
	}

	/**
	 * 端末に保存したregistration IDをクリアする。
	 *
	 * @param context コンテキスト
	 */
	public static void clearRegistrationId(Context context) {
		SharedPreferences pref = context.getSharedPreferences(PREF_NAME_REGISTRATION_INFO, Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
		Editor editor = pref.edit();
		editor.putString(PREF_KEY_REGISTRATION_ID, "");
		editor.commit();
	}

	/**
	 * 端末に保存した社員番号を取得する。<br>
	 * ※未登録時は空文字を返却する。
	 *
	 * @param context コンテキスト
	 * @return registration ID
	 */
	public static String getEmpNo(Context context) {
		SharedPreferences pref = getRegistrationInfoPreferences(context);
        String registrationId = pref.getString(PREF_KEY_EMP_NO, "");
        return registrationId;
	}

	/**
	 * 社員番号を端末に保存する。
	 *
	 * @param context コンテキスト
	 * @param empNo 社員番号
	 */
	public static void saveEmpNo(Context context, String empNo) {
		SharedPreferences pref = getRegistrationInfoPreferences(context);
		Editor editor = pref.edit();
		editor.putString(PREF_KEY_EMP_NO, empNo);
		editor.commit();
	}

	/**
	 * 社員番号をクリアする。
	 *
	 * @param context コンテキスト
	 */
	public static void clearEmpNo(Context context) {
		SharedPreferences pref = context.getSharedPreferences(PREF_NAME_REGISTRATION_INFO, Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
		Editor editor = pref.edit();
		editor.putString(PREF_KEY_EMP_NO, "");
		editor.commit();
	}

	/**
	 * 端末に保存したregistration IDを取得する。<br>
	 * ※未登録時は空文字を返却する。
	 *
	 * @param context コンテキスト
	 * @return registration ID
	 */
	public static String getSendEmpNo(Context context) {
		SharedPreferences pref = getRegistrationInfoPreferences(context);
        String registrationId = pref.getString(PREF_KEY_SEND_EMP_NO, "");
        return registrationId;
	}

	/**
	 * プッシュ通知の送信対象の社員番号を端末に保存する。
	 *
	 * @param context コンテキスト
	 * @param empNo プッシュ通知の送信対象の社員番号
	 */
	public static void saveSendEmpNo(Context context, String empNo) {
		SharedPreferences pref = getRegistrationInfoPreferences(context);
		Editor editor = pref.edit();
		editor.putString(PREF_KEY_SEND_EMP_NO, empNo);
		editor.commit();
	}

	/**
	 * 端末に保存したプッシュ通知の送信対象の社員番号をクリアする。
	 *
	 * @param context コンテキスト
	 */
	public static void clearSendEmpNo(Context context) {
		SharedPreferences pref = context.getSharedPreferences(PREF_NAME_REGISTRATION_INFO, Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
		Editor editor = pref.edit();
		editor.putString(PREF_KEY_SEND_EMP_NO, "");
		editor.commit();
	}


}
