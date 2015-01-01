package jp.sji.kansai.android.demo.activity;

import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDD;
import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDD_SLASH;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_EMPLOYEE_NO;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_KINTAI_DATE;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_PROJECT_INFO_LIST;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_TOTAL_WORKTIME_MIDNIGHT;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_TOTAL_WORKTIME_OVERTIMEWORK;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_TOTAL_WORKTIME_SCHEDULED;
import static jp.sji.kansai.android.demo.costants.AppConstants.NUMBER_FORMAT_TIME;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.db.dao.TKintaiInfoDao;
import jp.sji.kansai.android.demo.db.dao.TProjectInfoDao;
import jp.sji.kansai.android.demo.db.entity.TKintaiInfoEntity;
import jp.sji.kansai.android.demo.db.entity.TProjectInfoEntity;
import jp.sji.kansai.android.demo.util.DateUtil;
import jp.sji.kansai.android.demo.util.SystemUtil;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class KinmuInfoEditActivity extends BaseActivity {

	/** 勤務日付 */
	private TextView tvKinmuDate;

	/** 開始時間 */
	private TextView etStartTime;

	/** 終了時間 */
	private TextView etEndTime;

	/** シフト */
	private TextView etShift;
	private String shift_no;

	/** 特記事項 */
	private TextView etSpecialAffairs;

	/** 休暇内容 */
	private TextView etRest;
	private String rest_no;

	/** メモ */
	private TextView etMemo;

	/** プロジェクト */
	private Button btnProject;

	/** 保存ボタン */
	private Button btnSave;

	/** キャンセルボタン */
	private Button btnCancel;

	/** プロジェクト情報リスト */
	ArrayList<TProjectInfoEntity> projectInfoEntityList;

	/** 作業時間合計（定時） */
	private String totalHoursWorkedScheduledTime;

	/** 作業時間合計（残業） */
	private String totalHoursWorkedOvertimeWork;

	/** 作業時間合計（深夜） */
	private String totalHoursWorkedMidnight;

	/** テキスト入力ダイアログ用 **/
	private EditText dialogText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kinmuinfoedit);
		setTitleName("勤務情報編集");
		setTitleIcon(android.R.drawable.ic_menu_edit);
		setUploadStatus();

		// 初期処理
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

    public void onClick_SaveButton(View view){
    	onClick_SaveButton();
    }
    public void onClick_SaveButton(){
		Intent intent = new Intent(KinmuInfoEditActivity.this, ProjectInfoListActivity.class);
		intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, KinmuInfoEditActivity.this.employeeNo);
		intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO,
				SystemUtil.convDateToString(KinmuInfoEditActivity.this.kinmuDate, DATE_FORMAT_YYYYMMDD));
    	// 入力チェックを行う
    	if (!validate()) {
    		return;
    	}

    	// TODO [Tsuji] 再度DBから取得する必要はあるか？　initメソッドで取得したEntityをインスタンス変数に保持することも検討する
    	String strKintaiDate = SystemUtil.convDateToString(this.kinmuDate, DATE_FORMAT_YYYYMMDD);
		TKintaiInfoDao dao = new TKintaiInfoDao(this);
		TKintaiInfoEntity entity = dao.selectPK(this.employeeNo, strKintaiDate);

		// TODO [Tsuji] 稼働時間の算出が必要

		if (entity == null) {
			TKintaiInfoEntity insertEntity = new TKintaiInfoEntity();
			// 社員番号
			insertEntity.setEmployeeNo(this.employeeNo);
			// 日付
			insertEntity.setKintaiDate(strKintaiDate);
			// 開始
			insertEntity.setStartTime(this.etStartTime.getText().toString());
			// 終了
			insertEntity.setEndTime(this.etEndTime.getText().toString());
			// シフト
			//insertEntity.setShiftNo(this.etShift.getText().toString());
			insertEntity.setShiftNo(this.shift_no);
			// 特記事項
			insertEntity.setSpecialAffairs(this.etSpecialAffairs.getText().toString());
			// 休暇内容
			//insertEntity.setRestNo(this.etRest.getText().toString());
			insertEntity.setRestNo(this.rest_no);
			// メモ
			insertEntity.setMemo(this.etMemo.getText().toString());

			dao.insert(insertEntity);
		} else {
			// 変更のあった項目のみ変更する
			Map<String, String> updParamMap = new HashMap<String, String>();

			// 開始
			if (SystemUtil.isChanged(entity.getStartTime(), this.etStartTime.getText().toString())) {
				updParamMap.put(TKintaiInfoEntity.COLUMN_NAME_START_TIME, this.etStartTime.getText().toString());
			}

			// 終了
			if (SystemUtil.isChanged(entity.getEndTime(), this.etStartTime.getText().toString())) {
				updParamMap.put(TKintaiInfoEntity.COLUMN_NAME_END_TIME, this.etEndTime.getText().toString());
			}

			// シフト
			if (SystemUtil.isChanged(entity.getShiftNo(), this.etShift.getText().toString())) {
				//updParamMap.put(TKintaiInfoEntity.COLUMN_NAME_SHIFT_NO, this.etShift.getText().toString());
				updParamMap.put(TKintaiInfoEntity.COLUMN_NAME_SHIFT_NO, this.shift_no);
			}

			// 特記事項
			if (SystemUtil.isChanged(entity.getSpecialAffairs(), this.etSpecialAffairs.getText().toString())) {
				updParamMap.put(TKintaiInfoEntity.COLUMN_NAME_SPECIAL_AFFAIRS, this.etSpecialAffairs.getText().toString());
			}

			// 休暇内容
			if (SystemUtil.isChanged(entity.getRestNo(), this.etRest.getText().toString())) {
				//updParamMap.put(TKintaiInfoEntity.COLUMN_NAME_REST_NO, this.etRest.getText().toString());
				updParamMap.put(TKintaiInfoEntity.COLUMN_NAME_REST_NO, this.rest_no);
			}

			// メモ
			if (SystemUtil.isChanged(entity.getMemo(), this.etMemo.getText().toString())) {
				updParamMap.put(TKintaiInfoEntity.COLUMN_NAME_MEMO, this.etMemo.getText().toString());
			}

			// 変更があればupdate実行
			if (!updParamMap.isEmpty()) {
				dao.updatePK(this.employeeNo, strKintaiDate, updParamMap);
			}
		}

		showToast("保存が完了しました。");
		super.finish();
    }

    public void onClick_CancelButton(View view){
    	onClick_CancelButton();
    }
    public void onClick_CancelButton(){
    	super.finish();
    }

    // ************************************************************************
    // メニュークリックイベント
    // ************************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

    	// XML定義を呼び出し、該当のリソースを読み取り表示する
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.kinmuinfoedit, menu);
    	return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

    	String msg = "";

    	switch(item.getItemId()){
    		case R.id.dummykinmuinfoedit_menuItem_Save :
    			msg = "保存ボタンをタップしました";
    			onClick_SaveButton();
    			break;
    		case R.id.dummykinmuinfoedit_menuItem_Cancel :
    			msg = "キャンセルボタンをタップしました";
    			onClick_CancelButton();
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

		// 勤務情報を取得する
		TKintaiInfoDao kintaiInfoDao = new TKintaiInfoDao(this);
		TKintaiInfoEntity kintaiInfoEntity
				= kintaiInfoDao.selectPK(this.employeeNo, SystemUtil.convDateToString(this.kinmuDate, DATE_FORMAT_YYYYMMDD));

		// 勤務日付
		this.tvKinmuDate = (TextView) this.findViewById(R.id.lblViewYearMonth);
		this.tvKinmuDate.setText(SystemUtil.convDateToString(this.kinmuDate, DATE_FORMAT_YYYYMMDD_SLASH)
				+ "(" + DateUtil.getStrDayOfWeek(this.kinmuDate) + ")");
		// 開始
		this.etStartTime = (TextView) this.findViewById(R.id.kinmuInfoEdit_editText_start_time);
		// 終了
		this.etEndTime = (TextView) this.findViewById(R.id.kinmuInfoEdit_editText_end_time);
		// シフト
		this.etShift = (TextView) this.findViewById(R.id.kinmuInfoEdit_editText_shift);
		// 特記事項
		this.etSpecialAffairs = (TextView) this.findViewById(R.id.kinmuInfoEdit_editText_special_affairs);
		// 休暇内容
		this.etRest = (TextView) this.findViewById(R.id.kinmuInfoEdit_editText_rest);
		// メモ
		this.etMemo = (TextView) this.findViewById(R.id.kinmuInfoEdit_editText_memo);

		// レコードが存在した場合は、レコードの内容を初期表示する
		if (kintaiInfoEntity != null) {
			// 開始
			this.etStartTime.setText(kintaiInfoEntity.getStartTime());
			// 終了
			this.etEndTime.setText(kintaiInfoEntity.getEndTime());
			// シフト
			this.etShift.setText(getShiftName(kintaiInfoEntity.getShiftNo()));
			shift_no = kintaiInfoEntity.getShiftNo();
			// 特記事項
			this.etSpecialAffairs.setText(kintaiInfoEntity.getSpecialAffairs());
			// 休暇内容
			//this.etRest.setText(kintaiInfoEntity.getRestNo());
			this.etRest.setText(getRestName(kintaiInfoEntity.getRestNo()));
			rest_no = kintaiInfoEntity.getRestNo();
			// メモ
			this.etMemo.setText(kintaiInfoEntity.getMemo());
		}

		// プロジェクト情報を取得する
		TProjectInfoDao projectInfoDao = new TProjectInfoDao(this);
		this.projectInfoEntityList = (ArrayList<TProjectInfoEntity>) projectInfoDao.selProjectInfoForDayList(this.employeeNo, this.kinmuDate);

		// TODO [Tsuji] メソッドの共通化が必要
		// 取得した内容から合計時間の算出を行う
		calcTotalTime(this.projectInfoEntityList);

		// プロジェクト情報編集ボタン
		this.btnProject = (Button) this.findViewById(R.id.btn_kinmuinfoEdit_project);
		this.btnProject.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(KinmuInfoEditActivity.this, ProjectInfoListActivity.class);
				intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, KinmuInfoEditActivity.this.employeeNo);
				intent.putExtra(INTENT_EXTRA_KEY_KINTAI_DATE, KinmuInfoEditActivity.this.kinmuDate);
				intent.putExtra(INTENT_EXTRA_KEY_PROJECT_INFO_LIST, KinmuInfoEditActivity.this.projectInfoEntityList);
				intent.putExtra(INTENT_EXTRA_KEY_TOTAL_WORKTIME_SCHEDULED, KinmuInfoEditActivity.this.totalHoursWorkedScheduledTime);
				intent.putExtra(INTENT_EXTRA_KEY_TOTAL_WORKTIME_OVERTIMEWORK, KinmuInfoEditActivity.this.totalHoursWorkedOvertimeWork);
				intent.putExtra(INTENT_EXTRA_KEY_TOTAL_WORKTIME_MIDNIGHT, KinmuInfoEditActivity.this.totalHoursWorkedMidnight);
				startActivity(intent);
			}
		});

		// TODO [Eguchi] 画面上にボタンがあると入力時に邪魔なのでいったんコメントアウトする

