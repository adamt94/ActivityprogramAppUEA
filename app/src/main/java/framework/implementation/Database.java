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
    private static ArrayList<MapData> data;

    static BufferedReader reader;

    public Database(AssetManager am,String path){
        data = new ArrayList<>();
        getinfo(am,path);
    }

    //reads all the data from excel
    public static void getinfo(AssetManager am,String path){
        String line ="";

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
                    MapData md = new MapData(tokens[0], tokens[1], Double.parseDouble(tokens[3]), Double.parseDouble(tokens[2]), tokens[4], tokens[5], tokens[6], tokens[7], tokens[8], tokens[9]);

                    data.add(md);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }



    }



    public ArrayList<MapData> getData() {
        return data;
    }

    public void setData(ArrayList<MapData> data) {
        this.data = data;
    }

}
