package jp.sji.kansai.android.demo.buyer;

import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import java.util.ArrayList;

public class SupplierDetailActivity extends BuyerDemoActivity implements OnGesturePerformedListener{

	private final String GESTURE_FORWARD = "forward";
	private final String GESTURE_BACK = "back";
	private GestureLibrary gestureLibrary;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//レイアウト適用
		this.setContentView(R.layout.supplierdetail);

		//ジェスチャーライブラリのロード
		gestureLibrary = GestureLibraries.fromRawResource( this, R.raw.gestures );
		gestureLibrary.load();

		//ジェスチャー用のリスナをセット
		GestureOverlayView gestures = (GestureOverlayView)findViewById( R.id.supplierDetail_gestureOverlayView );
		gestures.addOnGesturePerformedListener( this );

		// 仕入先説明
		//-------------------------------
		// 各種オブジェクトを取得
		//-------------------------------
		// インテントの取得
		Intent intent = this.getIntent();

		TextView supplierName = (TextView)this.findViewById( R.id.supplierDetail_nameText );
		supplierName.setText( intent.getExtras().getString("SUPPLIER_NAME") );



		//取扱品目ボタンにリスナをセット
		Button materialListButton = (Button)this.findViewById(R.id.supplierDetail_MaterialListButton);
		materialListButton.setOnClickListener(
			new View.OnClickListener() {
				public void onClick(View v) {
					// インテントの生成
					Intent intent = new Intent(SupplierDetailActivity.this, MaterialListActivity.class);

					// 次のアクティビティの呼び出し
					startActivity(intent);
				}
			}
		);
		//依頼作成ボタンにリスナをセット
		Button requestCreateButton = (Button)this.findViewById(R.id.supplierDetail_RequestCreateButton);
		requestCreateButton.setOnClickListener(
			new View.OnClickListener() {
				public void onClick(View v) {
					// インテントの生成
					Intent intent = new Intent(SupplierDetailActivity.this, SupplierListActivity.class);

					// 次のアクティビティの呼び出し
					startActivity(intent);
				}
			}
		);
		//住所テキストにリスナをセット
		TextView map = (TextView)this.findViewById( R.id.supplierDetail_addressText );
		map.setOnClickListener(
			new View.OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent(SupplierDetailActivity.this, SupplierMapActivity.class);

					// パラメータの設定(次画面に引き継ぐパラメータを設定)
					intent.putExtra("INPUT_PARAM", "TEST");

					// 次のアクティビティの呼び出し
					startActivity(intent);
				}
			}
		);
	}


	//オプションズメニューの設定
	protected int getOptionsMenuResource(){

		return R.menu.supplierdetailmenu;

	}

	//メニューの各アイテムが選択されたときの設定
	public boolean onOptionsExtendedItemSelected(MenuItem item){

		switch( item.getItemId() ){
			//前へが選択されたとき
			case R.id.menuItem_prev:
				goBack();

			//次へが選択されたとき
			case R.id.menuItem_next:
				goForward();

			default:
				break;
		}

		return super.onOptionsExtendedItemSelected( item );

	}

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

				Double score = prediction.score;
				Toast.makeText( this, score.toString(), Toast.LENGTH_LONG).show();

				if( prediction.name.equals(GESTURE_FORWARD) ){
					goForward();
				}
				if( prediction.name.equals(GESTURE_BACK) ){
					goBack();
				}

			}

		//ジェスチャー候補がひとつもなかったとき
		} else {
			;
		}
	}

	//次の仕入先詳細への遷移処理
	private void goForward(){

		//仕入先名称編集
		TextView supplierName = (TextView)this.findViewById( R.id.supplierDetail_nameText );
		String nextSupplier = supplierName.getText() + "+";

		// インテントの生成
		Intent intent = new Intent(this, SupplierDetailActivity.class);

		// パラメータの設定(次画面に引き継ぐパラメータを設定)
		intent.putExtra("SUPPLIER_NAME", nextSupplier);

		// 次のアクティビティの呼び出し
		startActivity(intent);

	}
	//前の仕入先への遷移処理
	private void goBack(){

		//仕入先名称編集
		TextView supplierName = (TextView)this.findViewById( R.id.supplierDetail_nameText );
		String nextSupplier = supplierName.getText() + "-";

		// インテントの生成
		Intent intent = new Intent(this, SupplierDetailActivity.class);

		// パラメータの設定(次画面に引き継ぐパラメータを設定)
		intent.putExtra("SUPPLIER_NAME", nextSupplier);

		// 次のアクティビティの呼び出し
		startActivity(intent);


	}

}
