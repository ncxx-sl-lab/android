package jp.sji.kansai.android.demo.buyer;

import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

abstract class BuyerDemoListActivity extends ListActivity {
	private static final int MENU_ID_MENU = 9001;
	private static final int MENU_ID_LOGOUT = 9002;

	protected void outputLog(String message) {
		Log.i(this.getClass().getName(), message);
	}


	//オプションズメニューの設定
	public final boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);

		//画面固有のメニューアイテムを設定
		if( getOptionsMenuResource() == 0 ){
			;
		} else {
			getMenuInflater().inflate(getOptionsMenuResource(), menu);
		}

		//画面共通のメニューアイテムを追加（メニュー）
		menu.add( 0, MENU_ID_MENU, 98, R.string.menu_item_to_menu ).setIcon(R.drawable.icon);
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

			//そのほかのアイテムが選択されたとき
			default:
				onOptionsExtendedItemSelected( item );
		}

		return super.onOptionsItemSelected(item);

	}

	protected int getOptionsMenuResource(){

		return 0;

	}

	protected boolean onOptionsExtendedItemSelected( MenuItem item ){

		return true;

	}







}
