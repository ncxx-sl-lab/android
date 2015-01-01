package jp.sji.kansai.android.demo.activity;

import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_EMPLOYEE_NO;
import jp.sji.kansai.android.demo.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SettingMenuActivity extends BaseActivity {
	
	/** システム設定ボタン */
	private Button btnSystemSetting;
	
	/** マスタ設定ボタン */
	private Button btnMasterSetting;
	
	/** 個人設定ボタン */
	private Button btnPrivateSetting;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingmenu);
        setTitleName("設定メニュー");
        setTitleIcon(android.R.drawable.ic_menu_manage);
        setUploadStatus(); 
        
        initActivity();
        
    }

    
    // ************************************************************************
    // メニュークリックイベント
    // ************************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

    	// XML定義を呼び出し、該当のリソースを読み取り表示する
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.settingmenu, menu);
    	return true;
    	
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

    	String msg = "";
    	Intent intent = null;
    	
    	switch(item.getItemId()){
    		case R.id.setting_menuItem_SystemSetting :
    			msg = "システム設定ボタンをタップしました";
    			intent = new Intent(this,SettingMenuTabActivity.class);
    			intent.putExtra("MODE","System");
    			startActivity(intent);
    			break;
    		case R.id.setting_menuItem_MasterSetting :
    			msg = "マスタ設定ボタンをタップしました";
    			intent = new Intent(this,SettingMenuTabActivity.class);
    			intent.putExtra("MODE","Master");
    			startActivity(intent);
    			break;
    		case R.id.setting_menuItem_PrivateSetting :
    			msg = "個人設定ボタンをタップしました";
    			intent = new Intent(this,SettingMenuTabActivity.class);
    			intent.putExtra("MODE","Private");
    			startActivity(intent);
    			break;
    		default:
    			break;
    	}
    	
    	showToast(msg);
       	return true;
    } 
    
	/**
	 * 初期表示処理を行う
	 */
    @Override
	protected void initActivity() {

    	super.initActivity();
    
		// ボタンの設定を行う
		// システム設定ボタン
		this.btnSystemSetting = (Button) this.findViewById(R.id.btnSystemSetting);
		this.btnSystemSetting.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Intent intent = new Intent(SettingMenuActivity.this, SettingSystemActivity.class);
				//intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, SettingMenuActivity.this.employeeNo);
    			Intent intent = new Intent(SettingMenuActivity.this,SettingMenuTabActivity.class);
    			intent.putExtra("MODE","System");
    			
				startActivity(intent);
			}
		});
		
		// マスタ設定ボタン
		this.btnMasterSetting = (Button) this.findViewById(R.id.btnMasterSetting);
		this.btnMasterSetting.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Intent intent = new Intent(SettingMenuActivity.this, SettingMasterActivity.class);
				//intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, SettingMenuActivity.this.employeeNo);
    			Intent intent = new Intent(SettingMenuActivity.this,SettingMenuTabActivity.class);
    			intent.putExtra("MODE","Master");
				startActivity(intent);
			}
		});
		
		// 個人設定ボタン
		this.btnPrivateSetting = (Button) this.findViewById(R.id.btnPrivateSetting);
		this.btnPrivateSetting.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Intent intent = new Intent(SettingMenuActivity.this, SettingPrivateActivity.class);
				//intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, SettingMenuActivity.this.employeeNo);
    			Intent intent = new Intent(SettingMenuActivity.this,SettingMenuTabActivity.class);
    			intent.putExtra("MODE","Private");
				startActivity(intent);
			}
		});
    }
}