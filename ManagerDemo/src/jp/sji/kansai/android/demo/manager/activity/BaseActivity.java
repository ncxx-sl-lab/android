package jp.sji.kansai.android.demo.manager.activity;

import jp.sji.kansai.android.demo.manager.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

abstract class BaseActivity extends Activity{

	private static final int MENU_ID_MENU = 9001;
	private static final int MENU_ID_LOGOUT = 9002;
	private static final int MENU_ID_CONFIG = 9003;

	//オプションズメニューの設定
	public final boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);

		if (this.getClass() == MainMenuActivity.class) {
			//画面共通のメニューアイテムを追加（設定）
			menu.add(0, MENU_ID_CONFIG, 98, R.string.menu_item_to_config).setIcon(android.R.drawable.ic_menu_preferences);
		} else {
			//画面共通のメニューアイテムを追加（メニュー）
			menu.add( 0, MENU_ID_MENU, 98, R.string.menu_item_to_menu ).setIcon(R.drawable.icon);
		}
		//画面共通のメニューアイテムを追加（ログアウト）
		menu.add( 0, MENU_ID_LOGOUT, 99, R.string.menu_item_to_logout ).setIcon(android.R.drawable.ic_menu_close_clear_cancel);

		return true;
	}

	//メニューの各アイテムが選択されたときの設定
	public final boolean onOptionsItemSelected(MenuItem item){

		switch( item.getItemId() ){
			//メニューが選択されたとき
			case MENU_ID_MENU:
				// インテントの生成
				Intent intent = new Intent( this, MainMenuActivity.class );
				// 次のアクティビティの呼び出し
				startActivity( intent );

			//ログアウトが選択されたとき
			case MENU_ID_LOGOUT:
				break;

			// 設定が選択されたとき
			case MENU_ID_CONFIG:
	        	startActivity(new Intent(this, PushSetUpSelectActivity.class));
				break;

			//そのほかのアイテムが選択されたとき
			default:
				;
		}

		return super.onOptionsItemSelected(item);

	}

	public void onCreate(Bundle savedInstanceState, int rayoutResId){

		super.onCreate(savedInstanceState);

//		// タイトルバーにアイコンを入れる（setContentViewの前に実施）
//		requestWindowFeature(Window.FEATURE_LEFT_ICON);

		setContentView(rayoutResId);

//		// 表示するアイコン画像を設定する
//		setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,R.drawable.icon);
	}

	public void onCreate(Bundle savedInstanceState, View view){
		super.onCreate(savedInstanceState);

//		// タイトルバーにアイコンを入れる（setContentViewの前に実施）
//		requestWindowFeature(Window.FEATURE_LEFT_ICON);

		setContentView(view);

//		// 表示するアイコン画像を設定する
//		setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,R.drawable.icon);

	}

	/**
	 *
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

	protected void logError(String messageText){
		Log.e(this.getClass().getName(), messageText);
	}
	protected void logInfo(String messageText){
		Log.i(this.getClass().getName(), messageText);
	}
	protected void logDebug(String messageText){
		//デバッグモードであれば・・・の指定が必要だな
		Log.d(this.getClass().getName(), messageText);
	}
}
