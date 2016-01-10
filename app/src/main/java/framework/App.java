package framework;

/**
 * Created by BEN on 17/12/2015.
 */
public interface App {

    public Audio getAudio();

    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public Notification getNotification();

    public GPS getGPS();
}
