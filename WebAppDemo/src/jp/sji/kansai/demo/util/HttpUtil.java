package jp.sji.kansai.demo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import jp.sji.kansai.demo.dto.HttpResponseDto;
import jp.sji.kansai.demo.exception.SystemErrorException;

/**
 * HTTP通信処理用のUtilクラス
 */
public class HttpUtil {

	/**
	 * HTTP通信処理(POST)を行う
	 * ※パラメータをUTF-8でURLエンコードを行う
	 *
	 * @param url リクエストを行うURL
	 * @param paramMap リクエストパラメータのMAP<キー, 値>
	 *
	 * @return レスポンス内容(通信処理失敗時はnullを返却)
	 */
	public static HttpResponseDto executePostRequestUTF8(String url, Map<String, String> paramMap) {
		return executePostRequest(url, paramMap, "UTF-8", null);
	}

	/**
	 * HTTP通信処理(POST)を行う
	 * ※パラメータをUTF-8でURLエンコードを行う
	 *
	 * @param url リクエストを行うURL
	 * @param paramMap リクエストパラメータのMAP<キー, 値>
	 * @param headereMap リクエストヘッダのMAP<キー, 値>
	 *
	 * @return レスポンス内容(通信処理失敗時はnullを返却)
	 */
	public static HttpResponseDto executePostRequestUTF8(String url, Map<String, String> paramMap, Map<String, String> headereMap) {
		return executePostRequest(url, paramMap, "UTF-8", headereMap);
	}

	/**
	 * HTTP通信処理(POST)を行う
	 *
	 * @param url リクエストを行うURL
	 * @param paramMap リクエストパラメータのMAP<キー, 値>
	 * @param encode パラメータをURLエンコードする文字コード
	 *
	 * @return レスポンス内容(通信処理失敗時はnullを返却)
	 */
	public static HttpResponseDto executePostRequest(String url, Map<String, String> paramMap, String encode) {
		return executePostRequest(url, paramMap, encode, null);
	}

	/**
	 * HTTP通信処理(POST)を行う
	 *
	 * @param url リクエストを行うURL
	 * @param paramMap リクエストパラメータのMAP<キー, 値>
	 * @param encode パラメータをURLエンコードする文字コード
	 * @param headereMap リクエストヘッダのMAP<キー, 値>
	 *
	 * @return レスポンス内容(通信処理失敗時はnullを返却)
	 */
	public static HttpResponseDto executePostRequest(String url, Map<String, String> paramMap, String encode, Map<String, String> headereMap) {

		HttpURLConnection connection = null;
		try {
			URL requestURL = new URL(url);
			connection = (HttpURLConnection) requestURL.openConnection();
			connection.setDoOutput(true); // POSTを使用可能にする。
			connection.setRequestMethod("POST");

			// HTTPヘッダの設定
			if (headereMap != null) {
				for (Iterator<String> it = headereMap.keySet().iterator(); it.hasNext();) {
					String key = it.next();
					String value = headereMap.get(key);

					connection.setRequestProperty(key, value);
				}
			}

			// リクエストパラメータの作成
			if (paramMap != null) {
				StringBuilder queryBuf = new StringBuilder();
				for (Iterator<String> it = paramMap.keySet().iterator(); it.hasNext();) {
					String key = it.next();
					String value = URLEncoder.encode(paramMap.get(key), encode);

					if (queryBuf.length() > 0) {
						queryBuf.append("&");
					}
					queryBuf.append(key).append("=").append(value);
				}

				// リクエストパラメータの設定
				PrintStream ps = new PrintStream(connection.getOutputStream());
				ps.print(queryBuf.toString());
				ps.close();
			}

			// POSTリクエストを実行
			InputStream is = connection.getInputStream();

			// リクエスト結果を取得する
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder responseBuf = new StringBuilder();

			String line = null;
			while ((line = reader.readLine()) != null) {
				responseBuf.append(line).append("\n");
			}
			reader.close();

			// 実行結果の返却
			HttpResponseDto httpResponseDto = new HttpResponseDto();
			httpResponseDto.setStatusCode(connection.getResponseCode());
			httpResponseDto.setStatusMessage(connection.getResponseMessage());
			httpResponseDto.setResponseBody(responseBuf.toString());

			return httpResponseDto;

		} catch (Exception ex) {
			System.out.println("HTTP通信処理で予期せぬエラーが発生しました。");
			ex.printStackTrace();
			throw new SystemErrorException(ex);
		} finally {
			try {
				connection.disconnect();
			}catch (Exception ex) {
				;
			}
		}
	}
}
