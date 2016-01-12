package framework.implementation;

/**
 * Created by callum on 12-Jan-16.
 */

public class ActivityData {
    private String school;
    private int day;
    private int month;
    private int year;
    private int hour;
    private String description;
    private String location;
    private String room;

    public ActivityData(String school, int day, int month, int year, int hour, String description, String location, String room) {
        this.school = school;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.description = description;
        this.location = location;
        this.room = room;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "ActivityData{" +
                "school='" + school + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hour=" + hour +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}