package jp.sji.kansai.demo.form;

import org.apache.struts.action.ActionForm;

/**
 * APIの基底アクションフォームクラス
 *
 * @author teraoka
 */
abstract public class BaseApiForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	/** 結果コード */
	private String resultCode = null;

	/** 結果メッセージ */
	private String resultMessage = null;

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

