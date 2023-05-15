package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Helpers;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "termsofservice")
    WebElement checkTerms;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public void enableCheckTermsOfService(){
        Helpers.waitToBeVisibleAndClickeable(checkTerms);
        checkTerms.click();
    }

    public void clickCheckoutbutton(){
        Helpers.waitToBeVisibleAndClickeable(checkTerms);
        checkoutButton.click();
    }

}
