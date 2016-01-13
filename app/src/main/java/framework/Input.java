package framework;

import java.util.List;

/**
 * Interface for handling touch input
 */
public interface Input {

    /**
     * Class for tracking a single touch event on the screen
     */
    public static class TouchEvent {
        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGED = 2;
        public static final int TOUCH_HOLD = 3;

        public int type;
        public int x, y;
        public int pointer;
    }

    /**
     * Checks if screen is being pressed
     * @param pointer
     * @return boolean
     */
    public boolean isTouchDown(int pointer);

    /**
     * Gets x parameter of where on the screen was pressed
     * @param pointer
     * @return x posiiton
     */
    public int getTouchX(int pointer);

    /**
     * Gets y parameter of where on the screen was pressed
     * @param pointer
     * @return y position
     */
    public int getTouchY(int pointer);

    /**
     * Returns the list of all current touch events as a List
     * @return List of TouchEvents
     */
    public List<TouchEvent> getTouchEvents();
}
