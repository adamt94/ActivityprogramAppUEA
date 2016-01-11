package framework;

import android.location.Location;

/**
 * Created by BEN on 17/12/2015.
 */
public class AndroidLocation{

    private String title;
    private String description;
    private Location location;

    public AndroidLocation(Location location) {
        this.location = location;
    }

    public AndroidLocation(Location location, String title) {
        this.location = location;
        this.title = title;
    }

    public AndroidLocation(Location location, String title, String description) {
        this.location = location;
        this.title = title;
        this.description = description;
    }

    public double getLongitude(){ return location.getLongitude(); }

    public double getLatitude(){ return location.getLatitude(); }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
