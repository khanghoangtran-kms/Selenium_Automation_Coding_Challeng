package vn.kms.course.selenium.tests.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import vn.kms.course.selenium.bases.BaseTest;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class DemoNoPOMTest extends BaseTest{
    WebDriver driver;


    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        driver = new ChromeDriver();
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.safari());
    }

    @AfterEach
    public void afterEach() {
        //driver.quit();
    }

    @Test
    public void loginSuccessfully(){
//        // Skip risk alert about SSL and direct to the target site
//
//
//
//
//
//        WebElement loginBtn = wait.until(new Function<WebDriver, WebElement>(){
//            public WebElement apply (WebDriver driver){
//                return driver.findElement(By.xpath("//*[@class=\"Navbar_nav-icon-button__U7uSf\"]"));
//            }
//        });
//
//        loginBtn.click();
//
//        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(30L))
//                .pollingEvery(Duration.ofSeconds(5L))
//                .ignoring(NoSuchElementException.class);
//
//        WebElement inputEmail = wait1.until(new Function<WebDriver, WebElement>(){
//            public WebElement apply (WebDriver driver){
//                return driver.findElement(By.xpath("//*[@id=\"email\"]"));
//            }
//        });

//        WebElement inputPass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
//        inputEmail.clear();
//        inputPass.clear();
//        inputEmail.sendKeys("admin@example.com");
//        inputPass.sendKeys("admin");
//
//        WebElement submitBtn = driver.findElement(By.xpath("//form/descendant::button"));
//        submitBtn.click();

//        Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(30L))
//                .pollingEvery(Duration.ofSeconds(5L))
//                .ignoring(NoSuchElementException.class);
//
//        WebElement itemAccountPreferences = wait2.until(new Function<WebDriver, WebElement>() {
//
//            public WebElement apply(WebDriver webDriver) {
//                return driver.findElement(By.xpath("string(//div[@class='Navbar_user-menu__rYV7Z']/a[text()='Account preferences'])"));
//            }
//        });
//        WebElement itemLogout = driver.findElement(By.xpath("string(//div[@class='Navbar_user-menu__rYV7Z']/a[text()='Log out'])"));
//        String webUrl = driver.getCurrentUrl();
//        System.out.println(webUrl);
//        System.out.println(itemLogout.getText());

//        Assertions.assertEquals("https://demo.saleor.io/default-channel/en-US", webUrl);
//        Assertions.assertEquals("Account preferences", itemAccountPreferences);
//        Assertions.assertEquals("Log out", itemLogout);





//        WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
//        WebElement inputPass  =  driver.findElement(By.xpath("//*[@id=\"password\"]"));
//
//        System.out.println(inputEmail.getAttribute("type"));
//        System.out.println(inputPass.getAttribute("type"));

//        Log.i(storeDashboardTitle.getText());
//        driver.findElement(By.xpath("//*[@id='tabs']//a[normalize-space(.)='Login By Credentials']")).click();
//        driver.findElement(By.id("username")).sendKeys(
//                "thaovo");
//        driver.findElement(By.id("password")).sendKeys("kms");
//        driver.findElement(By.id("btnSubmit")).click();
//
//        Assertions.assertEquals("Home | PA Tool", driver.getTitle());
    }



}
