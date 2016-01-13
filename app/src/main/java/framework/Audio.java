package framework;

/**
 * This class acts as an Audio interface for the Android Audio class
 */
public interface Audio {

    /**
     * Type: Generator
     * Takes a string parameter and accesses a music file on the system.
     * Creates a Music object and returns it.
     * @param file String containing file location
     * @return Music Object
     * @see Music
     */
    public Music createMusic(String file);

    /**
     * Type: Generator
     * Takes a string parameter and accesses a sound file on the system.
     * Creates a Sound object and returns it.
     * @param file String containing file location
     * @return Sound Object
     * @see Sound
     */
    public Sound createSound(String file);
}