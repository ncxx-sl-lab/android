/**
 *
 */
package jp.sji.kansai.android.demo.buyer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author takashi.o
 *
 */
public class RequestProcessSelectActivity extends BuyerDemoActivity {

	/* (非 Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.requestprocessselect);

//		// 各種ボタン
//		Button backMenuButton = (Button)this.findViewById(R.id.reauestProcessSelect_BackMenuButton);
//		Button supplierSearchButton = (Button)this.findViewById(R.id.reauestProcessSelect_SupplierSearchButton);
//		Button materialListButton = (Button)this.findViewById(R.id.reauestProcessSelect_MaterialListButton);
//		Button barcodeReadButton = (Button)this.findViewById(R.id.reauestProcessSelect_BarcodeReadButton);
//
//		backMenuButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// インテントの生成
//				Intent intent = new Intent(RequestProcessSelectActivity.this, MainMenuActivity.class);
//
//				// 次のアクティビティの呼び出し
//				startActivity(intent);
//			}
//		});
//
//		supplierSearchButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// インテントの生成
//				Intent intent = new Intent(RequestProcessSelectActivity.this, SupplierListActivity.class);
//
//				// 次のアクティビティの呼び出し
//				startActivity(intent);
//			}
//		});
//
//		materialListButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// インテントの生成
//				Intent intent = new Intent(RequestProcessSelectActivity.this, MaterialListActivity.class);
//
//				// 次のアクティビティの呼び出し
//				startActivity(intent);
//			}
//		});
//
//		barcodeReadButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				// インテントの生成
//				Intent intent = new Intent(RequestProcessSelectActivity.this, MainMenuActivity.class);
//
//				// 次のアクティビティの呼び出し
//				startActivity(intent);
//			}
//		});
		
	}

//	public void clickMenuBackMenu(View v) {
//		// インテントの生成
//		Intent intent = new Intent(RequestProcessSelectActivity.this, MainMenuActivity.class);
//
//		// 次のアクティビティの呼び出し
//		startActivity(intent);
//	}
	

	// 仕入先検索
	public void clickMenuSupplierSearch(View v) {
		// インテントの生成
		Intent intent = new Intent(RequestProcessSelectActivity.this, SupplierListActivity.class);

		// 次のアクティビティの呼び出し
		startActivity(intent);
	}
	
	// 品目一覧
	public void clickMenuMaterialList(View v) {
		// インテントの生成
		Intent intent = new Intent(RequestProcessSelectActivity.this, MaterialListActivity.class);

		// 次のアクティビティの呼び出し
		startActivity(intent);
	}

	// バーコード読取
	public void clickMenuBarcodeRead(View v) {
//		// インテントの生成
//		Intent intent = new Intent(RequestProcessSelectActivity.this, MainMenuActivity.class);
//
//		// 次のアクティビティの呼び出し
//		startActivity(intent);
		
		showToast("[開発中]\nバーコード読取による品目検索を実施する");
		
	}

}