//		// ボタンの設定を行う
//		// 保存ボタン
//		this.btnSave = (Button) this.findViewById(R.id.btnSave);
//		this.btnSave.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				Intent intent = new Intent(KinmuInfoEditActivity.this, ProjectInfoListActivity.class);
//				intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO, KinmuInfoEditActivity.this.employeeNo);
//				intent.putExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO,
//						SystemUtil.convDateToString(KinmuInfoEditActivity.this.kinmuDate, DATE_FORMAT_YYYYMMDD));
//				onClick_SaveButton();
//			}
//		});
//
//		// キャンセルボタン
//		this.btnCancel = (Button) this.findViewById(R.id.btnCancel);
//		this.btnCancel.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				finish();
//			}
//		});
	}

	/**
	 * 入力チェックを行う
	 *
	 * @return 入力チェックOK：true<br>
	 *         入力チェックNG：false
	 */
	private boolean validate() {
		List<String> errorMsgList = new ArrayList<String>();

		// 開始
		if (SystemUtil.isEmpty(this.etStartTime.getText().toString())) {
			errorMsgList.add(this.getString(R.string.errorMsg_start_time_empty));
		}

		// 終了
		if (SystemUtil.isEmpty(this.etEndTime.getText().toString())) {
			errorMsgList.add(this.getString(R.string.errorMsg_end_time_empty));
		}

		// シフト
		if (SystemUtil.isEmpty(this.etShift.getText().toString())) {
			errorMsgList.add(this.getString(R.string.errorMsg_shift_empty));
		}

		if (!errorMsgList.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (String str : errorMsgList) {
				sb.append(str + "\n");
			}
			showToast(sb.toString());
			return false;
		}

		return true;
	}

	/**
	 * 開始時間の入力テキストをタップしたときの処理
	 * @param view
	 */
	public void onClick_StartTime(View view){
		showToast("開始時間の入力テキストをタップしました");

		Calendar date = Calendar.getInstance();

		int hour = date.get(Calendar.HOUR_OF_DAY);
		int min = date.get(Calendar.MINUTE);

		if (etStartTime.getText().length() > 0){
			//String[] time = etStartTime.getText().toString().split(":");
			//hour = Integer.parseInt(time[0]);
			//min = Integer.parseInt(time[1]);
			hour = Integer.parseInt(etStartTime.getText().toString().substring(0, 2));
			min = Integer.parseInt(etStartTime.getText().toString().substring(2, 4));
		}

		TimePickerDialog timePickerDialog = new TimePickerDialog(
				this,
				new TimePickerDialog.OnTimeSetListener() {

					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						etStartTime.setText(String.format("%02d",hourOfDay) + String.format("%02d", minute));

					}
				},
				hour,
				min,
				true
				);
		timePickerDialog.setTitle("開始時間");
		timePickerDialog.show();

	}

	/**
	 * 終了時間の入力テキストをタップしたときの処理
	 * @param view
	 */
	public void onClick_EndTime(View view){
		showToast("終了時間の入力テキストをタップしました");

		Calendar date = Calendar.getInstance();

		int hour = date.get(Calendar.HOUR_OF_DAY);
		int min = date.get(Calendar.MINUTE);


		if (etEndTime.getText().length() > 0){
			//String[] time = etEndTime.getText().toString().split(":");
			//hour = Integer.parseInt(time[0]);
			//min = Integer.parseInt(time[1]);
			hour = Integer.parseInt(etEndTime.getText().toString().substring(0, 2));
			min = Integer.parseInt(etEndTime.getText().toString().substring(2, 4));
		}

		TimePickerDialog timePickerDialog = new TimePickerDialog(
				this,
				new TimePickerDialog.OnTimeSetListener() {

					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						etEndTime.setText(String.format("%02d",hourOfDay) + String.format("%02d", minute));

					}
				},
				hour,
				min,
				true
				);
		timePickerDialog.setTitle("終了時間");
		timePickerDialog.show();

	}

	/**
	 * シフトの入力テキストをタップしたときの処理
	 * @param view
	 */
	public void onClick_Shift(View view){

		// TODO [Eguchi] とりあえず暫定的に固定化する
		final String shift_list[] = getShiftList();

		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("シフト選択");
		builder.setItems(shift_list, new DialogInterface.OnClickListener(){
		public void onClick(DialogInterface dialog, int which) {
			etShift.setText(shift_list[which]);
			shift_no = String.valueOf(which + 1);
			dialog.cancel();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

	/**
	 * 引数の添え字番号から表示するシフト内容を取得する
	 * @param rest_no
	 * @return String：シフト内容
	 */
	private String getShiftName(String shift_no){
		String shift_list[] = getShiftList();
		if( shift_no.length() > 0 ){
			return shift_list[Integer.valueOf(shift_no)];
		}else{
			return shift_list[0];
		}
	}


	/**
	 * 特記事項の入力テキストをタップしたときの処理
	 * @param view
	 */
	public void onClick_SpecialAffairs(View view){

		LayoutInflater inflater = LayoutInflater.from(this);
		View dialog_view = inflater.inflate(R.layout.dialog_text, null);
		dialogText = (EditText) dialog_view.findViewById(R.id.etInputText);
		dialogText.setText(etSpecialAffairs.getText());

   		//ダイアログの作成(AlertDialog.Builder)
        new AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("特記事項を入力してください")
            .setView(dialog_view)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                	etSpecialAffairs.setText(dialogText.getText().toString());
                }
            })
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    /* キャンセル処理 */
                }
            })
            .create().show();
	}


	/**
	 * 休暇内容のリストを取得する
	 * @return String[]：休暇内容リスト
	 */
	private String[] getShiftList(){
		// TODO [Eguchi] とりあえず暫定的に固定化する
		String shift_list[] = new String[5];
		shift_list[0] = "１";
		shift_list[1] = "２";
		shift_list[2] = "３";
		shift_list[3] = "４";
		shift_list[4] = "５";
		return shift_list;
	}

	/**
	 * 休暇内容の入力テキストをタップしたときの処理
	 * @param view
	 */
	public void onClick_Rest(View view){


		final String rest_list[] = getRestList();

		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("休暇選択");
		builder.setItems(rest_list, new DialogInterface.OnClickListener(){
		public void onClick(DialogInterface dialog, int which) {
			etRest.setText(rest_list[which]);
			// 空白が選択された場合は休暇番号は空文字にする
			if (which == 0) {
				rest_no = "";
			} else {
				rest_no = String.valueOf(which);
			}
			dialog.cancel();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();

	}

	/**
	 * 引数の添え字番号から表示する休暇内容を取得する
	 * @param rest_no
	 * @return String：休暇内容
	 */
	private String getRestName(String rest_no){
		String rest_list[] = getRestList();
		if( rest_no.length() > 0 ){
			return rest_list[Integer.valueOf(rest_no)];
		}else{
			return rest_list[0];
		}
	}

	/**
	 * 休暇内容のリストを取得する
	 * @return String[]：休暇内容リスト
	 */
	private String[] getRestList(){
		// TODO [Eguchi] とりあえず暫定的に固定化する
		String rest_list[] = new String[16];
		rest_list[0] = "";
		rest_list[1] = "１：有給（全日）";
		rest_list[2] = "２：有給（午前）";
		rest_list[3] = "３：有給（午後）";
		rest_list[4] = "４：欠勤";
		rest_list[5] = "５：慶弔休暇";
		rest_list[6] = "６：無給休暇";
		rest_list[7] = "７：振休";
		rest_list[8] = "８：代休";
		rest_list[9] = "９：特休（徹休）";
		rest_list[10] = "１０：特別休暇";
		rest_list[11] = "１１：リフレッシュ";
		rest_list[12] = "１２：夏期休暇";
		rest_list[13] = "１３：積立休暇";
		rest_list[14] = "１４：休業";
		rest_list[15] = "１５：教育訓練";
		return rest_list;
	}

	/**
	 * メモの入力テキストをタップしたときの処理
	 * @param view
	 */
	public void onClick_Memo(View view){

		LayoutInflater inflater = LayoutInflater.from(this);
		View dialog_view = inflater.inflate(R.layout.dialog_text, null);
		dialogText = (EditText) dialog_view.findViewById(R.id.etInputText);
		dialogText.setText(etMemo.getText());


   		//ダイアログの作成(AlertDialog.Builder)
        new AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("メモを入力してください")
            .setView(dialog_view)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                	etMemo.setText(dialogText.getText().toString());
                }
            })
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    /* キャンセル処理 */
                }
            })
            .create().show();
	}

	/**
	 * 合計時間の算出を行う
	 * @param projectInfoEntityList プロジェクト情報エンティティリスト
	 */
	private void calcTotalTime(List<TProjectInfoEntity> projectInfoEntityList) {
		// 表示フォーマット
		DecimalFormat df = new DecimalFormat(NUMBER_FORMAT_TIME);
		// 合計時間（定時）
		BigDecimal totalHoursWorkedScheduledTime = BigDecimal.ZERO;
		// 合計時間（残業）
		BigDecimal totalHoursWorkedOvertimeWork = BigDecimal.ZERO;
		// 合計時間（深夜）
		BigDecimal totalHoursWorkedMidnight = BigDecimal.ZERO;

		// List内の各種時間の合計を算出する
		for (TProjectInfoEntity entity : projectInfoEntityList) {
			totalHoursWorkedScheduledTime = totalHoursWorkedScheduledTime.add(new BigDecimal(entity.getHoursWorkedScheduledTime()));
			totalHoursWorkedOvertimeWork = totalHoursWorkedOvertimeWork.add(new BigDecimal(entity.getHoursWorkedOvertimeWork()));
			totalHoursWorkedMidnight= totalHoursWorkedMidnight.add(new BigDecimal(entity.getHoursWorkedMidnight()));
		}

		// 合計時間（定時）
		this.totalHoursWorkedScheduledTime = df.format(totalHoursWorkedScheduledTime);

		// 合計時間（残業）
		this.totalHoursWorkedOvertimeWork = df.format(totalHoursWorkedOvertimeWork);

		// 合計時間（深夜）
		this.totalHoursWorkedMidnight = df.format(totalHoursWorkedMidnight);
	}
}