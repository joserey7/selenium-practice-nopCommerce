package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties props = new Properties();
    public static FileReader fr;

    @Before("@browser")
    public void setUpBrowser() throws IOException {
        if (driver == null) {
            fr = new FileReader("src\\test\\resources\\config.properties");
            props.load(fr);
        }

        if (props.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (props.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (props.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else if (props.getProperty("browser").equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            driver.manage().window().fullscreen();
        }

    }

    @Before("@database")
    public void setUpDB() {
        System.out.println("Database connection created");
    }

    @After("@browser")
    public void tearDownBrowser() {
        driver.close();
        driver.quit();
        System.out.println("TearDown successfully");
    }

    @After("@database")
    public void tearDownDB() {
        System.out.println("Database connection closed");
    }
}
