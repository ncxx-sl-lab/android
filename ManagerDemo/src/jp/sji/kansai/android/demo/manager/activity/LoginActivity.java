package jp.sji.kansai.android.demo.manager.activity;

import jp.sji.kansai.android.demo.manager.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

public class LoginActivity extends BaseActivity {
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