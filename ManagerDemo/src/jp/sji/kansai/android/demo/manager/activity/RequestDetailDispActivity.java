package jp.sji.kansai.android.demo.manager.activity;

/**
 * 画面名　：承認履歴個別（照会）
 * クラス名：RequestDetailDispActivity
 */

import jp.sji.kansai.android.demo.manager.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RequestDetailDispActivity extends BaseActivity {
	
	
	static final int DIALOG_SEND_YES_NO = 0;
	static final int DIALOG_CANCEL_YES_NO = 1;
	
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.requestdetaildisp);
        
        super.onCreate(savedInstanceState,R.layout.requestdetaildisp);
        
        Button toHistryButton = (Button)this.findViewById(R.id.HistoryButton);    
        Button toOkButton = (Button)this.findViewById(R.id.OkButton);
        Button toNgButton = (Button)this.findViewById(R.id.NgButton);
       
        
        toHistryButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showToast("承認履歴をフィルタして表示だが。本文リンクがいいか？");
			}
        });
        
        
        toOkButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_SEND_YES_NO);
			}
        });
        
        toNgButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showToast("却下処理を行うボタンです");
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
	    		.setTitle("承認確認")
	    		.setMessage("この依頼を承認します。\nよろしいですか？")
	    		
	    		.setPositiveButton("はい", new DialogInterface.OnClickListener(){
	    			public void onClick(DialogInterface dialog, int whichButton){
	    				showToast("承認を完了しました。");
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
	    		.setTitle("却下確認")
	    		.setMessage("この依頼を却下します。\nよろしいですか？")
	    		
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