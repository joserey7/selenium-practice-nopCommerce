package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Helpers;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryDropdown;

    @FindBy(id = "BillingNewAddress_City")
    WebElement cityTexfield;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement addressTexfield;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCodeTexfield;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneTexfield;

    @FindBy(className = "new-address-next-step-button")
    WebElement billingContinue;

    @FindBy(className = "shipping-method-next-step-button")
    WebElement shippingContinue;

    @FindBy(id = "shippingoption_1")
    WebElement shippingMethodNextDayAir;

    @FindBy(className = "payment-method-next-step-button")
    WebElement paymentMethodContinue;

    @FindBy(className = "payment-info-next-step-button")
    WebElement paymentInfoContinue;

    @FindBy(className = "confirm-order-next-step-button")
    WebElement confirmOrderContinue;

    public void selectCountryDropdown(String country){
        Helpers.waitToBeVisible(countryDropdown);
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText(country);
    }

    public void writeCity(String city){
        Helpers.waitToBeVisible(cityTexfield);
        cityTexfield.sendKeys(city);
    }

    public void writeAddress(String address){
        Helpers.waitToBeVisible(addressTexfield);
        addressTexfield.sendKeys(address);
    }

    public void writeZipCode(String zip){
        Helpers.waitToBeVisible(zipCodeTexfield);
        zipCodeTexfield.sendKeys(zip);
    }

    public void writePhone(String phone){
        Helpers.waitToBeVisible(phoneTexfield);
        phoneTexfield.sendKeys(phone);
    }

    public void clickContinueBilling(){
        Helpers.waitToBeVisibleAndClickeable(phoneTexfield);
        billingContinue.click();
    }

    public void selectShippingMethodNextDay(){
        Helpers.waitToBeVisibleAndClickeable(shippingMethodNextDayAir);
        shippingMethodNextDayAir.click();
    }

    public void clickContinueShippingMethod(){
        Helpers.waitToBeVisibleAndClickeable(shippingContinue);
        shippingContinue.click();
    }

    public void clickContinuePaymentMethod(){
        Helpers.waitToBeVisibleAndClickeable(paymentMethodContinue);
        paymentMethodContinue.click();
    }

    public void clickContinuePaymentInfo(){
        Helpers.waitToBeVisibleAndClickeable(paymentInfoContinue);
        paymentInfoContinue.click();
    }

    public void clickContinueConfirm(){
        Helpers.waitToBeVisibleAndClickeable(confirmOrderContinue);
        confirmOrderContinue.click();
    }



}
