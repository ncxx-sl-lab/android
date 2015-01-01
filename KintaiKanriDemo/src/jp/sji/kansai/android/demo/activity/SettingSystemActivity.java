package jp.sji.kansai.android.demo.activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.util._FakeX509TrustManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class SettingSystemActivity extends BaseActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingsystem);
        setTitleName("システム設定");
        //setTitleIcon(android.R.drawable.ic_menu_manage);
        //setUploadStatus();         
        
    }

    
    // ************************************************************************
    // メニュークリックイベント
    // ************************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

    	// XML定義を呼び出し、該当のリソースを読み取り表示する
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.settingsystem, menu);
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
    
    // 個人設定ボタン
	public void toSettingPrivate(View view){
		Intent intent = null;
		intent = new Intent(this,SettingPrivateActivity.class);
		startActivity(intent);

	}

	// マスタ設定ボタン
	public void toSettingMaster(View view){
		Intent intent = null;
		intent = new Intent(this,SettingMasterActivity.class);
		startActivity(intent);

	}

	// 接続テストボタン
	public void toConnectTest(View view){

		try {
			_FakeX509TrustManager.allowAllSSL();
			URLConnection connection = new URL("https://163.43.165.51/KintaiKanriWebAPI/memployee?format=xml&e=00000&p=test").openConnection();
			HttpsURLConnection con = (HttpsURLConnection) connection;
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("Connection", "close");
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			
			int status =  con.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String s;
			StringBuffer sb = new StringBuffer();
			while ((s = reader.readLine()) != null) {
				sb.append(s);
			}
			reader.close();
			con.disconnect();
			
			AlertDialog.Builder AlertDlgBldr = new AlertDialog.Builder(SettingSystemActivity.this);
			AlertDlgBldr.setTitle("接続テスト");
			AlertDlgBldr.setMessage("接続に成功しました。" + status + sb.toString());
			AlertDlgBldr.setPositiveButton("ok", new DialogInterface.OnClickListener() {
				@Override              
				public void onClick(DialogInterface dialog, int which) {
				}
				});
			AlertDialog AlertDlg = AlertDlgBldr.create();
			AlertDlg.show();   
		} catch (Exception e) {
			AlertDialog.Builder AlertDlgBldr = new AlertDialog.Builder(SettingSystemActivity.this);
			AlertDlgBldr.setTitle("接続テスト");
			AlertDlgBldr.setMessage("接続に失敗しました。" + e.getMessage());
			AlertDlgBldr.setPositiveButton("ok", new DialogInterface.OnClickListener() {
				@Override              
				public void onClick(DialogInterface dialog, int which) {
				}
				});
			AlertDialog AlertDlg = AlertDlgBldr.create();
			AlertDlg.show();   
		}
	}

}