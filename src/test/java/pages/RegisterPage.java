package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Helpers;

public class RegisterPage  {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gender-male")
    WebElement maleGenderRadio;

    @FindBy(id = "FirstName")
    WebElement firstNameInput;

    @FindBy(id = "LastName")
    WebElement lastNameInput;

    @FindBy(name = "DateOfBirthDay")
    WebElement dayDropdown;

    @FindBy(name = "DateOfBirthMonth")
    WebElement monthDropdown;

    @FindBy(name = "DateOfBirthYear")
    WebElement yearDropdown;

    @FindBy(id = "Company")
    WebElement companyTextfield;

    @FindBy(id = "Email")
    WebElement emailTextfield;

    @FindBy(id = "Password")
    WebElement passwordTextfield;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTextfield;

    @FindBy(id = "register-button")
    WebElement confirmRegisterButton;

    public void selectMaleGender() {
        Helpers.waitToBeVisibleAndClickeable(maleGenderRadio);
        maleGenderRadio.click();
    }

    public void writeFirstName(String fistName) {
        Helpers.waitToBeVisible(firstNameInput);
        firstNameInput.sendKeys(fistName);
    }

    public void writeLastName(String lastName) {
        Helpers.waitToBeVisible(lastNameInput);
        lastNameInput.sendKeys(lastName);
    }

    public void selectBirthday(String day, String month, String year) {
        Helpers.waitToBeVisible(dayDropdown);
        Helpers.waitToBeVisible(monthDropdown);
        Helpers.waitToBeVisible(yearDropdown);
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByValue(day);
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByValue(month);
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByValue(year);
    }

    public void writeEmail(String email){
        Helpers.waitToBeVisible(emailTextfield);
        emailTextfield.sendKeys(email);
    }

    public void writeCompany(String company){
        Helpers.waitToBeVisible(companyTextfield);
        companyTextfield.sendKeys(company);
    }

    public void writePassword(String password){
        Helpers.waitToBeVisible(passwordTextfield);
        passwordTextfield.sendKeys(password);
    }

    public void writeConfirmPassword(String password){
        Helpers.waitToBeVisible(confirmPasswordTextfield);
        confirmPasswordTextfield.sendKeys(password);
    }

    public void confirmRegister(){
        Helpers.waitToBeVisibleAndClickeable(confirmRegisterButton);
        confirmRegisterButton.click();
    }

}
