package jp.sji.kansai.android.demo.activity;

import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class InfoView36KyouteiActivity extends BaseActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infoview36kyoutei);
        setTitleName("36協定とは？");
        setTitleIcon(android.R.drawable.ic_menu_help);
        setUploadStatus(); 
    }

    
    // ************************************************************************
    // メニュークリックイベント
    // ************************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

//    	// XML定義を呼び出し、該当のリソースを読み取り表示する
//    	MenuInflater inflater = getMenuInflater();
//    	inflater.inflate(R.menu.infoview36kyoutei, menu);
    	return true;
    	
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

//    	String msg = "";
//
//    	switch(item.getItemId()){
//    		case R.id.topmenu_menuItem_KinmuInfoDetail :
//    			msg = "基本情報ボタンをタップしました";
//    			break;
//    		case R.id.topmenu_menuItem_KinmuInfoList :
//    			msg = "勤務一覧ボタンをタップしました";
//    			break;
//    		case R.id.topmenu_menuItem_KinmuInfoEdit :
//    			msg = "勤務入力ボタンをタップしました";
//    			break;
//    		case R.id.topmenu_menuItem_KinmuInfoUpload :
//    			msg = "アップロードボタンをタップしました";
//    			break;
//    		case R.id.topmenu_menuItem_SettingMenu :
//    			msg = "設定ボタンをタップしました";
//    			break;    			
//    		case R.id.topmenu_menuItem_InfoView36Kyoutei :
//    			msg = "36協定とはボタンをタップしました";
//    			break;    			
//    		default:
//    			break;
//    	}
//    	
//	showToast(msg);
   	return true;
    	
    }    
}