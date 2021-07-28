package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AfterRegistration {
    WebDriver driver;

    public  AfterRegistration(WebDriver driver) {
        this.driver=driver;
    }

    /*
    * this function is to hover over the women menu
     */
    public void hoverToWomenMenu() {
        Helper.takeScreenShot("After Registration Page",driver);
        String women = Helper.readFromElementPropertyFile("women");
        Helper.hoverToElement(women,driver);
    }

    /*
    * to choose blouse category in women menu
     */
    public void chooseBlouse() {
        String blousesLocator = Helper.readFromElementPropertyFile("blouses");
        driver.findElement(By.xpath(blousesLocator)).click();
    }
}
