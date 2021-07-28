package pages;
import DataProvider.Classes.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    /*
    * this is to open the website home page
     */
    public void openHomePage() throws IOException {
        // get data from Excel Reader class
        ExcelReader ER = new ExcelReader();
        String URL = ER.getExcelData();
        driver.get(URL);
    }

    /*
    * this function is to take a screenshot of the home page
     */
    public void takesScreenshotsOfHomePage() {
        Helper.takeScreenShot("Home_Page", driver);
    }

    /*
    * this function is to start the sign up process
     */
    public void signUp() {
        String signUPlocator = Helper.readFromElementPropertyFile("signIn");
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(signUPlocator))));
        driver.findElement(By.xpath(signUPlocator)).click();
    }

}
