package jp.sji.kansai.android.demo.buyer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderDetailActivity extends BuyerDemoActivity {

	/* (非 Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate( Bundle savedInstanceState ){
		super.onCreate( savedInstanceState );

		this.setContentView( R.layout.requestconfirm );

		// 依頼入力
		//-------------------------------
		// 各種オブジェクトを取得
		//-------------------------------
		// 各種ボタン
		Button button1 = (Button)this.findViewById(R.id.requestconfirm_DecideButton);
		Button button2 = (Button)this.findViewById(R.id.requestconfirm_BackButton);

		// 決定ボタン
		button1.setOnClickListener(
			new View.OnClickListener() {
				public void onClick( View v ){
					// インテントの生成
					Intent intent = new Intent( OrderDetailActivity.this, MainMenuActivity.class );
					// 次のアクティビティの呼び出し
					startActivity(intent);
				}
			}
		);

		// 中止ボタン
		button2.setOnClickListener(
			new View.OnClickListener() {
				public void onClick( View v ){
					// インテントの生成
					Intent intent = new Intent( OrderDetailActivity.this, MainMenuActivity.class );
					// 次のアクティビティの呼び出し
					startActivity( intent );
				}
			}
		);

	}

}
