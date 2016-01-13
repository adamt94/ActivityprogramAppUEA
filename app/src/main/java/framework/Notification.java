package framework;

/**
 * Created by BEN on 17/12/2015.
 * Interface for setting/updating/canceling notifications
 */
public interface Notification {

    public void createNotification(int id, String title, String content);

    public void updateNotification(int id, String title, String content);

    public void cancelNotificaiton(int id);

    public void cancelAll();

    public void remind(int time, String title, String message);
}
