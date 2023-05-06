package KemitraanAkomodasi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tambahAkomodasiSteps {
	WebDriver driver = null;
	
	@Given("User tambah akomodasi has opened the browser")
	public void User_tambah_akomodasi_has_opened_the_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/ACER/Documents/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
	@And("User tambah akomodasi already in home page")
	public void User_tambah_akomodasi_already_in_home_page() {
	    driver.navigate().to("https://geotara.my.id/login");
	    driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.id("submit_login")).click();
	    WebElement pageTitle = driver.findElement(By.xpath("//div[@class='dashboard_bar' and contains(text(),'dashboard')]"));
		assertEquals("", pageTitle.getText().toLowerCase());
	}
	
	@When("User tambah akomodasi clicks on sidebar with tab name Kemitraan")
	public void User_tambah_akomodasi_clicks_on_sidebar_with_tab_name_Kemitraan() {
		driver.findElement(By.xpath("//a[@href='/dashboard']//span[text()='Kemitraan']")).click();
	}
	
	@And("User tambah akomodasi clicks on sidebar with dropdown tab name Akomodasi")
	public void User_tambah_akomodasi_clicks_on_sidebar_with_dropdown_tab_name_Akomodasi() {
		driver.findElement(By.xpath("//a[@href='/accomodation']")).click();
	}
	
	@And("User tambah akomodasi clicks on Tambah button")
	public void User_tambah_akomodasi_clicks_on_Tambah_button() {
		driver.findElement(By.xpath("//a[@href='/accomodation/tambah']/button")).click();
	}
	
	@And("User tambah akomodasi mengisi {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} dan {string}")
	public void User_tambah_akomodasi_mengisi_dan(String nama, String deskripsi, String banner, String provinsi, String kota, String distrik, String desa, String alamat, String longitude, String latitude, String no_telp, String email, String harga, String rating, String fasilitas, String tipe, String harga_fasilitas, String thumbnail) {
	    try {
			driver.findElement(By.name("nama")).sendKeys(nama);
			driver.findElement(By.name("deskripsi")).sendKeys(deskripsi);	    
			driver.findElement(By.name("thumbnail")).sendKeys(banner);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); 
			WebElement prov = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-input")));
			prov.sendKeys(provinsi);
			prov.sendKeys(Keys.ENTER);
			WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-3-input")));
			city.sendKeys(kota);
			city.sendKeys(Keys.ENTER);
			WebElement kec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-4-input")));
			kec.sendKeys(distrik);
			//code for longitude and latitude, but still can't
			kec.sendKeys(Keys.ENTER);
			WebElement village = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-5-input")));
			village.sendKeys(desa);
			village.sendKeys(Keys.ENTER);  
			WebElement addr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("alamat")));
			addr.sendKeys(alamat);	
			driver.findElement(By.name("no_telp")).sendKeys(no_telp);	    
			driver.findElement(By.name("email")).sendKeys(email);	    
			driver.findElement(By.name("harga")).sendKeys(harga);	    
			driver.findElement(By.name("rating")).sendKeys(rating);	    
			driver.findElement(By.name("fasilitas")).sendKeys(fasilitas);	    
			driver.findElement(By.name("tipe")).sendKeys(tipe);
			driver.findElement(By.cssSelector("div.mb-4 input[name='harga']")).sendKeys(harga_fasilitas);
			driver.findElement(By.xpath("//div[@class='mb-4']//input[@name='thumbnail']")).sendKeys(thumbnail);
	    } catch (ElementNotInteractableException e) {
			fail("Element is not interactable, test failed!");
		}
	}

	
	@And("User tambah akomodasi clicks on {string} button")
	public void User_tambah_akomodasi_clicks_on_choice_button(String choice) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary"))).click();
		} catch (ElementNotInteractableException e) {
			fail("Element is not interactable, test failed!");
		}
	}

	@Then("User tambah akomodasi should be {string} to see notifications Data Tersimpan")
	public void User_tambah_akomodasi_should_be_result_to_see_notifications_Data_Tersimpan(String condition) {
	    if (condition.equals("able")) {
	        String msg = driver.findElement(By.cssSelector(".swal2-title")).getText();
	        assertEquals("Data Berhasil Disimpan", msg);
	    } else if (condition.equals("not able")) {
	    	System.out.println("Notification is not expected to be present");
	    }
	}
}
