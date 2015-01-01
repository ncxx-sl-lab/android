package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：メインメニュー
 * クラス名：MainMenuActivity
 */

import jp.sji.kansai.android.demo.manager.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author 江口 博之
 *
 */
public class MainMenuActivity extends BaseActivity {

	// 終了確認ダイアログ用
	static final int DIALOG_END_YES_NO = 0;

	// 通知テスト用
    private NotificationManager mNotificationManager;
    private int NOTFICATION_ID;
    static final int DIALOG_NEW_NOTICE = 1;

	/**
	 *
	 */
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {

//		requestWindowFeature(Window.FEATURE_LEFT_ICON);
//
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.mainmenu);
//
//		setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,R.drawable.icon);

		super.onCreate(savedInstanceState,R.layout.dashboard);

//		super.onCreate(savedInstanceState,R.layout.mainmenu);


//		  Button toMapButton = (Button)this.findViewById(R.id.to_Map);
//        Button toBuyerButton = (Button)this.findViewById(R.id.to_Buyer);
//        Button toNoticeButton = (Button)this.findViewById(R.id.to_Notice);
//        Button toNoticeHistButton = (Button)this.findViewById(R.id.to_NoticeHist);
//        Button toRequestHistButton = (Button)this.findViewById(R.id.to_RequestHist);
//        Button toReportButton = (Button)this.findViewById(R.id.to_Report);
//        //Button toLogoutButton = (Button)this.findViewById(R.id.to_Logout);
//        //Button toNotificationTestButton = (Button)this.findViewById(R.id.to_NotificationTest);
//
//        toMapButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				//Intent intent = new Intent(MainMenuActivity.this, HellomapActivity.class);
//				//startActivity(intent);
//				showToast("作成中です");
//			}
//        });
//
//        toBuyerButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// バイヤー一覧アクティビティの呼び出し
//				Intent intent = new Intent(MainMenuActivity.this, BuyerListActivity.class);
//				startActivity(intent);
//			}
//        });
//
//        toNoticeButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// 通知品目一覧アクティビティの呼び出し
//				Intent intent = new Intent(MainMenuActivity.this,
//						jp.sji.kansai.android.demo.manager.activity.MaterialListActivity.class);
//				startActivity(intent);
//			}
//        });
//
//        toNoticeHistButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// 通知履歴一覧アクティビティの呼び出し
//				Intent intent = new Intent(MainMenuActivity.this,
//						jp.sji.kansai.android.demo.manager.activity.NoticeListActivity.class);
//				startActivity(intent);
//			}
//        });
//
//        toRequestHistButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// 承認メニューアクティビティの呼び出し
//				Intent intent = new Intent(MainMenuActivity.this,
//						jp.sji.kansai.android.demo.manager.activity.RequestMenuListActivity.class);
//				startActivity(intent);
//			}
//        });
//
//        toReportButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// レポート一覧アクティビティの呼び出し
//				Intent intent = new Intent(MainMenuActivity.this, ReportListActivity.class);
//				startActivity(intent);
//			}
//        });

	}


	public void clickMenuRequestHist(View v) {
		// 承認状況クリック処理

		// 承認メニューアクティビティの呼び出し
		Intent intent = new Intent(MainMenuActivity.this,
				jp.sji.kansai.android.demo.manager.activity.RequestMenuListActivity.class);
		startActivity(intent);
	}

	public void clickMenuNoticeHist(View v){
		// 通知状況クリック処理

		// 通知履歴一覧アクティビティの呼び出し
		Intent intent = new Intent(MainMenuActivity.this,
				jp.sji.kansai.android.demo.manager.activity.NoticeListActivity.class);
		startActivity(intent);
	}

	public void clickMenuBuyerList(View v){
		// バイヤー一覧クリック処理

		// バイヤー一覧アクティビティの呼び出し
		Intent intent = new Intent(MainMenuActivity.this, BuyerListActivity.class);
		startActivity(intent);
	}

	public void clickMenuNoticeSend(View v){
		// 通知作成クリック処理

		// 通知品目一覧アクティビティの呼び出し
		Intent intent = new Intent(MainMenuActivity.this,
				jp.sji.kansai.android.demo.manager.activity.MaterialListActivity.class);
		startActivity(intent);
	}

	public void clickMenuMap(View v){
		// 地図クリック処理
		// 通知品目一覧アクティビティの呼び出し
//		Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:34.686267,135.497474?q=ＳＪＩ"));

		Intent intent = new Intent(MainMenuActivity.this,
				jp.sji.kansai.android.demo.manager.activity.HellomapActivity.class);
		startActivity(intent);

//		showToast("作成中です");
	}

	public void clickMenuReport(View v){
		// レポートクリック処理

		// レポート一覧アクティビティの呼び出し
		Intent intent = new Intent(MainMenuActivity.this, ReportListActivity.class);
		startActivity(intent);
	}

	/**
	 *
	 */
    protected Dialog onCreateDialog(int id){
    	switch(id){
    		case DIALOG_END_YES_NO:
	    		return new AlertDialog.Builder(this)
	    		.setTitle("終了確認")
	    		.setMessage("アプリケーションを終了します。よろしいですか？")

	    		.setPositiveButton("はい", new DialogInterface.OnClickListener(){
	    			public void onClick(DialogInterface dialog, int whichButton){
	    				appEnd();
	    			}
	    		})
	    		.setNegativeButton("いいえ", new DialogInterface.OnClickListener(){
	    			public void onClick(DialogInterface dialog, int whichButton){
	    			}
	    		})
	    		.create();

    		case DIALOG_NEW_NOTICE:
	    		return new AlertDialog.Builder(this)
	    		.setTitle("承認確認")
	    		.setMessage("承認依頼が届きました。確認しますか？")

	    		.setPositiveButton("はい", new DialogInterface.OnClickListener(){
	    			public void onClick(DialogInterface dialog, int whichButton){
	    				Intent intent = new Intent(MainMenuActivity.this, jp.sji.kansai.android.demo.manager.activity.RequestDetailDispActivity.class);
	    				startActivity(intent);
	    				mNotificationManager.cancel(NOTFICATION_ID);
	    			}
	    		})
	    		.setNegativeButton("いいえ", new DialogInterface.OnClickListener(){
	    			public void onClick(DialogInterface dialog, int whichButton){
	    			}
	    		})
	    		.create();

    	}
		return null;
    }

    /**
     *
     */
    public void appEnd(){
    	super.finish();
    }

    /**
     *
     */
    public void finish()
    {
    	showDialog(DIALOG_END_YES_NO);
    }


}