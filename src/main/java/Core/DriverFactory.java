package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver = null;
    public static String browserName = "chrome";

    public static void initialize() {
        assert driver != null;
        driver.manage().window().maximize();
        DriverFactory.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://tempmail.plus/ru/");
    }

    public static void quit() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}