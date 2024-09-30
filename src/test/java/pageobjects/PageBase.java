package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class PageBase {

    private WebDriver driver;
    private Wait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void openBrowser(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.out.println("URL NOT FOUND.." + e);
        }

    }

    public void clickElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public void typeText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void selectListForText(By locator, String Text) {
        WebElement list = driver.findElement(locator);
        Select selectList = new Select(list);
        selectList.selectByVisibleText(Text);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
