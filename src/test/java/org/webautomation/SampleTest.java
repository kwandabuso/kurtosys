package org.webautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.webautomation.pojo.HomePage;
import org.webautomation.pojo.WhitePaper;

import java.io.IOException;

public class SampleTest extends BaseClass {


    @Test
    public void test1() throws IOException {
        homePage.AcceptCookies();
        WhitePaper whitePaper = homePage.clickWhitePaperLink();

        Assert.assertEquals(driver.getTitle(), "White Papers | Kurtosys");

        whitePaper.selectWhitePaper("EU rule change bolsters need for fast, localized fund website platforms");

        whitePaper.enterDetails("Testing", "Last", "kurtosys", "Finance");
        whitePaper.ErrorValidations();
    }
}
