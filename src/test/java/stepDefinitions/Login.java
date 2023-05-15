package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.LoginPage;
import utilities.Helpers;

import static base.BaseTest.driver;

public class Login {

    BasePage pages = new BasePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @When("clicks on login")
    public void clicks_on_login() {
        pages.clicklogin();
        pages.waitBody();
        Helpers.takeScreenShot();
    }
    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String email, String password) {
        loginPage.writeEmail(email);
        loginPage.writePassword(password);
        pages.waitBody();
        Helpers.takeScreenShot();
    }
    @Then("user is logged in")
    public void user_is_logged_in() {
        loginPage.confirmLogin();
        pages.waitBody();
        Helpers.takeScreenShot();
    }
}
