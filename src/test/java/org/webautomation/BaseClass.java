package org.webautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.webautomation.pojo.HomePage;

import java.time.Duration;

public class BaseClass {
    WebDriver driver;
    public  static  String path = System.getProperty("user.dir");
    HomePage homePage;
    public void InitialiseTest() {

        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\java\\org\\webautomation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeClass
    public HomePage OpenUrl() {
        InitialiseTest();
        driver.get("https://www.kurtosys.com/");
        homePage =new HomePage(driver);
        return homePage;
    }

    @AfterClass
    public void Cleanup() {
        driver.quit();
    }

}
