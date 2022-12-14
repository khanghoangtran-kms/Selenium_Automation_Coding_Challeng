package vn.kms.course.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.String;

public class CartPageUsingPageFactory {
    WebDriver driver;
    @FindBy(xpath = "//div[@class = 'flex justify-items-end space-x-4 ']/input[@type = 'number']")
    WebElement productQuantity;

    @FindBy(xpath = "//dl[@class='text-sm']/div/dd[@class='text-lg font-bold text-gray-900']")
    WebElement totalProductCost;

    @FindBy(xpath = "//div[@class= 'ml-8 flex-1 flex flex-col justify-center']/div/div/div/h3")
    WebElement productName;

    @FindBy(xpath = "//div[starts-with(@class, 'Navbar_inner')]/div[3]/a[2]")
    WebElement cartBtn;

    public CartPageUsingPageFactory(WebDriver webdriver){
        this.driver = webdriver;
        PageFactory.initElements(webdriver, this);
    }

    public String getProductName(){
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'ml-8 flex-1 flex flex-col justify-center']/div/div/div/h3")));
        return productName.getText();
    }

    public Integer getProductQuantity(){
        return Integer.parseInt(productQuantity.getAttribute("value"));
    }

    public double gettotalProductCost(){
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//dl[@class='text-sm']/div/dd[@class='text-lg font-bold text-gray-900']")));
        return Float.parseFloat(totalProductCost.getText().substring(1).replace(",", ""));
    }

    public void changeProductQuantity(int quantity){
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'flex justify-items-end space-x-4 ']/input[@type = 'number']")));
        productQuantity.clear();
        productQuantity.sendKeys(String.valueOf(quantity));
    }

    public void cartNavigate(){
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class, 'Navbar_inner')]/div[3]/a[2]")));
        cartBtn.click();
    }
}
