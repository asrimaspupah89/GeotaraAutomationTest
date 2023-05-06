package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPenggunaSteps {
	WebDriver driver = null;
	@Given("browser terbuka")
	public void browser_terbuka() {
		// Membuka browser dan membuka link objek pengujian
		System.setProperty("webdriver.chrome.driver", "/as QA/Cucumber/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(options);
//	    ChromeDriver driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
}

	@And("user membuka cms geotara")
	public void user_membuka_cms_geotara() {
		driver.navigate().to("https://geotara.my.id/");
	}

	@And("user memasukkan {string} dan {string}")
	public void user_memasukkan_dan(String string, String string2) {
		driver.findElement(By.id("email")).sendKeys("catur@geotara.com");
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.id("submit_login")).click();
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        System.out.println("error");
	    }
	}

	@When("user berada di dashboard")
	public void user_berada_di_dashboard() {
	    driver.findElement(By.className("dashboard_bar")).isDisplayed();
	}

	@Then("user diarahkan ke halaman pengguna")
	public void user_diarahkan_ke_halaman_pengguna() {
		driver.findElement(By.xpath("//a[contains(@class,'has-arrow') and contains(@href,'/') and span[text()='Manajemen']]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/pengguna') and text()='Pengguna']")).click();
	}


	@When("user menekan tombol tambah pengguna")
	public void user_menekan_tombol_tambah_pengguna() {
		driver.findElement(By.xpath("//a[@href='/pengguna/tambah']/button")).click();
	}

	@Then("user diarahkan ke form tambah pengguna")
	public void user_diarahkan_ke_form_tambah_pengguna() {
//		driver.findElement(By.className("dashboard_bar")).isDisplayed();
}

	@When("user add {} untuk nama baru")
	public void user_add_nama_untuk_nama_baru(String nama) {
        driver.findElement(By.xpath(" //*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/form/fieldset/div[1]/div[1]/input")).sendKeys(nama);
	}

	@And("user add {} untuk email baru")
	public void user_add_email_untuk_email_baru(String email) {
	    driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/form/fieldset/div[1]/div[2]/input")).sendKeys(email);
	}
	
	@And("user add {} untuk password")
	public void user_add_kata_sandi_untuk_password(String kataSandi) {
	    driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/form/fieldset/div[1]/div[3]/input")).sendKeys(kataSandi);
	}
	
	@And("user add {} untuk konfir pass")
	public void user_add_conf_kata_sandi_untuk_konfir_pass(String confKataSandi) {
	    driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/form/fieldset/div[1]/div[4]/input")).sendKeys(confKataSandi);
	}

	@And("user pilih {} untuk peran")
	public void user_pilih_peran_untuk_peran(String peran) {
	       driver.findElement(By.id("inputState")).sendKeys(peran);
	}
	
	@Then("menampilkan notifikasi berhasil Add Pengguna")
	public void menampilkan_notifikasi_berhasil_add_pengguna() {
		 driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/form/fieldset/button")).click();
	}
}