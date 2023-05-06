package Event;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class MenampilkanEventSteps {
	WebDriver driver = null;
	
	//	Given User has opened the browser
	@Given("User has opened the browser")
	public void User_has_opened_the_browser() {
	    System.setProperty("webdriver.chrome.driver", "/college stuff/smt 6/Pengujian Perangkat Lunak/tugas/praktek/W11/CucumberJava/src/test/resources/drivers/chromedriver.exe\"");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
//	When User click on header Event
	@When("User click on header Event")
	public void User_click_on_header_Event() {
		driver.findElement(By.xpath("//a[text()='Event']")).click();
	}
	
	
//	Then User should be able to see event page
	@Then("User should be able to see event page")
	public void User_should_be_able_to_see_event_page() {
		List<WebElement> title  = driver.findElements(By.xpath("//h2[@class='mb-2 text-sm lg:text-1xl font-bold text-primary']"));
		List<WebElement> subtitle = driver.findElements(By.xpath("//h1[@class='mb-8 text-3xl lg:text-5xl font-extrabold text-green-800']"));
		List<WebElement> content = driver.findElements(By.xpath("//div[@class='grid grid-cols-1 lg:grid-cols-3 gap-7']"));
		
		if (!title.isEmpty() && !subtitle.isEmpty() && !content.isEmpty()) {
			System.out.println("Article Event is displayed!");
		} else {
			System.out.println("Article Event is not displayed!");
		}
		
		Assert.assertTrue(!title.isEmpty() && !subtitle.isEmpty() && !content.isEmpty());
	}
	
//	Then User should be able to see article page about selected event "<event>" "<id>"
	@Then("User should be able to see article page about selected event {string} {string}")
	public void User_should_be_able_to_see_article_page_about_selected_event(String event, String id) {
		
		if (driver.getCurrentUrl().contains(id)) {
            System.out.println("Article Page About Selected Event is displayed!");
        } else {
            System.out.println("Article Page About Selected Event is not displayed!");
        }
		Assert.assertTrue(driver.getCurrentUrl().contains(id));
	}
	
//	Then User should be able to see pembayaran page <page>
	@Then("User should be able to see pembayaran page {string}")
	public void User_should_be_able_to_see_pembayaran_page(String page) {
		if (driver.getCurrentUrl().contains(page)) {
            System.out.println("Page Pembayaran is displayed!");
        } else {
            System.out.println("Page Pembayaran is not displayed!");
        }
		Assert.assertTrue(driver.getCurrentUrl().contains(page));
	}
	

//	And User has navigated on the landing page
	@And("User has navigated on the landing page")
	public void User_has_navigated_on_the_landing_page() {
		driver.navigate().to("https://portal.geotara.my.id/");	
	}
	
//	And User click button Lihat Event "<event>" on article banner
	@And("User click button Lihat Event {string} on article banner")
	public void User_click_button_Lihat_Event_on_article_banner(String event) {
		driver.findElement(By.xpath("//p[contains(text(),'"+ event +"')]/following-sibling::div/button/a[contains(text(),'Lihat Event')]")).click();
	}
	
//	And User click button Pesan Sekarang
	@And("User click button Pesan Sekarang")
	public void User_click_button_Pesan_Sekarang() {
		driver.findElement(By.xpath("//button[contains(text(), 'Pesan Sekarang')]")).click();
		
		WebElement pesanSekarangButton = driver.findElement(By.xpath("//button[contains(text(), 'Pesan Sekarang')]"));
		
		if (pesanSekarangButton.isEnabled()) {
		    System.out.println("Tombol Pesan Sekarang dapat diklik");
		    pesanSekarangButton.click();
		} else {
		    System.out.println("Tombol Pesan Sekarang tidak dapat diklik");
		}
		
		Assert.assertFalse(!pesanSekarangButton.isEnabled());
	}
}
