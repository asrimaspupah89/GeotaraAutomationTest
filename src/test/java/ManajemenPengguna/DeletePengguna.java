package StepDefinitions;

import java.time.Duration;

//import java.time.Duration;

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

public class DeletePengguna {
	WebDriver driver = null;
	
	@Given("membuka broswe")
	public void membuka_browser() {
		// Membuka browser dan membuka link objek pengujian
		System.setProperty("webdriver.chrome.driver", "/as QA/Cucumber/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(options);
//	    ChromeDriver driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
}

	@And("user membuka web geotara")
	public void user_membuka_web_geotara() {
		driver.navigate().to("https://geotara.my.id/");
	}

	@And("user memasukkan email dan password")
	public void user_memasukkan_dan() {
		driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.id("submit_login")).click();
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        System.out.println("error");
	    }
	}

	@When("user berada di dashboard geotara")
	public void user_berada_di_dashboard_geotara() {
	    driver.findElement(By.className("dashboard_bar")).isDisplayed();
	}

	@Then("user dinavigasikan ke halaman pengguna")
	public void user_dinavigasikan_ke_halaman_pengguna() {
		driver.findElement(By.xpath("//a[contains(@class,'has-arrow') and contains(@href,'/') and span[text()='Manajemen']]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/pengguna') and text()='Pengguna']")).click();
	}
	
	@When("user menekan tombol hapus")
	public void user_menekan_tombol_hapus() {
	    driver.findElement(By.xpath("//*[@id=\'cell-5-undefined\']/div/a[3]")).click();
	}
		

	@Then("menekan tombol konfirmasi")
	public void menekan_tombol_konfirmasi() {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
	}

	@Then("notifikasi user berhasil dihapus")
	public void notifikasi_user_berhasil_dihapus() {
		String berhasilText = driver.findElement(By.id("swal2-content")).getText();
		if (berhasilText != "Pengguna berhasil dihapus")
			   throw new RuntimeException("Error : something error");
	}
}