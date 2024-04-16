package org.webautomation.pojo;

import Helpers.Helpers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.webautomation.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class WhitePaper extends Helpers {

    private WebDriver driver;

    public WhitePaper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".white-papers.type-white-papers")
   List<WebElement> WhitePaperList;

    @FindBy(xpath = "(//section[contains(@class,'elementor-section elementor-top-section')]//iframe)[1]")
    WebElement iframe;

    @FindBy(css = "div.form-field.first_name.pd-text.required input")
    WebElement firstname;


    @FindBy(xpath = "//div[contains(@class , 'form-field  company pd-text')]//input")
    WebElement company;

    @FindBy(css = "div.form-field.last_name.pd-text.required input")
    WebElement lastname;

    @FindBy(xpath = "//div[contains(@class , 'form-field  industry pd-text')]//input")
    WebElement industry;

        @FindBy(css = "[value='Send me a copy']")
    WebElement sendMeACopy;


    @FindBy(css = "div p.error.no-label")
    List<WebElement> errors;

    public  void selectWhitePaper(String paper)
    {
        List<WebElement> whitePaper = WhitePaperList.stream().filter(s -> s.findElement(By.className("elementor-post__title")).getText().equalsIgnoreCase(paper)).collect(Collectors.toList());
        whitePaper.get(0).click();
    }

    public void enterDetails(String firstName, String lastName, String companyName, String industryName)
    {
        SwitchToFrame(driver, iframe);
        firstname.sendKeys(firstName);
        lastname.sendKeys(lastName);
        company.sendKeys(companyName);
        industry.sendKeys(industryName);
        sendMeACopy.click();
    }

    public  void ErrorValidations() throws IOException {
        for (WebElement element : errors) {
            File src = element.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(BaseClass.path + "\\Screenshots\\test.png"));

            Assert.assertEquals(element.getText(), "This field is required.");
        }
    }
}
