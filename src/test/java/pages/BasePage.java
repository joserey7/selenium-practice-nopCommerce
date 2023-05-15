package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Helpers;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ico-register")
    WebElement registerButton;

    @FindBy(className = "ico-login")
    WebElement loginButton;

    @FindBy(className = "ico-cart")
    WebElement cartButton;

    @FindBy(linkText = "Books")
    WebElement booksLink;

    @FindBy(className = "master-wrapper-page")
    WebElement body;

    public void clickRegister(){
        Helpers.waitToBeVisible(registerButton);
        registerButton.click();
    }

    public void clicklogin(){
        Helpers.waitToBeVisible(loginButton);
        loginButton.click();
    }
    public void clickCart(){
        Helpers.waitToBeVisible(cartButton);
        cartButton.click();
    }

    public void clickBooksMenu(){
        Helpers.waitToBeVisible(booksLink);
        booksLink.click();
    }

    public void waitBody(){
        Helpers.waitForScreenshot(body);
    }

}
