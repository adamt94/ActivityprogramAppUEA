package framework;

import framework.Graphics.ImageFormat;

/**
 * This interface handles images
 */
public interface Image {

    /**
     * get width of the image
     * @return width int
     */
    public int getWidth();

    /**
     * get height of the image
     * @return height int
     */
    public int getHeight();

    /**
     * get the image format
     * @return ImageFormat
     */
    public ImageFormat getFormat();

    /**
     * Dispose of image
     */
    public void dispose();
}
