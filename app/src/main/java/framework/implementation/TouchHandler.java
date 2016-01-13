package framework.implementation;

import android.view.View.OnTouchListener;

import java.util.List;

import framework.Input.TouchEvent;

/**
 * This interface provides handling for dealing with touching the screen
 */
public interface TouchHandler extends OnTouchListener {

    /**
     * Getter - returns if the screen is being pressed at the pointer
     * @param pointer instance to check
     * @return boolean
     */
    public boolean isTouchDown(int pointer);

    /**
     * Getter - returns the x position of the touch location
     * @param pointer instance to check
     * @return int x position
     */
    public int getTouchX(int pointer);

    /**
     * Getter - returns the y position of the touch location
     * @param pointer instance to check
     * @return int y position
     */
    public int getTouchY(int pointer);

    /**
     * Getter - returns a  list of all current touch events
     * @return List (TouchEvent)
     */
    public List<TouchEvent> getTouchEvents();
}
