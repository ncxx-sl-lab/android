package jp.sji.kansai.android.demo.buyer.adapter;

import android.widget.ArrayAdapter;
import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import jp.sji.kansai.android.demo.buyer.R;
import jp.sji.kansai.android.demo.buyer.dto.OrderListItemDto;

public class OrderListAdapter extends ArrayAdapter<OrderListItemDto> {

    private LayoutInflater         layoutInflater = null;
    private List<OrderListItemDto> items          = null;

	public OrderListAdapter( Context context, int resourceId, List<OrderListItemDto> items ){
		super( context, resourceId );

        //LayoutInflaterを取得
        layoutInflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.items = items;
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent ) {

		// view が再利用されていないときのみ、新規作成
		if( convertView == null ){
            // orderlistitem.xmlから1行分のレイアウトを生成
            convertView = layoutInflater.inflate( R.layout.orderlistitem, null );
		}

		OrderListItemDto item = items.get( position );
        TextView material = ( TextView )convertView.findViewById( R.id.orderListItem_material );
        TextView date     = ( TextView )convertView.findViewById( R.id.orderListItem_date );
        TextView status   = ( TextView )convertView.findViewById( R.id.orderListItem_status );

        // view に値をセット
        material.setText( item.getMaterial() );
        date.setText( item.getDate() );
        status.setText( item.getStatus() );

		return convertView;

	}
	@Override
    public int getCount() {
        return items.size();
    }

	@Override
    public OrderListItemDto getItem(int position) {
        return items.get( position );
    }

	@Override
    public long getItemId(int position) {
        return position;
    }


}
