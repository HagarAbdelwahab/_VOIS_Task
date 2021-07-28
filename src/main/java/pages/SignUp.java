package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class SignUp {
    WebDriver driver;

    public SignUp(WebDriver driver) {
        this.driver=driver;
    }
    public void enterEmail()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String email = Helper.readFromCredentialsPropertyFile("email");
        String emailLocator = Helper.readFromElementPropertyFile("emailLocator");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailLocator))).sendKeys(email);
        String createAccountButtonLocator = Helper.readFromElementPropertyFile("createAccountButtonLocator");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createAccountButtonLocator))).click();
    }
    public void enterSignUpFormData()
    {
        /*
        * choose user gender
         */
        String female = Helper.readFromElementPropertyFile("female");
        driver.findElement(By.xpath(female)).click();
        /*
        * type in user first name in form
         */
        String firstName= Helper.readFromCredentialsPropertyFile("firstName");
        String firstNameLocator = Helper.readFromElementPropertyFile("firstName");
        driver.findElement(By.xpath(firstNameLocator)).sendKeys(firstName);
        /*
        * type in user last name in form
         */
        String lastName = Helper.readFromCredentialsPropertyFile("lastName");
        String lastNameLocator = Helper.readFromElementPropertyFile("lastName");
        driver.findElement(By.xpath(lastNameLocator)).sendKeys(lastName);
        /*
         * type in user password in form
         */
        String password = Helper.readFromCredentialsPropertyFile("password");
        String passwordLocator = Helper.readFromElementPropertyFile("password");
        driver.findElement(By.xpath(passwordLocator)).sendKeys(password);
        /*
        * choose day of birth
         */
        String daysDropDown = Helper.readFromElementPropertyFile("daysDropDown");
        driver.findElement(By.xpath(daysDropDown)).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String dayValue = Helper.readFromElementPropertyFile("dayValue");
        By dayvalue = By.xpath(dayValue);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dayvalue)).click();
        /*
        * choose month of birth
         */
        String monthsDropDown = Helper.readFromElementPropertyFile("monthsDropDown");
        driver.findElement(By.xpath(monthsDropDown)).click();
        String monthValue = Helper.readFromElementPropertyFile("monthValue");
        By monthvalue = By.xpath(monthValue);
        wait.until(ExpectedConditions.visibilityOfElementLocated(monthvalue)).click();
        /*
        * choose year of birth
         */
        String yearsDropDown = Helper.readFromElementPropertyFile("yearsDropDown");
        driver.findElement(By.xpath(yearsDropDown)).click();
        String yearValue = Helper.readFromElementPropertyFile("yearValue");
        By yearvalue = By.xpath(yearValue);
        wait.until(ExpectedConditions.visibilityOfElementLocated(yearvalue)).click();
        /*
        * type in company
         */
        String companyLocator = Helper.readFromElementPropertyFile("company");
        String company = Helper.readFromCredentialsPropertyFile("company");
        driver.findElement(By.xpath(companyLocator)).sendKeys(company);
        /*
        * type in address
         */
        String addressLocator = Helper.readFromElementPropertyFile("address");
        String address = Helper.readFromCredentialsPropertyFile("address");
        driver.findElement(By.xpath(addressLocator)).sendKeys(address);
        /*
        * type in city
         */
        String cityLocator = Helper.readFromElementPropertyFile("city");
        String city = Helper.readFromCredentialsPropertyFile("city");
        driver.findElement(By.xpath(cityLocator)).sendKeys(city);

        /*
        *  choose state from dropdown menu
         */

        String stateDropDown = Helper.readFromElementPropertyFile("stateDropDown");
        driver.findElement(By.xpath(stateDropDown)).click();
        String stateLocator = Helper.readFromElementPropertyFile("state");
        By state = By.xpath(stateLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(state)).click();

        /*
        * type in postal code
         */
        String postalCodeLocator = Helper.readFromElementPropertyFile("postalCode");
        String postalCode = Helper.readFromCredentialsPropertyFile("postalCode");
        driver.findElement(By.xpath(postalCodeLocator)).sendKeys(postalCode);

        /*
        *choose country from dropdown menu
         */
        String countryDropDown = Helper.readFromElementPropertyFile("countryDropDown");
        driver.findElement(By.xpath(countryDropDown)).click();
        String country = Helper.readFromElementPropertyFile("country");
        By countrylocator = By.xpath(country);
        wait.until((ExpectedConditions.visibilityOfElementLocated(countrylocator))).click();
        /*
        * type in mobile phone
         */
        String mobileLocator = Helper.readFromElementPropertyFile("mobilePhone");
        driver.findElement(By.xpath(mobileLocator)).sendKeys(Helper.readFromCredentialsPropertyFile("mobilePhone"));

        /*
        * submit credentials
         */
        String SubmitLocator = Helper.readFromElementPropertyFile("submitButton");
        driver.findElement(By.xpath((SubmitLocator))).click();
    }

}
