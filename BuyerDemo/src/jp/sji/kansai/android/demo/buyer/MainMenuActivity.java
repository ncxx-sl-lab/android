package jp.sji.kansai.android.demo.buyer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends BuyerDemoActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
//        setContentView(R.layout.mainmenu);

//        Button toOrderReqButton = (Button)this.findViewById(R.id.MainMenuToOrderReq);
//        Button toOrderListButton = (Button)this.findViewById(R.id.MainMenuToOrderList);
//
//        toOrderReqButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// インテントの生成
//				Intent intent = new Intent(MainMenuActivity.this, RequestProcessSelectActivity.class);
//
//				// 次のアクティビティの呼び出し
//				startActivity(intent);
//			}
//		});
//        toOrderListButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// インテントの生成
//				Intent intent = new Intent(MainMenuActivity.this, OrderListActivity.class);
//
//				// 次のアクティビティの呼び出し
//				startActivity(intent);
//			}
//		});
    }
    
	public void clickMenuOrderReq(View v) {
		// インテントの生成
		Intent intent = new Intent(MainMenuActivity.this, RequestProcessSelectActivity.class);

		// 次のアクティビティの呼び出し
		startActivity(intent);
	}
	
	public void clickMenuNoticeList(View v) {
		// nothing.
		showToast("作成中（統合するかも？）");
	}
	
	public void clickMenuOrderList(View v) {
		// インテントの生成
		Intent intent = new Intent(MainMenuActivity.this, OrderListActivity.class);

		// 次のアクティビティの呼び出し
		startActivity(intent);
	}
    
}