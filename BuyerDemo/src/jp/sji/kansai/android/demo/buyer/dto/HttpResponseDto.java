package jp.sji.kansai.android.demo.buyer.dto;

/**
 * HTTPリクエストの実行結果を保持するクラス
 *
 * @author teraoka
 */
public class HttpResponseDto {

	/** HTTPステータスコード */
	private int statusCode;

	/** HTTPステータスメッセージ */
	private String statusMessage;

	/** レスポンスボディ */
	private String responseBody;

	/**
	 * HTTPステータスコードを取得します。
	 * @return HTTPステータスコード
	 */
	public int getStatusCode() {
	    return statusCode;
	}

	/**
	 * HTTPステータスコードを設定します。
	 * @param statusCode HTTPステータスコード
	 */
	public void setStatusCode(int statusCode) {
	    this.statusCode = statusCode;
	}

	/**
	 * HTTPステータスメッセージを取得します。
	 * @return HTTPステータスメッセージ
	 */
	public String getStatusMessage() {
	    return statusMessage;
	}

	/**
	 * HTTPステータスメッセージを設定します。
	 * @param statusMessage HTTPステータスメッセージ
	 */
	public void setStatusMessage(String statusMessage) {
	    this.statusMessage = statusMessage;
	}

	/**
	 * レスポンスボディを取得します。
	 * @return レスポンスボディ
	 */
	public String getResponseBody() {
	    return responseBody;
	}

	/**
	 * レスポンスボディを設定します。
	 * @param responseBody レスポンスボディ
	 */
	public void setResponseBody(String responseBody) {
	    this.responseBody = responseBody;
	}

}
