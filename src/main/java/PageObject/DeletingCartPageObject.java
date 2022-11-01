package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletingCartPageObject {
    private final WebDriver driver;

    public DeletingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public DeletingCartPageObject clickWomenBtn() {
        String womenBtn = "a[title='Women']";
        driver.findElement(By.cssSelector(womenBtn)).click();
        return this;
    }
    public DeletingCartPageObject clickDressesLink() {
        String dressesLink = "Dresses";
        driver.findElement(By.linkText(dressesLink)).click();
        return this;
    }
    public DeletingCartPageObject clickEveningDressesLink() {
        String eveningDressesLink = "Evening Dresses";
        driver.findElement(By.linkText(eveningDressesLink)).click();
        return this;
    }
    public DeletingCartPageObject clickProductName() {
        String productName = ".right-block .product-name";
        driver.findElement(By.cssSelector(productName)).click();
        return this;
    }
    public DeletingCartPageObject clickAddToCart() {
        String addToCart = "add_to_cart";
        driver.findElement(By.id(addToCart)).click();
        return this;
    }
    public DeletingCartPageObject clickContShopping() {
        String contShopping = "span[title='Continue shopping'] > span";
        driver.findElement(By.cssSelector(contShopping)).click();
        return this;
    }
    public DeletingCartPageObject clickViewCart() {
        String viewCart = "a[title='View my shopping cart']";
        driver.findElement(By.cssSelector(viewCart)).click();
        return this;
    }
    public DeletingCartPageObject clickIconTrash() {
        String iconTrash = ".icon-trash";
        driver.findElement(By.cssSelector(iconTrash)).click();
        return this;
    }
    public String getCartTitle() {
        String cartTitle = "a[title='View my shopping cart']";
        return driver.findElement(By.cssSelector(cartTitle)).getText();
    }
    public String getCartEmpty() {
        String cartEmpty = ".alert-warning";
        return driver.findElement(By.cssSelector(cartEmpty)).getText();
    }
}