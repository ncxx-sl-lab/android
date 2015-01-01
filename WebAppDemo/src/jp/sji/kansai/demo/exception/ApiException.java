package jp.sji.kansai.demo.exception;

/**
 * APIの業務エラー発生時にスローする例外クラス
 */
public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/** 結果コード */
	private String resultCode = null;

	/** 結果メッセージ */
	private String resultMessage = null;

	public ApiException(String resultCode, String resultMessage) {
		super();
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	/**
	 * 結果コードを取得します。
	 * @return 結果コード
	 */
	public String getResultCode() {
	    return resultCode;
	}

	/**
	 * 結果コードを設定します。
	 * @param resultCode 結果コード
	 */
	public void setResultCode(String resultCode) {
	    this.resultCode = resultCode;
	}

	/**
	 * 結果メッセージを取得します。
	 * @return 結果メッセージ
	 */
	public String getResultMessage() {
	    return resultMessage;
	}

	/**
	 * 結果メッセージを設定します。
	 * @param resultMessage 結果メッセージ
	 */
	public void setResultMessage(String resultMessage) {
	    this.resultMessage = resultMessage;
	}
}
