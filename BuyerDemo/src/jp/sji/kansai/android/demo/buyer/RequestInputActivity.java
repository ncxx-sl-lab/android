package jp.sji.kansai.android.demo.buyer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class RequestInputActivity extends BuyerDemoActivity {
	private ListView listView = null;

//	private ArrayAdapter<String> arrayAdapter = null;

	/* (非 Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.requestinput);

		// 依頼入力
		//-------------------------------
		// 各種オブジェクトを取得
		//-------------------------------
		// 各種ボタン
		Button button1 = (Button)this.findViewById(R.id.requestInput_ConfirmButton);
		Button button2 = (Button)this.findViewById(R.id.requestInput_StopButton);

		// 確認ボタン
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// インテントの生成
				Intent intent = new Intent(RequestInputActivity.this, RequestConfirmActivity.class);

				// 次のアクティビティの呼び出し
				startActivity(intent);
			}
		});

		// 中止ボタン
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// インテントの生成
				Intent intent = new Intent(RequestInputActivity.this, MaterialDetailActivity.class);

				// 次のアクティビティの呼び出し
				startActivity(intent);
			}
		});

	}

}
