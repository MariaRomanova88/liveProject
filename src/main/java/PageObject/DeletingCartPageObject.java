package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletingCartPageObject {
    private final WebDriver driver;

    public DeletingCartPageObject(WebDriver driver) {
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
    @Step("Click 'Continue shopping' button;")
    public void clickContShopping() {
        String contShopping = "span[title='Continue shopping'] > span";
        driver.findElement(By.cssSelector(contShopping)).click();
    }
    @Step("Click 'View my shopping cart' button;")
    public void clickViewCart() {
        String viewCart = "a[title='View my shopping cart']";
        driver.findElement(By.cssSelector(viewCart)).click();
    }
    @Step("Click 'icon-trash';")
    public void clickIconTrash() {
        String iconTrash = ".icon-trash";
        driver.findElement(By.cssSelector(iconTrash)).click();
    }
    @Step("Check empty Cart.")
    public String getCartEmpty() {
        String cartEmpty = ".alert-warning";
        return driver.findElement(By.cssSelector(cartEmpty)).getText();
    }
}