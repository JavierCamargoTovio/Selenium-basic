import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import pageobjects.ContactUp;
import pageobjects.PageBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class NavegationTest {

    private WebDriver driver;
    private PageBase pageBase;
    private ContactUp contactUp;

    @BeforeEach
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\JAVIER\\selenium\\selenium-basic\\src\\test\\resources\\chromedriver.exe");
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        driver = new FirefoxDriver();
        pageBase = new PageBase(driver);
        contactUp = new ContactUp(driver);
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void navigateToGoogle() throws InterruptedException {


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

    }

    @Test
    public void navegateToMercadoLibre() {


        driver.get("https://mercadolibre.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.xpath("//nav//ul//li//a[contains(., 'Colombia')]")).click();

        String currenUrl = driver.getCurrentUrl();

        String expectedUrl = "https://www.mercadolibre.com.co";
        assertTrue(currenUrl.contains(expectedUrl));

    }

    @Test
    public void workWithSelect() throws InterruptedException {

        driver.get("http://www.automationpractice.pl/index.php?id_category=3&controller=category");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement select = driver.findElement(By.id("selectProductSort"));

        Select selectWeb = new Select(select);

        selectWeb.selectByValue("quantity:desc");

    }

    @Test
    public void formContact() {
        pageBase.openBrowser("file://C:\\Users\\javier.camargo\\Downloads//formcontact.html");
        contactUp.selectChoose("Webmaster");
        contactUp.writeEmail("Pepito@gmail.com");
        contactUp.writeOrder("Test QA");
        contactUp.writeMensaje("este es una prueba");
        contactUp.ClickBoton();

        String expect = "Your message has been successfully sent to our team.";
        contactUp.validateTextMessage(expect);

    }
}
