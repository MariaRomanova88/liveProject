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

    public void dressesLink() {
        driver.findElement(By.linkText(dressesLink)).click();
    }
    public void eveningDressesLink() {
        driver.findElement(By.linkText(eveningDressesLink)).click();
    }

    public void productName() {
        driver.findElement(By.cssSelector(productName)).click();

    }
     public void addToCart() {
         driver.findElement(By.id(addToCart)).click();
     }

    public String getProductQuantity() {
        return driver.findElement(By.id(productQuantity)).getText();

    }
    public String getAddProduct() {
        return driver.findElement(By.id(addProduct)).getText();

    }
}

