package jp.sji.kansai.android.demo.activity;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import jp.sji.kansai.android.demo.R;

public class KinmuInfoAdapter extends ArrayAdapter {  
  
	private ArrayList items;  
	private LayoutInflater inflater;
	
	
	private TextView mDate;
	private TextView mWeekDay;
	private TextView mStartTime;
	private TextView mFinishTime;
  
	public KinmuInfoAdapter(Context context, int textViewResourceId,ArrayList items) {  
		super(context, textViewResourceId, items);  
		this.items = items;  
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	}  
  
	@Override  
	public View getView(int position, View convertView, ViewGroup parent) {  
		// ビューを受け取る  
		View view = convertView;  
		if (view == null) {  
			// 受け取ったビューがnullなら新しくビューを生成  
			view = inflater.inflate(R.layout.kinmuinfolist_row, null);  
		}  
		// 表示すべきデータの取得  
		KinmuInfoData item = (KinmuInfoData)items.get(position);  
		if (item != null) {  
			mDate = (TextView)view.findViewById(R.id.txtDate);
			mDate.setText(item.getDate());
			
			mWeekDay = (TextView)view.findViewById(R.id.txtWeekDay);
			mWeekDay.setText(item.getWeekDay());

			mStartTime = (TextView)view.findViewById(R.id.txtStartTime);
			mStartTime.setText(item.getStartTime());
			
			mFinishTime = (TextView)view.findViewById(R.id.txtFinishTime);
			mFinishTime.setText(item.getFinishTime());			
		}	
		return view;  
	}
}  