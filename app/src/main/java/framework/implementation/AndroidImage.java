package framework.implementation;

import android.graphics.Bitmap;

import framework.Graphics.ImageFormat;
import framework.Image;

/**
 * This class implements the Image interface and handles the Images within the application
 */
public class AndroidImage implements Image {
    Bitmap bitmap;
    ImageFormat format;

    /**
     * Constructor - for an AndroidImage object
     * @param bitmap Image data
     * @param format format of th edata being passed in
     */
    public AndroidImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }      
}
