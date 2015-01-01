/**
 *
 */
package jp.sji.kansai.android.demo.manager.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jp.sji.kansai.android.demo.manager.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * @author takashi.o
 *
 */
public class BuyerListActivity extends BaseActivity {

	private ListView listView = null;

	private ArrayAdapter<String> arrayAdapter = null;

	/**
	 * アクティビティが最初に起動する時に実行されるメソッド<br>
	 * <br>
	 * onSaveInstanceStateメソッドで保存された情報がある場合は、<br>
	 * 引数のBundleにその情報が引き渡され、状態を復元させることが可能<br>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

//		outputLog("onCreate");

		//-----------------------
		// 初期処理
		//-----------------------
		// 親クラスのメソッドを実行
		super.onCreate(savedInstanceState);

		// アクティビティにビュー(next.xml)を追加
		setContentView(R.layout.buyerlist);

		
		String buyername[] = new String[10];
		for (int i = 0; i < 10; i++) {
			buyername[i] = "バイヤー" + (i+1);
		}

		String buyercode[] = new String[10];
		for (int i = 0; i < 10; i++) {
			buyercode[i] = "000000" + (i+1);
		}
        
        ListView lv = (ListView)findViewById(R.id.buyerList_BuyerListView);
        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
        
        for ( int i=0 ; i< 10 ; i++ ) {
        	 HashMap<String,String> map = new HashMap<String,String>();
        	 map.put("title",buyername[i]);
        	 map.put("detail",buyercode[i]);
        	 data.add(map);
        }
        
        SimpleAdapter sa = new SimpleAdapter(this, data, R.layout.row, new String[]{"title","detail"},new int[]{R.id.listtitle,R.id.listdetail});
        lv.setAdapter(sa);        

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

                // 品目個別アクティビティの呼び出し
				Intent intent = new Intent(BuyerListActivity.this, jp.sji.kansai.android.demo.manager.activity.BuyerDetailActivity.class);
				startActivity(intent);
            }
        });		
		
		
//		this.listView = (ListView)this.findViewById(R.id.buyerList_BuyerListView);
//
//		this.arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
//
//		List<String> list = new ArrayList<String>();
//		for (int i = 1; i < 10; i++) {
//			list.add("バイヤー" + i);
//		}
//
//		// 表示データのクリア
//		this.arrayAdapter.clear();
//
//		// 表示データの設定
//		for (String str : list) {
//			this.arrayAdapter.add(str);
//		}
//
//		this.listView.setAdapter(this.arrayAdapter);
//
//		// クリックイベント
//		this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				ListView listView = (ListView)parent;
//
//				String item = (String)listView.getItemAtPosition(position);
////				Toast.makeText(MaterialListActivity.this, item, Toast.LENGTH_LONG).show();
//
//				// インテントの生成
//				Intent intent = new Intent(BuyerListActivity.this, BuyerDetailActivity.class);
//
//				// パラメータの設定(次画面に引き継ぐパラメータを設定)
//				intent.putExtra("BUYER_NAME", item);
//
//				// 次のアクティビティの呼び出し
//				startActivity(intent);
//			}
//		});
//
//		this.listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//			public void onItemSelected(AdapterView<?> parent, View view,
//					int position, long id) {
////				ListView listView = (ListView)parent;
//
////				String item = (String)listView.getSelectedItem();
////				Toast.makeText(MaterialListActivity.this, item, Toast.LENGTH_LONG).show();
//			}
//
//			public void onNothingSelected(AdapterView<?> parent) {
//			}
//		});
	}
}
