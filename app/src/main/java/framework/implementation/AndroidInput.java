package framework.implementation;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

import java.util.List;

import framework.Input;

/**
 * This class implements the Input interface and handles all user input to the application
 */
public class AndroidInput implements Input {    
    TouchHandler touchHandler;

    /**
     * Constructor - for the AndroidInput object
     * Either assigns a single or multiple touch handler to the program based off of compatibility
     * @param context Details about application
     * @param view View to monitor
     * @param scaleX X size
     * @param scaleY Y size
     */
    public AndroidInput(Context context, View view, float scaleX, float scaleY) {
        if(Integer.parseInt(VERSION.SDK) < 5) 
            touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
        else
            touchHandler = new MultiTouchHandler(view, scaleX, scaleY);        
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
    
}
