package framework.implementation;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;

import framework.Image;
import framework.Notification;

/**
 * Created by BEN on 17/12/2015.
 */
public class AndroidNotification implements Notification {

    private Builder builder;
    private NotificationManager manager;
    private Context context;

    public AndroidNotification(Context context) {
        this.context = context;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public void createNotification(int id, String title, String content) {
        builder = new Builder(context);
        builder.setSmallIcon(android.support.v7.appcompat.R.drawable.notification_template_icon_bg);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setAutoCancel(true);
        builder.setCategory(NotificationCompat.CATEGORY_EVENT);
        builder.setDefaults(android.app.Notification.DEFAULT_SOUND);
        builder.setDefaults(android.app.Notification.DEFAULT_VIBRATE);
        Intent rIntent = new Intent();
        manager.notify(id,builder.build());
    }

    @Override
    public void updateNotification(int id, String title, String content){
        builder = new Builder(context);
        builder.setSmallIcon(android.support.v7.appcompat.R.drawable.notification_template_icon_bg);
        if(title != null) builder.setContentTitle(title);
        if(title != null)builder.setContentText(content);
        builder.setDefaults(android.app.Notification.DEFAULT_SOUND);
        builder.setDefaults(android.app.Notification.DEFAULT_VIBRATE);
        builder.setAutoCancel(true);
        Intent rIntent = new Intent();
        manager.notify(id,builder.build());
    }

    @Override
    public void cancelNotificaiton(int id) {
        manager.cancel(id);
    }

    @Override
    public void cancelAll() {
        manager.cancelAll();
    }

    @Override
    public void remind (int time, String title, String message)
    {
        AlarmReceiver rec = new AlarmReceiver();
        context.registerReceiver(rec, new IntentFilter("alarmReciever"));
        Intent alarmIntent = new Intent("alarmReciever");
        alarmIntent.putExtra("message", message);
        alarmIntent.putExtra("title", title);
        PendingIntent pintent = PendingIntent.getBroadcast(context,0,alarmIntent,0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+time, pintent);
    }

    public class AlarmReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("message");
            String title = intent.getStringExtra("title");
            builder = new Builder(context);
            builder.setSmallIcon(android.support.v7.appcompat.R.drawable.notification_template_icon_bg);
            builder.setContentTitle(title);
            builder.setContentText(message);
            builder.setAutoCancel(true);
            builder.setCategory(NotificationCompat.CATEGORY_EVENT);
            builder.setDefaults(android.app.Notification.DEFAULT_SOUND);
            builder.setDefaults(android.app.Notification.DEFAULT_VIBRATE);
            manager.notify(0, builder.build());
        }
    }
}
