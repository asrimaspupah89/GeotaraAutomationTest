package KemitraanRestoran;

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

public class tambahRestoranSteps {
	WebDriver driver = null;

	 @Given("^User tambah restoran has opened the browser$")
	    public void user_tambah_restoran_has_opened_the_browser() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\GeotaraAutomationTest-main\\GeotaraAutomationTest-main\\src\\test\\resources\\drivers\\chromedriver.exe");
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--remote-allow-origins=*");
		    
		    driver = new ChromeDriver(options);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	    }

	    @And("^User tambah restoran already in home page$")
	    public void user_tambah_restoran_already_in_home_page() {
	    	driver.navigate().to("https://geotara.my.id/login");
		    driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
		    driver.findElement(By.id("password")).sendKeys("admin");
		    driver.findElement(By.id("submit_login")).click();
		    WebElement pageTitle = driver.findElement(By.xpath("//div[@class='dashboard_bar' and contains(text(),'dashboard')]"));
			assertEquals("", pageTitle.getText().toLowerCase());
	    }

	    @When("^User tambah restoran clicks on Kemitraan button$")
	    public void user_tambah_restoran_clicks_on_Kemitraan_button() {
	    	driver.findElement(By.xpath("//a[@href='/dashboard']//span[text()='Kemitraan']")).click();
	    }
	    
	    @And("^User tambah restoran clicks on Restoran button$")
	    public void user_tambah_restoran_clicks_on_Restoran_button() {
	    	driver.findElement(By.xpath("//a[@href='/restoran']")).click();
	    }

	    @And("^User tambah restoran clicks on Tambah button$")
	    public void user_tambah_restoran_clicks_on_Tambah_button() {
	    	driver.findElement(By.xpath("//a[@href='/restoran/tambah']/button")).click();
	    }

	    @And("^User tambah restoran mengisi {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	    public void user_tambah_restoran_mengisi(String nama, String banner, String provinsi, String kota, String distrik, String desa, String alamat, String longitude, String latitude, String no_Telp, String email, String rating, String jam_buka, String jam_tutup) {
	    	try {
			    	driver.findElement(By.name("nama")).sendKeys(nama);
					driver.findElement(By.name("banner")).sendKeys(banner);	    
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
					driver.findElement(By.name("no_telp")).sendKeys(no_Telp);	    
					driver.findElement(By.name("email")).sendKeys(email);	    
					driver.findElement(By.name("rating")).sendKeys(rating);
					driver.findElement(By.name("jam_buka")).sendKeys(jam_buka);
					driver.findElement(By.name("jam_tutup")).sendKeys(jam_tutup);
			} catch (ElementNotInteractableException e) {
					fail("Element is not interactable, test failed!");
				}
	    }

	    @And("^User tambah restoran clicks on \"([^\"]*)\" button$")
	    public void user_tambah_restoran_clicks_on_button(String simpan) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary"))).click();
			} catch (ElementNotInteractableException e) {
				fail("Element is not interactable, test failed!");
			}
	    }

	    @Then("^User tambah restoran should be \"([^\"]*)\" to see notifications Data Tersimpan$")
	    public void user_tambah_restoran_should_be_to_see_notifications_Data_Tersimpan(String condition) {
	    	if (condition.equals("able")) {
		        String msg = driver.findElement(By.cssSelector(".swal2-title")).getText();
		        assertEquals("Data Berhasil Disimpan", msg);
		    } else if (condition.equals("not able")) {
		    	System.out.println("Notification is not expected to be present");
		    }
		}
	}