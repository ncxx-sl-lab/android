package jp.sji.kansai.android.demo.buyer;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class StockListActivity extends BuyerDemoActivity {

	/**
	 * アクティビティが最初に起動する時に実行されるメソッド<br>
	 * <br>
	 * onSaveInstanceStateメソッドで保存された情報がある場合は、<br>
	 * 引数のBundleにその情報が引き渡され、状態を復元させることが可能<br>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		outputLog("onCreate");

		//-----------------------
		// 初期処理
		//-----------------------
		// 親クラスのメソッドを実行
		super.onCreate(savedInstanceState);

		setContentView(R.layout.stocklist);

		TableLayout tableLayout = (TableLayout)this.findViewById(R.id.StockList_Table);

		for (int i = 1; i < 10; i++) {

			TableRow tableRow = new TableRow(this);

			// 倉庫
			TextView textVIew1 = new TextView(this);
			textVIew1.setText("倉庫" + i + "　:");

			// 数量
			TextView textVIew2 = new TextView(this);
			textVIew2.setText("0");

			// 単位
			TextView textVIew3 = new TextView(this);
			textVIew3.setText("個");

			// 引数で幅、高さ指定
			tableRow.addView(textVIew1, 100, 30);
			tableRow.addView(textVIew2);
			tableRow.addView(textVIew3);

			tableLayout.addView(
					tableRow,
					new TableLayout.LayoutParams(
							ViewGroup.LayoutParams.WRAP_CONTENT,
							ViewGroup.LayoutParams.FILL_PARENT));
		}

	}

}
