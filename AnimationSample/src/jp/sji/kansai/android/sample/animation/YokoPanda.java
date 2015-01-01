package jp.sji.kansai.android.sample.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class YokoPanda extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.panda);
        Animation anim
        = AnimationUtils.loadAnimation(this, R.anim.runawaypanda);
        ImageView panda = (ImageView) this.findViewById(R.id.panda);
        panda.startAnimation(anim);
    }
}
