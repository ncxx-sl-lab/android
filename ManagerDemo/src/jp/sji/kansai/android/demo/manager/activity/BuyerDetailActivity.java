package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：バイヤー個別
 * クラス名：BuyerDetailActivity
 */

import jp.sji.kansai.android.demo.manager.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuyerDetailActivity extends BaseActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyerdetail);

//        Button toMapButton = (Button)this.findViewById(R.id.buyerDetail_MapDisplayButton);
//        Button toResultButton = (Button)this.findViewById(R.id.buyerDetail_ResultDisplayButton);
//        Button toNoticeConfirmButton = (Button)this.findViewById(R.id.buyerDetail_NoticeConfirmButton);
//
//        toMapButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// 位置表示アクティビティの呼び出し
//				Intent intent = new Intent(BuyerDetailActivity.this, HellomapActivity.class);
//
//				// パラメータの設定(次画面に引き継ぐパラメータを設定)
//				intent.putExtra("INPUT_PARAM", "TEST");
//
//				startActivity(intent);
//			}
//        });
//
//        toResultButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// 実績表示アクティビティの呼び出し
//				Intent intent = new Intent(BuyerDetailActivity.this, BuyerAchievementActivity.class);
//				startActivity(intent);
//			}
//        });
//
//        toNoticeConfirmButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// 通知内容確認アクティビティの呼び出し
//				Intent intent = new Intent(BuyerDetailActivity.this, NoticeConfirmActivity.class);
//				startActivity(intent);
//			}
//        });
    }
    
    public void clickMapDisplayButton(View v){
    	
    	showToast("該当バイヤーの位置情報を地図画面で表示する");
    	
		// 位置表示アクティビティの呼び出し
		Intent intent = new Intent(BuyerDetailActivity.this, HellomapActivity.class);

		// パラメータの設定(次画面に引き継ぐパラメータを設定)
		intent.putExtra("INPUT_PARAM", "TEST");

		startActivity(intent);    	
    }
    
    public void clickResultDisplayButton(View v){
    	
    	showToast("該当バイヤーの販売実績を一覧表示する");
    	
		// 実績表示アクティビティの呼び出し
		Intent intent = new Intent(BuyerDetailActivity.this, BuyerAchievementActivity.class);
		startActivity(intent);    	
    }
    public void clickNoticeConfirmButton(View v){
    	
    	showToast("該当バイヤーで絞り込んだ通知・承認一覧画面を表示する");
    	
		// 通知状況一覧アクティビティの呼び出し
		Intent intent = new Intent(BuyerDetailActivity.this, NoticeListActivity.class);
		startActivity(intent);

		
    }
    public void clickNoticeEntryButton(View v){
    	
    	showToast("該当バイヤーに通知を行う");
    	
		// 通知作成アクティビティの呼び出し
		Intent intent = new Intent(BuyerDetailActivity.this, NoticeEntryActivity.class);
		intent.putExtra("FROMBUYERID", "バイヤー１");
		startActivity(intent);
		
    }
    
    public void clickSendTelButton(View v){
    	
    	showToast("該当バイヤーの電話に発信する");
    	
    }  
}