package MyStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProduct() {
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public ProductPage quantityIncrease() {
        String quantityIncrease = ".icon-plus";
        driver.findElement(By.cssSelector(quantityIncrease)).click();
        return this;
    }

    public ProductPage quantityDecrease() {
        String quantityDecrease = ".icon-minus";
        driver.findElement(By.cssSelector(quantityDecrease)).click();
        return this;
    }

    public ProductPage sizeOption() {
        String sizeOption = "select#group_1";
        driver.findElement(By.cssSelector(sizeOption)).click();
        return this;
    }

    public ProductPage addToCartBtn() {
        String addToCartBtn = "#add_to_cart span";
        driver.findElement(By.cssSelector(addToCartBtn)).click();
        return this;
    }

    public ProductPage homePageLink() {
        String homePageLink = ".icon-home";
        driver.findElement(By.cssSelector(homePageLink)).click();
        return this;
    }

}
