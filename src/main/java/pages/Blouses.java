package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Blouses {
    WebDriver driver;
    public Blouses(WebDriver driver) {
        this.driver=driver;
    }
    String addLocator;

    /*
    * scroll to selected blouse
     */
    public void scrollToBlouse()
    {
        String inStock = Helper.readFromElementPropertyFile("inStock");
        Helper.scrollToElement(inStock,driver);
    }

    /*
    * move to the blouse image by mouse hovering
     */
    public void hoverToBlouseImg() {
        //hover and then click
        String blouseImg = Helper.readFromElementPropertyFile("blouseImage");
        Helper.hoverToElement(blouseImg, driver);
    }

    /*
    * add the available blouse to cart
     */
    public void addToCart()
    {
      //  System.out.println("hover is done");
        Helper.takeScreenShot("Blouse Page",driver);
        String addtoCart = Helper.readFromElementPropertyFile("addtoCart");
        driver.findElement(By.xpath(addtoCart)).click();
    }

    /*
    * proceed to check out process
     */
    public void proceedToCheckOut(){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        String proceedLocator = Helper.readFromElementPropertyFile("proceed");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(proceedLocator))));
        driver.findElement(By.xpath(proceedLocator)).click();

    }

}
