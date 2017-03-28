package utility;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Created by FlavianDurigu on 3/28/2017.
 */
public class Log {

    //initialize Log4j logs
    private static Logger Log = Logger.getLogger(Log.class.getName());


    //this is to print log for the beginning of the test case
    public static void startTestCase (String sTestCaseName){
        Log.info("****************************************************************************************");
        Log.info("$$$$$$$$$$$$$$$$$$$$$$$$$             "+sTestCaseName+"        $$$$$$$$$$$$$$$$$$$$$$$$$");
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
    }

    //this is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName){
        Log.info("XXXXXXXXXXXXXXXXXXXXXXXXX              "+"-E---N---D-"+"       XXXXXXXXXXXXXXXXXXXXXXXXX");
        Log.info("X");
        Log.info("X");
        Log.info("X");
        Log.info("X");
    }

    // Need to create these methods, so that they can be called
    public static void info(String message) {
       Log.info(message);
    }

    public static void warn(String message) {
       Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }
}
