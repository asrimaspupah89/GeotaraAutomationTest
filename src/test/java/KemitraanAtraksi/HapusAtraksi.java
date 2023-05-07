// Author : Nisa Hauna Yusriyyah
// Hapus data atraksi CMS Geotara

package KemitraanAtraksi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class HapusAtraksi {
	WebDriver driver = null;

	@Given("User has opened the browser")
	public void userOpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}

	@And("User open website cms geotara")
	public void userOpenWebCMSGeotara() {
		driver.navigate().to("https://geotara.my.id/");
	}

	@And("User inputs valid authorization")
	public void userInputValidAuthorization() {
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
	
	@When("User click on sidebar Kemitraan")
	public void userClickKemitraan() {
		driver.findElement(By.xpath("//a[@href='/dashboard']//span[text()='Kemitraan']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}
	
	@And("User click Atraksi")
	public void userClickAtraksi() {
		driver.findElement(By.xpath("//a[@href='/attraction']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}
	
	 @When("User click button delete") 
	 public void userClickButtonDelete() { 
		 driver.findElement(By.cssSelector("a.btn.btn-danger.shadow.btn-xs")).click(); 
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("error");
			}
		 }

	 @And("User gets notification message")
	 public void userGetsNotificationMessage() {
		 String notifMessage = driver.findElement(By.id("swal2-title")).getText();
		 assertEquals("Anda yakin ingin menghapus attraction ini?", notifMessage);
		 if (notifMessage.isEmpty())
	            throw new RuntimeException("Error : something error");
	    }

	 @Then("User click button cancel") 
	 public void userClickButtonCancel() { 
		 driver.findElement(By.cssSelector("button.swal2-cancel.swal2-styled")).click(); 
		 try { 
			 Thread.sleep(2000); 
			 } catch (InterruptedException e) {
				 System.out.println("error"); 
				 } 
		 }

	 @When("User click button delete again") 
	 public void userClickButtonDeleteAgain() { 
		 driver.findElement(By.cssSelector("a.btn.btn-danger.shadow.btn-xs")).click(); 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("error");
			}
		 }
	 
	 @And("User gets notification message again")
	 public void userGetsNotificationMessageAgain() {
		 String notifMessage = driver.findElement(By.id("swal2-title")).getText();
		 assertEquals("Anda yakin ingin menghapus attraction ini?", notifMessage);
		 if (notifMessage.isEmpty())
	            throw new RuntimeException("Error : something error");
	    }
	 
	 @And("User click button hapus") 
	 public void userClickButtonHapus(){
		 driver.findElement(By.cssSelector("button.swal2-confirm.swal2-styled")).click();
		 try { 
			 Thread.sleep(1000); 
			 } catch (InterruptedException e) {
				 System.out.println("error"); 
				 } 
		 }
	 
	 @Then("User gets notification success message")
	 public void userGetsNotificationSuccessMessage() {
	     String notifSuccess = driver.findElement(By.id("swal2-title")).getText();
	     assertEquals("Dihapus!", notifSuccess);
	        if (notifSuccess.isEmpty())
	            throw new RuntimeException("Error : something error");
	    }

}
