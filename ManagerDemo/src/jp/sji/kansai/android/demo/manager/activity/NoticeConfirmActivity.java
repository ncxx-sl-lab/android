package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：通知内容確認
 * クラス名：NoticeConfirmActivity
 */

import jp.sji.kansai.android.demo.manager.R;
import jp.sji.kansai.android.demo.manager.costants.PropertyConstants;
import jp.sji.kansai.android.demo.manager.util.APServerManager;
import jp.sji.kansai.android.demo.manager.util.C2DMManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoticeConfirmActivity extends BaseActivity {

	static final int DIALOG_SEND_YES_NO = 0;
	static final int DIALOG_CANCEL_YES_NO = 1;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.noticeconfirm);

        super.onCreate(savedInstanceState,R.layout.noticeconfirm);

        Button toSendButton = (Button)this.findViewById(R.id.SendButton);
        Button toCancelButton = (Button)this.findViewById(R.id.CancelButton);

        toSendButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//showToast("作成中です");
				showDialog(DIALOG_SEND_YES_NO);
			}
        });

        toCancelButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//showToast("作成中です");
				//showDialog(DIALOG_CANCEL_YES_NO);
				finish();
			}
        });

    }

	/**
	 *
	 */
    protected Dialog onCreateDialog(int id){
    	switch(id){
    		case DIALOG_SEND_YES_NO:
	    		return new AlertDialog.Builder(this)
	    		.setTitle("送信確認")
	    		.setMessage("この内容で通知します。\nよろしいですか？")

	    		.setPositiveButton("はい", new DialogInterface.OnClickListener(){
	    			public void onClick(DialogInterface dialog, int whichButton){

	    				if ("true".equals(PropertyConstants.PUSH_ENABLE.toLowerCase())) {
	    					//-------------------------------
	    					// プッシュ通知使用する場合
	    					//-------------------------------
	    					// プッシュ通知送信対象の社員番号の取得
	    					String sendEmpNo = C2DMManager.getSendEmpNo(NoticeConfirmActivity.this);

	    					if ("".equals(sendEmpNo)) {
	    						showSimpleAlert("エラー", "プッシュ通知の送信先が設定されていません。");
	    						return;
	    					}

	    					try {
	    						// APサーバーにプッシュ通知を依頼する。
	    						APServerManager.push(NoticeConfirmActivity.this, sendEmpNo, C2DMManager.getEmpNo(NoticeConfirmActivity.this));
	    					} catch (Exception ex) {
	    						showSimpleAlert("エラー", "プッシュ通知に失敗しました。");
	    					}
	    				}

	    				showToast("通知を完了しました。");
	    				Intent intent = new Intent(NoticeConfirmActivity.this, jp.sji.kansai.android.demo.manager.activity.MaterialListActivity.class);
//	    				intent.putExtra("ITEMCD", item);
	    				startActivity(intent);
	    				finish();
	    			}
	    		})
	    		.setNegativeButton("いいえ", new DialogInterface.OnClickListener(){
	    			public void onClick(DialogInterface dialog, int whichButton){
	    			}
	    		})
	    		.create();
    		case DIALOG_CANCEL_YES_NO:
	    		return new AlertDialog.Builder(this)
	    		.setTitle("中止確認")
	    		.setMessage("この通知を中止します。\nよろしいですか？")

	    		.setPositiveButton("はい", new DialogInterface.OnClickListener(){
	    			public void onClick(DialogInterface dialog, int whichButton){
	    				finish();
	    			}
	    		})
	    		.setNegativeButton("いいえ", new DialogInterface.OnClickListener(){
	    			public void onClick(DialogInterface dialog, int whichButton){
	    			}
	    		})
	    		.create();

    	}
		return null;
    }

}