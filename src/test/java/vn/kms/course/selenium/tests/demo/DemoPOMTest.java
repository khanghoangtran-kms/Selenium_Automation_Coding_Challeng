package vn.kms.course.selenium.tests.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vn.kms.course.selenium.bases.BasePage;
import vn.kms.course.selenium.bases.BaseTest;
import vn.kms.course.selenium.demo.*;

import javax.swing.*;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DemoPOMTest extends BaseTest {
    WebDriver driver;
    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        driver = new ChromeDriver();
        SkipNoSSLCertRiskPage skipRisk = new SkipNoSSLCertRiskPage(driver);
        skipRisk.SkipRiskAccess();

    }

//    @AfterEach
//    public void afterEach() {
//        driver.quit();
//    }

    @Test
    public void loginSuccessfullyPageFactory(){

        HomePageUsingPageFactory homePage = new HomePageUsingPageFactory(driver);
        homePage.LoginNavigate();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        LoginPageUsingPageFactory loginPage = new LoginPageUsingPageFactory(driver);
        String email = "admin@example.com";
        String password = "admin";
        loginPage.login(email, password);

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class, 'Navbar_user-menu-container')]")));

        // Success Login
        String URL = driver.getCurrentUrl();
        System.out.println("Check if Log In successfully ...");
        Assertions.assertEquals("https://demo.saleor.io/default-channel/en-US/", URL);
        System.out.println("1/3 Passed");
        Assertions.assertEquals("Account preferences", homePage.getAccountButtonText());
        System.out.println("2/3 Passed");
        Assertions.assertEquals("Log out", homePage.getLogoutButtonText());
        System.out.println("3/3 Passed");

    }
    @Test
    public void ValidateAddtoCart(){
        HomePageUsingPageFactory homepage = new HomePageUsingPageFactory(driver);

//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        homepage.ClickAnItem();

//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        ProductPageUsingPageFactory productpage = new ProductPageUsingPageFactory(driver);
        double productCost = productpage.chooseOption(2);
        productpage.addToCart();
        String productName = productpage.getProductName();

//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        CartPageUsingPageFactory cartpage = new CartPageUsingPageFactory(driver);
        Integer quantity = 12;
        cartpage.changeProductQuantity(quantity);
        Integer productQuantity = cartpage.getProductQuantity();

        driver.get("https://demo.saleor.io/default-channel/en-US");

//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        cartpage.cartNavigate();

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        System.out.println("Check if Add-to-cart function works ...");
        Assertions.assertEquals(cartpage.getProductName(), productName);
        System.out.println("1/3 Passed");
        Assertions.assertEquals(cartpage.getProductQuantity(), productQuantity);
        System.out.println("2/3 Passed");
        Assertions.assertEquals(cartpage.gettotalProductCost(), productCost * productQuantity);
        System.out.println("3/3 Passed");

    }
}
