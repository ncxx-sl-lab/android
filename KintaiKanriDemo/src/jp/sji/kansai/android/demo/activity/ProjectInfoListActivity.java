package jp.sji.kansai.android.demo.activity;

import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.math.BigDecimal;

import android.content.Context;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import jp.sji.kansai.android.demo.R;
import jp.sji.kansai.android.demo.db.entity.TProjectInfoEntity;
import jp.sji.kansai.android.demo.util.DateUtil;
import jp.sji.kansai.android.demo.util.SystemUtil;
import static jp.sji.kansai.android.demo.costants.AppConstants.DATE_FORMAT_YYYYMMDD_SLASH;
import static jp.sji.kansai.android.demo.costants.AppConstants.GESTURE_NAME_BACK;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_PROJECT_INFO_LIST;
import static jp.sji.kansai.android.demo.costants.AppConstants.INTENT_EXTRA_KEY_PROJECT_INFO_INDEX;
import static jp.sji.kansai.android.demo.costants.AppConstants.NUMBER_FORMAT_TIME;

public class ProjectInfoListActivity extends BaseActivity implements OnGesturePerformedListener {
	
	/** 空プロジェクト行判別フラグ */
	private static final String FLG_EMPTY_PROJECT = "FLG_EMPTY_PROJECT";
	
	/** プロジェクト情報リスト */
	ArrayList<TProjectInfoEntity> projectInfoEntityList;
	
	/** プロジェクトリストアダプタ */
	ProjectInfoAdapter adapter;
	
	/** ジェスチャーライブラリ */
	private GestureLibrary gestureLibrary;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projectinfolist);
		setTitleName("プロジェクト情報一覧");
		setTitleIcon(android.R.drawable.ic_menu_agenda);
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
		
		// リストビュー取得
		ListView projectInfoListView = (ListView)findViewById(R.id.projectListView_pj_list);
		
		// リスト表示データ取得
		projectInfoEntityList = (ArrayList<TProjectInfoEntity>)intent.getSerializableExtra(INTENT_EXTRA_KEY_PROJECT_INFO_LIST);
		
		// プロジェクトトータルデータ作成
		setProjectInfoTotalLine();
		
		// 「新規プロジェクト」行を追加
		if(!containEmptyProject()){
			TProjectInfoEntity emptyProject = new TProjectInfoEntity();
			emptyProject.setProjectNo(FLG_EMPTY_PROJECT);
			projectInfoEntityList.add( emptyProject );
		}
		
		// アダプタセット
		adapter = new ProjectInfoAdapter(
			this, 
			R.id.projectListView_pj_list, 
			projectInfoEntityList
		); 
		projectInfoListView.setAdapter( adapter	);
		
		//コンテキストメニューセット
		registerForContextMenu(projectInfoListView);
		
		//リストアイテム選択時の処理
		projectInfoListView.setOnItemClickListener(
			new AdapterView.OnItemClickListener(){
				public void onItemClick( AdapterView<?> parent, View view, int position, long id ){
					
					// インテントの生成
					Intent intent = new Intent( ProjectInfoListActivity.this, ProjectInfoEditActivity.class );
					
					// 選択されたプロジェクトの情報をインテントにセット
					intent.putExtra(INTENT_EXTRA_KEY_PROJECT_INFO_INDEX, position);
					intent.putExtra(INTENT_EXTRA_KEY_PROJECT_INFO_LIST, projectInfoEntityList);
					
					// 次アクティビティの呼び出し
					startActivity( intent );
					
				}
			}
		);
		// 決定ボタン
		Button saveButton = (Button)this.findViewById(R.id.projectListView_button_save);
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
	 * プロジェクト合計行の更新
	 */
	private void setProjectInfoTotalLine() {
		
		// 表示フォーマット
		DecimalFormat df = new DecimalFormat(NUMBER_FORMAT_TIME);
		BigDecimal basicProjectTotal   = BigDecimal.ZERO;;
		BigDecimal zangyouProjectTotal = BigDecimal.ZERO;;
		BigDecimal shinyaProjectTotal  = BigDecimal.ZERO;;
		
		for( TProjectInfoEntity projectInfo: projectInfoEntityList){
			
			if(projectInfo.getHoursWorkedScheduledTime() != null){
				basicProjectTotal   = basicProjectTotal.add( new BigDecimal(projectInfo.getHoursWorkedScheduledTime()));
			}
			if(projectInfo.getHoursWorkedOvertimeWork() != null){
				zangyouProjectTotal = zangyouProjectTotal.add( new BigDecimal(projectInfo.getHoursWorkedOvertimeWork()));
			}
			if(projectInfo.getHoursWorkedMidnight() != null){
				shinyaProjectTotal  = shinyaProjectTotal.add( new BigDecimal(projectInfo.getHoursWorkedMidnight()));
			}
		}
		
		TextView basicProjectTotalView = (TextView)this.findViewById(R.id.projectListView_total_basic_time);
		basicProjectTotalView.setText(df.format(basicProjectTotal));
		
		TextView zangyouProjectTotalView = (TextView)this.findViewById(R.id.projectListView_total_zangyou_time);
		zangyouProjectTotalView.setText(df.format(zangyouProjectTotal));
		
		TextView shinyaProjectTotalView = (TextView)this.findViewById(R.id.projectListView_total_shinya_time);
		shinyaProjectTotalView.setText(df.format(shinyaProjectTotal));
	}
	/**
	 * 「新規プロジェクト追加」行を持っているかを判定する
	 */
	private boolean containEmptyProject() {
		for(ListIterator<TProjectInfoEntity> it = projectInfoEntityList.listIterator(projectInfoEntityList.size()); it.hasPrevious();){
			TProjectInfoEntity project = it.previous();
			if(project.getProjectNo().equals(FLG_EMPTY_PROJECT)){
				return true;
			}
		}
		return false;
	}
	/**
	* ジェスチャーの初期処理
	*/
	private void setGestures() {
		//ジェスチャーライブラリのロード
		gestureLibrary = GestureLibraries.fromRawResource( this, R.raw.gestures );
		gestureLibrary.load();

		//ジェスチャー用のリスナをセット
		GestureOverlayView gestures = (GestureOverlayView)findViewById( R.id.projectinfolistView_gesture );
		gestures.addOnGesturePerformedListener( this );

	}

