import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestScenario extends BaseTest {

    HomePage home;
    SignUp signup;
    AfterRegistration afterRegistration;
    Blouses blouse;
    Order order;

    /*
     * Creating objects of each page so they can use the functions mentioned in each one.
     */
    @BeforeClass
    public void setDriver() {
        home = new HomePage(driver);
        signup = new SignUp(driver);
        afterRegistration = new AfterRegistration(driver);
        blouse = new Blouses(driver);
        order = new Order(driver);
    }

    @BeforeMethod
    public void openHomePageOfTestAutomation() throws IOException {
        home.openHomePage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Scenario to sign up into the website, purchase a blouse and validate the order")
    public void test1() {
        home.takesScreenshotsOfHomePage();
        home.signUp();

        signup.enterEmail();
        signup.enterSignUpFormData();

        afterRegistration.hoverToWomenMenu();
        afterRegistration.chooseBlouse();

        blouse.scrollToBlouse();
        blouse.hoverToBlouseImg();
        blouse.addToCart();
        blouse.proceedToCheckOut();

        order.proceedToCheckoutInCheckSummary();
        order.proceedToCheckoutInAddress();
        order.checkShipping();
        order.choosePaymentMethod();
        order.checkOrderSummary();
        order.checkOrderInstructions();
        order.displayInvoice();

        Assert.assertEquals(order.getPurchaseDate(),order.getCurrentDate());
        Assert.assertEquals(order.checkPrice(),order.checkExpectedPrice());
        Assert.assertEquals(order.checkStatus(),order.checkExpectedStatus());
    }

    @AfterClass
    public void endSession() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.quit();
    }
}
