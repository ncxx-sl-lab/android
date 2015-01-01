package jp.sji.kansai.android.sample.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class KumiawasePanda extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.pandas);
        Animation anim1
        = AnimationUtils.loadAnimation(this, R.anim.rollingpanda2);
        ImageView panda1 = (ImageView) this.findViewById(R.id.panda1);
        panda1.startAnimation(anim1);
        
        Animation anim2
        = AnimationUtils.loadAnimation(this, R.anim.fadeinpanda);
        ImageView panda2 = (ImageView) this.findViewById(R.id.panda2);
        panda2.startAnimation(anim2);
        
        Animation anim3
        = AnimationUtils.loadAnimation(this, R.anim.falldownpanda2);
        ImageView panda3 = (ImageView) this.findViewById(R.id.panda3);
        panda3.startAnimation(anim3);
    }
}
