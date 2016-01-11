package se2.saaf.framework;

import se2.saaf.framework.implementation.Database;

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

    public Database getDatabase();
}
