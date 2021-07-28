package DataProvider.Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UserCredentialsReader {
    /*
     *Load the properties file from the location specified at the path reader property file to locate different element
     * locators
     */
    public static Properties inputField =
            loadProperties(System.getProperty("user.dir")+PathReader.PathReader.getProperty("UserCredentials"));
    private static Properties loadProperties(String path)
    {
        Properties property = new Properties();
        // stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            property.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        }

        return property;
    }
}
