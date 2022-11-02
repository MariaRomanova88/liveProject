package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletingCartPageObject {
    private final WebDriver driver;

    public DeletingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickWomenBtn() {
        String womenBtn = "a[title='Women']";
        driver.findElement(By.cssSelector(womenBtn)).click();
    }
    public void clickDressesLink() {
        String dressesLink = "Dresses";
        driver.findElement(By.linkText(dressesLink)).click();
    }
    public void clickEveningDressesLink() {
        String eveningDressesLink = "Evening Dresses";
        driver.findElement(By.linkText(eveningDressesLink)).click();
    }
    public void clickProductName() {
        String productName = ".right-block .product-name";
        driver.findElement(By.cssSelector(productName)).click();
    }
    public void clickAddToCart() {
        String addToCart = "add_to_cart";
        driver.findElement(By.id(addToCart)).click();
    }
    public void clickContShopping() {
        String contShopping = "span[title='Continue shopping'] > span";
        driver.findElement(By.cssSelector(contShopping)).click();
    }
    public void clickViewCart() {
        String viewCart = "a[title='View my shopping cart']";
        driver.findElement(By.cssSelector(viewCart)).click();
    }
    public void clickIconTrash() {
        String iconTrash = ".icon-trash";
        driver.findElement(By.cssSelector(iconTrash)).click();
    }
    public String getCartEmpty() {
        String cartEmpty = ".alert-warning";
        return driver.findElement(By.cssSelector(cartEmpty)).getText();
    }
}