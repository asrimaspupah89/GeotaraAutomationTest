package Stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteMerchant {
	
	WebDriver driver = null;
	
	@Given("browser open")
	public void browser_open() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/Asus/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
	}

	@And("user at login page")
	public void user_at_login_page(){
	
		driver.navigate().to("https://geotara.my.id/login");
	
	}
	
	@When("user enter email and password")
	public void user_enter_email_and_password() {

		driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
		driver.findElement(By.id("password")).sendKeys("admin");
	
	}

	@And("user clicks at login button")
	public void user_clicks_at_login_button() {
	    driver.findElement(By.id("submit_login")).click();
	}

	@Then("user is navigate to the dashboard page")
	public void user_is_navigate_to_the_dashboard_page() {
	    String expectedUrl = "https://geotara.my.id/dashboard";
	    String actualUrl = driver.getCurrentUrl();
	}
	
	@When("User click on the kemitraan button")
	public void user_click_on_the_kemitraan_button() {
	    driver.findElement(By.id("kemitraan-tab")).click();
	}

	@And("User click on Merchant dan Souvernir button")
	public void user_click_on_Merchant_dan_Souvernir_button() {
		driver.findElement(By.id("merchant-menu")).click();
	}

	@Then("User is navigate to the merchant page")
	public void user_is_navigate_to_merchant_page() {
		String expectedUrl = "https://geotara.my.id/merchant";
	    String actualUrl = driver.getCurrentUrl();
	}
	
	@When("User klik tombol hapus dan menghapus baris 7")
	public void user_klik_tombol_hapus_dan_menghapus_baris_7() {
	driver.findElement(By.cssSelector("a.shadow.btn.btn-danger.btn-xs")).click();
	}
	
	@And("User click on Ya Hapus button")
	public void user_click_on_Ya_Hapus_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Ya, hapus!')]")).click();
	} 
	
	@Then("User is stay in the merchant page")
	public void user_is_stay_to_merchant_page() {
		String expectedUrl = "https://geotara.my.id/merchant";
	    String actualUrl = driver.getCurrentUrl();
	}

}