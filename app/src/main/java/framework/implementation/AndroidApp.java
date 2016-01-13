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
    private Database database;
    private PowerManager.WakeLock wakeLock;

    public AndroidApp(Activity activity) {
        this.activity = activity;
        graphics = new AndroidGraphics(activity.getAssets(), Bitmap.createBitmap(480,800, Bitmap.Config.RGB_565));
        audio = new AndroidAudio(activity);
        input = new AndroidInput(activity,activity.getCurrentFocus(),480/ activity.getWindowManager().getDefaultDisplay().getWidth(),800/ activity.getWindowManager().getDefaultDisplay().getWidth());
        fileIO = new AndroidFileIO(activity);
        notification = new AndroidNotification(activity);
        gps = new AndroidGPS(activity);
        database = new Database(activity.getAssets(),"", "");
        PowerManager powerManager = (PowerManager) activity.getSystemService(activity.getApplicationContext().POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "MyGame");
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

    @Override
    public Database getDatabase() {
        return database;
    }


}