package jp.sji.kansai.android.demo.activity;

import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_HHMM;
import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_HHMM_SLASH;
import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDD;
import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDD_SLASH;
import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMM_JAPAN;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_EMPLOYEE_NO;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_KINTAI_DATE;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_NEXT_MONTH;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_PREVIOUS_MONTH;

import java.util.ArrayList;
import java.util.List;

import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.db.dao.TKintaiInfoDao;
import jp.sji.kansai.android.demo.db.entity.TKintaiInfoEntity;
import jp.sji.kansai.android.demo.util.DateUtil;
import jp.sji.kansai.android.demo.util.SystemUtil;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class KinmuInfoListActivity extends BaseActivity {

	// 表示するデータのリスト
	private ArrayList list = null;
	// ListAdapter
	private KinmuInfoAdapter adapter = null;

	/** 勤務日付 */
	private TextView tvKinmuDate;

	/** 前月ボタン */
	private Button btnPreviousMonth;

	/** 当月ボタン */
	private Button btnThisMonth;

	/** 翌月ボタン */
	private Button btnNextMonth;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kinmuinfolist);
		setTitleName("勤務情報一覧");
		setTitleIcon(android.R.drawable.ic_menu_agenda);
		setUploadStatus();

		// 初期処理を実行する
		initActivity();
	}

	/**
	 * リスタート時処理
	 */
	@Override
	protected void onRestart() {
		super.onRestart();

		// 初期処理を行う
		initActivity();
	}

    // ************************************************************************
    // メニュークリックイベント
    // ************************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

    	// XML定義を呼び出し、該当のリソースを読み取り表示する
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.kinmuinfolist, menu);
    	return true;

    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		String msg = "";
		Intent intent = null;

		switch (item.getItemId()) {
		case R.id.kinmuinfolist_menuItem_Before:
			msg = "＜＜前月ボタンをタップしました";
			intent = new Intent(this, KinmuInfoListActivity.class);
			intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, this.employeeNo);
			intent.putExtra(INTENT_EXTRA_KEY_PREVIOUS_MONTH, (DateUtil.addMonth(this.kinmuDate, -1)));
			startActivity(intent);
			break;
		case R.id.kinmuinfolist_menuItem_Next:
			msg = "翌月＞＞ボタンをタップしました";
			intent = new Intent(this, KinmuInfoListActivity.class);
			intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, this.employeeNo);
			intent.putExtra(INTENT_EXTRA_KEY_NEXT_MONTH, (DateUtil.addMonth(this.kinmuDate, 1)));
			startActivity(intent);
			break;
		case R.id.kinmuinfolist_menuItem_Current:
			msg = "当月ボタンをタップしました";
			intent = new Intent(this, KinmuInfoListActivity.class);
			intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, this.employeeNo);
			startActivity(intent);
			break;
		case R.id.kinmuinfolist_menuItem_KinmuNewInput:
			msg = "勤務入力ボタンをタップしました";
			intent = new Intent(this, KinmuInfoEditActivity.class);
			intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, this.employeeNo);
			startActivity(intent);
			break;
		default:
			break;
		}

		showToast(msg);
		return true;

	}

    // ダミーデータ生成
    private void createDummyData() {
	    this.list = new ArrayList();
	    KinmuInfoData item1 = new KinmuInfoData();
	    item1.setDate("11/01");
	    item1.setWeekDay("(火)");
	    item1.setStartTime("09:00");
	    item1.setFinishTime("18:00");
	    list.add(item1);

	    KinmuInfoData item2 = new KinmuInfoData();
	    item2.setDate("11/02");
	    item2.setWeekDay("(水)");
	    item2.setStartTime("09:00");
	    item2.setFinishTime("18:00");
	    list.add(item2);

	    KinmuInfoData item3 = new KinmuInfoData();
	    item3.setDate("11/03");
	    item3.setWeekDay("(木)");
	    item3.setStartTime("*****");
	    item3.setFinishTime("*****");
	    list.add(item3);

	    KinmuInfoData item4 = new KinmuInfoData();
	    item4.setDate("11/04");
	    item4.setWeekDay("(金)");
	    item4.setStartTime("09:00");
	    item4.setFinishTime("19:00");
	    list.add(item4);

	    KinmuInfoData item5 = new KinmuInfoData();
	    item5.setDate("11/05");
	    item5.setWeekDay("(土)");
	    item5.setStartTime("*****");
	    item5.setFinishTime("*****");
	    list.add(item5);

	    KinmuInfoData item6 = new KinmuInfoData();
	    item6.setDate("11/06");
	    item6.setWeekDay("(日)");
	    item6.setStartTime("*****");
	    item6.setFinishTime("*****");
	    list.add(item6);

	    KinmuInfoData item7 = new KinmuInfoData();
	    item7.setDate("11/07");
	    item7.setWeekDay("(月)");
	    item7.setStartTime("09:00");
	    item7.setFinishTime("21:30");
	    list.add(item7);

	    KinmuInfoData item8 = new KinmuInfoData();
	    item8.setDate("11/08");
	    item8.setWeekDay("(火)");
	    item8.setStartTime("09:00");
	    item8.setFinishTime("19:00");
	    list.add(item8);

	    KinmuInfoData item9 = new KinmuInfoData();
	    item9.setDate("11/09");
	    item9.setWeekDay("(水)");
	    item9.setStartTime("09:00");
	    item9.setFinishTime("17:45");
	    list.add(item9);

	    KinmuInfoData item10 = new KinmuInfoData();
	    item10.setDate("11/10");
	    item10.setWeekDay("(木)");
	    item10.setStartTime("09:00");
	    item10.setFinishTime("21:30");
	    list.add(item10);
    }

    /**
     * Activityの初期処理を行う
     */
    @Override
	protected void initActivity() {
    	super.initActivity();

    	// 対象月の勤務情報一覧を取得する
		TKintaiInfoDao kintaiInfoDao = new TKintaiInfoDao(this);
		List<TKintaiInfoEntity> kintaiInfoEntityList
				= kintaiInfoDao.selKintaiInfoForMonth(this.employeeNo, this.kinmuDate);

		// 勤務日付
		this.tvKinmuDate = (TextView) this.findViewById(R.id.lblViewYearMonth);
		this.tvKinmuDate.setText(SystemUtil.convDateToString(this.kinmuDate, DATE_FORMAT_YYYYMM_JAPAN));

		// 取得した内容をリストで表示する
		KinmuInfoListAdapter adapter = new KinmuInfoListAdapter(this, R.layout.kinmuinfolist_row, kintaiInfoEntityList);
		ListView listView = (ListView) findViewById(R.id.lstKinmuInfo);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
				ListView listView = (ListView) parent;
				TKintaiInfoEntity entity = (TKintaiInfoEntity) listView.getItemAtPosition(pos);

				Intent intent = new Intent(KinmuInfoListActivity.this, KinmuInfoViewActivity.class);
				intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, entity.getEmployeeNo());
				intent.putExtra(INTENT_EXTRA_KEY_KINTAI_DATE, SystemUtil.toDate(entity.getKintaiDate(), DATE_FORMAT_YYYYMMDD));
				startActivity(intent);
			}
		});

		// ボタンの設定を行う
		// 前月ボタン
		this.btnPreviousMonth = (Button) this.findViewById(R.id.btnBefore);
		this.btnPreviousMonth.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(KinmuInfoListActivity.this, KinmuInfoListActivity.class);
				intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, KinmuInfoListActivity.this.employeeNo);
				intent.putExtra(INTENT_EXTRA_KEY_PREVIOUS_MONTH, (DateUtil.addMonth(KinmuInfoListActivity.this.kinmuDate, -1)));
				finish();
				startActivity(intent);
			}
		});

		// 当月ボタン
		this.btnThisMonth = (Button) this.findViewById(R.id.btnToday);
		this.btnThisMonth.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(KinmuInfoListActivity.this, KinmuInfoListActivity.class);
				intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, KinmuInfoListActivity.this.employeeNo);
				finish();
				startActivity(intent);
			}
		});

		// 翌月ボタン
		this.btnNextMonth = (Button) this.findViewById(R.id.btnNext);
		this.btnNextMonth.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(KinmuInfoListActivity.this, KinmuInfoListActivity.class);
				intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, KinmuInfoListActivity.this.employeeNo);
				intent.putExtra(INTENT_EXTRA_KEY_PREVIOUS_MONTH, (DateUtil.addMonth(KinmuInfoListActivity.this.kinmuDate, 1)));
				finish();
				startActivity(intent);
			}
		});

	}

	/**
	 * 勤務情報一覧を表示するアダプタ
	 * @author Hiroshi Tsuji
	 *
	 */
	private class KinmuInfoListAdapter extends ArrayAdapter<TKintaiInfoEntity> {

		private LayoutInflater layoutInflater;

		/** 勤務日付 */
		private TextView kintaiDate;

		/** 勤務日付　曜日 */
		private TextView kintaiDayOfWeek;

		/** 開始時間 */
		private TextView startTime;

		/** 終了時間 */
		private TextView endTime;

		/**
		 * コンストラクタ
		 * @param context
		 * @param textViewResourceId
		 * @param itemList
		 */
		public KinmuInfoListAdapter(Context context, int textViewResourceId, List<TKintaiInfoEntity> itemList) {
			super(context, textViewResourceId, itemList);
			this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// ビューを受け取る
			View view = convertView;
			if (view == null) {
				// 受け取ったビューがnullなら新しくビューを生成
				view = this.layoutInflater.inflate(R.layout.kinmuinfolist_row, null);
			}

			// 表示すべきデータの取得
			TKintaiInfoEntity entity = this.getItem(position);
			if (entity != null) {

				// 勤怠日付
				this.kintaiDate = (TextView) view.findViewById(R.id.txtDate);
				this.kintaiDate.setText(SystemUtil.convStrToStrDateFormat(entity.getKintaiDate(), DATE_FORMAT_YYYYMMDD, DATE_FORMAT_YYYYMMDD_SLASH));

				// 曜日
				this.kintaiDayOfWeek = (TextView) view.findViewById(R.id.txtWeekDay);
				this.kintaiDayOfWeek.setText("(" + DateUtil.getStrDayOfWeek(entity.getKintaiDate()) + ")");

				// 土曜日・日曜日は色を変更
				if(DateUtil.getStrDayOfWeek(entity.getKintaiDate()).equals("土")){
					this.kintaiDate.setTextColor(0xff0000ff);
					this.kintaiDayOfWeek.setTextColor(0xff0000ff);
				}else if(DateUtil.getStrDayOfWeek(entity.getKintaiDate()).equals("日")){
					this.kintaiDate.setTextColor(0xffff0000);
					this.kintaiDayOfWeek.setTextColor(0xffff0000);			
				}else{
					this.kintaiDate.setTextColor(0xff000000);
					this.kintaiDayOfWeek.setTextColor(0xff000000);			
				}
				
				// 開始時間
				this.startTime = (TextView) view.findViewById(R.id.txtStartTime);
				this.startTime.setText(SystemUtil.convStrToStrDateFormat(entity.getStartTime(), DATE_FORMAT_HHMM, DATE_FORMAT_HHMM_SLASH));

				// 終了時間
				this.endTime = (TextView) view.findViewById(R.id.txtFinishTime);
				this.endTime.setText(SystemUtil.convStrToStrDateFormat(entity.getEndTime(), DATE_FORMAT_HHMM,DATE_FORMAT_HHMM_SLASH));
			}
			return view;
		}
	}
}