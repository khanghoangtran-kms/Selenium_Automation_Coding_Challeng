package vn.kms.course.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageUsingPageFactory {
    @FindBy(xpath = "//button[@class = 'Navbar_nav-icon-button__U7uSf' and @aria-hidden = 'true']")
    WebElement accountIconBtn;

    @FindBy(xpath = "//*[@class='flex-1 flex justify-end']/a/button[@aria-hidden='true']")
    WebElement accessoryBtn;

    @FindBy(xpath = "//div[@class = 'Navbar_user-menu__rYV7Z']/a")
    WebElement accountPrefBtn;

    @FindBy(xpath = "//div[@class = 'Navbar_user-menu__rYV7Z']/button")
    WebElement logOutBtn;

    @FindBy(xpath = "//ul[@data-testid = 'productsList']/li[@class = 'w-full' and position() = 1]")
    WebElement productItem;

    WebDriver driver;
    public HomePageUsingPageFactory(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void LoginNavigate(){
        accountIconBtn.click();
    }

    public void CartNavigate(){
        accessoryBtn.click();
    }

    public void ProductNavigate(int product){

    }

    public String getAccountButtonText(){
        return this.accountPrefBtn.getAttribute("innerHTML");
    }

    public String getLogoutButtonText(){
        return this.logOutBtn.getAttribute("innerHTML");
    }

    public void Logout(){
        // Perform hover event for displaying the button, then click() should work.
        // (Otherwise Exception occurs)
        Actions action = new Actions(driver);
        action.moveToElement(this.accountIconBtn).perform();
        logOutBtn.click();
    }

    public void ClickAnItem(){
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@data-testid = 'productsList']/li[@class = 'w-full' and position() = 1]")));
        productItem.click();
    }
}
