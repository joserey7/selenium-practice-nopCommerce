package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Helpers;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    WebElement emailTextfield;

    @FindBy(id = "Password")
    WebElement passwordTextfield;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
    WebElement loginButton;

    public void writeEmail(String email){
        Helpers.waitToBeVisible(emailTextfield);
        emailTextfield.sendKeys(email);
    }

    public void writePassword(String password){
        Helpers.waitToBeVisible(passwordTextfield);
        passwordTextfield.sendKeys(password);
    }

    public void confirmLogin(){
        Helpers.waitToBeVisibleAndClickeable(loginButton);
        loginButton.click();
    }

}
