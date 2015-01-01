package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：通知履歴一覧
 * クラス名：NoticeListActivity
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NoticeListActivity extends BaseActivity {

	String[] materialname =new String[] {
			"通知履歴品目１","通知履歴品目２","通知履歴品目３","通知履歴品目４","通知履歴品目５",
			"通知履歴品目６","通知履歴品目７","通知履歴品目８","通知履歴品目９","通知履歴品目１０",
			"通知履歴品目１１","通知履歴品目１２","通知履歴品目１３","通知履歴品目１４","通知履歴品目１５",
			"通知履歴品目１６","通知履歴品目１７","通知履歴品目１８","通知履歴品目１９","通知履歴品目２０"

	};

	/**
	 *
	 */
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        
    	//super.onCreate(savedInstanceState);
    	//ListView lv = new ListView(this);
        //setContentView(lv);
    	
    	ListView lv = new ListView(this);
    	super.onCreate(savedInstanceState,lv);
    	

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, materialname);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

                ListView listView = (ListView) parent;
                String item = (String) listView.getItemAtPosition(position);

                //showToast(String.format("onItemSelected: %s", item));

                // 通知個別アクティビティの呼び出し
				Intent intent = new Intent(NoticeListActivity.this,
						jp.sji.kansai.android.demo.manager.activity.NoticeDetailActivity.class);
				intent.putExtra("ITEMCD", item);
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