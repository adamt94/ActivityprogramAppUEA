package framework;

import android.graphics.Paint;

/**
 * This interface allows for various display funcitons to be called
 */
public interface Graphics {

    /**
     * Type: Enum
     * Enumerated values for various image formats in order to make code
     * more readable and to ensure conformity to the allowed types
     * @see Graphics.ImageFormat
     */
    public static enum ImageFormat {
        ARGB8888, ARGB4444, RGB565
    }

    /**
     * Type: Generator
     * Generates an Image object from the Strign location and ImageFormat
     * @param fileName String location of image
     * @param format Type of image file
     * @return Image
     * @see Image
     */
    public Image newImage(String fileName, ImageFormat format);

    /**
     * Type: Drawable
     * Clears the screen to a particular colour
     * @param color integer colour value to be cleared to
     */
    public void clearScreen(int color);

    /**
     * Type: Drawable
     * The draw method for a single line from point (x,y) to point (x2, y2) of colour "color"
     * @param x integer x position
     * @param y integer y position
     * @param x2 integer x position
     * @param y2 integer y position
     * @param color int colour value
     */
    public void drawLine(int x, int y, int x2, int y2, int color);

    /**
     * Type: Drawable
     * The draw method for a single rectangle from point (x,y) to point (x2, y2) of colour "color"
     * @param x integer x position
     * @param y integer y position
     * @param width integer x position
     * @param height integer y position
     * @param color int colour value
     */
    public void drawRect(int x, int y, int width, int height, int color);

    /**
     * Type: Drawable
     * The draw method for drawing a re-sizad image
     * @param image Image to be drawn
     * @param x X position to be drawn at
     * @param y Y position to be drawn at
     * @param srcX original image X pos to take from
     * @param srcY original image Y pos to take from
     * @param srcWidth original image width
     * @param srcHeight original image height
     */
    public void drawImage(Image image, int x, int y, int srcX, int srcY,
                          int srcWidth, int srcHeight);

    /**
     * Type: Drawable
     * Draw image at the specified (X,Y) co-ordinates as the bottom left
     * @param Image Image to be drawn
     * @param x X position
     * @param y Y position
     */
    public void drawImage(Image Image, int x, int y);

    /**
     * Type: Drawable
     * Draw a string at the coordinates (X,Y)
     * @param text String to be drawn
     * @param x X position
     * @param y Y position
     * @param paint Style and colour information
     */
    void drawString(String text, int x, int y, Paint paint);

    /**
     * Type: Getter
     * Returns the framebuffer width
     * @return framebuffer width
     */
    public int getWidth();

    /**
     * Type: Getter
     * Returns the framebuffer height
     * @return framebuffer height
     */
    public int getHeight();

    /**
     * Type: Drawable
     * Fill the entire canvas' bitmap with the specified ARGB color
     * @param i A value
     * @param j R Value
     * @param k G Value
     * @param l B Value
     */
    public void drawARGB(int i, int j, int k, int l);
}
