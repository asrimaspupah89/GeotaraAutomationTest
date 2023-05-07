package Event;

import TheDriver.TheDriver;
import java.time.Duration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class EditEventSteps {

    @Given("User already in home page")
    public void user_is_on_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        TheDriver.getInstance();
        // fullscreen
        TheDriver.getInstance().manage().window().maximize();
        TheDriver.getInstance().navigate().to("https://geotara.my.id/login");
        TheDriver.getInstance().findElement(By.id("email")).sendKeys("admin@geotara.com");
        TheDriver.getInstance().findElement(By.id("password")).sendKeys("admin");
        TheDriver.getInstance().findElement(By.id("submit_login")).click();
    }
    @And("User click Publikasi on the sidebar")
    public void user_click_publikasi_on_the_sidebar() {
        // Write code here that turns the phrase above into concrete actions
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"publikasi-btn\"]/span")).click();
    }

    @And("User click Acara on the sidebar")
    public void user_click_acara_on_the_sidebar() {
        // Write code here that turns the phrase above into concrete actions
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div/div[1]/ul/li[3]/ul/li[2]/a")).click();
    }

//    @And("User cick Next button")
//    public void user_cick_next_button() {
//        // Write code here that turns the phrase above into concrete actions
//        TheDriver.getInstance().findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[2]/div[1]/div[5]/div/a[2]")).click();
//    }

    @And("User click Edit button on Testing Acara")
    public void user_click_edit_button_on_testing_acara() {
        // Write code here that turns the phrase above into concrete actions
        TheDriver.getInstance().findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[2]/div[1]/div[5]/div/a[2]")).click();
    }

    @When("User edited the {string} {string} {string} {string} {string} events properties")
    public void user_edited_the_events_properties(String title, String desc, String penyelenggara, String kontak, String price) {
        // Write code here that turns the phrase above into concrete actions

//        TheDriver.getInstance().wait(3000);

        WebDriverWait wait = new WebDriverWait(TheDriver.getInstance(), Duration.ofSeconds(10));
        //change the title
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[1]/input")));
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[1]/input")).click();
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[1]/input")).clear();
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[1]/input")).sendKeys(title);

        //change the description
        WebElement element1 = TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[3]/textarea"));
        Actions actions = new Actions(TheDriver.getInstance());
        actions.moveToElement(element).click().perform();
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[3]/textarea")).clear();
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[3]/textarea")).sendKeys(desc);

        //change textarea
        WebElement element2 = TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[3]/textarea"));
        Actions actions2 = new Actions(TheDriver.getInstance());
        actions.moveToElement(element).click().perform();
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[3]/textarea")).clear();
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[4]/input")).sendKeys(penyelenggara);

        //change contact person
        WebElement element3 = TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[5]/input"));
        Actions actions3 = new Actions(TheDriver.getInstance());
        actions.moveToElement(element).click().perform();
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[5]/input")).clear();
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[5]/input")).sendKeys(kontak);

        //change price
        WebElement element4 = TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[6]/input"));
        Actions actions4 = new Actions(TheDriver.getInstance());
        actions.moveToElement(element).click().perform();
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[6]/input")).clear();
//        String priceStr = Integer.toString(price);
        TheDriver.getInstance().findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/div[1]/div[6]/input")).sendKeys(price);

    }

    @And("click Submit button")
    public void click_submit_button() {
// Wait for the element to be clickable before clicking it
        // Wait for the element to be clickable before clicking it
        WebElement element5 = TheDriver.getInstance().findElement(By.xpath("/html/body/div/div/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/button"));
        JavascriptExecutor executor = (JavascriptExecutor) TheDriver.getInstance();
        executor.executeScript("window.scrollBy(0,1000)");
        WebDriverWait wait = new WebDriverWait(TheDriver.getInstance(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element5));


// Wait for a small delay to ensure the page is fully loaded and the element is in view
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(TheDriver.getInstance());
        actions.moveToElement(element5).click().perform();

    }

    @Then("events properties has been edited")
    public void events_properties_has_been_edited() {
        // Write code here that turns the phrase above into concrete actions
        try {
            String assert1 = TheDriver.getInstance().findElements(By.className("swal2-title")).get(0).getText();
            assertEquals("Berhasil!", assert1);
        } finally{
            TheDriver.getInstance().close();
            TheDriver.deleteInstance();
        }
    }

}
