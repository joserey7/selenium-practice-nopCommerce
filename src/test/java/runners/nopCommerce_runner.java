package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"base", "stepDefinitions"},
        tags = "@browser",
        plugin = {"pretty", "summary", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class nopCommerce_runner {
}
