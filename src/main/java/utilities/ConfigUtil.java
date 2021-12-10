package utilities;
import utilities.readers.PropertiesReader;

public class ConfigUtil {
    public static String Web_URL;
    //=====================================================
    public static void loadTestConfigurations() {
        PropertiesReader reader = new PropertiesReader( "config.properties");
        Web_URL = reader.getPropertyUsingKey("Web_URL");
    }
}
