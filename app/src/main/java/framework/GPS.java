package framework;

import android.location.Location;

/**
 * Created by BEN on 17/12/2015.
 * Interface for getting location
 */
public interface GPS{

    public Location getLocation();

    public void enableLocation();

    public void disableLocation();
}
