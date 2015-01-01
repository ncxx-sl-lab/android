package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：承認履歴一覧
 * クラス名：RequestListActivity
 */

import java.util.ArrayList;
import java.util.HashMap;

import jp.sji.kansai.android.demo.manager.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class RequestListActivity extends BaseActivity {
	
	String[] request_title =new String[] {
			"○○物品１","未承認品目２","未承認品目３","未承認品目４","未承認品目５",
			"未承認品目６","未承認品目７","未承認品目８","未承認品目９","未承認品目１０"
			
	};
	
	String[] request_detail =new String[] {
			"SJI太郎","依頼者２","依頼者３","依頼者４","依頼者５",
			"依頼者６","依頼者７","依頼者８","依頼者９","依頼者１０"
	};
	/**
	 * 
	 */
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
    	
//    	super.onCreate(savedInstanceState);
//    	this.setContentView(R.layout.requestlist);

    	super.onCreate(savedInstanceState,R.layout.requestlist);

    	
    	ListView lv = (ListView)findViewById(R.id.RequestListView);
		//setContentView(lv);
    	
               

        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
        
        for ( int i=0 ; i< 10 ; i++ ) {
        	 HashMap<String,String> map = new HashMap<String,String>();
        	 map.put("title",request_title[i]);
        	 map.put("detail",request_detail[i]);
        	 data.add(map);
        }
        
        SimpleAdapter sa = new SimpleAdapter(this, data, R.layout.row, new String[]{"title","detail"},new int[]{R.id.listtitle,R.id.listdetail});
        lv.setAdapter(sa);
        
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
            	try{
            		
	            	//ListView listView = (ListView) parent;
	                String item = String.valueOf(position);
	
	                //showToast(String.format("onItemSelected: %s", item));
	                
	                logInfo("Selected Position   ---> " + item);
	                logInfo("Selected ListTitle  ---> " + request_title[position]);
	                logInfo("Selected ListDetail ---> " + request_detail[position]);
	                // 承認履歴個別アクティビティの呼び出し
					Intent intent = new Intent(RequestListActivity.this, jp.sji.kansai.android.demo.manager.activity.RequestDetailDispActivity.class);
					intent.putExtra("ITEMCD", item);
					startActivity(intent);
					
            	}catch(Exception ex){
            		logError(ex.toString());
            	}
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