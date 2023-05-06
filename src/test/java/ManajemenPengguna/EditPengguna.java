package ManajemenPengguna;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.*;
import static org.junit.Assert.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditPengguna {
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
	
	@And("user mengakses ke halaman pengguna")
	public void user_diarahkan_ke_halaman_pengguna() {
		driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div/div[1]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div/div[1]/ul/li[5]/a/..")).click();
		driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div/div[1]/ul/li[5]/ul/li/a")).click();
	}
	
	@When("user menekan tombol edit")
	public void user_menekan_tombol_edit() {
		driver.findElement(By.xpath("//*[@id=\"cell-5-undefined\"]/div/a[2]")).click();
	}
	
	@And("user memasukan nama pengguna baru dengan {word} {word}")
	public void user_memasukan_nama_pengguna_baru_dengan_nama(String Nama, String Email) {
		driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/form/fieldset/div[1]/div[1]/input")).sendKeys(Nama);
		driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/form/fieldset/div[1]/div[1]/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/form/fieldset/div[1]/div[2]/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/form/fieldset/div[1]/div[2]/input")).sendKeys(Email);
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
