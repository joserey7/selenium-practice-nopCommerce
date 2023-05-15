package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BooksPage {

    WebDriver driver;

    public BooksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div")
    WebElement itemGrid;

    public void addAllItemsToCart() throws InterruptedException {
        List<WebElement> elements = itemGrid.findElements(By.className("item-box"));
        for (WebElement element : elements) {
            element.findElement(By.tagName("button")).click();
            Thread.sleep(500);
        }
    }

}
