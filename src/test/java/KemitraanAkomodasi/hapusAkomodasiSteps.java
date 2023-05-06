package KemitraanAkomodasi;

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

public class hapusAkomodasiSteps {
	WebDriver driver = null;
	
	@Given("User hapus akomodasi has opened the browser")
	public void User_hapus_akomodasi_has_opened_the_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/ACER/Documents/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
	@And("User hapus akomodasi already in home page")
	public void User_hapus_akomodasi_already_in_home_page() {
	    driver.navigate().to("https://geotara.my.id/login");
	    driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.id("submit_login")).click();
	    WebElement pageTitle = driver.findElement(By.xpath("//div[@class='dashboard_bar' and contains(text(),'dashboard')]"));
		assertEquals("", pageTitle.getText().toLowerCase());
	}
	
	@When("User hapus akomodasi clicks on sidebar with tab name Kemitraan")
	public void User_hapus_akomodasi_clicks_on_sidebar_with_tab_name_Kemitraan() {
		driver.findElement(By.xpath("//a[@href='/dashboard']//span[text()='Kemitraan']")).click();
	}
	
	@And("User hapus akomodasi clicks on sidebar with dropdown tab name Akomodasi")
	public void User_hapus_akomodasi_clicks_on_sidebar_with_dropdown_tab_name_Akomodasi() {
		driver.findElement(By.xpath("//a[@href='/accomodation']")).click();
	}
	
	@And("User hapus akomodasi clicks on Hapus button")
	public void User_hapus_akomodasi_clicks_on_Hapus_button() {
		driver.findElement(By.cssSelector("i.fa.fa-trash")).click();;
	}
	
	@And("User hapus akomodasi gets a data delete notification")
	public void User_hapus_akomodasi_gets_a_data_delete_notification() {
		String msgText = driver.findElement(By.cssSelector(".swal2-title")).getText();
	    assertEquals("Anda yakin ingin menghapus accomodation ini?", msgText);
	}
	
	@And("User hapus akomodasi clicks on {string} button")
	public void User_hapus_akomodasi_clicks_on_choice_button(String choice) {
		if (choice.equals("Ya Hapus")) {
	        fail("Test fail, element not interactable");
	    } else {
	    	driver.findElement(By.xpath("//button[text()='"+choice+"']")).click();
	    }
	}

	@Then("User hapus akomodasi should be {string} to see notification Data berhasil Dihapus")
	public void User_hapus_akomodasi_should_be_condition_to_see_notification_Data_berhasil_Dihapus(String condition) {
	    if (condition.equals("able")) {
	        String msg = driver.findElement(By.cssSelector(".swal2-title")).getText();
	        assertEquals("Data Berhasil Dihapus", msg);
	    } else if (condition.equals("not able")) {
	    	System.out.println("Notification is not expected to be present");
	    }
	}
	
	@And("User hapus akomodasi should be able to see the Accommodation home page {string}")
	public void User_hapus_akomodasi_should_be_able_to_see_the_Accommodation_home_page_result(String result) {
		if (result.equals("with the deleted data on the home page gone")) {
	        boolean isPresent = driver.findElements(By.xpath("//td[contains(text(),'Hotel Santika Garut')]/parent::tr")).size() > 0;
	        assertFalse(isPresent);
	    } else {
	    	WebElement pageTitle = driver.findElement(By.xpath("//div[@class='dashboard_bar' and contains(text(),'accomodation')]"));
			assertEquals("accomodation", pageTitle.getText().toLowerCase());
	    }
	}
}
