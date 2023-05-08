package PublikasiAcara;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class tambahAcara {
    WebDriver driver = null;
    private static Logger LOGGER = LoggerFactory.getLogger(tambahAcara.class);

    @Given("User has opened the browser")
    public void user_has_opened_the_browser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Daily\\KULIAH\\Perkulihan JTK\\Semester 6\\Software Testing\\GeotaraAutomationTest\\src\\test\\resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @Given("User already in home page")
    public void user_already_in_home_page() {
        driver.navigate().to("https://geotara.my.id/login");

        driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
        driver.findElement(By.id("password")).sendKeys("admin");

        driver.findElement(By.id("submit_login")).click();

        By containerSelector = By.className("container-fluid");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(containerSelector));
        } catch (TimeoutException e) {
            fail("The home page did not load within 10 seconds.");
            driver.quit();
        }
    }

    @When("User clicks on sidebar with tab name {string}")
    public void user_clicks_on_sidebar_with_tab_name(String tabName) {
        if(tabName.equals("Publikasi")) {
            By dropdownTab = By.xpath("/html/body/div/div/div[3]/div/div[1]/ul/li[3]/a");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdownTab));
                element.click();
            } catch (TimeoutException e) {
                fail("The tab " + tabName + " did not load within 10 seconds.");
                driver.quit();
            }
        }
    }

    @When("User clicks on sidebar with dropdown tab name {string}")
    public void user_clicks_on_sidebar_with_dropdown_tab_name(String dropdownTabName) {
        if(dropdownTabName.equals("Acara")) {
            By dropdownTab = By.xpath("/html/body/div/div/div[3]/div/div[1]/ul/li[3]/ul/li[2]/a");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                wait.until(ExpectedConditions.elementToBeClickable(dropdownTab)).click();
            } catch (TimeoutException e) {
                fail("The dropdown tab " + dropdownTabName + " did not load within 10 seconds.");
                driver.quit();
            }
        }

    }

    @When("User clicks on {string} button")
    public void user_clicks_on_button(String buttonName) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By button = null;
        if(buttonName.equals("Tambah")) {
            button = By.xpath("/html/body/div/div/div[4]/div/div[2]/div/div/div[1]/a/button");
        } else if(buttonName.equals("Simpan")) {
            button = By.xpath("/html/body/div/div/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/button");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(button));
//            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (ElementClickInterceptedException e) {
            fail(e.getMessage());
            driver.quit();
        } catch (TimeoutException e) {
            fail("The button " + buttonName + " did not load within 10 seconds.");
            driver.quit();
        }
    }

    @When("User fill form")
    public void user_fill_form(DataTable testData) throws ParseException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);

            Map<String, String> data = testData.asMap(String.class, String.class);

            driver.findElement(By.name("nama")).sendKeys(data.get("nama_event"));
        } catch (TimeoutException e) {
            LOGGER.info("Timeout exception occurred.");
            driver.quit();
        }
    }

    @Then("User is navigated to the acara list page")
    public void user_is_navigated_to_the_acara_list_page() {
        By containerSelector = By.className("card-title");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(containerSelector));
            String actualText = element.getText();
            Assert.assertEquals("The actual text does not match the expected text.", "Daftar Acara", actualText);
            driver.quit();
        } catch (TimeoutException e) {
            fail("The acara list page did not load within 10 seconds.");
            driver.quit();
        }
    }

    @Then("User should be able to see success notification with message {string}")
    public void user_should_be_able_to_see_success_notification_with_message(String message) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-content")));
                String actualText = element.getText();
                Assert.assertEquals("The actual text does not match the expected text.", message, actualText);
                driver.quit();
            } catch (TimeoutException e) {
                fail("The success notification did not load within 10 seconds.");
                driver.quit();
            }
        } catch (TimeoutException e) {
            LOGGER.info("Timeout exception occurred.");
            driver.quit();
        }
    }

    @Then("User should be able to see error notification with message {string}")
    public void user_should_be_able_to_see_error_notification_with_message(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-content")));
            String actualText = element.getText();
            Assert.assertEquals("The actual text does not match the expected text.", message, actualText);
            driver.quit();
        } catch (TimeoutException e) {
            fail("The error notification did not load within 10 seconds.");
            driver.quit();
        }
    }
}
