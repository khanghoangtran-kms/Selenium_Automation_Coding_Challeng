package vn.kms.course.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPageUsingPageFactory {
    WebDriver driver ;

    @FindBy(xpath = "//div[@role='radiogroup']//div[@role='radio' and position()=1]")
    WebElement option1;

    @FindBy(xpath = "//div[@role='radiogroup']//div[@role='radio' and position()=2]")
    WebElement option2;
//  //div[starts-with(@id, 'headlessui-radiogroup-:')]/div/div[1]
    @FindBy(xpath = "//button[@data-testid = 'addToCartButton']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[starts-with(@data-testid, 'cartProductItem')]")
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
            WebDriverWait wait = new WebDriverWait(this.driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='radiogroup']//div[@role='radio' and position()=1]")));
            option1.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid = 'addToCartButton']")));
            addToCartBtn.click();
            return this.getProductCost1();
        }
        if (choice == 2){
            WebDriverWait wait = new WebDriverWait(this.driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='radiogroup']//div[@role='radio' and position()=2]")));
            option2.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid = 'addToCartButton']")));
            addToCartBtn.click();
            return this.getProductCost2();
        }
        return -1;
    }

    public String getProductName(){
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[starts-with(@data-testid, 'cartProductItem')]")));
        return productName.getText();
    }

    public void addToCart(){
        addToCartBtn.click();
    }

    public float getProductCost1(){
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id, 'headlessui-radiogroup-:')]/div/div[1]/div/div/div/div/following-sibling::div")));
        return Float.parseFloat(productCost1.getText().substring(1));
    }

    public float getProductCost2(){
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id, 'headlessui-radiogroup-:')]/div/div[2]/div/div/div/div/following-sibling::div")));
        return Float.parseFloat(productCost2.getText().substring(1));
    }
}
