package framework.implementation;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by adam on 09-Jan-16.
 */
public class CampusMap {


    public CampusMap(){}

    //method returns a Cameraposition bt adjusting zoom level with given position
    public CameraPosition defaultCameraPosition(LatLng position){
       return new CameraPosition.Builder()
                .target(position)      // Sets the center of the map to Mountain View
                .zoom(18)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera to east
                .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                .build();
    }


    //uses tileprovider to get uea campus map from url
    public TileProvider getCampusMap(){
        TileProvider tileProvider = new UrlTileProvider(256, 256) {
            @Override
            public URL getTileUrl(int x, int y, int zoom) {

    /* Define the URL pattern for the tile images */
                String s = String.format(" https://www.uea.ac.uk/ueaflatfiles/campusmap/%d/%d/%d.png",
                        zoom, x, y);

                if (!checkTileExists(x, y, zoom)) {
                    return null;
                }

                try {
                    return new URL(s);
                } catch (MalformedURLException e) {
                    throw new AssertionError(e);
                }
            }

            /*
             * Check that the tile server supports the requested x, y and zoom.
             * Complete this stub according to the tile range you support.
             * If you support a limited range of tiles at different zoom levels, then you
             * need to define the supported x, y range at each zoom level.
             */
            private boolean checkTileExists(int x, int y, int zoom) {
                int minZoom = 15;
                int maxZoom = 21;

                if ((zoom < minZoom || zoom > maxZoom)) {
                    return false;
                }

                return true;
            }
        };
        return tileProvider;
    }



}
