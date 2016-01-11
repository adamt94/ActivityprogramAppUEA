//package se2.saaf.framework;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.widget.ImageView;
//
//import com.activity.adam.locationfinder.MainActivity;
//import com.activity.adam.locationfinder.R;
//
//import java.lang.Override;import java.lang.Runnable;
//
//public class Splash extends Activity {
//
//    ImageView UEALogo;
//    /** Duration of wait **/
//    private final int SPLASH_DISPLAY_LENGTH = 3000;
//
//
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle icicle) {
//        super.onCreate(icicle);
//        setContentView(R.layout.activity_splash);
//        UEALogo = (ImageView)findViewById(R.id.imageView);
//        int resID = getResources().getIdentifier("UEALogoFull.png", "assets",  getPackageName());
//        UEALogo.setImageResource(resID);
//
//        /* New Handler to start the Menu-Activity
//         * and close this Splash-Screen after some seconds.*/
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                /* Create an Intent that will start the Menu-Activity. */
//                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
//                Splash.this.startActivity(mainIntent);
//                Splash.this.finish();
//            }
//        }, SPLASH_DISPLAY_LENGTH);
//    }
//}