package jp.sji.kansai.android.demo.buyer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MaterialDetailActivity extends BuyerDemoActivity {
	/* (非 Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.materialdetail);

		// 商品説明
		//-------------------------------
		// 各種オブジェクトを取得
		//-------------------------------
		// インテントの取得
		Intent intent = this.getIntent();

		String materialName = "";
		try {
			materialName = intent.getExtras().getString("MATERIAL_NAME");
		} catch (Exception e) {
			// 処理なし
		}

		// テキストボックスのオブジェクトを取得
		TextView textView = (TextView)this.findViewById(R.id.materialDetail_MaterialInfoText);

		textView.setText(materialName + "\r\nあいうえお");

		// 各種ボタン
		Button requestCreateButton = (Button)this.findViewById(R.id.materialDetail_RequestCreateButton);
		Button stockListButton = (Button)this.findViewById(R.id.materialDetail_StockListButton);

		// 決定ボタン
		requestCreateButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// インテントの生成
				Intent intent = new Intent(MaterialDetailActivity.this, RequestInputActivity.class);

				// 次のアクティビティの呼び出し
				startActivity(intent);
			}
		});

		// 戻るボタン
		stockListButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// インテントの生成
				Intent intent = new Intent(MaterialDetailActivity.this, StockListActivity.class);

				// 次のアクティビティの呼び出し
				startActivity(intent);
			}
		});

	}

}
