package vn.kms.course.selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.String;

public class CartPageUsingPageFactory {
    WebDriver driver;
    @FindBy(xpath = "//div[@class = 'flex justify-items-end space-x-4 ']/input[@type = 'number']")
    WebElement productQuantity;

    @FindBy(xpath = "//dl[@class='text-sm']/div/dd[@class='text-lg font-bold text-gray-900']")
    WebElement totalProductCost;

    @FindBy(xpath = "//div[@class= 'ml-8 flex-1 flex flex-col justify-center']/div/div/div/h3")
    WebElement productName;

    @FindBy(xpath = "//button[@type='button' and @class='Navbar_nav-icon-button__U7uSf' and @aria-hidden='true']")
    WebElement cartBtn;

    public CartPageUsingPageFactory(WebDriver webdriver){
        this.driver = webdriver;
        PageFactory.initElements(webdriver, this);
    }

    public String getProductName(){
        return productName.getText();
    }
    public Integer getProductQuantity(){
        return Integer.parseInt(productQuantity.getAttribute("value"));
    }

    public double gettotalProductCost(){
        return Float.parseFloat(totalProductCost.getText().substring(1).replace(",", ""));
    }

    public void changeProductQuantity(int quantity){
        productQuantity.clear();
        productQuantity.sendKeys(String.valueOf(quantity));
    }

    public void cartNavigate(){
        cartBtn.click();
    }
}
