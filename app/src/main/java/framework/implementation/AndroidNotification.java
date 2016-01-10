package framework.implementation;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
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
    private int id;
    private String contentTitle;
    private String contentText;
    private Image icon;

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
        Intent rIntent = new Intent();
        manager.notify(id,builder.build());
    }

    @Override
    public void updateNotification(int id, String title, String content){
        builder = new Builder(context);
        builder.setSmallIcon(android.support.v7.appcompat.R.drawable.notification_template_icon_bg);
        if(title != null) builder.setContentTitle(title);
        if(title != null)builder.setContentText(content);
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
}
