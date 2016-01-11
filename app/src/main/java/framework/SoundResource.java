package framework;

/**
 * Created by Callum on 30/10/2015.
 */

import framework.implementation.AndroidAudio;
import android.app.Activity;
public class SoundResource {

    private Audio MyAudio;
    private Sound MySound;

    public SoundResource(Activity Act){
        MyAudio = new AndroidAudio(Act);
    }

    public void load(String resourcePath){
        MySound = MyAudio.createSound(resourcePath);
    }

    public void play(){
        MySound.play((float)0.9);
    }

    public void stop(){
        MySound.stop();
    }
}
