package framework;

import android.content.SharedPreferences;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class acts as a File Input Output interface for the Android FileIO class
 */
public interface FileIO {
    /**
     * Type: Generator
     * This method takes a string location of an input file and creates an input stream
     * @param file String location of the input file
     * @return An InputStream from the file
     * @throws IOException If (file does not exist / could not be read) error is returned
     */
    public InputStream readFile(String file) throws IOException;

    /**
     * Type: Generator
     * This method takes a string location of an output file and creates an output stream
     * @param file String location of the output file
     * @return An OutputStream from the file
     * @throws IOException If (file does not exist / could not be read) error is returned
     */
    public OutputStream writeFile(String file) throws IOException;

    /**
     * Type: Generator
     * This method takes a string location of an asset and creates an input stream
     * @param file
     * @return An InputStream from the asset
     * @throws IOException
     */
    public InputStream readAsset(String file) throws IOException;

    /**
     * Type : Getter
     * A getter method for the SharedPreferences of the class
     * @return SharedPreferences of the class
     */
    public SharedPreferences getSharedPref();
}
