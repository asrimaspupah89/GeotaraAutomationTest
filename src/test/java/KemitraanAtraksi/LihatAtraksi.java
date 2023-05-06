package KemitraanAtraksi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LihatAtraksi {
    WebDriver driver;

    @Given("user has opened the browser")
    public void user_has_opened_the_browser() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Documents/Programming/Java/GeotaraAutomationTest/src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.navigate().to("https://portal.geotara.my.id/");
    }
    @Given("user has navigated on the landing page")
    public void user_has_navigated_on_the_landing_page() {
        // Get the current URL of the page
        String actualUrl = driver.getCurrentUrl();

        // Define the expected URL of the page
        String expectedUrl = "https://portal.geotara.my.id/";

        // Use assertEquals to compare the actual and expected URLs
        assertEquals(expectedUrl, actualUrl);
    }
    @When("user click on header {string}")
    public void user_click_on_header(String string) {
        driver.findElement(By.xpath("//*[@id=\"dropdownNavbarLink\"]")).click();
    }
    @When("user click on {string}")
    public void user_click_on(String string) {
        driver.findElement(By.xpath("//a[text()='Atraksi' and contains(@class, 'block')]")).click();
    }

    @Then("user should be able to see atraksi page")
    public void user_should_be_able_to_see_atraksi_page() {
        // Get the current URL of the page
        String actualUrl = driver.getCurrentUrl();

        // Define the expected URL of the page
        String expectedUrl = "https://portal.geotara.my.id/attraction";

        // Use assertEquals to compare the actual and expected URLs
        assertEquals(expectedUrl, actualUrl);
    }

    // TC 2
    @When("user click on Lihat Artikel")
    public void user_click_on_lihat_artikel() {
        driver.findElement(By.xpath("//button[span[text()='Lihat Artikel']]")).click();
    }

    @Then("user should be able to see article page")
    public void user_should_be_able_to_see_article_page() {
        // Get the current URL of the page
        String actualUrl = driver.getCurrentUrl();

        // Define the expected URL of the page
        String expectedUrl = "https://portal.geotara.my.id/artikel/detail/";

        // Use assertEquals to compare the actual and expected URLs
        assertEquals(expectedUrl, actualUrl);
    }

    // TC 3
    @When("user click on dropdown {string}")
    public void user_click_on_dropdown(String string) {
        driver.findElement(By.xpath("//button[div/span[text()='Sort By']]")).click();
    }
    @When("user click item {string}")
    public void user_click_item(String string) {
        driver.findElement(By.xpath("//li[text()='A-Z']")).click();
    }
    @Then("user should be able to see card sort by alphabetically A-Z on page about atraksi")
    public void user_should_be_able_to_see_card_sort_by_alphabetically_a_z_on_page_about_atraksi() {
        // Get the current URL of the page
        String actualUrl = driver.getCurrentUrl();

        // Define the expected URL of the page
        String expectedUrl = "https://portal.geotara.my.id/attraction?filter=A-Z";

        // Use assertEquals to compare the actual and expected URLs
        assertTrue(actualUrl.startsWith(expectedUrl));
    }

    // TC 4
    @Then("user should be able to see card sort by alphabetically Z-A on page about atraksi")
    public void user_should_be_able_to_see_card_sort_by_alphabetically_z_a_on_page_about_atraksi() {
        // Get the current URL of the page
        String actualUrl = driver.getCurrentUrl();

        // Define the expected URL of the page
        String expectedUrl = "https://portal.geotara.my.id/attraction?filter=Z-A";

        // Use assertEquals to compare the actual and expected URLs
        assertTrue(actualUrl.startsWith(expectedUrl));
    }

    // TC 5
    @Then("user should be able to see card sort by price Low to High on page about atraksi")
    public void user_should_be_able_to_see_card_sort_by_price_low_to_high_on_page_about_atraksi() {
        // Get the current URL of the page
        String actualUrl = driver.getCurrentUrl();

        // Define the expected URL of the page
        String expectedUrl = "https://portal.geotara.my.id/attraction?filter=Low-High";

        // Use assertEquals to compare the actual and expected URLs
        assertTrue(actualUrl.startsWith(expectedUrl));
    }
}
