package DataProvider.Classes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * this class is to read all paths for all reader files from a property file.
 */
public class PathReader
{
    public static Properties PathReader =
            loadProperties(System.getProperty("user.dir")+"\\"+"\\src\\main\\java\\DataProvider\\Data\\Path.properties");

    private static Properties loadProperties(String path)
    {
        Properties prop = new Properties();
        // stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            prop.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        }

        return prop;
    }
}
