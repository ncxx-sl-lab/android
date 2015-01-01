package jp.sji.kansai.android.demo.activity;

import java.util.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.db.entity.TProjectInfoEntity;
import jp.sji.kansai.android.demo.db.entity.MProjectNoEntity;
import jp.sji.kansai.android.demo.db.entity.MWorkCdEntity;
import jp.sji.kansai.android.demo.util.DateUtil;
import jp.sji.kansai.android.demo.util.SystemUtil;
import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDD_SLASH;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_PROJECT_INFO_INDEX;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_PROJECT_INFO_LIST;
import static jp.sji.kansai.android.demo.costants.AppConstants.GESTURE_NAME_BACK;

public class ProjectInfoEditActivity extends BaseActivity implements OnGesturePerformedListener{
	
	/** 空プロジェクト行判別フラグ */
	private static final String FLG_EMPTY_PROJECT = "FLG_EMPTY_PROJECT";
	
	private TextView projectNoView;
	private TextView workCDView;
	private TextView basicTimeView;
	private TextView zangyouTimeView;
	private TextView shinyaTimeView;
	
	/** プロジェクト情報リスト */
	private ArrayList<TProjectInfoEntity> projectInfoEntityList;
	private TProjectInfoEntity projectInfoEntity;
	private int projectInfoIndex;
	
	/** ジェスチャーライブラリ */
	private GestureLibrary gestureLibrary;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projectinfoedit);
		setTitleName("プロジェクト情報編集");
		setTitleIcon(android.R.drawable.ic_menu_edit);
		setUploadStatus();
		
		// 初期処理
		initActivity();
	}
	/**
	 * 初期表示処理を行う
	 */
	@Override
	protected void initActivity() {
		
		super.initActivity();
		
		Intent intent = getIntent();
		
		// ヘッダ日付セット
		TextView tvKinmuDate = (TextView)this.findViewById(R.id.lblViewYearMonth);
		tvKinmuDate.setText(SystemUtil.convDateToString(this.kinmuDate, DATE_FORMAT_YYYYMMDD_SLASH)
				+ "(" + DateUtil.getStrDayOfWeek(this.kinmuDate) + ")");
		
		projectInfoIndex = intent.getIntExtra(INTENT_EXTRA_KEY_PROJECT_INFO_INDEX, 0);
		projectInfoEntityList = (ArrayList<TProjectInfoEntity>)intent.getSerializableExtra(INTENT_EXTRA_KEY_PROJECT_INFO_LIST);
		projectInfoEntity = projectInfoEntityList.get(projectInfoIndex);
		
		
		// プロジェクト番号
		projectNoView = (TextView)this.findViewById(R.id.projectinfo_edit_pjno);
		if(projectInfoEntity.getProjectNo().equals(FLG_EMPTY_PROJECT)){
			projectNoView.setText( "" );
			
		} else {
			projectNoView.setText( projectInfoEntity.getProjectNo() );
			
		}
		
		// 作業コード
		workCDView = (TextView)this.findViewById(R.id.projectinfo_edit_workcd);
		workCDView.setText( projectInfoEntity.getWorkCd() );
		
		// 定時内作業時間
		basicTimeView = (TextView)this.findViewById(R.id.projectinfo_edit_basictime);
		basicTimeView.setText( projectInfoEntity.getHoursWorkedScheduledTime() );
		
		// 残業作業時間
		zangyouTimeView = (TextView)this.findViewById(R.id.projectinfo_edit_zangyoutime);
		zangyouTimeView.setText( projectInfoEntity.getHoursWorkedOvertimeWork() );
		
		// 深夜作業時間
		shinyaTimeView = (TextView)this.findViewById(R.id.projectinfo_edit_shinyatime);
		shinyaTimeView.setText( projectInfoEntity.getHoursWorkedMidnight() );
		
		
		// 決定ボタン
		Button saveButton = (Button)this.findViewById(R.id.projectinfo_edit_save);
		saveButton.setOnClickListener(
			new View.OnClickListener() {
				public void onClick( View v ){
					onClick_SaveButton();
				}
			}
		);
		
		// ジェスチャー初期処理
		setGestures();
		
	}
	
	/**
	* ジェスチャーの初期処理
	*/
	private void setGestures() {
		//ジェスチャーライブラリのロード
		gestureLibrary = GestureLibraries.fromRawResource( this, R.raw.gestures );
		gestureLibrary.load();

		//ジェスチャー用のリスナをセット
		GestureOverlayView gestures = (GestureOverlayView)findViewById( R.id.projectinfoeditView_gesture );
		gestures.addOnGesturePerformedListener( this );

	}

	/**
	* プロジェクト番号選択時の処理
	*/
	public void onClick_pjNo(View view){
		// ビルダ生成
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// リストに表示するデータの取得
		final List<MProjectNoEntity> projectList = getProjectNoList();
		// ビルダに各種データをセット
		builder.setTitle("プロジェクト番号選択");
		builder.setAdapter(
				// アダプタ
				new ProjectNoAdapter(
					this, 
					R.id.projectinfoedit_dialog_pjno_row, 
					projectList
				),
				// アイテム選択時の処理
				new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which){
						projectNoView.setText( projectList.get(which).getProjectNo() );
						dialog.cancel();
					}
				}
			);
		// ダイアログ表示
		builder.create().show();
	}
	/**
	* プロジェクト番号マスタから一覧を取得する
	*/
	private List<MProjectNoEntity> getProjectNoList(){
		
		//
		// DBから、プロジェクト番号マスタを取得するコード
		//
		
		List<MProjectNoEntity> projectNoList = new ArrayList<MProjectNoEntity>();
		
		MProjectNoEntity projectRecord = new MProjectNoEntity();
		projectRecord.setProjectNo("3V-00129901-00x");
		projectRecord.setProjectName("O社/営業ｼｽﾃﾑ維持管理支援");
		projectNoList.add(projectRecord);
		
		projectRecord = new MProjectNoEntity();
		projectRecord.setProjectNo("3V-10120002-00x");
		projectRecord.setProjectName("S社/業務ｼｽﾃﾑ保守支援");
		projectNoList.add(projectRecord);
		
		projectRecord = new MProjectNoEntity();
		projectRecord.setProjectNo("3V-20120103-00x");
		projectRecord.setProjectName("B社/SAP保守開発作業");
		projectNoList.add(projectRecord);
		
		projectRecord = new MProjectNoEntity();
		projectRecord.setProjectNo("3V-30120204-00x");
		projectRecord.setProjectName("N社/S生命開発支援");
		projectNoList.add(projectRecord);
		
		projectRecord = new MProjectNoEntity();
		projectRecord.setProjectNo("3V-40120305-00x");
		projectRecord.setProjectName("D社/ＪＰ工事機能追加開発一括");
		projectNoList.add(projectRecord);
		
		projectRecord = new MProjectNoEntity();
		projectRecord.setProjectNo("3V-50120406-00x");
		projectRecord.setProjectName("T社/飲料向けｼｽﾃﾑ開発");
		projectNoList.add(projectRecord);
		
		projectRecord = new MProjectNoEntity();
		projectRecord.setProjectNo("3V-60120507-00x");
		projectRecord.setProjectName("関西SL部/未アサイン");
		projectNoList.add(projectRecord);
		
		return projectNoList;
		
	}
