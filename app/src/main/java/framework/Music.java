package framework;

/**
 * An interface for handling music
 */
public interface Music {

    /**
     * Plays track
     */
    public void play();

    /**
     * Stops Playing
     */
    public void stop();

    /**
     * Pauses Track
     */
    public void pause();

    /**
     * Set looping either on or off
     * @param looping on or off
     */
    public void setLooping(boolean looping);

    /**
     * Set playback volume
     * @param volume
     */
    public void setVolume(float volume);

    /**
     * check if file is playing
     * @return if it is playing
     */
    public boolean isPlaying();

    /**
     * check if file has stopped playing
     * @return if it has stopped
     */
    public boolean isStopped();

    /**
     * check if file is looping
     * @return
     */
    public boolean isLooping();

    /**
     * Dispose of file
     */
    public void dispose();

    /**
     * Sets position of player to begining of file
     */
    void seekBegin();
}