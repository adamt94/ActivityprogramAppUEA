package se2.saaf.framework;

/**
 * Created by BEN on 17/12/2015.
 *  use alarm manager TODO!
 */
public interface Notification {

    public void createNotification(int id, String title, String content);

    public void updateNotification(int id, String title, String content);

    public void cancelNotificaiton(int id);

    public void cancelAll();
}
