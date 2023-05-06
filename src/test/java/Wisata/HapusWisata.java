//Author : Hilma Sri Rahayu
//Date : 06 Mei 2023
//Description : Menghapus data tur dan travel

package Wisata;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HapusWisata {

	WebDriver driver = null;

	@Given("browser starts up")
	public void browserStartsUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}

	@And("user open geotara cms web")
	public void userOpenGeotaraCMSWeb() {
		driver.navigate().to("https://geotara.my.id/");
	}

	@And("user enter invalid username and password")
	public void userEnterInvalidUsernameAndPassword() {
		driver.findElement(By.id("email")).sendKeys("hilma@geotara.com");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("submit_login")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}

	 @And("user presses ok button") 
	 public void userPressesOkButton() { 
		 driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled'][text()='OK']")).click();
		 
		 try {
			 Thread.sleep(1000); } 
		 catch (InterruptedException e) {
			 System.out.println("error"); 
		 } 
	}

	@And("user enter valid username and password")
	public void userEnterValidUsernameAndPassword() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("admintest@geotara.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("submit_login")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}

	@And("user presses wisata")
	public void userPressesWisata() {
		driver.findElement(By.xpath("//a[@class='ai-icon' and @href='/wisata']")).click(); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}

	 @When("user presses delete button") 
	 public void userPressesDeleteButton() { 
		 driver.findElement(By.cssSelector("div#row-0 div[data-column-id='5'] a.btn-danger")).click();  
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("error");
			}
		 }

	 @And("notification shown")
	 public void notificationShown() {
		 String titleNotif = driver.findElement(By.id("swal2-title")).getText();
		 	if (titleNotif.isEmpty())
	            throw new RuntimeException("Error : something error");
	    }

	 @Then("user presses cancel button") 
	 public void userPressesCancelButton() { 
		 driver.findElement(By.xpath("//div[@class='swal2-actions']//button[@class='swal2-cancel swal2-styled']")).click(); 
		 try { 
			 Thread.sleep(1000); 
			 } catch (InterruptedException e) {
				 System.out.println("error"); 
				 } 
		 }

	 @When("user presses delete button again") 
	 public void userPressesDeleteButtonAgain() { 
		 driver.findElement(By.cssSelector("div#row-0 div[data-column-id='5'] a.btn-danger")).click();  
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("error");
			}
		 }
	 
	 @And("notification shown again")
	 public void notificationShownAgain() {
		 String titleNotif = driver.findElement(By.id("swal2-title")).getText();
		 	if (titleNotif.isEmpty())
	            throw new RuntimeException("Error : something error");
	    }

	 @Then("user presses hapus button") 
	 public void userPressesHapusButton(){
		 driver.findElement(By.cssSelector("button.swal2-confirm")).click();
		 }

}
