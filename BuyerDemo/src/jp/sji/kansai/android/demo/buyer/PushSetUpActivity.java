package jp.sji.kansai.android.demo.buyer;

import jp.sji.kansai.android.demo.buyer.util.C2DMManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PushSetUpActivity extends BuyerDemoActivity {

	public static final String REGIST_RESULT_DISP_ACTION = "jp.sji.kansai.android.sample.c2dm.reist.result.disp";

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

	private final BroadcastReceiver mRegistResultReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			mResult = intent.getExtras().getString(PARAM_RESULT);

			if (RESULT_SUCCESS.equals(mResult)) {
				setViewSuccess();
			} else {
				setViewFailed();
			}
		}
	};

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
		setContentView(R.layout.push_setup_regist);

		//------------------------
		// パラメータの取得
		//------------------------
		// インテントの取得
		Intent intent = this.getIntent();
		mMode = intent.getExtras().getString(PARAM_MODE);

		//------------------------
		// 各種オブジェクトを取得
		//------------------------
		// [設定]ボタンのオブジェクトを取得
		Button buttonSetUp = (Button)this.findViewById(R.id.button_setup);

		// 説明文のオブジェクトを取得
		TextView textViewDesc = (TextView)this.findViewById(R.id.textView_desc);

		// 社員番号
		final EditText editTextEmpNo = (EditText)this.findViewById(R.id.editText_empId);

		if (MODE_RECV.equals(mMode)) {
			// 受信設定の場合

			//------------------------
			// 画面表示設定
			//------------------------
			textViewDesc.setText(getString(R.string.textView_descRecvRegist)); // 説明文

			//------------------------
			// ボタンの動作設定
			//------------------------
			// [設定]ボタン
			buttonSetUp.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					// 社員番号の取得
					String empNo = editTextEmpNo.getText().toString();

					if (checkEmpId(empNo)) {
						// C2DMサーバーにAndroid端末を登録する。
						C2DMManager.saveEmpNo(PushSetUpActivity.this, empNo);
						C2DMManager.register(PushSetUpActivity.this);
					}
				}
			});

			//------------------------
			// レシーバーの登録
			//------------------------
			registerReceiver(mRegistResultReceiver, new IntentFilter(REGIST_RESULT_DISP_ACTION));
		} else {
			// 送信設定の場合

			//------------------------
			// 画面表示設定
			//------------------------
			textViewDesc.setText(getString(R.string.textView_descSendRegist)); // 説明文

			//------------------------
			// ボタンの動作設定
			//------------------------
			// [設定]ボタン
			buttonSetUp.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					// 社員番号の取得
					String empNo = editTextEmpNo.getText().toString();

					if (checkEmpId(empNo)) {
						// Android端末にプッシュ通知の送信対象の社員番号を登録する。
						C2DMManager.saveSendEmpNo(PushSetUpActivity.this, empNo);

						// 登録結果画面に遷移する。
						setViewSuccess();
					}
				}
			});
		}
	}

    @Override
    public void onDestroy() {
        unregisterReceiver(mRegistResultReceiver);
        super.onDestroy();
    }

	private void setViewSuccess() {
		// アクティビティにビューを設定
		setContentView(R.layout.push_setup_complete);

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
				startActivity(new Intent(PushSetUpActivity.this, PushSetUpSelectActivity.class ));
			}
		});
	}

	private void setViewFailed() {
		// アクティビティにビューを設定
		setContentView(R.layout.push_setup_complete);

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
				startActivity(new Intent(PushSetUpActivity.this, PushSetUpSelectActivity.class ));
			}
		});
	}

	private boolean checkEmpId(String empId) {
		if (empId == null || "".equals(empId)) {
			// 未入力の場合
			showSimpleAlert("入力エラー", "社員IDは必須です。");
			return false;
		} else if (!empId.matches("[a-z0-9]*")) {
			// 半角英数字以外の場合
			showSimpleAlert("入力エラー", "社員IDは半角英数字で入力してください。");
		} else if (empId.length() > 10) {
			// 10文字より大きい場合
			showSimpleAlert("入力エラー", "社員IDは10文字以内で入力してください。");
			return false;
		}

		return true;
	}
}