package jp.sji.kansai.demo.action.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.sji.kansai.demo.action.BaseApiAction;
import jp.sji.kansai.demo.constants.PropertyConstants;
import jp.sji.kansai.demo.dao.C2DMRegistInfoDao;
import jp.sji.kansai.demo.dto.HttpResponseDto;
import jp.sji.kansai.demo.exception.ApiException;
import jp.sji.kansai.demo.exception.SystemErrorException;
import jp.sji.kansai.demo.form.BaseApiForm;
import jp.sji.kansai.demo.util.DBManager;
import jp.sji.kansai.demo.util.HttpUtil;

/**
 * プッシュ通知APIのアクションクラス
 *
 * @author teraoka
 */
public class C2DMPushAction extends BaseApiAction {

	private static final long serialVersionUID = 1L;

	/** クライアント認証トークン */
	private static String clientCertifyToken = null;

	/**
	 * APIの処理を実行する。
	 */
	public void process(BaseApiForm baseForm, HttpServletRequest request) throws Exception {

		// リクエストパラメータの取得
		String empNo = request.getParameter("empNo");
		String division = request.getParameter("division");
		String message = request.getParameter("message");

		Connection conn=null;
		try{
			conn = DBManager.getConnection();

			// registrationIDの取得
			String registrationId = C2DMRegistInfoDao.selectRegistrationId(conn, empNo, division);

			if (registrationId != null) {
				// メッセージをプッシュする
				pushMassage(registrationId, message);
			} else {
				// プッシュ通知対象のデータがない場合
				throw new ApiException("10002", "プッシュ通知対象のデータが存在しません。");
			}
		}finally{
			try{
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e){}
		}
	}

	/**
	 * メッセージをプッシュする。
	 */
	private void pushMassage(String registrationId, String message) {

		// クライアント認証トークン
		if (clientCertifyToken == null) {
			clientCertifyToken = getClientToken();
		}

		// HTTPヘッダの作成
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Authorization", "GoogleLogin auth=" + clientCertifyToken);

		// リクエストパラメータの作成
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("registration_id", registrationId);
		paramMap.put("collapse_key", "1");
		paramMap.put("data.message", message);

		// POSTリクエストの実行
		HttpResponseDto httpResponseDto = HttpUtil.executePostRequestUTF8(PropertyConstants.GOOGLE_PUSH_URL, paramMap, headerMap);

		if (httpResponseDto.getStatusCode() != HttpURLConnection.HTTP_OK) {
			System.out.println("メッセージのプッシュに失敗しました。ステータスコード = " + httpResponseDto.getStatusCode());
			throw new ApiException("10000", "メッセージのプッシュに失敗しました。ステータスコード = " + httpResponseDto.getStatusCode());
		}

		// [Error=]以降の文字列を取得
		String errorMessage = getResultFromResponse(httpResponseDto.getResponseBody(), "Error=");

		if (errorMessage != null) {
			throw new ApiException("10001", errorMessage);
		}
	}

	/**
	 * クライアントキーを取得する
	 */
	public String getClientToken() {

		// リクエストパラメータの作成
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("accountType", "HOSTED_OR_GOOGLE");
		paramMap.put("Email", PropertyConstants.GOOGLE_CLIENT_ID);
		paramMap.put("Passwd", PropertyConstants.GOOGLE_CLIENT_PASSWORD);
		paramMap.put("service", "ac2dm");
		paramMap.put("source", "sji-sample-1.0");

		// POSTリクエストの実行
		HttpResponseDto httpResponseDto = HttpUtil.executePostRequestUTF8(PropertyConstants.GOOGLE_CLIENT_LOGIN_URL, paramMap);

		if (httpResponseDto.getStatusCode() != HttpURLConnection.HTTP_OK) {
			System.out.println("メッセージのプッシュに失敗しました。ステータスコード = " + httpResponseDto.getStatusCode());
			throw new ApiException("10000", "メッセージのプッシュに失敗しました。ステータスコード = " + httpResponseDto.getStatusCode());
		}

		// [Auth=]以降の文字列を取得
		String clientCertifyToken = getResultFromResponse(httpResponseDto.getResponseBody(), "Auth=");

		return clientCertifyToken;
	}

	/**
	 * レスポンスから特定の接頭辞の文字列を取得する。
	 *
	 * @param response レスポンス
	 * @param prefix 取得する行の接頭辞
	 * @return レスポンスから切り出した文字列
	 */
	private String getResultFromResponse(String response, String prefix) {
		String result = null;
		try {
			// リクエスト結果を取得する
			BufferedReader reader = new BufferedReader(new StringReader(response));

			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(prefix)) {
					result = line.substring(prefix.length());
					break;
				}
			}
			reader.close();

		} catch (IOException ex) {
			throw new SystemErrorException(ex);
		}
		return result;
	}
}
