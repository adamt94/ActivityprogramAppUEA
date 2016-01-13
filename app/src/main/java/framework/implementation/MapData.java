package framework.implementation;

/**
 * Created by adam on 29-Dec-15.
 * Used in database to store locaiton instances with more information
 */
public class MapData {
    private String type;
    private String name;
    //these two should be put into a Location object
    private double latitude;
    private double longitude;
    private String id;
    private String facility;
    private String description;
    private String abbr;
    private String openingTimes;
    private int image;
    private String link;
    public MapData(String type, String name, double longitude, double latitude, String id,
                   String facility, String description, String abbr, String openingTimes, String link) {
        this.type = type;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id = id;
        this.facility = facility;
        this.description = description;
        this.abbr = abbr;
        this.openingTimes = openingTimes;

        this.link = link;
    }
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getFacility() {
        return facility;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }

    public int getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public void setOpeningTimes(String openingTimes) {
        this.openingTimes = openingTimes;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MapData{" + "type=" + type + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude +
                ", id=" + id + ", facility=" + facility + ", description=" + description + ", abbr=" + abbr + ", openingTimes=" + openingTimes +
                ", image=" + image + ", link=" + link + '}';
    }






}