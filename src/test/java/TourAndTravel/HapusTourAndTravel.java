//Author : Hilma Sri Rahayu
//Date : 06 Mei 2023
//Description : Menghapus data tur dan travel

package TourAndTravel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HapusTourAndTravel {

	WebDriver driver = null;

	@Given("browser is launched")
	public void browserIsLaunched() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}

	@And("user opens geotara cms web")
	public void userOpensGeotaraCMSWeb() {
		driver.navigate().to("https://geotara.my.id/");
	}

	@And("user inputs invalid email and password")
	public void userInputsInvalidEmailAndPassword() {
		driver.findElement(By.id("email")).sendKeys("hilma@geotara.com");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("submit_login")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}

	 @And("user presses the ok button") 
	 public void userPressesTheOkButton() { 
		 driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled'][text()='OK']")).click();
		 
		 try {
			 Thread.sleep(1000); } 
		 catch (InterruptedException e) {
			 System.out.println("error"); 
		 } 
	}

	@And("user inputs valid email and password")
	public void userInputsValidEmailAndPassword() {
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

	@And("user presses tur dan travel menu")
	public void userPressesTurDanTravelMenu() {
		driver.findElement(By.id("kemitraan-tab")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
		driver.findElement(By.linkText("Tur dan Travel")).click();
	}
	
	 @When("user presses the delete button") 
	 public void userPressesTheDeleteButton() { 
		 driver.findElement(By.xpath("//div[@id='row-4']//a[@class='shadow btn btn-danger btn-xs ']/i[@class='fa fa-trash']")).click(); 
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("error");
			}
		 }

	 @And("notification displayed")
	 public void notificationDisplayed() {
		 String titleNotif = driver.findElement(By.id("swal2-title")).getText();
		 	if (titleNotif.isEmpty())
	            throw new RuntimeException("Error : something error");
	    }

	 @Then("user presses the cancel button") 
	 public void userPressesTheCancelButton() { 
		 driver.findElement(By.xpath("//div[@class='swal2-actions']//button[@class='swal2-cancel swal2-styled']")).click(); 
		 try { 
			 Thread.sleep(1000); 
			 } catch (InterruptedException e) {
				 System.out.println("error"); 
				 } 
		 }

	 @When("user presses the delete button again") 
	 public void userPressesTheDeleteButtonAgain() { 
		 driver.findElement(By.xpath("//div[@id='row-4']//a[@class='shadow btn btn-danger btn-xs ']/i[@class='fa fa-trash']")).click(); 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("error");
			}
		 }
	 
	 @And("notification displayed again")
	 public void notificationDisplayedAgain() {
		 String titleNotif = driver.findElement(By.id("swal2-title")).getText();
		 	if (titleNotif.isEmpty())
	            throw new RuntimeException("Error : something error");
	    }
	 
	 @And("user presses the hapus button") 
	 public void userPressesTheHapusButton(){
		 driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
		 try { 
			 Thread.sleep(1000); 
			 } catch (InterruptedException e) {
				 System.out.println("error"); 
				 } 
		 }
	 
	 @Then("notification success")
	 public void notificationSuccess() {
	     String textBerhasil = driver.findElement(By.id("swal2-title")).getText();
	        if (textBerhasil.isEmpty())
	            throw new RuntimeException("Error : something error");
	    }
}
