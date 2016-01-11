package framework;

/**
 * Created by Callum on 06/11/2015.
 */
public abstract class FrameworkCopyright {

    private String CopyrightText = "This application is based on the Simple Android Application" +
            " Framework. (c) University of East Anglia 2015";
    protected abstract String getAppCopyright();

    public final String getCopyright(){
        return CopyrightText = "\n\n" + getAppCopyright();
    }


}

