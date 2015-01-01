package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：通知品目個別
 * クラス名：MaterialDetailActivity
 */

import jp.sji.kansai.android.demo.manager.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MaterialDetailActivity extends BaseActivity {

	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {

//    	super.onCreate(savedInstanceState);
//        setContentView(R.layout.materialdetail);
        
        super.onCreate(savedInstanceState,R.layout.materialdetail);
        
        Button toSelectButton = (Button)this.findViewById(R.id.SelectButton);
         
        toSelectButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// 通知入力アクティビティの呼び出し
				Intent intent = new Intent(MaterialDetailActivity.this, jp.sji.kansai.android.demo.manager.activity.NoticeEntryActivity.class);
				intent.putExtra("SELECTMATERIALID", "CENTURY(センチュリー) CL-SU13TV1B MEZZO(メッツォ) ハイビジョン液晶テレビ 13V型");
				startActivity(intent);
			}
        });

        
       

    }
    
}