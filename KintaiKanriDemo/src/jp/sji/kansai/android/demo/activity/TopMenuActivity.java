package jp.sji.kansai.android.demo.activity;

import static jp.sji.kansai.android.demo.costants.AppConstants.NUMBER_FORMAT_TIME;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.costants.AppConstants;
import jp.sji.kansai.android.demo.db.dao.TProjectInfoDao;
import jp.sji.kansai.android.demo.db.entity.TProjectInfoEntity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TopMenuActivity extends BaseActivity{

	private ProgressDialog mProgressDialog;
	
	
	
	/** 現在日時 */
	private TextView txtTopMenuSysDate = null;

	/** 作業時間合計（定時） */
	private TextView tvTotalScheduledTime = null;

	/** 作業時間合計（残業） */
	private TextView tvTotalOvertimeWork = null;

	/** 作業時間合計（深夜） */
	private TextView tvTotalMidnight = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topmenu);
        setTitleName("トップメニュー");
        setTitleIcon(android.R.drawable.ic_menu_compass);
        setUploadStatus();

		initActivity();
    }

    // ************************************************************************
    // メニュークリックイベント
    // ************************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

    	// XML定義を呼び出し、該当のリソースを読み取り表示する
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.topmenu, menu);
    	return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

    	String msg = "";
    	Intent intent = null;

    	switch(item.getItemId()){
    		case R.id.topmenu_menuItem_KinmuInfoDetail :
    			msg = "基本情報ボタンをタップしました";
    			intent = new Intent(this,KinmuInfoDetailActivity.class);
    			startActivity(intent);
    			break;
    		case R.id.topmenu_menuItem_KinmuInfoList :
    			msg = "勤務一覧ボタンをタップしました";
    			intent = new Intent(this,KinmuInfoListActivity.class);
    			startActivity(intent);
    			break;
    		case R.id.topmenu_menuItem_KinmuInfoEdit :
    			msg = "勤務入力ボタンをタップしました（作成中）";
    			intent = new Intent(this,KinmuInfoEditActivity.class);
    			startActivity(intent);
    			break;
    		case R.id.topmenu_menuItem_KinmuInfoUpload :
    			msg = "アップロードボタンをタップしました";
    			onClick_Upload();
    			break;
    		case R.id.topmenu_menuItem_SettingMenu :
    			msg = "設定ボタンをタップしました";
    			intent = new Intent(this,SettingMenuActivity.class);
    			startActivity(intent);
    			break;
    		case R.id.topmenu_menuItem_InfoView36Kyoutei :
    			msg = "36協定とはボタンをタップしました";
    			intent = new Intent(this,InfoView36KyouteiActivity.class);
    			startActivity(intent);
    			break;
    		default:
    			break;
    	}

	    if (item.getItemId() != R.id.topmenu_menuItem_KinmuInfoUpload ){
	    	showToast(msg);
	    }
    return true;
   	
    }
    
    public void onClick_Upload(){
    	
    	try{
	    	mProgressDialog = new ProgressDialog(this);
	        // プログレスダイアログのタイトルを設定します
	    	mProgressDialog.setTitle("勤務情報アップロード中");
	        // プログレスダイアログのメッセージを設定します
	    	mProgressDialog.setMessage("しばらくお待ちください");
	        // プログレスダイアログの確定（false）／不確定（true）を設定します
	    	mProgressDialog.setIndeterminate(false);
	        // プログレスダイアログのスタイルを水平スタイルに設定します
	        //mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	        // プログレスダイアログのスタイルを円スタイルに設定します
	    	mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	        // プログレスダイアログの最大値を設定します
	    	mProgressDialog.setMax(100);
	        // プログレスダイアログの値を設定します
	    	mProgressDialog.incrementProgressBy(30);
	        // プログレスダイアログのセカンダリ値を設定します
	    	mProgressDialog.incrementSecondaryProgressBy(70);
	        // プログレスダイアログのキャンセルが可能かどうかを設定します
	        mProgressDialog.setCancelable(false);
	        // プログレスダイアログを表示します
	        mProgressDialog.show();
    	}catch(Exception ex){
    		
    	}
        (new Thread(runnable)).start();
    	
    }

    private Runnable runnable = new Runnable(){
        public void run() {

        // ここではダミーで五秒のスリープを行う
		// 実際にはここに処理を書く
		try {

			Thread.sleep(5000);
			
			//mProgressDialogの文字を変更するにはHandlerを使わないといけないのかな？
			
			
			//Thread.sleep(1000);
			
		} catch (InterruptedException e) {
                	
        }

    	// 処理が完了したら、ダイアログを消すためにdismiss()を実行する
    	mProgressDialog.dismiss();
         
    	
        }
    };
    
    
	public void onClick_KinmuInfoDetail(View view){
		Intent intent = null;
		intent = new Intent(this,KinmuInfoDetailActivity.class);
		startActivity(intent);

	}

	public void onClick_KinmuInfoList(View view){
		Intent intent = null;
		intent = new Intent(this,KinmuInfoListActivity.class);
		startActivity(intent);

	}

	public void onClick_KinmuInfoEdit(View view){
		Intent intent = null;
		intent = new Intent(this,KinmuInfoEditActivity.class);
		startActivity(intent);

	}

	/**
	 * 初期処理
	 */
	@Override
	protected void initActivity() {
		super.initActivity();

		txtTopMenuSysDate =  (TextView) this.findViewById(R.id.txtTopMenuSysDate);
		txtTopMenuSysDate.setText(getSysDateString(AppConstants.DATE_FORMAT_YYYYMMDD_JAPAN));

		TProjectInfoDao projectInfoDao = new TProjectInfoDao(this);
		List<TProjectInfoEntity> projectInfoEntityList = projectInfoDao.selProjectInfoForMonthSummaryList(this.employeeNo, this.kinmuDate);

		TopMenuProjectInfoAdapter adapter = new TopMenuProjectInfoAdapter(this, R.layout.topmenu_row, projectInfoEntityList);
		ListView listView = (ListView) findViewById(R.id.lstTopMenuProjectInfo);
		listView.setAdapter(adapter);

		// 合計時間の算出を行う
		calcTotalTime(projectInfoEntityList);
	}

	/**
	 * 合計時間の算出を行う
	 * @param projectInfoEntityList プロジェクト情報エンティティリスト
	 */
	private void calcTotalTime(List<TProjectInfoEntity> projectInfoEntityList) {
		// 表示フォーマット
		DecimalFormat df = new DecimalFormat(NUMBER_FORMAT_TIME);
		// 合計時間（定時）
		BigDecimal totalScheduledTime = BigDecimal.ZERO;
		// 合計時間（残業）
		BigDecimal totalOvertimeWork = BigDecimal.ZERO;
		// 合計時間（深夜）
		BigDecimal totalMidnight = BigDecimal.ZERO;

		// List内の各種時間の合計を算出する
		for (TProjectInfoEntity entity : projectInfoEntityList) {
			totalScheduledTime = totalScheduledTime.add(new BigDecimal(entity.getHoursWorkedScheduledTime()));
			totalOvertimeWork = totalOvertimeWork.add(new BigDecimal(entity.getHoursWorkedOvertimeWork()));
			totalMidnight= totalMidnight.add(new BigDecimal(entity.getHoursWorkedMidnight()));
		}

		// 合計時間（定時）
		this.tvTotalScheduledTime = (TextView) this.findViewById(R.id.tv_topmenu_pj_info_total_hours_worked_scheduled_time);
		this.tvTotalScheduledTime.setText(df.format(totalScheduledTime));

		// 合計時間（残業）
		this.tvTotalOvertimeWork = (TextView) this.findViewById(R.id.tv_topmenu_pj_info_total_hours_worked_overtime_work);
		this.tvTotalOvertimeWork.setText(df.format(totalOvertimeWork));

		// 合計時間（深夜）
		this.tvTotalMidnight = (TextView) this.findViewById(R.id.tv_topmenu_pj_info_total_hours_worked_midnight);
		this.tvTotalMidnight.setText(df.format(totalMidnight));
	}

	/**
	 * トップメニュープロジェクト情報表示アダプタ
	 *
	 * @author Hiroshi Tsuji
	 *
	 */
    private class TopMenuProjectInfoAdapter extends ArrayAdapter<TProjectInfoEntity> {

		private LayoutInflater layoutInflater;

		/** プロジェクト番号 */
		private TextView projectNo;

		/** 稼働時間（定時） */
		private TextView hoursWorkedScheduledTime;

		/** 稼働時間（残業） */
		private TextView hoursWorkedOvertimeWork;

		/** 稼働時間（深夜） */
		private TextView hoursWorkedMidnight;

		/** 表示フォーマット */
		private DecimalFormat df = new DecimalFormat(NUMBER_FORMAT_TIME);

		/**
		 * コンストラクタ
		 * @param context
		 * @param textViewResourceId
		 * @param itemList
		 */
		public TopMenuProjectInfoAdapter(Context context, int textViewResourceId, List<TProjectInfoEntity> itemList) {
			super(context, textViewResourceId, itemList);
			this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// ビューを受け取る
			View view = convertView;
			if (view == null) {
				// 受け取ったビューがnullなら新しくビューを生成
				view = this.layoutInflater.inflate(R.layout.topmenu_row, null);
			}

			// 表示すべきデータの取得
			TProjectInfoEntity entity = this.getItem(position);
			if (entity != null) {
				// プロジェクト番号
				this.projectNo = (TextView)view.findViewById(R.id.projectNo);
				this.projectNo.setText(entity.getProjectNo() + "／" + entity.getWorkCd());

				// 稼働時間（定時）
				this.hoursWorkedScheduledTime = (TextView)view.findViewById(R.id.basicTime);
				this.hoursWorkedScheduledTime.setText(df.format(new BigDecimal(entity.getHoursWorkedScheduledTime())));

				// 稼働時間（残業）
				this.hoursWorkedOvertimeWork = (TextView)view.findViewById(R.id.zangyouTime);
				this.hoursWorkedOvertimeWork.setText(df.format(new BigDecimal(entity.getHoursWorkedOvertimeWork())));

				// 稼働時間（深夜）
				this.hoursWorkedMidnight = (TextView)view.findViewById(R.id.shinyaTime);
				this.hoursWorkedMidnight.setText(df.format(new BigDecimal(entity.getHoursWorkedMidnight())));
			}
			return view;
		}
		
		// リストを選択しても反応しないようにする（暫定）
		@Override
		public boolean areAllItemsEnabled() {
		    return false;
		}
		@Override
		public boolean isEnabled(int position) {
		    return false;
		}
    }
}