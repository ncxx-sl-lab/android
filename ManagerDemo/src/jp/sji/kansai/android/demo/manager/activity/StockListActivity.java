package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：在庫一覧
 * クラス名：StockListActivity
 */

import jp.sji.kansai.android.demo.manager.R;
import android.os.Bundle;

public class StockListActivity extends BaseActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stocklist);
    }
}