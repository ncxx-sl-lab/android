package jp.sji.kansai.android.demo.manager.activity;

import jp.sji.kansai.android.demo.manager.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SeniSakiActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

//		outputLog("onCreate");

		//------------------------
		// 初期処理
		//------------------------
		// 親クラスのメソッドを実行
		super.onCreate(savedInstanceState);

		// アクティビティにビュー(main.xml)を追加
		setContentView(R.layout.senisaki);

		//------------------------
		// 各種オブジェクトを取得
		//------------------------
		// [次へ]ボタンのオブジェクトを取得
		Button buttonNext = (Button)this.findViewById(R.id.button_next);

		// テキストボックスのオブジェクトを取得
		final EditText textInput = (EditText)this.findViewById(R.id.editText_input);

		// テキストボックスにインテント文字列表示
		Intent intent = this.getIntent();
		textInput.setText(intent.getExtras().getString("INPUT_PARAM"));


		//------------------------
		// ボタンの動作設定
		//------------------------
		// [次へ]ボタン
		buttonNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
/*
 * 				// インテントの生成

				Intent intent = new Intent(SeniSakiActivity.this, HellomapActivity.class);

				// パラメータの設定(次画面に引き継ぐパラメータを設定)
				intent.putExtra("INPUT_PARAM", textInput.getText().toString());

				// 次のアクティビティの呼び出し
				startActivity(intent);
*/
				finish();
				}
		});
	}




}