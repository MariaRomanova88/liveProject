package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletingCartPageObject {
    private WebDriver driver;

    private final String womenBtn = "a[title='Women']";
    private final String dressesLink = "Dresses";
    private final String eveningDressesLink = "Evening Dresses";
    private final String productName = ".right-block .product-name";
    private final String addToCart = "add_to_cart";
    private final String ContShopping = "span[title='Continue shopping'] > span";
    private final String viewCart = "a[title='View my shopping cart']";
    private final String iconTrash = ".icon-trash";
    private final String cartTitle = "a[title='View my shopping cart']";
    private final String cartEmpty = ".alert-warning";

    public DeletingCartPageObject(WebDriver driver) {
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

    public void clickContShopping() {
        driver.findElement(By.cssSelector(ContShopping)).click();
    }

    public void clickViewCart() {
        driver.findElement(By.cssSelector(viewCart)).click();
    }

    public void clickIconTrash() {
        driver.findElement(By.cssSelector(iconTrash)).click();
    }

    public String getCartTitle() {
        return driver.findElement(By.cssSelector(cartTitle)).getText();

    }
    public String getCartEmpty() {
        return driver.findElement(By.cssSelector(cartEmpty)).getText();

    }
}