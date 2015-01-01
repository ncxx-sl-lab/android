package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：通知履歴個別
 * クラス名：NoticeDetailActivity
 */

import jp.sji.kansai.android.demo.manager.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoticeDetailActivity extends BaseActivity {
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.noticedetail);
        
        super.onCreate(savedInstanceState,R.layout.noticedetail);
        
        Button toReEntryButton = (Button)this.findViewById(R.id.ReEntryButton);    
     
        
        toReEntryButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
                // 通知入力アクティビティの呼び出し
				Intent intent = new Intent(NoticeDetailActivity.this, jp.sji.kansai.android.demo.manager.activity.NoticeEntryActivity.class);
				intent.putExtra("FROMBUYERID", "バイヤー１");
				intent.putExtra("SELECTMATERIALID", "CENTURY(センチュリー) CL-SU13TV1B MEZZO(メッツォ) ハイビジョン液晶テレビ 13V型");
				intent.putExtra("SELECTMATERIALCOUNT", "100");
				startActivity(intent);
			}
        });
        

       
        
    }

    
}