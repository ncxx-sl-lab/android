package jp.sji.kansai.android.demo.activity;

import static jp.sji.kansai.android.demo.costants.AppConstants.*;
import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDD;
import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDD_SLASH;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_EMPLOYEE_NO;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_KINTAI_DATE;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_NEXT_DAY;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_PREVIOUS_DAY;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.db.dao.TKintaiInfoDao;
import jp.sji.kansai.android.demo.db.dao.TProjectInfoDao;
import jp.sji.kansai.android.demo.db.entity.TKintaiInfoEntity;
import jp.sji.kansai.android.demo.db.entity.TProjectInfoEntity;
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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class KinmuInfoViewActivity extends BaseActivity {

	/** 日付 */
	private TextView tvKinmuDate = null;

	/** 勤務時間 */
	private TextView tvKinmuTime = null;

	/** シフト番号 */
	private TextView tvShiftNo = null;

	/** 特記事項 */
	private TextView tvSpecialAffairs = null;

	/** 休暇番号 */
	private TextView tvRestNo = null;

	/** メモ */
	private TextView tvMemo = null;

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
		setContentView(R.layout.kinmuinfoview);
		setTitleName("勤務情報表示");
		setTitleIcon(android.R.drawable.ic_menu_agenda);
		setUploadStatus();

		initActivity();
	}

	/**
	 * リスタート時処理
	 */
	@Override
	protected void onRestart() {
		super.onRestart();

		// 初期処理
		initActivity();
	}

	// ************************************************************************
	// メニュークリックイベント
	// ************************************************************************
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// XML定義を呼び出し、該当のリソースを読み取り表示する
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.kinmuinfoview, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		String msg = "";
		Intent intent = null;

		switch (item.getItemId()) {
			case R.id.dummykinmuinfoview_menuItem_Before:
				msg = "＜＜前日ボタンをタップしました";
				intent = new Intent(this, KinmuInfoViewActivity.class);
				intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, this.employeeNo);
				intent.putExtra(INTENT_EXTRA_KEY_PREVIOUS_DAY, DateUtil.addDate(this.kinmuDate, -1));
				finish();
				startActivity(intent);
				break;
			case R.id.dummykinmuinfoview_menuItem_KinmuNewInput:
				msg = "勤務時間編集ボタンをタップしました";
				intent = new Intent(this, KinmuInfoEditActivity.class);
				intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, this.employeeNo);
				intent.putExtra(INTENT_EXTRA_KEY_KINTAI_DATE, this.kinmuDate);
				startActivity(intent);
				break;
			case R.id.dummykinmuinfoview_menuItem_Next:
				msg = "翌日＞＞ボタンをタップしました";
				intent = new Intent(this, KinmuInfoViewActivity.class);
				intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, this.employeeNo);
				intent.putExtra(INTENT_EXTRA_KEY_NEXT_DAY, DateUtil.addDate(this.kinmuDate, 1));
				finish();
				startActivity(intent);
				break;
			default:
				break;
		}

		showToast(msg);
		return true;
	}

	/**
	 * 初期表示処理を行う
	 */
	@Override
	protected void initActivity() {

		super.initActivity();

		// ------------------------------
		// 勤怠情報表示部
		// ------------------------------
		TKintaiInfoDao kintaiInfoDao = new TKintaiInfoDao(this);
		TKintaiInfoEntity kintaiInfoEntity = kintaiInfoDao.selectPK(this.employeeNo, SystemUtil.convDateToString(this.kinmuDate, DATE_FORMAT_YYYYMMDD));

		// 日付
		this.tvKinmuDate = (TextView) this.findViewById(R.id.kinmuInfoView_TextView_kinmu_Date);
		this.tvKinmuDate.setText(SystemUtil.convDateToString(this.kinmuDate, DATE_FORMAT_YYYYMMDD_SLASH)
				+ "(" + DateUtil.getStrDayOfWeek(this.kinmuDate) + ")");
		// 勤務時間
		this.tvKinmuTime = (TextView) this.findViewById(R.id.kinmuInfoView_TextView_kinmuTime);
		// シフト番号
		this.tvShiftNo = (TextView) this.findViewById(R.id.kinmuInfoView_TextView_shiftNo);
		// 特記事項
		this.tvSpecialAffairs = (TextView) this.findViewById(R.id.kinmuInfoView_TextView_specialAffairs);
		// 休暇番号
		this.tvRestNo = (TextView) this.findViewById(R.id.kinmuInfoView_TextView_restNo);
		// メモ
		this.tvMemo = (TextView) this.findViewById(R.id.kinmuInfoView_TextView_memo);

		if (kintaiInfoEntity != null) {
			// 勤務時間
			this.tvKinmuTime.setText(SystemUtil.convDateToString(SystemUtil.toDate(kintaiInfoEntity.getStartTime(), DATE_FORMAT_HHMM), DATE_FORMAT_HHMM_SLASH)
					+ "～" + SystemUtil.convDateToString(SystemUtil.toDate(kintaiInfoEntity.getEndTime(), DATE_FORMAT_HHMM), DATE_FORMAT_HHMM_SLASH));
			// シフト番号
			this.tvShiftNo.setText(kintaiInfoEntity.getShiftNo());
			// 特記事項
			this.tvSpecialAffairs.setText(kintaiInfoEntity.getSpecialAffairs());
			// 休暇番号
			this.tvRestNo.setText(kintaiInfoEntity.getRestNo());
			// メモ
			this.tvMemo.setText(kintaiInfoEntity.getMemo());
		} else {
			showToast("指定された日付の勤務情報がありません。");
			return;
		}

		// ------------------------------
		// プロジェクト情報表示部
		// ------------------------------
		TProjectInfoDao projectInfoDao = new TProjectInfoDao(this);
		List<TProjectInfoEntity> projectInfoEntityList = projectInfoDao.selProjectInfoForDayList(this.employeeNo, this.kinmuDate);

		ProjectInfoListAdapter adapter = new ProjectInfoListAdapter(this, projectInfoEntityList);
		ListView listView = (ListView) this.findViewById(R.id.kinmuInfoView_pj_list);
		listView.setAdapter(adapter);

		// 取得した内容から合計時間の算出を行う
		calcTotalTime(projectInfoEntityList);



//		TableLayout tableLayout = (TableLayout) this.findViewById(R.id.tableLayout2);
//		// ヘッダー行生成
//		TableRow headerRow = new TableRow(this);
//		// プロジェクト番号
//		TextView tvProjectNo = new TextView(this);
//		tvProjectNo.setText(getString(R.string.kinmuInfoView_label_project_no));
//		headerRow.addView(tvProjectNo);
//
//		// 作業コード
//		TextView tvWorkCd = new TextView(this);
//		tvWorkCd.setText(getString(R.string.kinmuInfoView_label_work_cd));
//		headerRow.addView(tvWorkCd);
//
//		// 定時
//		TextView tvScheduledTime = new TextView(this);
//		tvScheduledTime.setText(getString(R.string.kinmuInfoView_label_scheduled_time));
//		headerRow.addView(tvScheduledTime);
//
//		// 残業
//		TextView tvOvertimeWork = new TextView(this);
//		tvOvertimeWork.setText(getString(R.string.kinmuInfoView_label_overtime_work));
//		headerRow.addView(tvOvertimeWork);
//
//		// 深夜
//		TextView tvMidnight = new TextView(this);
//		tvMidnight.setText(getString(R.string.kinmuInfoView_label_midnight));
//		headerRow.addView(tvMidnight);
//
//		tableLayout.addView(headerRow);
//
//		// ヘッダー行生成
//		TableRow totalRow = new TableRow(this);
//		// 合計
//		TextView tvLabelTotal = new TextView(this);
//		tvLabelTotal.setText("合計");
//
//		// 作業コード
//		TextView tvLabelWorkCd = new TextView(this);
//
//		// 定時合計
//		TextView tvContScheduledTimeTotal = new TextView(this);
//
//		// 残業合計
//		TextView tvContOvertimeWorkTotal = new TextView(this);
//
//		// 深夜合計
//		TextView tvContMidnightTotal = new TextView(this);
//
//		BigDecimal scheduledTimeTotal = BigDecimal.ZERO;
//		BigDecimal overtimeWorkTotal = BigDecimal.ZERO;
//		BigDecimal midnightTotal = BigDecimal.ZERO;
//
//		// TODO [Tsuji] 小数点第2位まで表示するよう修正する
//		// TODO [Tsuji] ListViewレイアウトにする
//		for (TProjectInfoEntity entity : projectInfoEntityList) {
//			// 内容表示行生成
//			TableRow contentRow = new TableRow(this);
//
//			// プロジェクト番号
//			TextView tvContProjectNo = new TextView(this);
//			tvContProjectNo.setText(entity.getProjectNo());
//			contentRow.addView(tvContProjectNo);
//
//			// 作業コード
//			TextView tvContWorkCd = new TextView(this);
//			tvContWorkCd.setText(entity.getWorkCd());
//			contentRow.addView(tvContWorkCd);
//
//			// 定時
//			TextView tvContScheduledTime = new TextView(this);
//			tvContScheduledTime.setText(entity.getHoursWorkedScheduledTime());
//			contentRow.addView(tvContScheduledTime);
//
//			scheduledTimeTotal = scheduledTimeTotal.add(new BigDecimal(entity.getHoursWorkedScheduledTime()));
//
//			// 残業
//			TextView tvContOvertimeWork = new TextView(this);
//			tvContOvertimeWork.setText(entity.getHoursWorkedOvertimeWork());
//			contentRow.addView(tvContOvertimeWork);
//
//			overtimeWorkTotal = overtimeWorkTotal.add(new BigDecimal(entity.getHoursWorkedOvertimeWork()));
//
//			// 深夜
//			TextView tvContMidnight = new TextView(this);
//			tvContMidnight.setText(entity.getHoursWorkedMidnight());
//			contentRow.addView(tvContMidnight);
//
//			midnightTotal = midnightTotal.add(new BigDecimal(entity.getHoursWorkedMidnight()));
//
//			tableLayout.addView(contentRow);
//		}
//
//		totalRow.addView(tvLabelTotal);
//		totalRow.addView(tvLabelWorkCd);
//		tvContScheduledTimeTotal.setText(scheduledTimeTotal.toString());
//		totalRow.addView(tvContScheduledTimeTotal);
//		tvContOvertimeWorkTotal.setText(overtimeWorkTotal.toString());
//		totalRow.addView(tvContOvertimeWorkTotal);
//		tvContMidnightTotal.setText(midnightTotal.toString());
//		totalRow.addView(tvContMidnightTotal);
//		tableLayout.addView(totalRow);
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
		this.tvTotalScheduledTime = (TextView) this.findViewById(R.id.kinmuInfoView_TextView_total_scheduledTime);
		this.tvTotalScheduledTime.setText(df.format(totalScheduledTime));

		// 合計時間（残業）
		this.tvTotalOvertimeWork = (TextView) this.findViewById(R.id.kinmuInfoView_TextView_total_overtimeWork);
		this.tvTotalOvertimeWork.setText(df.format(totalOvertimeWork));

		// 合計時間（深夜）
		this.tvTotalMidnight = (TextView) this.findViewById(R.id.kinmuInfoView_TextView_total_midnight);
		this.tvTotalMidnight.setText(df.format(totalMidnight));
	}

	/**
	 * プロジェクト一覧を表示するアダプタ
	 * @author Hiroshi Tsuji
	 *
	 */
	private class ProjectInfoListAdapter extends ArrayAdapter<TProjectInfoEntity> {

		private LayoutInflater layoutInflater;

		/** プロジェクト番号 */
		private TextView tvProjectNo;

		/** 作業コード */
		//private TextView tvWorkCd;

		/** 定時 */
		private TextView tvScheduledTime;

		/** 残業 */
		private TextView tvOvertimeWork;

		/** 深夜 */
		private TextView tvMidnight;

		/** 表示フォーマット */
		private DecimalFormat df = new DecimalFormat(NUMBER_FORMAT_TIME);

		/**
		 * コンストラクタ
		 * @param context
		 * @param entityArray
		 */
		public ProjectInfoListAdapter(Context context, List<TProjectInfoEntity> entityList) {
			super(context, 0, entityList);
			layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				convertView = this.layoutInflater.inflate(R.layout.kinmuinfoview_pj_row, null);
			}

			TProjectInfoEntity entity = this.getItem(position);

			// プロジェクト番号
			this.tvProjectNo = (TextView) convertView.findViewById(R.id.tv_kinmuInfoView_project_no);
			this.tvProjectNo.setText(entity.getProjectNo() + "/" + entity.getWorkCd());
			
			// 作業コード
			//this.tvWorkCd = (TextView) convertView.findViewById(R.id.tv_kinmuInfoView_work_cd);
			//this.tvWorkCd.setText(entity.getWorkCd());

			// 定時
			this.tvScheduledTime = (TextView) convertView.findViewById(R.id.tv_kinmuInfoView_scheduledTime);
			this.tvScheduledTime.setText(df.format(new BigDecimal(entity.getHoursWorkedScheduledTime())));
			
			logDebug(this.tvScheduledTime.getText().toString());
			
			// 残業
			this.tvOvertimeWork = (TextView) convertView.findViewById(R.id.tv_kinmuInfoView_overtimeWork);
			this.tvOvertimeWork.setText(df.format(new BigDecimal(entity.getHoursWorkedOvertimeWork())));
			
			logDebug(this.tvOvertimeWork.getText().toString());
			
			// 深夜
			this.tvMidnight = (TextView) convertView.findViewById(R.id.tv_kinmuInfoView_midnight);
			this.tvMidnight.setText(df.format(new BigDecimal(entity.getHoursWorkedMidnight())));
			
			logDebug(this.tvMidnight.getText().toString());
			
			return convertView;
		}
	}
}