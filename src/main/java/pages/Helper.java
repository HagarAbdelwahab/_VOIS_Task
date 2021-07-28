package pages;

import DataProvider.Classes.ElementReader;
import DataProvider.Classes.UserCredentialsReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class Helper {
    WebDriver driver;

    public static void hoverToElement(String locator, WebDriver driver) {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.xpath(locator));
        actions.moveToElement(target).perform();
    }

    public static String readFromElementPropertyFile(String locatorName)
    {
        String locator =  ElementReader.ElementLocator.getProperty(locatorName);
        return locator;
    }

    public static String readFromCredentialsPropertyFile(String InputField)
    {
        String input = UserCredentialsReader.inputField.getProperty(InputField);
        return input;
    }
    public static void scrollToElement(String locator, WebDriver driver)
    {
        WebElement element=driver.findElement(By.xpath(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

    }
    public static void takeScreenShot(String page, WebDriver driver)
    {
        //cast your driver object into a screenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //add path to file, this file is at project directory, from which we can copy the SrcFile to another directory
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination at screenshots folder
        File DestFile=new File(System.getProperty("user.dir")+"\\screenshots\\"+page);

        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
