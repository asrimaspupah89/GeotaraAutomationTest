// Author : Nisa Hauna Yusriyyah
// Tambah data atraksi CMS Geotara

package KemitraanAtraksi;

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

public class TambahAtraksi {
	WebDriver driver = null;
	
	@Given("Browser already opened")
	public void userOpenBrowser() {
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}
	
	@And("User has opened cms geotara web app")
	public void userHasOpenCMSGeotara() {
		driver.navigate().to("https://geotara.my.id/");
	}
	
	@And("User inputs valid email and password")
	public void userInputValidAuthorization() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("submit_login")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}
	
	@When("User click kemitraan on sidebar")
	public void userClickKemitraan() {
		driver.findElement(By.xpath("//a[@href='/dashboard']//span[text()='Kemitraan']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}
	
	@And("User click Atraksi on dropdown list")
	public void userClickAtraksi() {
		driver.findElement(By.xpath("//a[@href='/attraction']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}
	
	@And("User clicks button tambah")
	public void userClickButtonTambah() {
		driver.findElement(By.xpath("//a[@href='/attraction/tambah']/button")).click();
	}
	
	@And("User input {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} dan {string}")
	public void UserInput(String nama, String banner, String harga_tiket, String provinsi, String kota, String distrik, String desa, String alamat, String longitude, String latitude, String tipe_atraksi, String rating, String deskripsi, String durasi, String kapasitas) {
	    try {
			driver.findElement(By.name("nama")).sendKeys(nama);	    
			driver.findElement(By.name("thumbnail")).sendKeys(banner);	    
			driver.findElement(By.name("harga_tiket")).sendKeys(harga_tiket);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); 
			WebElement prov = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-input")));
			prov.sendKeys(provinsi);
			prov.sendKeys(Keys.ENTER);
			WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-3-input")));
			city.sendKeys(kota);
			city.sendKeys(Keys.ENTER);
			WebElement kec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-4-input")));
			kec.sendKeys(distrik);
			kec.sendKeys(Keys.ENTER);
			WebElement village = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-5-input")));
			village.sendKeys(desa);
			village.sendKeys(Keys.ENTER);  
			WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("alamat")));
			address.sendKeys(alamat);	    
			driver.findElement(By.name("tipe_atraksi")).sendKeys(tipe_atraksi);
			driver.findElement(By.name("rating")).sendKeys(rating);
			driver.findElement(By.name("deskripsi")).sendKeys(deskripsi);
			driver.findElement(By.name("durasi")).sendKeys(durasi);	    
			driver.findElement(By.name("kapasitas")).sendKeys(kapasitas);
	    } catch (ElementNotInteractableException e) {
			fail("Element is not interactable, test failed!");
		}
	}
	
	@And("User click button simpan")
	public void UserClickButtonSimpan() {
		driver.findElement(By.cssSelector("button.btn.btn-primary.me-2")).click(); 
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("error");
			}
	}

	@Then("User should be {string} to see notifications Data Tersimpan")
	public void User_tambah_akomodasi_should_be_result_to_see_notifications_Data_Tersimpan(String condition) {
	    if (condition.equals("able")) {
	        String msg = driver.findElement(By.cssSelector(".swal2-title")).getText();
	        assertEquals("Data Berhasil Disimpan", msg);
	    } else if (condition.equals("not able")) {
	    	System.out.println("Notification is not expected to be present");
	    }
	}

}
