package KemitraanRestoran;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class hapusRestoranSteps {
	WebDriver driver = null;
	
	@Given("User hapus restoran has opened the browser")
	public void User_hapus_restoran_has_opened_the_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\GeotaraAutomationTest-main\\GeotaraAutomationTest-main\\src\\test\\resources\\drivers");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
	@And("User hapus restoran already in home page")
	public void User_hapus_restoran_already_in_home_page() {
	    driver.navigate().to("https://geotara.my.id/login");
	    driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.id("submit_login")).click();
	    WebElement pageTitle = driver.findElement(By.xpath("//div[@class='dashboard_bar' and contains(text(),'dashboard')]"));
		assertEquals("", pageTitle.getText().toLowerCase());
	}
	
	@When("User hapus restoran clicks on Kemitraan button")
	public void User_hapus_restorna_clicks_on_Kemitraan_button() {
		driver.findElement(By.xpath("//a[@href='/dashboard']//span[text()='Kemitraan']")).click();
	}
	
	@And("User hapus restoran clicks on Restoran button")
	public void User_hapus_akomodasi_clicks_on_Restoran_button() {
		driver.findElement(By.xpath("//a[@href='/restoran']")).click();
	}
	
	@And("User hapus restoran clicks on Hapus {string} button")
	public void User_hapus_restoran_clicks_on_Hapus_button(String row_data) {
		driver.findElement(By.xpath("//div[@id='row-" + row_data + "']//i[@class='fa fa-trash']")).click();
	}
	
	@And("User hapus restoran gets a data delete notification")
	public void User_hapus_restoran_gets_a_data_delete_notification() {
		String msgText = driver.findElement(By.cssSelector(".swal2-title")).getText();
	    assertEquals("Anda yakin ingin menghapus accomodation ini?", msgText);
	}
	
	@And("User hapus restoran clicks on {string} button")
	public void User_hapus_restoran_clicks_on_choice_button(String choice) {
		if (choice.equals("Ya Hapus")) {
	        fail("Test fail, element not interactable");
	    } else {
	    	driver.findElement(By.xpath("//button[text()='"+choice+"']")).click();
	    }
	}

	@Then("User hapus restoran should be {string} to see notification Data berhasil Dihapus")
	public void User_hapus_restorna_should_be_condition_to_see_notification_Data_berhasil_Dihapus(String condition) {
	    if (condition.equals("able")) {
	        String msg = driver.findElement(By.cssSelector(".swal2-title")).getText();
	        assertEquals("Data Berhasil Dihapus", msg);
	    } else if (condition.equals("not able")) {
	    	System.out.println("Notification is not expected to be present");
	    }
	}
	
	@And("User hapus restoran should be able to see the Restoran home page {string}")
	public void User_hapus_restoran_should_be_able_to_see_the_Restoran_home_page_result(String result) {
		if (result.equals("with the deleted data on the home page gone")) {
	        boolean isPresent = driver.findElements(By.xpath("//td[contains(text(),'Restoran A')]/parent::tr")).size() > 0;
	        assertFalse(isPresent);
	    } else {
	    	WebElement pageTitle = driver.findElement(By.xpath("//div[@class='dashboard_bar' and contains(text(),'restoran')]"));
			assertEquals("restoran", pageTitle.getText().toLowerCase());
	    }
	}
}
