package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddingCartPageObject {
    private WebDriver driver;

    private final String womenBtn = "a[title='Women']";
    private final String dressesLink = "Dresses";
    private final String eveningDressesLink = "Evening Dresses";
    private final String productName = ".right-block .product-name";
    private final String addToCart = "add_to_cart";
    private final String productQuantity = "span#layer_cart_product_quantity";
    private final String addProduct = ".col-md-6.col-xs-12.layer_cart_product > h2";

    public AddingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickWomenBtn() {
        driver.findElement(By.cssSelector(womenBtn)).click();
    }

    public void clickDressesLink() {
        driver.findElement(By.linkText(dressesLink)).click();
    }
    public void clickEveningDressesLink() {
        driver.findElement(By.linkText(eveningDressesLink)).click();
    }

    public void clickProductName() {
        driver.findElement(By.cssSelector(productName)).click();

    }
     public void clickAddToCart() {
         driver.findElement(By.id(addToCart)).click();
     }

    public String getProductQuantity() {
        return driver.findElement(By.cssSelector(productQuantity)).getText();

    }
    public String getAddProduct() {
        return driver.findElement(By.cssSelector(addProduct)).getText();

    }
}

