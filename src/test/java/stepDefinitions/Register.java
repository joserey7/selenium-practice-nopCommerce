package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.RegisterPage;
import utilities.Helpers;

import static base.BaseTest.driver;

public class Register {

    BasePage pages = new BasePage(driver);
    RegisterPage registerPage = new RegisterPage(driver);

    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String url) {
        driver.get(url);
        pages.waitBody();
        Helpers.takeScreenShot();
    }

    @When("clicks on register")
    public void clicks_on_register() {
        pages.clickRegister();
        pages.waitBody();
        Helpers.takeScreenShot();
    }
    @When("the user fills the form with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_fills_the_form_with_and_and_and_and_and_and_and_and
            (String firstName, String lastName, String day, String month, String year, String email, String company, String pasword) {
        registerPage.selectMaleGender();
        registerPage.writeFirstName(firstName);
        registerPage.writeLastName(lastName);
        registerPage.selectBirthday(day,month,year);
        registerPage.writeEmail(email);
        registerPage.writeCompany(company);
        registerPage.writePassword(pasword);
        registerPage.writeConfirmPassword(pasword);
        pages.waitBody();
        Helpers.takeScreenShot();
        registerPage.confirmRegister();
        pages.waitBody();
        Helpers.takeScreenShot();
    }


}
