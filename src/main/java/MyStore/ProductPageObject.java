package MyStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPageObject {

    private final WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getProduct() {
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public ProductPageObject quantityIncrease() {
        String quantityIncrease = ".icon-plus";
        driver.findElement(By.cssSelector(quantityIncrease)).click();
        return this;
    }

    public ProductPageObject quantityDecrease() {
        String quantityDecrease = ".icon-minus";
        driver.findElement(By.cssSelector(quantityDecrease)).click();
        return this;
    }

    public ProductPageObject sizeOption() {
        String sizeOption = "select#group_1";
        driver.findElement(By.cssSelector(sizeOption)).click();
        return this;
    }

    public ProductPageObject addToCartBtn() {
        String addToCartBtn = "#add_to_cart span";
        driver.findElement(By.cssSelector(addToCartBtn)).click();
        return this;
    }

    public ProductPageObject homePageLink() {
        String homePageLink = ".icon-home";
        driver.findElement(By.cssSelector(homePageLink)).click();
        return this;
    }

}
