package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：承認メニュー
 * クラス名：RequestMenuListActivity
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RequestMenuListActivity extends BaseActivity {

	String[] materialname =new String[] {
			"未承認品目(13)","承認済品目(20)"
	};

	/**
	 *
	 */
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {

//    	super.onCreate(savedInstanceState);
//    	ListView lv = new ListView(this);
//      setContentView(lv);
    	
    	ListView lv = new ListView(this);
    	super.onCreate(savedInstanceState,lv);

        


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, materialname);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

                //ListView listView = (ListView) parent;
                //String item = (String) listView.getItemAtPosition(position);

                //showToast(String.format("onItemSelected: %s", position));
                // 承認履歴アクティビティの呼び出し
				Intent intent = new Intent(RequestMenuListActivity.this, jp.sji.kansai.android.demo.manager.activity.RequestListActivity.class);

                if( position == 0 ){
					intent.putExtra("MODE", "0");
				}else{
					intent.putExtra("MODE", "1");
				}
				startActivity(intent);
            }
        });


        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                //ListView listView = (ListView) parent;
                //String item = (String) listView.getSelectedItem();
                //showToast(String.format("onItemSelected: %s", item));

            }
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }

}