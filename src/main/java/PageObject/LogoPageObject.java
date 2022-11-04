package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoPageObject {
    private final WebDriver driver;
    private final String cartBtn = "[title='View my shopping cart']";
    public LogoPageObject(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click 'Logo';")
    public LogoPageObject clickLogoBtn() {
        driver.findElement(By.cssSelector(cartBtn)).click();
        return this;
    }
    @Step("Click 'About us' link;")
    public LogoPageObject clickAboutLink() {
        String aboutLink = "About us";
        driver.findElement(By.linkText(aboutLink)).click();
        return this;
    }
    @Step("Click 'Cart' button;")
    public LogoPageObject clickCartBtn() {
        driver.findElement(By.cssSelector(cartBtn)).click();
        return this;
    }
    @Step("Check 'Logo' appears.")
    public WebElement getLogo() {
        String logoBtn = "img[alt='My Store']";
        return driver.findElement(By.cssSelector(logoBtn));
    }
}
