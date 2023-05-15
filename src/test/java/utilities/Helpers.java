package utilities;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helpers {

    private static String getBase64Screenshot() {
        return ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BASE64);
    }

    public static void takeScreenShot(){
        ExtentCucumberAdapter.getCurrentStep()
                .info(MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot())
                        .build());
    }
    public static void takeScreenShot(String title){
        ExtentCucumberAdapter.getCurrentStep()
                .info(MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot(),title)
                        .build());
    }

    public static void waitForScreenshot(WebElement element){
        new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void waitToBeVisible(WebElement element){
        new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeVisibleAndClickeable(WebElement element){
        new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitToBeVisibleAndSelected(WebElement element){
        new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeSelected(element));
    }

}
