package jp.sji.kansai.android.demo.manager.activity;

import jp.sji.kansai.android.demo.manager.R;
import jp.sji.kansai.android.demo.manager.util.C2DMManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PushSetUpSelectActivity extends BaseActivity {

	/**
	 * アクティビティが最初に起動する時に実行されるメソッド<br>
	 * <br>
	 * onSaveInstanceStateメソッドで保存された情報がある場合は、<br>
	 * 引数のBundleにその情報が引き渡され、状態を復元させることが可能<br>
	 *
	 * @param savedInstanceState onSaveInstanceStateメソッドで保存された情報
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		//------------------------
		// 初期処理
		//------------------------
		// 親クラスのメソッドを実行
		super.onCreate(savedInstanceState);

		// アクティビティにビューを追加
		setContentView(R.layout.push_setup_select);

		//------------------------
		// 表示データの作成
		//------------------------
		String[] data = {"受信設定", "送信設定"};

		//------------------------
		// 各種オブジェクトを取得
		//------------------------
		ArrayAdapter<String> arrayAdapter
		= new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, data );

		ListView list = (ListView)findViewById( R.id.listView_setupMenu );
		list.setAdapter( arrayAdapter );

		// クリックイベント
		list.setOnItemClickListener(
			new AdapterView.OnItemClickListener(){
				public void onItemClick( AdapterView<?> parent, View view, int position, long id ){

					if (position == 0) {
						// 受信設定の場合
						String registrationId = C2DMManager.getRegistrationId(PushSetUpSelectActivity.this);
						Intent intent = null;
						if ("".equals(registrationId)) {
							intent = new Intent(PushSetUpSelectActivity.this, PushSetUpActivity.class );
						} else {
							intent = new Intent(PushSetUpSelectActivity.this, PushReferActivity.class );
						}
						intent.putExtra(PushSetUpActivity.PARAM_MODE, PushSetUpActivity.MODE_RECV);
						// 次のアクティビティの呼び出し
						startActivity( intent );
					} else {
						// 送信設定の場合
						String registrationId = C2DMManager.getSendEmpNo(PushSetUpSelectActivity.this);
						Intent intent = null;
						if ("".equals(registrationId)) {
							intent = new Intent(PushSetUpSelectActivity.this, PushSetUpActivity.class );
						} else {
							intent = new Intent(PushSetUpSelectActivity.this, PushReferActivity.class );
						}
						intent.putExtra(PushSetUpActivity.PARAM_MODE, PushSetUpActivity.MODE_SEND);
						// 次のアクティビティの呼び出し
						startActivity( intent );
					}

				}
			}
		);
	}

}