package jp.sji.kansai.android.demo.activity;

import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_EMPLOYEE_NO;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_KINTAI_DATE;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_NEXT_DAY;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_NEXT_MONTH;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_PREVIOUS_DAY;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_PREVIOUS_MONTH;

import java.util.Date;

import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.util.DateUtil;
import jp.sji.kansai.android.demo.util.SystemUtil;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

abstract class BaseActivity extends Activity{

	// MEMO
	// とりあえず少しずつ整理
	/** 社員番号 */
	protected String employeeNo;

	/** 勤務日付 */
	protected Date kinmuDate;

	public void onClick_headerMenuSetting(View view){
		logInfo("Settingがタップされました");
		Intent intent = null;
		intent = new Intent(this,SettingMenuActivity.class);
		startActivity(intent);

	}

	public void onClick_headerMenuKinmuInfoList(View view){
		logInfo("KinmuInfoListがタップされました");
		Intent intent = null;
		intent = new Intent(this,KinmuInfoListActivity.class);
		startActivity(intent);

	}

	public void onClick_headerMenuTopPage(View view){
		logInfo("TopPageがタップされました");
		Intent intent = null;
		intent = new Intent(this,TopMenuActivity.class);
		startActivity(intent);
	}

	public void setTitleName(String titleText){
		//TextView activityTitle = null;
		//activityTitle = (TextView) this.findViewById(R.id.activityTitle);
		//activityTitle.setText(titleText);
		setTitle(titleText);

	}

	public void setTitleIcon(int ResourceID){
		ImageView activitySymbol = null;
		activitySymbol = (ImageView) this.findViewById(R.id.activitySymbol);
		activitySymbol.setImageResource(ResourceID);
	}

	public void setUploadStatus(){
		// uploadが未実施の場合にアイコンを表示する
		ImageView uploadSymbol = null;
		uploadSymbol = (ImageView) this.findViewById(R.id.uploadStatusSymbol);
		uploadSymbol.setVisibility(ImageView.GONE);		// 非表示
		uploadSymbol.setVisibility(ImageView.VISIBLE);	// 表示
	}

	/**
	 * トースト表示を行う。
	 * @param messageText トーストに表示する文字列
	 */
	protected void showToast(String messageText){
		Toast.makeText(this, messageText, Toast.LENGTH_LONG).show();
	}

	/**
	 * シンプルなアラート表示を行う。
	 * @param title タイトル
	 * @param message メッセージ
	 */
	protected void showSimpleAlert(String title, String message) {
		AlertDialog.Builder ad = new AlertDialog.Builder(this);
		ad.setTitle(title);
		ad.setMessage(message);
		ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		ad.create();
		ad.show();
	}

	/**
	 * ERRORログ出力
	 * @param messageText
	 */
	protected void logError(String messageText){
		Log.e(this.getClass().getName(), messageText);
	}

	/**
	 * INFOログ出力
	 * @param messageText
	 */
	protected void logInfo(String messageText){
		Log.i(this.getClass().getName(), messageText);
	}

	/**
	 * DEBUGログ出力
	 * @param messageText
	 */
	protected void logDebug(String messageText){
		// MEMO
		// デバッグモードであれば・・・の指定が必要か？
		Log.d(this.getClass().getName(), messageText);
	}

	protected String getSysDateString(String format){
		return SystemUtil.convDateToString(DateUtil.getSysdate(),format);
	}

	/**
	 * Activityの初期処理を行う
	 */
	protected void initActivity() {
		// 前Activityから共通情報を取得する
		Intent intent = getIntent();

		// 社員番号
		if (intent.hasExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO)) {
			this.employeeNo = intent.getStringExtra(INTENT_EXTRA_KEY_EMPLOYEE_NO);
		} else {
			// TODO [Tsuji] デフォルトの社員番号はどこから取得する？
			this.employeeNo = "99999";
		}

		// 勤怠日付
		if (intent.hasExtra(INTENT_EXTRA_KEY_KINTAI_DATE)) {
			this.kinmuDate = (Date) intent.getSerializableExtra(INTENT_EXTRA_KEY_KINTAI_DATE);
		} else if (intent.hasExtra(INTENT_EXTRA_KEY_PREVIOUS_MONTH)) {
			this.kinmuDate = (Date) intent.getSerializableExtra(INTENT_EXTRA_KEY_PREVIOUS_MONTH);
		} else if (intent.hasExtra(INTENT_EXTRA_KEY_NEXT_MONTH)) {
			this.kinmuDate = (Date) intent.getSerializableExtra(INTENT_EXTRA_KEY_NEXT_MONTH);
		} else if (intent.hasExtra(INTENT_EXTRA_KEY_PREVIOUS_DAY)) {
			this.kinmuDate = (Date) intent.getSerializableExtra(INTENT_EXTRA_KEY_PREVIOUS_DAY);
		} else if (intent.hasExtra(INTENT_EXTRA_KEY_NEXT_DAY)) {
			this.kinmuDate = (Date) intent.getSerializableExtra(INTENT_EXTRA_KEY_NEXT_DAY);
		} else {
			this.kinmuDate = DateUtil.getSysdate();
		}
	}


}
