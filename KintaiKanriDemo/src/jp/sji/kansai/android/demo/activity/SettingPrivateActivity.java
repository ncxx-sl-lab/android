package jp.sji.kansai.android.demo.activity;

import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SettingPrivateActivity extends BaseActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingprivate);
        //setTitleName("個人設定");
        //setTitleIcon(android.R.drawable.ic_menu_mylocation);
        //setUploadStatus();

/*
          ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // アイテムを追加します
        adapter.add("B");
        adapter.add("F");
        adapter.add("G");
        adapter.add("Z01");
        adapter.add("Z90");
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        // アダプターを設定します
        spinner.setAdapter(adapter);

        // スピナーのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                Spinner spinner = (Spinner) parent;
                // 選択されたアイテムを取得します
                String item = (String) spinner.getSelectedItem();
//                Toast.makeText(SettingPrivateActivity.this, "プロバイダが無効です。", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
*/
        ArrayAdapter<String> adapter_proj_code = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter_proj_code.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // アイテムを追加します
        adapter_proj_code.add("3V-301299xx-00x");
        adapter_proj_code.add("3V-301200xx-00x");
        adapter_proj_code.add("3V-301211xx-0xx");
        Spinner spinner_proj_code = (Spinner) findViewById(R.id.spinner2);
        // アダプターを設定します
        spinner_proj_code.setAdapter(adapter_proj_code);
        // スピナーのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
        spinner_proj_code.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
/*                Spinner spinner = (Spinner) parent;
                // 選択されたアイテムを取得します
                String item = (String) spinner.getSelectedItem();
                Toast.makeText(SettingPrivateActivity.this, item, Toast.LENGTH_LONG).show();
*/
                }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });



    }


    // ************************************************************************
    // メニュークリックイベント
    // ************************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

    	// XML定義を呼び出し、該当のリソースを読み取り表示する
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.settingprivate, menu);
    	return true;

    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	String msg = "";
    	Intent intent = null;

    	switch(item.getItemId()){
    		case R.id.txthead1 :
    			msg = "システム設定ボタンをタップしました";
    			intent = new Intent(this,SettingSystemActivity.class);
    			startActivity(intent);
    			break;
    		case R.id.txthead2:
    			msg = "マスタ設定ボタンをタップしました";
    			intent = new Intent(this,SettingMasterActivity.class);
    			startActivity(intent);
    			break;
    		case R.id.txthead3:
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
*/


    // ************************************************************************
    // 個人設定メニューイベント
    // ************************************************************************
	public void toSettingSystem(View view){
		Intent intent = null;
		intent = new Intent(this,SettingSystemActivity.class);
		startActivity(intent);

	}

	public void toSettingMaster(View view){
		Intent intent = null;
		intent = new Intent(this,SettingMasterActivity.class);
		startActivity(intent);

	}



}