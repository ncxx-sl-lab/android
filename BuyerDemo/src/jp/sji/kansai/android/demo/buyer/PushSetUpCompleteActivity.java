package jp.sji.kansai.android.demo.buyer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PushSetUpCompleteActivity extends BuyerDemoActivity {

	/** インテントのパラメータ：処理モード */
	public final static String PARAM_MODE = "pMode";

	/** インテントのパラメータ：処理結果 */
	public final static String PARAM_RESULT = "pResult";

	/** 処理モード：受信設定 */
	public final static String MODE_RECV = "recv";

	/** 処理モード：送信設定 */
	public final static String MODE_SEND = "send";

	/** 処理結果：成功 */
	public final static String RESULT_SUCCESS = "success";

	/** 処理結果：失敗 */
	public final static String RESULT_FAILED = "failed";

	/** 処理モード */
	private String mMode = null;

	/** 処理結果 */
	private String mResult = null;


	/**
	 * アクティビティが最初に起動する時に実行されるメソッド<br>
	 * <br>
	 * onSaveInstanceStateメソッドで保存された情報がある場合は、<br>
	 * 引数のBundleにその情報が引き渡され、状態を復元させることが可能<br>
	 *
	 * @param savedInstanceState onSaveInstanceStateメソッドで保存された情報
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		//------------------------
		// 初期処理
		//------------------------
		// 親クラスのメソッドを実行
		super.onCreate(savedInstanceState);

		// アクティビティにビューを追加
		setContentView(R.layout.push_setup_complete);

		//------------------------
		// パラメータの取得
		//------------------------
		// インテントの取得
		Intent intent = this.getIntent();
		mMode = intent.getExtras().getString(PARAM_MODE);
		mResult = intent.getExtras().getString(PARAM_RESULT);

		if (RESULT_SUCCESS.equals(mResult)) {
			setViewSuccess();
		} else {
			setViewFailed();
		}
	}

	private void setViewSuccess() {

		//------------------------
		// 各種オブジェクトを取得
		//------------------------
		// [次へ]ボタンのオブジェクトを取得
		Button buttonSetUp = (Button)this.findViewById(R.id.button_complete);
		buttonSetUp.setText(getString(R.string.button_complete));

		// 説明文のオブジェクトを取得
		TextView textViewDesc = (TextView)this.findViewById(R.id.textView_desc);
		if (MODE_RECV.equals(mMode)) {
			textViewDesc.setText(getString(R.string.textView_descRecvSuccess));
		} else {
			textViewDesc.setText(getString(R.string.textView_descSendSuccess));
		}

		//------------------------
		// ボタンの動作設定
		//------------------------
		// [完了]ボタン
		buttonSetUp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// メイン画面へ遷移
				startActivity(new Intent(PushSetUpCompleteActivity.this, PushSetUpSelectActivity.class ));
			}
		});
	}

	private void setViewFailed() {

		//------------------------
		// 各種オブジェクトを取得
		//------------------------
		// [次へ]ボタンのオブジェクトを取得
		Button buttonSetUp = (Button)this.findViewById(R.id.button_complete);
		buttonSetUp.setText(getString(R.string.button_retry));

		// 説明文のオブジェクトを取得
		TextView textViewDesc = (TextView)this.findViewById(R.id.textView_desc);
		if (MODE_RECV.equals(mMode)) {
			textViewDesc.setText(getString(R.string.textView_descRecvFailed));
		} else {
			textViewDesc.setText(getString(R.string.textView_descSendFailed));
		}

		//------------------------
		// ボタンの動作設定
		//------------------------
		// [設定をやり直す]ボタン
		buttonSetUp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// メイン画面へ遷移
				startActivity(new Intent(PushSetUpCompleteActivity.this, PushSetUpSelectActivity.class ));
			}
		});
	}
}