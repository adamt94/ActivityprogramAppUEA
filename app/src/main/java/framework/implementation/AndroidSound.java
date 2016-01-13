package framework.implementation;

import android.media.SoundPool;

import framework.Sound;

/**
 * This class implements the Sound interface and keeps Sound within a pool structure
 */
public class AndroidSound implements Sound {
    int soundId;
    SoundPool soundPool;

    /**
     * Constructor - for AndroidSound object
     * assigns a sound a soundId and assigns it to a soundPool
     * @param soundPool Pool to join
     * @param soundId Identifying number
     */
    public AndroidSound(SoundPool soundPool, int soundId) {
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

    @Override
    public void play(float volume) {
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }

    @Override
    public void dispose() {
        soundPool.unload(soundId);
    }

}
