package vn.kms.course.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageUsingPageFactory {
    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//form/descendant::button")
    WebElement submitBtn;

    WebDriver driver;

    public LoginPageUsingPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password){
        inputEmail.clear();
        inputPassword.clear();
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        submitBtn.click();
    }
}