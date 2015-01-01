package jp.sji.kansai.android.demo.buyer.util;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import jp.sji.kansai.android.demo.buyer.costants.PropertyConstants;
import jp.sji.kansai.android.demo.buyer.dto.HttpResponseDto;
import jp.sji.kansai.android.demo.buyer.exception.SystemErrorException;
import android.content.Context;

/**
 * APサーバーとの通信処理を行う。
 */
public class APServerManager {

	/** APサーバーのURL(registration ID登録用) */
	private static final String AP_SERVER_REGISTER_URL = PropertyConstants.AP_SERVER_URL + "/C2DMRegist.do";

	/** APサーバーのURL(registration ID解除用) */
	private static final String AP_SERVER_UNREGISTER_URL = PropertyConstants.AP_SERVER_URL + "/C2DMUnRegist.do";

	/** APサーバーのURL(プッシュ通知用) */
	private static final String AP_SERVER_PUSH_URL = PropertyConstants.AP_SERVER_URL + "/C2DMPush.do";

	/**
	 * APサーバーにC2DMの設定情報を登録する。
	 *
	 * @param context コンテキスト
	 * @param empNo 社員番号
	 * @param registrationId registrationID
	 */
	public static void register(Context context, String empNo, String registrationId) {

		// AndroidIDの取得
		String deviceId = SystemUtil.getDeviceId(context);

		// リクエストパラメータの作成
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("empNo", empNo);
		paramMap.put("division", PropertyConstants.C2DM_DIVISION_DEVICE);
		paramMap.put("registrationId", registrationId);
		paramMap.put("deviceId", deviceId);

		// POSTリクエストの実行
		HttpResponseDto httpResponseDto = HttpUtil.executePostRequestUTF8(AP_SERVER_REGISTER_URL, paramMap);

		if (httpResponseDto.getStatusCode() != HttpURLConnection.HTTP_OK) {
			throw new SystemErrorException("不正なHTTPステータスコードが返却されました。statusCode = " + httpResponseDto.getStatusCode());
		}

		if (!checkApiResult(httpResponseDto.getResponseBody())) {
			throw new SystemErrorException("APサーバーにてC2DMの設定情報の登録に失敗しました。");
		}
	}

	/**
	 * APサーバーに登録したC2DMの設定情報を削除する。
	 *
	 * @param context コンテキスト
	 */
	public static void unregister(Context context) {

		// AndroidIDの取得
		String deviceId = SystemUtil.getDeviceId(context);

		// リクエストパラメータの作成
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("division", PropertyConstants.C2DM_DIVISION_DEVICE);
		paramMap.put("deviceId", deviceId);

		// POSTリクエストの実行
		HttpResponseDto httpResponseDto = HttpUtil.executePostRequestUTF8(AP_SERVER_UNREGISTER_URL, paramMap);

		if (httpResponseDto.getStatusCode() != HttpURLConnection.HTTP_OK) {
			throw new SystemErrorException("不正なHTTPステータスコードが返却されました。statusCode = " + httpResponseDto.getStatusCode());
		}

		if (!checkApiResult(httpResponseDto.getResponseBody())) {
			throw new SystemErrorException("APサーバーにてC2DMの設定情報の削除に失敗しました。");
		}
	}

	/**
	 * APサーバーにプッシュ通知を依頼する。
	 *
	 * @param context コンテキスト
	 * @param empNo プッシュ通知の送信対象の社員番号
	 * @param requestNo 申請番号
	 */
	public static void push(Context context, String empNo, String requestNo) {

		// リクエストパラメータの作成
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("empNo", empNo);
		paramMap.put("division", PropertyConstants.C2DM_DIVISION_PUSH);
		paramMap.put("message", requestNo);

		// POSTリクエストの実行
		HttpResponseDto httpResponseDto = HttpUtil.executePostRequestUTF8(AP_SERVER_PUSH_URL, paramMap);

		if (httpResponseDto.getStatusCode() != HttpURLConnection.HTTP_OK) {
			throw new SystemErrorException("不正なHTTPステータスコードが返却されました。statusCode = " + httpResponseDto.getStatusCode());
		}

		if (!checkApiResult(httpResponseDto.getResponseBody())) {
			throw new SystemErrorException("APサーバーにてプッシュ通知に失敗しました。");
		}
	}

	/**
	 * APIの実行結果をチェックする。
	 *
	 * @param xml APIの実行結果
	 * @return true：正常終了 false：異常終了
	 */
	private static boolean checkApiResult(String xml) {
		//TODO [teraoka] XML解析処理が未実装のため、簡易的なチェックを行う
		if (xml.contains("<resultCode>00000</resultCode>")) {
			// 結果コードが正常の場合
			return true;
		} else {
			return false;
		}
	}
}
