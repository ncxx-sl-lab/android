package jp.sji.kansai.android.demo.buyer;

import java.util.List;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SupplierListActivity extends BuyerDemoListActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

		//-----------------------
		// 初期処理
		//-----------------------
		// 親クラスのメソッドを実行
        super.onCreate(savedInstanceState);

        // リスト表示用のデータ取得
        List<String> supplierList = getSupplierListItems();

        // アダプタ作成
        setListAdapter( new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, supplierList) );

		// クリックイベント
		getListView().setOnItemClickListener(
			new AdapterView.OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					ListView listView = (ListView)parent;

					String item = (String)listView.getItemAtPosition(position);

					// インテントの生成
					Intent intent = new Intent(SupplierListActivity.this, SupplierDetailActivity.class);

					// パラメータの設定(次画面に引き継ぐパラメータを設定)
					intent.putExtra("SUPPLIER_NAME", item);

					// 次のアクティビティの呼び出し
					startActivity(intent);
				}
			}
		);
    }

    /** 一覧に表示する仕入先情報を取得する  */
	private List<String> getSupplierListItems() {

		List<String> list = new ArrayList<String>();

		for (int i = 1; i < 10; i++) {
			list.add("仕入先" + i);
		}
		list.add("test");

		return list;
	}

//	//オプションズメニューの設定
//	protected int getOptionsMenuResource(){
//
//		return R.menu.supplierlistmenu;
//
//	}
//
//	//メニューの各アイテムが選択されたときの設定
//	public boolean onOptionsExtendedItemSelected(MenuItem item){
//
//		switch( item.getItemId() ){
//
//			case R.id.optMenuItem_sort:
//
//
//				arrayAdapter.notifyDataSetChanged();
//
//			default:
//				break;
//		}
//
//		return super.onOptionsExtendedItemSelected(item);
//
//	}
}