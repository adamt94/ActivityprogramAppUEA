package framework;//package se2.saaf.framework;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.activity.adam.activityprogram.MainActivity;
import com.activity.adam.activityprogram.R;

import java.lang.Override;import java.lang.Runnable;

/**
 * Default Splash Screen Activity
 * Shows UEA Logo and Name
 */
public class Splash extends Activity {

    ImageView UEALogo;
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 2000;
    RelativeLayout layout;
    ImageView iv;
    TextView tv;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //create params
        RelativeLayout.LayoutParams vp =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
                        RelativeLayout.LayoutParams.FILL_PARENT);
        layout = new RelativeLayout(this);
        iv = new ImageView(this);
        tv = new TextView(this);
        layout.addView(iv);
        layout.addView(tv);
        layout.setLayoutParams(vp);
        layout.setBackgroundColor(Color.parseColor("#303F9F"));

        vp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        // vp.topMargin = 450;
        iv.setLayoutParams(vp);
        vp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        vp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        vp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        vp.bottomMargin= 200;
        tv.setTextSize(20);
        tv.setText("University Of East Anglia");
        tv.setTextColor(Color.parseColor("#ffffff"));
        tv.setLayoutParams(vp);

        int resID = getResources().getIdentifier("uealogoalt", "drawable",  getPackageName());
        // tv.setLayoutParams(vp);
        iv.setImageResource(resID);



        setContentView(layout);
        // UEALogo = (ImageView)findViewById(R.id.imageView);

        //  UEALogo.setImageResource(resID);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}