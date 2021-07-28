package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    WebDriver driver;

    public Order(WebDriver driver) {
        this.driver=driver;
    }
    /*
    * this is to check delivery and invoice address and takes a screenshot of the summary page
     */
    public void proceedToCheckoutInCheckSummary() {
        String deliveryAddressLocator = Helper.readFromElementPropertyFile("delieveryAddress");
        String proceedToCheckOutLocator = Helper.readFromElementPropertyFile("proceedtoCheckOutinSummary");
        Helper.scrollToElement(deliveryAddressLocator,driver);
        Helper.takeScreenShot("Summary", driver);
        driver.findElement(By.xpath(proceedToCheckOutLocator)).click();

    }
    /*
    *  this function is to check the delivery address against the billing address and take a screenshot of the address page
     */
    public void proceedToCheckoutInAddress() {
        String billingAddressLocator = Helper.readFromElementPropertyFile("billingAddress");
        String proccedToCheckOutLocator = Helper.readFromElementPropertyFile("proccedtoCheckOutinAddress");
        Helper.scrollToElement(billingAddressLocator,driver);
        Helper.takeScreenShot("Billing Address",driver);
        driver.findElement(By.xpath(proccedToCheckOutLocator)).click();
    }

    /*
    * this is to check the terms of services and take a screenshot of the check
     */
    public void checkShipping() {
        String shippingOptionLocator = Helper.readFromElementPropertyFile("ShippingOptions");
        String processCarrierLocator = Helper.readFromElementPropertyFile("proceedtoCheckOutinShipping");
        String checkboxLocator = Helper.readFromElementPropertyFile("termsOfServicescheckbox");
        Helper.scrollToElement(shippingOptionLocator,driver);
        driver.findElement(By.xpath(checkboxLocator)).click();
        Helper.takeScreenShot("Shipping Option",driver);
        driver.findElement(By.xpath(processCarrierLocator)).click();
    }

    /*
    * this function is to choose the wire frame payment option and takes a screenshot of the product details
     */
    public void choosePaymentMethod() {
        String productDetailsLocator = Helper.readFromElementPropertyFile("productInPayment");
        String wireFrameLocator= Helper.readFromElementPropertyFile("bankwireinPaymentMethod");
        Helper.scrollToElement(productDetailsLocator,driver);
        Helper.takeScreenShot("Product Payment Details",driver);
        driver.findElement(By.xpath(wireFrameLocator)).click();
    }

    /*
    * this function is to display the payment details to confirm order
     */
    public void checkOrderSummary() {
        String finalPaymentInfoLocator= Helper.readFromElementPropertyFile("bankWirePaymentDetails");
        String orderConfirmationButtonLocator= Helper.readFromElementPropertyFile("confirmOrder");
        Helper.scrollToElement(finalPaymentInfoLocator,driver);
        Helper.takeScreenShot("Bank-Wire Payment Info",driver);
        driver.findElement(By.xpath(orderConfirmationButtonLocator)).click();
    }

    /*
    * this is to display the order confirmation report
     */
    public void checkOrderInstructions() {
        String OrderConfirmationLocator= Helper.readFromElementPropertyFile("orderConfirmation");
        String backToOrdersLocator= Helper.readFromElementPropertyFile("backToOrder");
        Helper.scrollToElement(OrderConfirmationLocator,driver);
        Helper.takeScreenShot("Order Confirmation",driver);
        driver.findElement(By.xpath(backToOrdersLocator)).click();
    }

    /*
     * This function is to display the order history and to take a screenshot
     */
    public void displayInvoice(){
        String orderHistoryLocator= Helper.readFromElementPropertyFile("orderHistory");
        Helper.scrollToElement(orderHistoryLocator,driver);
        Helper.takeScreenShot("Invoice",driver);
    }

    /*
    * this function is to return the purchase date displayed at the website
     */
    public String getPurchaseDate() {
        String dateOfOrderLocator = Helper.readFromElementPropertyFile("date");
        String purchaseDate = driver.findElement(By.xpath(dateOfOrderLocator)).getText();
        return purchaseDate;
    }

    /*
    * this is to get the system date that should be compatible to the purchase date
     */
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String dateOfToday= dateFormat.format(date);
        return dateOfToday;
    }

    /*
    * this is to return the blouse price displayed at the final invoice
     */
    public String checkPrice() {
        String totalPriceLocator = Helper.readFromElementPropertyFile("totalPrice");
        String actualPrice = driver.findElement(By.xpath(totalPriceLocator)).getText();
        return actualPrice;
    }

    /*
    * to return the blouse expected price
     */
    public String checkExpectedPrice() {
        return "$30.16" ;
    }

    /*
    * this is to check the status of the item
     */
    public String checkStatus() {
        String statusLocator = Helper.readFromElementPropertyFile("status");
        String status = driver.findElement(By.xpath(statusLocator)).getText();
        return status;
    }

    /*
    * this is to set the expected status to "On backorder"
     */
    public String checkExpectedStatus() {
        return "On backorder";
    }


}
