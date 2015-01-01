package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：通知品目一覧
 * クラス名：MaterialListActivity
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

public class MaterialListActivity extends BaseActivity  {

	String[] materialname =new String[] {
			"CENTURY(センチュリー)	CL-SU13TV1B MEZZO(メッツォ) ハイビジョン液晶テレビ 13V型" , 
			"PIXELA	PRD-LB116B PRODIA(プロディア) ハイビジョン液晶テレビ 16V型" ,
			"SHARP(シャープ) LC-19K5-B(ブラック) AQUOS(アクオス) ハイビジョン液晶テレビ 19V型" ,
			"SONY(ソニー) KDL-40EX720 BRAVIA(ブラビア) 3D対応フルハイビジョン液晶テレビ 40V型" ,
			"Panasonic(パナソニック) TH-L24C3 VIERA(ビエラ) フルハイビジョン液晶テレビ 24V型" ,
			"通知品目６",
			"通知品目７",
			"通知品目８",
			"通知品目９",
			"通知品目１０",
			"通知品目１１",
			"通知品目１２",
			"通知品目１３",
			"通知品目１４",
			"通知品目１５",
			"通知品目１６",
			"通知品目１７",
			"通知品目１８",
			"通知品目１９",
			"通知品目２０"
	};
	
	
	String[] materialcode = new String[] {
			"CLSU13TV1B" ,
			"PRDLB116B" , 
			"LC19K5B" ,
			"KDL40EX720" ,
			"THL24C3" ,
			"XXXXXXX006" ,
			"XXXXXXX007" ,
			"XXXXXXX008" ,
			"XXXXXXX009" ,
			"XXXXXXX010" ,
			"XXXXXXX011" ,
			"XXXXXXX012" ,
			"XXXXXXX013" ,
			"XXXXXXX014" ,
			"XXXXXXX015" ,
			"XXXXXXX016" ,
			"XXXXXXX017" ,
			"XXXXXXX018" ,
			"XXXXXXX019" ,
			"XXXXXXX020" 
	};
	
	String[] materialgroup = new String[] {
			"液晶テレビ" ,
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ" , 
			"液晶テレビ"  
	};
	

	/**
	 *
	 */
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        this.setContentView(R.layout.materiallist);
        
        super.onCreate(savedInstanceState,R.layout.materiallist);
        
        //ListView lv = new ListView(this);
        //setContentView(lv);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //       android.R.layout.simple_list_item_1, materialname);
        //lv.setAdapter(adapter);
        //lv.setBackgroundColor(Color.WHITE);

        //setContentView(lv);
        
        ListView lv = (ListView)findViewById(R.id.MaterialListView);
        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
        
        for ( int i=0 ; i< 10 ; i++ ) {
        	 HashMap<String,String> map = new HashMap<String,String>();
        	 map.put("title",materialcode[i]);
        	 map.put("detail",materialname[i]);
        	 data.add(map);
        }
        
        SimpleAdapter sa = new SimpleAdapter(this, data, R.layout.row, new String[]{"title","detail"},new int[]{R.id.listtitle,R.id.listdetail});
        lv.setAdapter(sa);        

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

//                ListView listView = (ListView) parent;
//                String item = (String) listView.getItemAtPosition(position);

                //showToast(String.format("onItemSelected: %s", item));

                // 品目個別アクティビティの呼び出し
				Intent intent = new Intent(MaterialListActivity.this, jp.sji.kansai.android.demo.manager.activity.MaterialDetailActivity.class);
//				intent.putExtra("ITEMCD", item);
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