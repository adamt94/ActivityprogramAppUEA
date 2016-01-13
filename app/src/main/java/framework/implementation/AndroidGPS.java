package framework.implementation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import framework.GPS;
/**
 * Created by BEN on 17/12/2015.
 *
 */
public class AndroidGPS implements GPS {
    private boolean GPS = false;
    private LocationManager locationManager;
    private AndroidLocationListener locationListener;
    private Activity activity;

    public AndroidGPS(Activity activity) {
        // Acquire a reference to the system Location Manager
        locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new AndroidLocationListener();
        this.activity = activity;
    }

    private class AndroidLocationListener implements LocationListener {

        Location myLocation = new Location(LocationManager.NETWORK_PROVIDER);

        @Override
        public void onLocationChanged(Location location) {
            myLocation = location;
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    }

    @Override
    public Location getLocation() {
        return locationListener.myLocation;
    }

    @Override
    public void enableLocation() {
        GPS = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (GPS) {
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(activity, "Permission Not Granted", Toast.LENGTH_SHORT).show();
            } else {
                locationManager.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER, 5000, 10, locationListener);
            }
        } else {
            Toast.makeText(activity, "GPS unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void disableLocation() {
        GPS = false;
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(activity, "Permission Not Granted", Toast.LENGTH_SHORT).show();
        }
        else {
            locationManager.removeUpdates(locationListener);
        }
    }


}
