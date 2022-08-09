package vn.kms.course.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkipNoSSLCertRiskPage {
    private String BASE_URL = "http://demo.getsaleor.com";
    @FindBy(id = "details-button")
    WebElement detailBtn;

    @FindBy(id = "proceed-link")
    WebElement processBtn;
    WebDriver driver;
    public SkipNoSSLCertRiskPage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void SkipRiskAccess(){
        driver.get(BASE_URL);
        detailBtn.click();
        processBtn.click();
    }
}
