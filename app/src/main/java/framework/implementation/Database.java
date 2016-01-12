package framework.implementation;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by BEN on 17/12/2015.
 */
public class Database {
    //contains all the data of uea locations,buildings etc
    private static ArrayList<MapData> mapData;
    private static ArrayList<ActivityData> activityData;

    static BufferedReader reader;

    public Database(AssetManager am, String path, String app) {
        if (app == "activity") {
            activityData = new ArrayList<>();
            readInfo(am, path, app);
        } else if (app == "map") {
            mapData = new ArrayList<>();
            readInfo(am, path, app);
        }
    }

    //reads all the data from excel
    public static void readInfo(AssetManager am, String path, String app) {
        String line = "";

        try {
            //create file reader

            InputStream stream = am.open(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            //Read the CSV file header to skip it
            reader.readLine();


            //Read the file line by line starting from the second line
            while ((line = reader.readLine()) != null) {

                //Get all tokens available in line
                String[] tokens = line.split("\t");


                if (tokens.length > 0) {
                    //creates the mapdata object
                    if (app == "map"){
                    MapData md = new MapData(tokens[0], tokens[1], Double.parseDouble(tokens[3]), Double.parseDouble(tokens[2]), tokens[4], tokens[5], tokens[6], tokens[7], tokens[8], tokens[9]);

                    mapData.add(md);}
                    else if (app == "activity"){
                        ActivityData ad = new ActivityData(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), tokens[5], tokens[6], tokens[7]);
                    activityData.add(ad);
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }


    }


    public ArrayList<MapData> getMapData() {
        return mapData;
    }

    public void setMapData(ArrayList<MapData> data) {
        this.mapData = data;
    }

    public ArrayList<ActivityData> getActivityData() {
        return activityData;
    }

    public void setActivityData(ArrayList<ActivityData> data) {
        this.activityData = data;
    }

}
