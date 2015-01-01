package jp.sji.kansai.android.demo.buyer;

import java.util.ArrayList;
import java.util.List;

import jp.sji.kansai.android.demo.buyer.costants.PropertyConstants;
import jp.sji.kansai.android.demo.buyer.util.APServerManager;
import jp.sji.kansai.android.demo.buyer.util.C2DMManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class RequestConfirmActivity extends BuyerDemoActivity {
	private ListView listView = null;

//	private ArrayAdapter<String> arrayAdapter = null;

	/* (非 Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.requestconfirm);

		// 依頼入力
		//-------------------------------
		// 各種オブジェクトを取得
		//-------------------------------
		// 各種ボタン
		Button button1 = (Button)this.findViewById(R.id.requestconfirm_DecideButton);
		Button button2 = (Button)this.findViewById(R.id.requestconfirm_BackButton);

		// 決定ボタン
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				if ("true".equals(PropertyConstants.PUSH_ENABLE.toLowerCase())) {
					//-------------------------------
					// プッシュ通知使用する場合
					//-------------------------------
					// プッシュ通知送信対象の社員番号の取得
					String sendEmpNo = C2DMManager.getSendEmpNo(RequestConfirmActivity.this);

					if ("".equals(sendEmpNo)) {
						showSimpleAlert("エラー", "プッシュ通知の送信先が設定されていません。");
						return;
					}

					try {
						// APサーバーにプッシュ通知を依頼する。
						APServerManager.push(RequestConfirmActivity.this, sendEmpNo, C2DMManager.getEmpNo(RequestConfirmActivity.this));
					} catch (Exception ex) {
						showSimpleAlert("エラー", "プッシュ通知に失敗しました。");
					}
				}

				// インテントの生成
				Intent intent = new Intent(RequestConfirmActivity.this, MaterialListActivity.class);

				// 次のアクティビティの呼び出し
				startActivity(intent);
			}
		});

		// 中止ボタン
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// インテントの生成
				Intent intent = new Intent(RequestConfirmActivity.this, RequestInputActivity.class);

				// 次のアクティビティの呼び出し
				startActivity(intent);
			}
		});

	}

	/**
	 *
	 * @param pListView
	 */
	private void setListView(ListView pListView) {
		ArrayAdapter<String> wArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

		List<String> list = new ArrayList<String>();
		list.add("申請先");
		list.add("管理者ｘｘ");
		list.add("購入店舗");
		list.add("高島屋梅田店");
		list.add("商品情報");
		list.add("長靴");
		list.add("7,000円");

		// 表示データのクリア
		wArrayAdapter.clear();

		// 表示データの設定
		for (String str : list) {
			wArrayAdapter.add(str);
		}

		pListView.setAdapter(wArrayAdapter);

	}

}
