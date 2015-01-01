package jp.sji.kansai.android.demo.buyer;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.content.Intent;
import jp.sji.kansai.android.demo.buyer.adapter.OrderListAdapter;
import jp.sji.kansai.android.demo.buyer.dto.OrderListItemDto;

public class OrderListActivity extends BuyerDemoListActivity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );

        // リスト表示用のデータ取得
        List<OrderListItemDto> orderList = getOrderListItems();

        // アダプタ作成
        setListAdapter( new OrderListAdapter(this, R.id.orderListView, orderList) );

		// クリックイベント
		getListView().setOnItemClickListener(
			new AdapterView.OnItemClickListener(){
				public void onItemClick( AdapterView<?> parent, View view, int position, long id ){
//
//					*** view や position から、次画面への値を取得する処理 ***
//
					// インテントの生成
					Intent intent = new Intent( OrderListActivity.this, OrderDetailActivity.class );
					// 次のアクティビティの呼び出し
					startActivity( intent );
				}
			}
		);

    }

    /** 一覧に表示する発注履歴情報を取得する  */
	private List<OrderListItemDto> getOrderListItems(){

		List<OrderListItemDto> items = new ArrayList<OrderListItemDto>();

		for (int i = 1; i < 30; i++) {

			OrderListItemDto item = new OrderListItemDto();
			item.setMaterial( "品目" + i );
			item.setDate( "2011.7." + i );
			if(i%2 == 1){
				item.setStatus( "発注済" );
			}else{
				item.setStatus( "未承認" );
			}
			items.add( item );

		}
		return items;
	}

}