// ************************************************************************
	/**
	* 内部クラス：プロジェクト番号一覧表示用アダプタ
	*/
// ************************************************************************
	private class ProjectNoAdapter extends ArrayAdapter<MProjectNoEntity>{
		
		private LayoutInflater layoutInflater = null;
		
		/**
		 * コンストラクタ
		 * @param context
		 * @param resourceId
		 * @param items
		 */
		public ProjectNoAdapter( Context context, int resourceId, List<MProjectNoEntity> items ){
			super( context, resourceId, items );
			
			//LayoutInflaterを取得
			layoutInflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		@Override
		public View getView( int position, View convertView, ViewGroup parent ) {
			// view が再利用されていないときのみ、新規作成
			if( convertView == null ){
				// 1行分のレイアウトを生成
				convertView = layoutInflater.inflate( R.layout.projectinfoedit_dialog_pjno_row, null );
			}
			
			// 表示データの取得
			MProjectNoEntity item = getItem( position );
			
			if( item != null ){
				
				// プロジェクト番号
				TextView projectNo
					= ( TextView )convertView.findViewById( R.id.projectinfoedit_dialog_pjno_row_pjno);
				projectNo.setText( item.getProjectNo() );
				
				// プロジェクト名
				TextView projectName 
					= ( TextView )convertView.findViewById( R.id.projectinfoedit_dialog_pjno_row_pjname);
				projectName.setText( item.getProjectName() );
				
			}
			return convertView;
		}
	}
	
	/**
	* 作業コード選択時の処理
	*/
	public void onClick_workCd(View view){
		// ビルダ生成
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// リストに表示するデータの取得
		final List<MWorkCdEntity> workList = getWorkCdList();
		// ビルダに各種データをセット
		builder.setTitle("作業コード選択");
		builder.setAdapter(
			// アダプタ
			new WorkCdAdapter(
				this, 
				R.id.projectinfoedit_dialog_workcd_row, 
				workList
			),
			// アイテム選択時の処理
			new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which){
					workCDView.setText( workList.get(which).getWorkCd() );
					dialog.cancel();
				}
			}
		);
		// ダイアログ表示
		builder.create().show();
	}
	/**
	* 作業コードマスタから一覧を取得する
	*/
	private List<MWorkCdEntity> getWorkCdList() {
		
		//
		// DBから、作業コードマスタを取得するコード
		//
		
		List<MWorkCdEntity> workCdList = new ArrayList<MWorkCdEntity>();
		MWorkCdEntity workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("A");
		workRecord.setWorkName("企画");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("B");
		workRecord.setWorkName("要件定義");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("C");
		workRecord.setWorkName("外部設計");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("D");
		workRecord.setWorkName("内部設計");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("E");
		workRecord.setWorkName("プログラム設計");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("F");
		workRecord.setWorkName("プログラム作成");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("G");
		workRecord.setWorkName("結合テスト");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("H");
		workRecord.setWorkName("総合テスト");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("I");
		workRecord.setWorkName("受入テスト");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("K");
		workRecord.setWorkName("移行");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("L");
		workRecord.setWorkName("保守");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("Z0100");
		workRecord.setWorkName("部内業務");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("Z0200");
		workRecord.setWorkName("訓練（教育）");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("Z0300");
		workRecord.setWorkName("未アサイン");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("Z0400");
		workRecord.setWorkName("会社行事");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("Z0500");
		workRecord.setWorkName("その他時間");
		workCdList.add(workRecord);
		
		workRecord = new MWorkCdEntity();
		workRecord.setWorkCd("Z9000");
		workRecord.setWorkName("非勤務時間");
		workCdList.add(workRecord);
		
		return workCdList;
	}
