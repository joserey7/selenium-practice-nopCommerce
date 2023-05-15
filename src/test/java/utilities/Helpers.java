package utilities;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helpers {

    private String getBase64Screenshot() {
        return ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BASE64);
    }

    public void takeScreenShot(){
        ExtentCucumberAdapter.getCurrentStep()
                .info(MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot())
                        .build());
    }
    public void takeScreenShot(String title){
        ExtentCucumberAdapter.getCurrentStep()
                .info(MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot(),title)
                        .build());
    }

}
