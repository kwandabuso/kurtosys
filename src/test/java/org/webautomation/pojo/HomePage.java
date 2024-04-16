package org.webautomation.pojo;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Helpers {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookiesButton;


    @FindBy(css = "div[data-elementor-type='footer'] [href='https://www.kurtosys.com/white-papers/']")
    WebElement whitePaperLink;


    public void AcceptCookies() {
        acceptCookiesButton.click();
    }

    public WhitePaper clickWhitePaperLink() {
        scrollElementToView(driver, whitePaperLink);
        whitePaperLink.click();
        return new WhitePaper(driver);
    }


}
