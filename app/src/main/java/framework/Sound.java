package framework;

/**
 * Interface for playing and disposing of sounds
 */
public interface Sound {
    /**
     * Method to play a sound object at a certain volume
     * @param volume Volume for sound to be played at
     */
    public void play(float volume);

    /**
     * Get rid of sound object
     */
    public void dispose();
}
