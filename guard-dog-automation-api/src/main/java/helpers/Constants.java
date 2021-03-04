package helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Constants {


    public static String USER_TOKEN = "[USER_TOKEN]";
    public static String REFRESH_TOKEN = "[REFRESH_TOKEN]";
    public static String USER_PASSWORD;

    public static String User_Name;

    static {
        try {
            User_Name = getPropValues("UserName");
            USER_PASSWORD = getPropValues("Password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPropValues(final String key) throws IOException {
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();

            inputStream = Constants.class.getClassLoader().getResourceAsStream("config.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file 'config.properties' not found in the classpath");
            }

            return prop.getProperty(key);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return null;
    }
}
