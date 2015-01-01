package jp.sji.kansai.android.demo.buyer;

import java.util.List;
import java.util.Vector;

//import jp.hews.hellomap.HellomapActivity;
//import jp.hews.hellomap.R;
//import jp.hews.hellomap.SeniSakiActivity;
//import jp.hews.hellomap.HellomapActivity.IconOverlay;
//import jp.hews.hellomap.HellomapActivity.IconOverlay.PointInfo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
//import android.view.Gravity;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ZoomControls;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class SupplierMapActivity extends BuyerDemoMapActivity{

	   // ログ出力用のタグ
	   static final String TAG = "SupplierMapActivity";

	    // アイコンを表示する位置
	    GeoPoint mPoint;

		/** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.suppliermap);

	        /* Mapコントローラの取得 */
	        MapView m = (MapView)findViewById(R.id.mapview);
	        MapController c = m.getController();

	        /* ZOOMと表示位置の設定 */
	        c.setZoom(15);
	        c.setCenter(new GeoPoint(34686267,135497474));

	        /* ズームコントロールの追加 */
//	        ZoomControls zc = (ZoomControls) m.getZoomControls();
//	        zc.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
//	        zc.setGravity(Gravity.BOTTOM + Gravity.CENTER_HORIZONTAL);
//	        m.addView(zc);
//			// [戻る]ボタンのオブジェクトを取得
//			Button buttonback = (Button)this.findViewById(R.id.supplierMap_back);
//			buttonback.setOnClickListener(new View.OnClickListener() {
//				public void onClick(View v) {
//					finish();
//					}
//			});



	    	// イメージを地図上に表示する
	    	setOverlay(new GeoPoint(34686267,135497474));
	    }

	    protected boolean isRouteDisplayed() {
	        return false;
	    }

	    private void setOverlay(GeoPoint point) {

	        // Overlayクラスを生成する
	        Bitmap icon = BitmapFactory.decodeResource(getResources(),
	                                                   R.drawable.icon);
	        IconOverlay overlay = new IconOverlay(icon, point);

	        // 生成したOverlayクラスを追加する
	        MapView map_view = (MapView) findViewById(R.id.mapview);
	        List<Overlay> overlays = map_view.getOverlays();
	        overlays.add(overlay);
	    }

	    // 地図上に表示されるオーバーレイ
	    private class IconOverlay extends Overlay {

	        // 描画するアイコン
	        Bitmap mIcon;
	        int mOffsetX;
	        int mOffsetY;

	        //マークリスト用クラス（位置とタイトル文字列の保存）
	        private class PointInfo{
	        	Bitmap mIcon;
	        	int mOffsetX;
	        	int mOffsetY;
	        	String mInfoString;
	        	//String mActivityName;//タップ時の遷移先アクティビティ名
	        	//String mActivityString;//タップ時の引数文字列

	        	public PointInfo(int x,int y,String str){
	        		mOffsetX = x;
	        		mOffsetY = y;
	        		mInfoString = str;
	        	}
	        }

	        Vector<PointInfo> mark_list = new Vector <PointInfo>();

	        // アイコンを表示する位置
	        GeoPoint mPoint;

	       IconOverlay(Bitmap icon, GeoPoint initial) {
	            // アイコンと、アイコンの中心のオフセット
	            mIcon = icon;
	            mOffsetX = 0 - icon.getWidth() / 2;
	            mOffsetY = 0 - icon.getHeight() / 2;
	            mPoint = initial;

	            /* デモ用のマーク位置とラベルの定義　*/
	            PointInfo p1 = new PointInfo(34686267,135497474,"(株)ＳＪＩ");
	            PointInfo p2 = new PointInfo(34697367,135499474,"(株)丸三角四角");
	            PointInfo p3 = new PointInfo(34688267,135508574,"（株）□◇会社");
	            mark_list.add(p1);
	            mark_list.add(p2);
	            mark_list.add(p3);

	       }

	        // 地図のタップ時に呼び出される
	        @Override
	        public boolean onTap(GeoPoint point, MapView mapView) {
	            // タップされた位置を記録する
	            mPoint = point;
	            Log.i(TAG, "Point = " + point.getLatitudeE6() + " , " + point.getLongitudeE6());

				// インテントの生成
				Intent intent = new Intent(SupplierMapActivity.this, SupplierDetailActivity.class);

				String str1 = "情報なし";

				// クリック位置の情報調べ
	            for(int i=0;i< mark_list.size();i++){
	            	PointInfo p1 = (PointInfo) mark_list.elementAt(i);
	            	if(p1.mOffsetX > point.getLatitudeE6()-1000 &&
	            	   p1.mOffsetX < point.getLatitudeE6()+1000 &&
	            	   p1.mOffsetY > point.getLongitudeE6() -1000 &&
	            	   p1.mOffsetY < point.getLongitudeE6() +1000 ){
	            		str1 = p1.mInfoString;
	            	}

	            }


				// パラメータの設定(次画面に引き継ぐパラメータを設定)
				intent.putExtra("INPUT_PARAM", str1);

				// 次のアクティビティの呼び出し
				startActivity(intent);

	            return super.onTap(point, mapView);
	        }

	        // 地図の描画時に、shadow=true, shadow=falseと2回呼び出される
	        @Override
	        public void draw(Canvas canvas, MapView mapView,
	                         boolean shadow) {
	            super.draw(canvas, mapView, shadow);
	            if (!shadow) {
	                // 地図上の場所と、描画用のCanvasの座標の変換
	                Projection projection = mapView.getProjection();
	                Point point = new Point();
	                projection.toPixels(mPoint, point);
	                point.offset(mOffsetX, mOffsetY);

	                for(int i=0;i< mark_list.size();i++){
	                	PointInfo p1 = (PointInfo) mark_list.elementAt(i);
	                	drawPoint(canvas, mapView,p1);
	                }
	/*              クリック位置に描画する場合の描画処理
	                // アイコンを描画
//	                canvas.drawBitmap(mIcon, point.x, point.y, null);

	                // テキストの描画
	                // 背景の四角描画
	                Paint balloonPaint = new Paint( Paint.ANTI_ALIAS_FLAG);
	                balloonPaint.setTextSize( 35);
	                balloonPaint.setColor( Color.LTGRAY);

	                RectF balloonRectF = new RectF( point.x, point.y-27, point.x + 140, point.y);
	                canvas.drawRoundRect(balloonRectF, 5, 5, balloonPaint);

	                // テキスト用ペイントの生成
	                Paint textPaint = new Paint( Paint.ANTI_ALIAS_FLAG);
	                textPaint.setTextSize( 26);
	                textPaint.setColor( Color.BLACK);

	                canvas.drawText( "○×株式会社", point.x, point.y, textPaint);
	*/
	            }

	       }
	        /* 画面上にアイコンと文字列を描画する */
	        public void drawPoint(Canvas canvas, MapView mapView,PointInfo p1) {
	       		// 地図上の場所と、描画用のCanvasの座標の変換
	       		Projection projection = mapView.getProjection();
	       		Point point = new Point();
	       		GeoPoint mPointwk = new GeoPoint(p1.mOffsetX, p1.mOffsetY);
	       		projection.toPixels(mPointwk, point);
	       		point.offset(mOffsetX, mOffsetY);

	       		// アイコンを描画
	       		canvas.drawBitmap(mIcon, point.x, point.y, null);

	       		// テキストの描画
	       		// 背景の四角描画
	       		Paint balloonPaint = new Paint( Paint.ANTI_ALIAS_FLAG);
	       		balloonPaint.setTextSize( 22);
	       		balloonPaint.setColor( Color.LTGRAY);

	       		RectF balloonRectF = new RectF( point.x, point.y-24, point.x + 150, point.y+6);
	       		canvas.drawRoundRect(balloonRectF, 7, 5, balloonPaint);

	       		// テキスト用ペイントの生成
	       		Paint textPaint = new Paint( Paint.ANTI_ALIAS_FLAG);
	       		textPaint.setTextSize( 22);
	       		textPaint.setColor( Color.BLACK);

	       		canvas.drawText( p1.mInfoString, point.x, point.y, textPaint);
	        }

	    };

}
