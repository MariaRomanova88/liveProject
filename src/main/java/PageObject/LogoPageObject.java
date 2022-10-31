package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoPageObject {
    private final WebDriver driver;
    private final String cartBtn = "[title='View my shopping cart']";
    public LogoPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLogoBtn() {
        driver.findElement(By.cssSelector(cartBtn)).click();
    }
    public void clickAboutLink() {
        String aboutLink = "About us";
        driver.findElement(By.linkText(aboutLink)).click();
    }
    public void clickCartBtn() {
        driver.findElement(By.cssSelector(cartBtn)).click();
    }
    public WebElement getLogo() {
        String logoBtn = "img[alt='My Store']";
        return driver.findElement(By.cssSelector(logoBtn));
    }
}
