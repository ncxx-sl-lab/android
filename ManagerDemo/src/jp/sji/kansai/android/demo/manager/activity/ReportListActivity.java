package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：レポート一覧
 * クラス名：ReportListActivity
 */

import jp.sji.kansai.android.demo.manager.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 *
 * @author takashi.o
 *
 */
public class ReportListActivity extends BaseActivity {

	/**
	 *
	 */
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reportlist);

//		Button toStockListButton = (Button)this.findViewById(R.id.reportList_StockListButton);
//		Button toSalesAchievementListButton = (Button)this.findViewById(R.id.reportList_SalesAchievementListButton);
//
//		toStockListButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// 在庫一覧アクティビティの呼び出し
//				Intent intent = new Intent(ReportListActivity.this, StockListActivity.class);
//				startActivity(intent);
//			}
//        });
//
//		toSalesAchievementListButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// 販売実績一覧アクティビティの呼び出し
//				Intent intent = new Intent(ReportListActivity.this, SalesAchievementListActivity.class);
//				startActivity(intent);
//			}
//        });
	}
	
	public void clickMenuStockListReport(View v){
		// 在庫一覧アクティビティの呼び出し
		Intent intent = new Intent(ReportListActivity.this, StockListActivity.class);
		startActivity(intent);
	}
	public void clickMenuSalesAchievementReport(View v){
		// 販売実績一覧アクティビティの呼び出し
		Intent intent = new Intent(ReportListActivity.this, SalesAchievementListActivity.class);
		startActivity(intent);
	}
}