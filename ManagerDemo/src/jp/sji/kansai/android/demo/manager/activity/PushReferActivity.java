package jp.sji.kansai.android.demo.manager.activity;

import jp.sji.kansai.android.demo.manager.R;
import jp.sji.kansai.android.demo.manager.util.C2DMManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PushReferActivity extends BaseActivity {

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

	private final BroadcastReceiver mUnRegistResultReceiver = new BroadcastReceiver() {
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
		setContentView(R.layout.push_setup_refer);

		//------------------------
		// パラメータの取得
		//------------------------
		// インテントの取得
		Intent intent = this.getIntent();
		mMode = intent.getExtras().getString(PARAM_MODE);

		//------------------------
		// 各種オブジェクトを取得
		//------------------------
		// [解除]ボタンのオブジェクトを取得
		Button buttonSetUp = (Button)this.findViewById(R.id.button_unregist);

		// 説明文のオブジェクトを取得
		TextView textViewDesc = (TextView)this.findViewById(R.id.textView_desc);

		// 社員番号のオブジェクトを取得
		TextView textViewEmpNo = (TextView)this.findViewById(R.id.textView_empNo);

		// registrationIDのラベルのオブジェクトを取得
		TextView textViewLabelRegistId = (TextView)this.findViewById(R.id.textView_label_registId);

		// registrationIDのオブジェクトを取得
		TextView textViewRegistId = (TextView)this.findViewById(R.id.textView_registId);


		if (MODE_RECV.equals(mMode)) {
			// 受信設定の場合

			//------------------------
			// 画面表示設定
			//------------------------
			textViewDesc.setText(getString(R.string.textView_descRecvRefer)); // 説明文
			textViewEmpNo.setText(C2DMManager.getEmpNo(PushReferActivity.this)); // 社員番号
			textViewRegistId.setText(C2DMManager.getRegistrationId(PushReferActivity.this)); // registrationID

			//------------------------
			// ボタンの動作設定
			//------------------------
			// [解除]ボタン
			buttonSetUp.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// C2DMサーバーへの登録を解除する。
					C2DMManager.unregister(PushReferActivity.this);
				}
			});

			//------------------------
			// レシーバーの登録
			//------------------------
			registerReceiver(mUnRegistResultReceiver, new IntentFilter(REGIST_RESULT_DISP_ACTION));

		} else {
			// 送信設定の場合

			//------------------------
			// 画面表示設定
			//------------------------
			textViewDesc.setText(getString(R.string.textView_descSendRefer)); // 説明文
			textViewEmpNo.setText(C2DMManager.getSendEmpNo(PushReferActivity.this)); // 社員番号
			textViewLabelRegistId.setWillNotDraw(true); // registrationID(ラベル)
			textViewLabelRegistId.setHeight(0); // registrationID
			textViewRegistId.setWillNotDraw(true); // registrationID
			textViewRegistId.setHeight(0); // registrationID

			//------------------------
			// ボタンの動作設定
			//------------------------
			// [解除]ボタン
			buttonSetUp.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// Android端末にプッシュ通知の送信対象の社員番号を登録する。
					C2DMManager.clearSendEmpNo(PushReferActivity.this);

					// 解除結果画面に遷移する。
					setViewSuccess();
				}
			});
		}
	}

    @Override
    public void onDestroy() {
        unregisterReceiver(mUnRegistResultReceiver);
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
			textViewDesc.setText(getString(R.string.textView_descRecvUnRegistSuccess));
		} else {
			textViewDesc.setText(getString(R.string.textView_descSendUnRegistSuccess));
		}

		//------------------------
		// ボタンの動作設定
		//------------------------
		// [完了]ボタン
		buttonSetUp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// メイン画面へ遷移
				startActivity(new Intent(PushReferActivity.this, PushSetUpSelectActivity.class ));
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
			textViewDesc.setText(getString(R.string.textView_descRecvUnRegistFailed));
		} else {
			textViewDesc.setText(getString(R.string.textView_descSendUnRegistFailed));
		}

		//------------------------
		// ボタンの動作設定
		//------------------------
		// [設定をやり直す]ボタン
		buttonSetUp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// メイン画面へ遷移
				startActivity(new Intent(PushReferActivity.this, PushSetUpSelectActivity.class ));
			}
		});
	}
}