package jp.sji.kansai.android.sample.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button yoko = (Button)findViewById(R.id.yoko);
        Button tate = (Button)findViewById(R.id.tate);
        Button mawaru = (Button)findViewById(R.id.mawaru);
        Button kieru = (Button)findViewById(R.id.kieru);
        Button dekkakunaru = (Button)findViewById(R.id.dekkakunaru);
        Button kumiawase = (Button)findViewById(R.id.kumiawase);
        Button go = (Button)findViewById(R.id.go);
        Button go2 = (Button)findViewById(R.id.go2);
        Button go3 = (Button)findViewById(R.id.go3);
        Button go4 = (Button)findViewById(R.id.go4);
        
        yoko.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  				Intent intent = new Intent(AnimationSampleActivity.this, YokoPanda.class);
  				startActivity(intent);
  			}
  		});
        tate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  				Intent intent = new Intent(AnimationSampleActivity.this, TatePanda.class);
  				startActivity(intent);
  			}
  		});
        mawaru.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  				Intent intent = new Intent(AnimationSampleActivity.this, RollingPanda.class);
  				startActivity(intent);
  			}
  		});
        kieru.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  				Intent intent = new Intent(AnimationSampleActivity.this, KiePanda.class);
  				startActivity(intent);
  			}
  		});
        dekkakunaru.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  				Intent intent = new Intent(AnimationSampleActivity.this, GiantPanda.class);
  				startActivity(intent);
  			}
  		});
        kumiawase.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  				Intent intent = new Intent(AnimationSampleActivity.this, KumiawasePanda.class);
  				startActivity(intent);
  			}
  		});
        go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  				Intent intent = new Intent(AnimationSampleActivity.this, BigPanda.class);
  				startActivity(intent);
  				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
  		});
        go2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  				Intent intent = new Intent(AnimationSampleActivity.this, BigPanda.class);
  				startActivity(intent);
  				overridePendingTransition(R.anim.come, R.anim.fadeout);
            }
  		});
        go3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  				Intent intent = new Intent(AnimationSampleActivity.this, BigPanda.class);
  				startActivity(intent);
  				overridePendingTransition(R.anim.slide_in_front, R.anim.slide_out_back);
            }
  		});
        go4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  				Intent intent = new Intent(AnimationSampleActivity.this, BigPanda.class);
  				startActivity(intent);
  				overridePendingTransition(R.anim.rolling_in, R.anim.rolling_out);
            }
  		});

    }
}