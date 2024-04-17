package org.webautomation.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.webautomation.pojo.WhitePaper;

import java.io.IOException;

public class SampleTest extends BaseClass {


    @Test(dataProvider = "getData")
    public void test1(String firstName, String lastName, String company, String industry, String whitepaper) throws IOException {
        homePage.AcceptCookies();
        WhitePaper whitePaper = homePage.clickWhitePaperLink();

        Assert.assertEquals(driver.getTitle(), "White Papers | Kurtosys");

        whitePaper.selectWhitePaper(whitepaper);

        whitePaper.enterDetails(firstName, lastName, company, industry);
        whitePaper.ErrorValidations();
    }
    @DataProvider
    public Object[][] getData()
    {
        return new Object [][]{{"Testing", "Last", "kurtosys","Finance", "EU rule change bolsters need for fast, localized fund website platforms"}};
    }
}
