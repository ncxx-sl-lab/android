package jp.sji.kansai.android.demo.buyer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MasterSyncActivity extends BuyerDemoActivity implements Runnable {
	private static ProgressDialog waitDialog;
	private Thread thread;

	/* (非 Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.mastersync);

		// 商品説明
		//-------------------------------
		// 各種オブジェクトを取得
		//-------------------------------
		// テキストボックスのオブジェクトを取得
		TextView textView = (TextView)this.findViewById(R.id.masterSync_ConfirmMessageTextView);

		textView.setText("マスタの同期処理を実施します。\r\n処理には２，３分かかります。");

		// 各種ボタン
		Button masterSyncButton = (Button)this.findViewById(R.id.masterSync_ExecButton);

		// 同期ボタン
		masterSyncButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				MasterSyncActivity.this.setWait();

			}
		});
	}

	public void run() {
		try {
			//ダイアログがしっかり見えるように少しだけスリープ
			//（nnn：任意のスリープ時間・ミリ秒単位）
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			//スレッドの割り込み処理を行った場合に発生、catchの実装は割愛
		}
		//run内でUIの操作をしてしまうと、例外が発生する為、
		//Handlerにバトンタッチ
		handler.sendEmptyMessage(0);

	}

	private Handler handler = new Handler() {
		public void handleMessage(Message msg){
			// HandlerクラスではActivityを継承してないため
			// 別の親クラスのメソッドにて処理を行うようにした。
			MasterSyncActivity.this.masterSyncProcess();

			// プログレスダイアログ終了
			waitDialog.dismiss();
			waitDialog = null;

			// インテントの生成
			Intent intent = new Intent(MasterSyncActivity.this, MainMenuActivity.class);

			// 次のアクティビティの呼び出し
			startActivity(intent);
	    }
	};

	/**
	 *
	 */
	private void setWait() {

		waitDialog = new ProgressDialog(this);

		waitDialog.setMessage("ネットワーク接続中...");

		waitDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

		waitDialog.show();

		this.thread = new Thread(this);

		this.thread.start();
	}

	/**
	 *
	 */
	private void masterSyncProcess() {
		// 現在実装なし
	}

}
