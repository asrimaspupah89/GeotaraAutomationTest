package KemitraanAtraksi;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import TheDriver.TheDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class EditAtraksi {
	WebDriver driver = null;
	
	@Given("web browser telah dibuka")
	public void membuka_web_browser() {
		System.setProperty("webdriver.cromedriver", "/as QA/Cucumber/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@And("user mengakses web geotara")
	public void uer_mengakses_web_geotara() {
		driver.navigate().to("https://geotara.my.id/");
	}
	
	@And("user menginput email dan password")
	public void user_menginput_email_dan_Password() {
		driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("submit_login")).click();
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			System.out.println("error");
		}
	}
	
	@And("user masuk di dashboard geotara")
	public void user_masuk_Di_dashboard_geotara() {
		driver.findElement(By.className("dashboard_bar")).isDisplayed();
	}
	
	@When("user mengklik kemitraan")
	public void user_mengklik_kemitraan() {
		WebElement kemitraanBtn = driver.findElement(By.id("kemitraan-tab"));
		kemitraanBtn.click();
	}
	
	@And("mengklik atraksi")
	public void mengklik_atraksi() {
		WebElement atraksiBtn = driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div/div[1]/ul/li[4]/ul/li[2]/a"));
		atraksiBtn.click();
	}
	
	@When("user mengkilk tombol edit")
	public void user_mengklik_tombol_edit() {
		WebElement editatraksiBtn = driver.findElement(By.className("fa-pen"));
		WebElement editBtn = editatraksiBtn.findElement(By.xpath(".."));
		editBtn.click();
	}
	
	@When("user memasukan info atraksi {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_memasukan_info_atraksi(String nama, String harga, String provinsi, String kota, String distrik, String desa, String alamat, String longitude, String latitude) throws InterruptedException {
		WebElement formInputNama = driver.findElement(By.name("nama"));
		WebElement formInputDeskripsi = driver.findElement(By.name("deskripsi"));
		WebElement formInputThumbnail = driver.findElement(By.name("thumbnail"));
		WebElement formInputProvinsi = driver.findElement(By.id("react-select-2-input"));
		WebElement formInputKota = driver.findElement(By.id("react-select-3-input"));
		WebElement formInputDistrik = driver.findElement(By.id("react-select-4-input"));
		WebElement formInputDesa = driver.findElement(By.id("react-select-5-input"));
		WebElement formInputAlamat = driver.findElement(By.name("alamat"));
		WebElement formInputLongitude = driver.findElement(By.name("longitude"));
		WebElement formInputLatitude = driver.findElement(By.name("latitude"));
		WebElement formInputHarga = driver.findElement(By.name("harga"));
		
		Thread.sleep(4000);
		formInputNama.clear();
		formInputNama.sendKeys(nama);
		formInputDeskripsi.clear();
		formInputDeskripsi.sendKeys(harga);
		formInputThumbnail.sendKeys(provinsi);
		formInputProvinsi.sendKeys(provinsi+"\n");
		formInputKota.sendKeys(kota+"\n");
		formInputDistrik.sendKeys(distrik+"\n");
		formInputDesa.sendKeys(desa+"\n");
		formInputAlamat.clear();
		formInputAlamat.sendKeys(alamat);
		formInputLongitude.sendKeys(longitude);
		formInputLatitude.sendKeys(latitude);	
		formInputHarga.sendKeys(harga);
	}
	
	@And("menekan tombol update")
	public void menekan_tombol_update() {
		driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/form/fieldset/button")).click();
	}
	
	@Then("notifikasi user berhasil di edit")
	public void notifikasi_user_berhasil_di_edit() {
		String berhasilText = driver.findElement(By.id("swal2-content")).getText();
		System.out.println(berhasilText);
		assertEquals("Pengguna berhasil diupdate", berhasilText);
	}
}