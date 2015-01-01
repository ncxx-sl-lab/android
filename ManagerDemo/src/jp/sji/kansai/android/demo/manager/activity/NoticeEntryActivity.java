package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：通知内容確認
 * クラス名：NoticeConfirmActivity
 */

import jp.sji.kansai.android.demo.manager.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NoticeEntryActivity extends BaseActivity {
	
	static final int DIALOG_SEND_YES_NO = 0;
	static final int DIALOG_CANCEL_YES_NO = 1;
	
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.noticeentry);
        
        super.onCreate(savedInstanceState,R.layout.noticeentry);

        Button toSendButton = (Button)this.findViewById(R.id.SendButton);
//        Button toSelectButton = (Button)this.findViewById(R.id.SelectButton);

//       toSelectButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				showToast("バイヤー検索画面を表示する");
//			}
//        });

        
        // 画面遷移元の情報をもとに初期表示を行う

		Intent intent = this.getIntent();

		TextView txtFromBuyerID = (TextView)this.findViewById( R.id.FromBuyerID );
		TextView txtSelectMaterialID = (TextView)this.findViewById( R.id.SelectMaterialID );
		TextView txtSelectMaterialCount = (TextView)this.findViewById( R.id.SelectMaterialCount );
		
		txtFromBuyerID.setText( intent.getExtras().getString("FROMBUYERID") );        
		txtSelectMaterialID.setText( intent.getExtras().getString("SELECTMATERIALID") );
		txtSelectMaterialCount.setText( intent.getExtras().getString("SELECTMATERIALCOUNT") );
        
        
        
        toSendButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// 通知内容確認アクティビティの呼び出し
				Intent intent = new Intent(NoticeEntryActivity.this, jp.sji.kansai.android.demo.manager.activity.NoticeConfirmActivity.class);
				startActivity(intent);
			}
        });

        
    }
    
    public void clickFromBuyerID(View v){
    	showToast("通知バイヤーを選択する一覧画面を表示する");
    }
    
    public void clickSelectMaterialID(View v){
    	showToast("品目を選択する一覧画面を表示する");
    }
    
    public void clickSelectMaterialCount(View v){
    	showToast("数量を入力できるダイアログを表示する");
    }
    
    public void clickComments(View v){
    	showToast("コメントを入力できるダイアログを表示する");
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
	    				showToast("通知を完了しました。");
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
	    		.setTitle("確認")
	    		.setMessage("入力を中止します。\nよろしいですか？")
	    		
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