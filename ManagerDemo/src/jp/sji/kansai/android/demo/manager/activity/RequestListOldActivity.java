package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：承認履歴一覧
 * クラス名：RequestListActivity
 */

import jp.sji.kansai.android.demo.manager.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RequestListOldActivity extends BaseActivity {

	String[] non_list =new String[] {
			"未承認品目１","未承認品目２","未承認品目３","未承認品目４","未承認品目５",
			"未承認済品目６","未承認品目７","未承認品目８","未承認品目９","未承認品目１０",
			"未承認済品目１１","未承認品目１２","未承認品目１３","未承認品目１４","未承認品目１５",
			"未承認済品目１６","未承認品目１７","未承認品目１８","未承認品目１９","未承認品目２０"

	};

	String[] ok_list =new String[] {
			"承認済品目１","承認済品目２","承認済品目３","承認済品目４","承認済品目５",
			"承認済品目６","承認済品目７","承認済品目８","承認済品目９","承認済品目１０",
			"承認済品目１１","承認済品目１２","承認済品目１３","承認済品目１４","承認済品目１５",
			"承認済品目１６","承認済品目１７","承認済品目１８","承認済品目１９","承認済品目２０"

	};

	/**
	 *
	 */
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        this.setContentView(R.layout.requestlistold);
    	
    	super.onCreate(savedInstanceState,R.layout.requestlistold);
    	
        ListView lv = new ListView(this);
        setContentView(lv);


		Intent intent = this.getIntent();

		String mode = intent.getExtras().getString("MODE");

		logDebug("mode ---> " + mode);

		//showToast(mode);
        ArrayAdapter<String> adapter = null;


        if (mode.equals("0")){
        	logDebug("non_list");
	        adapter = new ArrayAdapter<String>(this,
	                android.R.layout.simple_list_item_1, non_list);
	        setTitle("[Menu]-[承認履歴]-[未承認履歴一覧]");

        }else{
        	logDebug("ok_list");
	        adapter = new ArrayAdapter<String>(this,
	                android.R.layout.simple_list_item_1, ok_list);
	        setTitle("[Menu]-[承認履歴]-[承認履歴一覧]");
        }

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

                ListView listView = (ListView) parent;
                String item = (String) listView.getItemAtPosition(position);

                //showToast(String.format("onItemSelected: %s", item));

                // 承認履歴個別アクティビティの呼び出し
				Intent intent = new Intent(RequestListOldActivity.this, jp.sji.kansai.android.demo.manager.activity.RequestDetailDispActivity.class);
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