// ************************************************************************
	/**
	* 内部クラス：作業コード一覧表示用アダプタ
	*/
// ************************************************************************
	private class WorkCdAdapter extends ArrayAdapter<MWorkCdEntity>{
		
		private LayoutInflater layoutInflater = null;
		
		/**
		 * コンストラクタ
		 * @param context
		 * @param resourceId
		 * @param items
		 */
		public WorkCdAdapter( Context context, int resourceId, List<MWorkCdEntity> items ){
			super( context, resourceId, items );
			
			//LayoutInflaterを取得
			layoutInflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		@Override
		public View getView( int position, View convertView, ViewGroup parent ) {
			// view が再利用されていないときのみ、新規作成
			if( convertView == null ){
				// 1行分のレイアウトを生成
				convertView = layoutInflater.inflate( R.layout.projectinfoedit_dialog_workcd_row, null );
			}
			
			// 表示データの取得
			MWorkCdEntity item = getItem( position );
			
			if( item != null ){
				
				// 作業コード
				TextView projectNo
					= ( TextView )convertView.findViewById( R.id.projectinfoedit_dialog_workcd_row_workcd);
				projectNo.setText( item.getWorkCd() );
				
				// 作業名
				TextView projectName 
					= ( TextView )convertView.findViewById( R.id.projectinfoedit_dialog_workcd_row_workname);
				projectName.setText( item.getWorkName() );
				
			}
			return convertView;
		}	
	}
	/**
	* 定時選択時の処理
	*/
	public void onClick_basicTime(View view){
		// ビルダ生成
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// リストに表示するデータの取得
		final String basicTimes[] = getResources().getStringArray(R.array.basic_time);
		// ビルダに各種データをセット
		builder.setTitle("定時内作業時間選択");
		builder.setItems(
			// アイテムリスト
			basicTimes,
			// アイテム選択時の処理
			new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which){
					basicTimeView.setText(basicTimes[which]);
					dialog.cancel();
				}
			}
		);
		// ダイアログ表示
		builder.create().show();
	}
	/**
	* 残業選択時の処理
	*/
	public void onClick_zangyouTime(View view){
		// ビルダ生成
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// リストに表示するデータの取得
		final String zangyouTimes[] = getResources().getStringArray(R.array.zangyou_time);
		// ビルダに各種データをセット
		builder.setTitle("残業作業時間選択");
		builder.setItems(
			// アイテムリスト
			zangyouTimes,
			// アイテム選択時の処理
			new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which) {
					zangyouTimeView.setText(zangyouTimes[which]);
					dialog.cancel();
				}
			}
		);
		// ダイアログ表示
		builder.create().show();
	}
	/**
	* 深夜選択時の処理
	*/
	public void onClick_shinyaTime(View view){
		// ビルダ生成
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// リストに表示するデータの取得
		final String shinyaTimes[] = getResources().getStringArray(R.array.shinya_time);
		// ビルダに各種データをセット
		builder.setTitle("深夜作業時間選択");
		builder.setItems(
			// アイテムリスト
			shinyaTimes,
			// アイテム選択時の処理
			new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which) {
					shinyaTimeView.setText(shinyaTimes[which]);
					dialog.cancel();
				}
			}
		);
		// ダイアログ表示
		builder.create().show();
	}
	
	
	
	// ************************************************************************
	// メニュークリックイベント
	// ************************************************************************
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		
		// XML定義を呼び出し、該当のリソースを読み取り表示する
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.projectinfoedit, menu);
		return true;
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		String msg = "";
		
		switch(item.getItemId()){
			case R.id.projectinfoedit_menuItem_Save :
				msg = "保存ボタンをタップしました";
				onClick_SaveButton();
				break;
			case R.id.projectinfoedit_menuItem_Cancel :
				msg = "キャンセルボタンをタップしました";
				onClick_CancelButton();
				break;
			default:
				break;
		}
		
		showToast(msg);
		return true;
		
	}
	public void onClick_SaveButton(){
		// インテントの生成
		Intent intent = new Intent( ProjectInfoEditActivity.this, ProjectInfoListActivity.class );
		
		projectInfoEntity.setProjectNo(projectNoView.getText().toString());
		projectInfoEntity.setWorkCd(workCDView.getText().toString());
		projectInfoEntity.setHoursWorkedScheduledTime(basicTimeView.getText().toString());
		projectInfoEntity.setHoursWorkedOvertimeWork(zangyouTimeView.getText().toString());
		projectInfoEntity.setHoursWorkedMidnight(shinyaTimeView.getText().toString());
		
		// 更新したプロジェクトの情報をインテントにセット
		intent.putExtra(INTENT_EXTRA_KEY_PROJECT_INFO_LIST, projectInfoEntityList);
		
		finish();
		// 次アクティビティの呼び出し
		startActivity( intent );
	}
	public void onClick_SaveButton(View view){
		onClick_SaveButton();
	}
	public void onClick_CancelButton(){
		// インテントの生成
		Intent intent = new Intent( ProjectInfoEditActivity.this, ProjectInfoListActivity.class );
		
		// 更新前プロジェクトの情報をインテントにセット
		intent.putExtra(INTENT_EXTRA_KEY_PROJECT_INFO_LIST, projectInfoEntityList);
		
		finish();
		// 次アクティビティの呼び出し
		startActivity( intent );
	}
	public void onClick_CancelButton(View view){
		onClick_CancelButton();
	}
	
// ************************************************************************
	/**
	* ジェスチャー
	*/
// ************************************************************************
	@Override
	public void onGesturePerformed( GestureOverlayView overlay, Gesture gesture ){
		ArrayList<Prediction> predictions = gestureLibrary.recognize( gesture );
		
		//ジェスチャー候補がひとつ以上取得できたとき
		if( predictions.size() > 0 ){
			
			//ジェスチャー候補を調査
			for( Prediction prediction : predictions ){
				
				//スコアが3より高い候補がなければ、なにもしない。
				if ( prediction.score <= 3 ){
					return;
				}
				
//				Double score = prediction.score;
//				Toast.makeText( this, score.toString(), Toast.LENGTH_LONG).show();
				
				if( prediction.name.equals(GESTURE_NAME_BACK) ){
					
					onClick_CancelButton();
					
				}
				
			}
			
		//ジェスチャー候補がひとつもなかったとき
		} else {
			;
		}
	}
}