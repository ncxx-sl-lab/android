package jp.sji.kansai.android.demo.buyer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.WindowManager.LayoutParams;

public class LoginActivity extends BuyerDemoActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);  
        setContentView(R.layout.login);
        

        Button toLoginButton = (Button)this.findViewById(R.id.LoginButton);

        toLoginButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// インテントの生成
				Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);

				// 次のアクティビティの呼び出し
				startActivity(intent);
			}
		});

    }
    
}