/**
 *
 */
package jp.sji.kansai.android.demo.buyer;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author takashi.o
 *
 */
public class MaterialListActivity extends BuyerDemoListActivity {

	/**
	 * アクティビティが最初に起動する時に実行されるメソッド<br>
	 * <br>
	 * onSaveInstanceStateメソッドで保存された情報がある場合は、<br>
	 * 引数のBundleにその情報が引き渡され、状態を復元させることが可能<br>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		//-----------------------
		// 初期処理
		//-----------------------
		// 親クラスのメソッドを実行
		super.onCreate(savedInstanceState);

        // リスト表示用のデータ取得
        List<String> materialList = getMaterialListItems();
		
        // アダプタ作成
        setListAdapter( new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, materialList) );
		
		// クリックイベント
        getListView().setOnItemClickListener(
        	new AdapterView.OnItemClickListener() {
        		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        			ListView listView = (ListView)parent;

        			String item = (String)listView.getItemAtPosition(position);
//					Toast.makeText(MaterialListActivity.this, item, Toast.LENGTH_LONG).show();

        			// インテントの生成
        			Intent intent = new Intent(MaterialListActivity.this, MaterialDetailActivity.class);

        			// パラメータの設定(次画面に引き継ぐパラメータを設定)
        			intent.putExtra("MATERIAL_NAME", item);

        			// 次のアクティビティの呼び出し
        			startActivity(intent);
        		}
        	}
        );

        getListView().setOnItemSelectedListener(
        	new AdapterView.OnItemSelectedListener() {
        		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        			ListView listView = (ListView)parent;

        			String item = (String)listView.getSelectedItem();
//					Toast.makeText(MaterialListActivity.this, item, Toast.LENGTH_LONG).show();
        		}

        		public void onNothingSelected(AdapterView<?> parent) {
        		}
        	}
        );
	}

	/**
	 * 一覧に表示する品目情報を取得する
	 */
	private List<String> getMaterialListItems() {
		
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < 10; i++) {
			list.add("品目" + i);
		}
		return list;
		
	}

//	/* (非 Javadoc)
//	 * @see android.app.Activity#onResume()
//	 */
//	@Override
//	protected void onResume() {
//		List<String> list = new ArrayList<String>();
//		list.add("品目１");
//		list.add("品目２");
//		list.add("品目３");
//
//		// 表示データのクリア
//		this.arrayAdapter.clear();
//
//		// 表示データの設定
//		for (String str : list) {
//			this.arrayAdapter.add(str);
//		}
//	}


}
