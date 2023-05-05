package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		
		driver = new ChromeDriver(options);
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
//		System.out.println("Inside Step - user is on login page");
		driver.navigate().to("https://geotara.my.id");
	}
	
	@When("user enters {string} and {string}")
	public void user_enters_username_and_password(String email, String password) {
//		System.out.println("Inside Step - user enters username and password" + username + password);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@And("clicks on login button")
	public void clicks_on_login_button() {
//		System.out.println("Inside Step - clicks on login button");
		driver.findElement(By.id("submit_login")).click();
	}
	
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("user is navigated to the home page");
//		driver.findElement(By.xpath("//*[@id=\"psaapp\"]/div/div[2]/div/div[2]/div/div[1]")).isDisplayed();
	}
}
