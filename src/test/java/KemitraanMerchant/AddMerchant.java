package Stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddMerchant {
	
	WebDriver driver = null;
	
	@Given("browser opened")
	public void browser_opened() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/Asus/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		
	}

	@And("user on login page")
	public void user_on_login_page(){
	
		driver.navigate().to("https://geotara.my.id/login");
	
	}
	
	@When("user enters email and password")
	public void user_enters_email_and_password() {

		driver.findElement(By.id("email")).sendKeys("catur@geotara.com");
		driver.findElement(By.id("password")).sendKeys("admin");
	
	}

	@And("user click on login button")
	public void user_click_on_login_button() {
	    driver.findElement(By.id("submit_login")).click();
	}

	@Then("user is navigated to the dashboard page")
	public void user_is_navigated_to_the_dashboard_page() {
	    String expectedUrl = "https://geotara.my.id/dashboard";
	    String actualUrl = driver.getCurrentUrl();
	}
	
	@When("User clicks on the kemitraan button")
	public void user_clicks_on_kemitraan_button() {
	    driver.findElement(By.id("kemitraan-tab")).click();
	}

	@And("User clicks on Merchant dan Souvernir button")
	public void user_clicks_on_Merchant_dan_Souvernir_button() {
		driver.findElement(By.id("merchant-menu")).click();
	}

	@Then("User is navigated to the merchant page")
	public void user_is_navigated_to_merchant_page() {
		String expectedUrl = "https://geotara.my.id/merchant";
	    String actualUrl = driver.getCurrentUrl();
	}
	
	@When("User clicks on the tambah button")
	public void user_clicks_on_tambah_button() {
	    driver.findElement(By.xpath("//button[contains(.,'Tambah')]")).click();
	}
	
	@Then("User is navigated to the tambah page")
	public void user_is_navigated_to_tambah_page() {
		String expectedUrl = "https://geotara.my.id/merchant/tambah";
	    String actualUrl = driver.getCurrentUrl();
	}
	
	@When("user enters merchant name")
	public void user_enters_merchant_name() {

		driver.findElement(By.name("nama")).sendKeys("Ibu Siti");
	}
	
	@And("User clicks on choose file button")
	public void User_clicks_on_choose_file_button() {
	    String fileLocation = System.getProperty("user.home") + "/Downloads/bajupantai.jpg";
	    driver.findElement(By.name("thumbnail")).sendKeys(fileLocation);
	}
	
	@And("User clicks on Provinsi")
	public void user_clicks_on_Provinsi() {
	    driver.findElement(By.id("react-select-2-input")).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'JAWA BARAT')]"))).click();
	}
	
	@And("User clicks on Kota")
	public void user_clicks_on_Kota() {
	    driver.findElement(By.id("react-select-3-input")).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'KABUPATEN PANGANDARAN')]"))).click();
	}
	
	@And("User clicks on Distrik")
	public void user_clicks_on_Distrik() {
		driver.findElement(By.id("react-select-4-input")).click();
		driver.findElement(By.id("react-select-4-input")).sendKeys("PANGANDARAN");
		driver.findElement(By.xpath("//div[text()='PANGANDARAN']")).click();
		driver.findElement(By.id("react-select-5-input")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1wa3eu0-placeholder' and text()='PANGANDARAN']"))).click();
	}
	
	@And("User clicks on Desa")
	public void user_clicks_on_Desa() {
		driver.findElement(By.id("react-select-5-input")).sendKeys("PANANJUNG");
		driver.findElement(By.xpath("//div[text()='PANANJUNG']")).click();
		driver.findElement(By.id("root")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'PANANJUNG')]"))).click();
		}
	
	@And("User clicks on Alamat")
	public void user_clicks_on_Alamat() {
		driver.findElement(By.name("alamat")).sendKeys("Jalan Tiwar");
	}
	
	@And("User clicks on Longitude")
	public void user_clicks_on_Longitude() {
		driver.findElement(By.name("Longitude")).sendKeys("108.64540978173694");
	}
}