// ************************************************************************
	/**
	 * 内部クラス：プロジェクト一覧表示用アダプタ
	 */
// ************************************************************************
	public class ProjectInfoAdapter extends ArrayAdapter<TProjectInfoEntity>{
		
		private LayoutInflater layoutInflater = null;
		
		/**
		 * コンストラクタ
		 * @param context
		 * @param resourceId
		 * @param items
		 */
		public ProjectInfoAdapter( Context context, int resourceId, List<TProjectInfoEntity> items ){
			super( context, resourceId, items );
			
			//LayoutInflaterを取得
			layoutInflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		
		@Override
		public View getView( int position, View convertView, ViewGroup parent ) {
			
			// 表示データの取得
			TProjectInfoEntity item = getItem( position );
			if( item.getProjectNo().equals(FLG_EMPTY_PROJECT) ){
				convertView = layoutInflater.inflate( R.layout.projectinfolist_emptyrow, null );
				
			}else{
			
				// view が再利用されていないときのみ、新規作成
				if( convertView == null || convertView.getId() == R.id.projectinfolist_emptyrow_view){
					// projectinfolist_row.xmlから1行分のレイアウトを生成
					convertView = layoutInflater.inflate( R.layout.projectinfolist_row, null );
				}
				
				// 表示データのセット
				if( item != null ){
					// プロジェクト番号
					TextView projectNo   = ( TextView )convertView.findViewById( R.id.projectinfo_pjno );
					projectNo.setText( item.getProjectNo() );
					
					// 作業コード
					TextView workCD      = ( TextView )convertView.findViewById( R.id.projectinfo_workcd );
					workCD.setText( item.getWorkCd() );
					
					// 定時内作業時間
					TextView basicTime   = ( TextView )convertView.findViewById( R.id.projectinfo_basictime );
					basicTime.setText( item.getHoursWorkedScheduledTime() );
					
					// 残業作業時間
					TextView zangyouTime = ( TextView )convertView.findViewById( R.id.projectinfo_zangyoutime );
					zangyouTime.setText( item.getHoursWorkedOvertimeWork() );
					
					// 深夜作業時間
					TextView shinyaTime  = ( TextView )convertView.findViewById( R.id.projectinfo_shinyatime );
					shinyaTime.setText( item.getHoursWorkedMidnight() );
				}
			}
			return convertView;
		}
	}
	// ************************************************************************
    // メニュークリックイベント
    // ************************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

    	// XML定義を呼び出し、該当のリソースを読み取り表示する
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.projectinfolist, menu);
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
		
//    	String msg = "";
//
//    	switch(item.getItemId()){
//    		case R.id.topmenu_menuItem_KinmuInfoDetail :
//    			msg = "基本情報ボタンをタップしました";
//    			break;
//    		case R.id.topmenu_menuItem_KinmuInfoList :
//    			msg = "勤務一覧ボタンをタップしました";
//    			break;
//    		case R.id.topmenu_menuItem_KinmuInfoEdit :
//    			msg = "勤務入力ボタンをタップしました";
//    			break;
//    		case R.id.topmenu_menuItem_KinmuInfoUpload :
//    			msg = "アップロードボタンをタップしました";
//    			break;
//    		case R.id.topmenu_menuItem_SettingMenu :
//    			msg = "設定ボタンをタップしました";
//    			break;    			
//    		case R.id.topmenu_menuItem_InfoView36Kyoutei :
//    			msg = "36協定とはボタンをタップしました";
//    			break;    			
//    		default:
//    			break;
//    	}
//    	
//	showToast(msg);
	return true;
		
	}
	public void onClick_SaveButton(){
		// インテントの生成
		Intent intent = new Intent( ProjectInfoListActivity.this, KinmuInfoEditActivity.class );
		finish();
		startActivity(intent);
	}
	public void onClick_SaveButton(View view){
		onClick_SaveButton();
	}
	public void onClick_CancelButton(){
		// インテントの生成
		Intent intent = new Intent( ProjectInfoListActivity.this, KinmuInfoEditActivity.class );
		finish();
		startActivity(intent);
	}
	public void onClick_CancelButton(View view){
		onClick_CancelButton();
	}
	
	public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo){
		super.onCreateContextMenu(menu, view, menuInfo);
		getMenuInflater().inflate(R.menu.projectinfolist_context, menu);
		menu.setHeaderTitle("コンテキストメニュー");
		
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		switch (item.getItemId()) {
			case R.id.projectinfolist_contextmenuItem_Remove:
				projectInfoEntityList.remove(info.position);
				setProjectInfoTotalLine();
				adapter.notifyDataSetChanged();
				return true;
		}
		return true;
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
					
//					Double score = prediction.score;
//					Toast.makeText( this, score.toString(), Toast.LENGTH_LONG).show();
					
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