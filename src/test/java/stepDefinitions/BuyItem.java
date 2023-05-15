package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.BooksPage;
import pages.CartPage;
import pages.CheckoutPage;
import utilities.Helpers;

import static base.BaseTest.driver;

public class BuyItem {

    Login login = new Login();
    BasePage pages = new BasePage(driver);
    BooksPage booksPage = new BooksPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("the user selects books in the menu")
    public void the_user_selects_books_in_the_menu() {
        pages.clickBooksMenu();
        pages.waitBody();
        Helpers.takeScreenShot();
    }
    @When("buys one of each one")
    public void buys_one_of_each_one() throws InterruptedException {
        booksPage.addAllItemsToCart();
        pages.waitBody();
        Thread.sleep(1000);
        Helpers.takeScreenShot();
    }
    @When("goes to the cart")
    public void goes_to_the_cart() throws InterruptedException {
        Thread.sleep(5000);
        pages.clickCart();
        pages.waitBody();
        Helpers.takeScreenShot();
    }
    @When("selects checkout accepting the terms of service")
    public void selects_checkout_accepting_the_terms_of_service() {
        cartPage.enableCheckTermsOfService();
        cartPage.clickCheckoutbutton();
        pages.waitBody();
        Helpers.takeScreenShot();
    }

    @When("selects country {string} city {string} address {string} zipCode {string} phone {string}")
    public void selects_country_city_address_zip_code_phone(String country, String city, String address, String zip, String phone) {
        checkoutPage.selectCountryDropdown(country);
        checkoutPage.writeCity(city);
        checkoutPage.writeAddress(address);
        checkoutPage.writeZipCode(zip);
        checkoutPage.writePhone(phone);
        pages.waitBody();
        Helpers.takeScreenShot();
        checkoutPage.clickContinueBilling();
    }

    @When("selects shipping method")
    public void selects_shipping_method() {
        checkoutPage.selectShippingMethodNextDay();
        pages.waitBody();
        Helpers.takeScreenShot();
        checkoutPage.clickContinueShippingMethod();
    }

    @When("selects payment method")
    public void selects_payment_method() {
        pages.waitBody();
        Helpers.takeScreenShot();
        checkoutPage.clickContinuePaymentMethod();
    }

    @When("selects payment information")
    public void selects_payment_information() {
        pages.waitBody();
        Helpers.takeScreenShot();
        checkoutPage.clickContinuePaymentInfo();
    }

    @When("confirms the order")
    public void confirms_the_order() {
        pages.waitBody();
        Helpers.takeScreenShot();
        checkoutPage.clickContinueConfirm();
    }

    @Then("order is requested successfully")
    public void order_is_requested_successfully() throws InterruptedException {
        pages.waitBody();
        Thread.sleep(2000);
        Helpers.takeScreenShot();
    }

}
