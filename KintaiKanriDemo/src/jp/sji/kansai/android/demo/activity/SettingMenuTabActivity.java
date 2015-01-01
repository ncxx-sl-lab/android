package jp.sji.kansai.android.demo.activity;

import jp.sji.kansai.android.demo.R;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class SettingMenuTabActivity extends BaseTabActivity {

	TabHost tabHost = null;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingtablayout);
		// setTitleName("設定メニュー");
		// setTitleIcon(android.R.drawable.ic_menu_manage);
		// setUploadStatus();

		tabHost = getTabHost();
		Resources res = getResources();
		
		TabHost.TabSpec spec;
		Intent intent;

		intent = new Intent().setClass(this, SettingSystemActivity.class);
		spec = tabHost
				.newTabSpec("tab1")
				.setIndicator("システム設定",
						res.getDrawable(android.R.drawable.ic_menu_manage))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, SettingMasterActivity.class);
		spec = tabHost
				.newTabSpec("tab2")
				.setIndicator("マスタ設定",
						res.getDrawable(android.R.drawable.ic_menu_preferences))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, SettingPrivateActivity.class);
		spec = tabHost
				.newTabSpec("tab3")
				.setIndicator("個人設定",
						res.getDrawable(android.R.drawable.ic_menu_mylocation))
				.setContent(intent);
		tabHost.addTab(spec);
				
		tabHost.setCurrentTab(0);
		setTitleName("システム設定");
		setTitleIcon(android.R.drawable.ic_menu_manage);
		
    	Bundle extras = getIntent().getExtras();
    	if (extras != null){
	    	if (extras.getString("MODE").toString().equals("System")){
				tabHost.setCurrentTab(0);
				setTitleName("システム設定");
				setTitleIcon(android.R.drawable.ic_menu_manage);
	    	}else if(extras.getString("MODE").toString().equals("Master")){
				tabHost.setCurrentTab(1);
				setTitleName("マスタ設定");
				setTitleIcon(android.R.drawable.ic_menu_preferences);    		
	    	}else{
	    		tabHost.setCurrentTab(2);
				setTitleName("個人設定");
				setTitleIcon(android.R.drawable.ic_menu_mylocation);	    		
	    	}
    	}
		tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
			// タブがクリックされた時のハンドラ
			@Override
			public void onTabChanged(String tabId) {
				if(tabId == "tab1") {
					//tabHost.setCurrentTab(0);
					setTitleName("システム設定");
					setTitleIcon(android.R.drawable.ic_menu_manage);						
				}else if(tabId == "tab2"){
					//tabHost.setCurrentTab(1);
					setTitleName("マスタ設定");
					setTitleIcon(android.R.drawable.ic_menu_preferences);					
				}else if(tabId == "tab3") {
					//tabHost.setCurrentTab(2);
					setTitleName("個人設定");
					setTitleIcon(android.R.drawable.ic_menu_mylocation);					
				}
			}
		});
		
		
	}

}