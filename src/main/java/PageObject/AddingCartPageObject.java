package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddingCartPageObject {
    private final WebDriver driver;

    public AddingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click 'Women' button;")
    public void clickWomenBtn() {
        String womenBtn = "a[title='Women']";
        driver.findElement(By.cssSelector(womenBtn)).click();
    }
    @Step("Click 'Dresses' link;")
    public void clickDressesLink() {
        String dressesLink = "Dresses";
        driver.findElement(By.linkText(dressesLink)).click();
    }
    @Step("Click 'Evening Dresses' link;")
    public void clickEveningDressesLink() {
        String eveningDressesLink = "Evening Dresses";
        driver.findElement(By.linkText(eveningDressesLink)).click();
    }
    @Step("Click 'Printed Dress';")
    public void clickProductName() {
        String productName = ".right-block .product-name";
        driver.findElement(By.cssSelector(productName)).click();
    }
    @Step("Click 'Add to Cart' button;")
    public void clickAddToCart() {
        String addToCart = "add_to_cart";
        driver.findElement(By.id(addToCart)).click();
    }
    @Step("Check product quantity '1';")
    public String getProductQuantity() {
        String productQuantity = "span#layer_cart_product_quantity";
        return driver.findElement(By.cssSelector(productQuantity)).getText();
    }
    @Step("Check adding to the Cart.")
    public String getAddProduct() {
        String addProduct = ".col-md-6.col-xs-12.layer_cart_product > h2";
        return driver.findElement(By.cssSelector(addProduct)).getText();
    }
}