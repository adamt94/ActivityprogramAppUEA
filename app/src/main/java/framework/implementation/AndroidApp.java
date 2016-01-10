package framework.implementation;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.PowerManager;

import framework.App;
import framework.Audio;
import framework.FileIO;
import framework.GPS;
import framework.Graphics;
import framework.Input;
import framework.Notification;

/**
 * Created by BEN on 17/12/2015.
 */
public class AndroidApp implements App{
    private Activity activity;
    private Graphics graphics;
    private Audio audio;
    private Input input;
    private FileIO fileIO;
    private Notification notification;
    private GPS gps;
    private PowerManager.WakeLock wakeLock;

    public AndroidApp(Activity activity) {
        this.activity = activity;
      //  graphics = new AndroidGraphics(activity.getAssets(), );
        audio = new AndroidAudio(activity);
        //input = new AndroidInput();
        fileIO = new AndroidFileIO(activity);
        notification = new AndroidNotification(activity);
        gps = new AndroidGPS(activity);

    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Notification getNotification() {
        return notification;
    }

    @Override
    public GPS getGPS() {
        return gps;
    }
}
