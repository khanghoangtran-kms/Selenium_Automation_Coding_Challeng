package vn.kms.course.selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageUsingPageFactory {
    WebDriver driver ;

    @FindBy(id = "headlessui-label-:r2:")
    WebElement option1;

    @FindBy(id = "headlessui-label-:r4:")
    WebElement option2;
//  //div[starts-with(@id, 'headlessui-radiogroup-:')]/div/div[1]
    @FindBy(xpath = "//button[@data-testid = 'addToCartButton']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//h1[@data-testid='productName']")
    WebElement productName;

    @FindBy(xpath = "//div[starts-with(@id, 'headlessui-radiogroup-:')]/div/div[1]/div/div/div/div/following-sibling::div")
    WebElement productCost1;

    @FindBy(xpath = "//div[starts-with(@id, 'headlessui-radiogroup-:')]/div/div[2]/div/div/div/div/following-sibling::div")
    WebElement productCost2;

    public ProductPageUsingPageFactory(WebDriver webdriver){
        this.driver = webdriver;
        PageFactory.initElements(webdriver, this);
    }

    public float chooseOption(int choice){
        if (choice == 1){
            option1.click();
            addToCartBtn.click();
            return this.getProductCost1();
        }
        if (choice == 2){
            option2.click();
            addToCartBtn.click();
            return this.getProductCost2();
        }
        return -1;
    }

    public String getProductName(){
        return productName.getText();
    }

    public void addToCart(){
        addToCartBtn.click();
    }

    public float getProductCost1(){
        return Float.parseFloat(productCost1.getText().substring(1));
    }

    public float getProductCost2(){
        return Float.parseFloat(productCost2.getText().substring(1));
    }
}
