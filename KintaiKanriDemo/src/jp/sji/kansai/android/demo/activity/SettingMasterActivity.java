package jp.sji.kansai.android.demo.activity;

import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class SettingMasterActivity extends BaseActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingmaster);
        //setTitleName("マスタ設定");
        //setTitleIcon(android.R.drawable.ic_menu_preferences);
        //setUploadStatus(); 
        
    }

    
    // ************************************************************************
    // メニュークリックイベント
    // ************************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

    	// XML定義を呼び出し、該当のリソースを読み取り表示する
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.settingmaster, menu);
    	return true;
    	
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

    	String msg = "";
    	Intent intent = null;
    	
    	switch(item.getItemId()){
    		case R.id.setting_menuItem_SystemSetting :
    			msg = "システム設定ボタンをタップしました";
    			intent = new Intent(this,SettingSystemActivity.class);
    			startActivity(intent);
    			break;
    		case R.id.setting_menuItem_MasterSetting :
    			msg = "マスタ設定ボタンをタップしました";
    			intent = new Intent(this,SettingMasterActivity.class);
    			startActivity(intent);
    			break;
    		case R.id.setting_menuItem_PrivateSetting :
    			msg = "個人設定ボタンをタップしました";
    			intent = new Intent(this,SettingPrivateActivity.class);
    			startActivity(intent);
    			break;
    		default:
    			break;
    	}
    	
    	showToast(msg);
       	return true;
    	
    }    
}