package MyStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//'Search field' validation.
public class SearchField {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.id("search_query_top")).click();

        driver.findElement(By.id("search_query_top")).sendKeys("Dress");

        driver.findElement(By.id("search_query_top")).clear();

        driver.findElement(By.id("search_query_top")).sendKeys("Pijamas");

        driver.findElement(By.id("search_query_top")).clear();

        driver.findElement(By.cssSelector("#header > div:nth-child(3) .row")).click();

        driver.quit();

    }
}
