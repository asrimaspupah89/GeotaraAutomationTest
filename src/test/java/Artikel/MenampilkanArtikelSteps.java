package Artikel;

import java.time.Duration;

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

public class MenampilkanArtikelSteps{
WebDriver driver = null;
	
//	Given User artikel has opened the browser
	@Given("User artikel has opened the browser")
	public void User_artikel_has_opened_the_browser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
//	And User artikel has navigated on the landing page
	@And("User artikel has navigated on the landing page")
	public void User_artikel_has_navigated_on_the_landing_page() {
		driver.navigate().to("https://portal.geotara.my.id/");	
	}
	
//	When User artikel click on header Rencanakan Perjalanan Anda
	@When("User artikel click on header Rencanakan Perjalanan Anda")
	public void User_artikel_click_on_header_Rencanakan_Perjalanan_Anda() {
		driver.findElement(By.id("dropdownNavbarLink")).click();	}
	
//	And User artikel click on Artikel
	@And("User artikel click on Artikel")
	public void User_artikel_click_on_Artikel() {
		driver.findElement(By.cssSelector("a.block[href='/artikel']")).click();
	}
	
//	Then User artikel should be able to see Artikel page
	@Then("User artikel should be able to see Artikel page")
	public void User_artikel_should_be_able_to_see_Artikel_page() {
		if (driver.getCurrentUrl().contains("/artikel")) {
          System.out.println("Page Artikel is displayed!");
      } else {
          System.out.println("Page Artikel is not displayed!");
      }
		Assert.assertTrue(driver.getCurrentUrl().contains("/artikel"));
	}
	
//	And User artikel click button Lihat Artikel on article banner
	@And("User artikel click button Lihat Artikel on article banner")
	public void User_artikel_click_button_Lihat_Artikel_on_article_banner() {
		WebElement lihatArtikelButton = driver.findElement(By.xpath("//button[contains(@class, 'flex items-center px-8 py-4 bg-yellow-300 rounded-md') and span[text()='Lihat Artikel']]"));
		if (lihatArtikelButton.isEnabled()) {
		    System.out.println("Tombol Lihat Artikel dapat diklik");
		    lihatArtikelButton.click();
		} else {
		    System.out.println("Tombol Lihat Artikel tidak dapat diklik");
		}
	}
	
//	Then User artikel should be able to see article page about Artikel
	@Then("User artikel should be able to see article page about Artikel")
	public void User_artikel_should_be_able_to_see_article_page_about_Artikel() {
		if (driver.getCurrentUrl().contains("/artikel")) {
          System.out.println("Page Artikel is displayed!");
      } else {
          System.out.println("Page Artikel is not displayed!");
      }
		Assert.assertTrue(driver.getCurrentUrl().contains("/artikel"));
	}
	
//  And User artikel click dropdown on sort by button
	@And("User artikel click dropdown on sort by button")
	public void User_artikel_click_dropdown_on_sort_by_button() {
		driver.findElement(By.xpath("//button[contains(.,'Sort By')]")).click();
	}
	
//   And User artikel click item "<item>"
	@And("User artikel click item {string}")
	public void User_artikel_item(String item) {
		if (item.equals("64560bf3d491fbccae050682")) {
			driver.findElement(By.xpath("//a[contains(@class, 'flex ') and contains(@href, '64560bf3d491fbccae050682')]")).click();
		} 
	}
	
//   Then User artikel should be able to see card sort by "<sort>" on page about Artikel
	@Then("User artikel should be able to see detail")
	public void User_artikel_should_be_able_to_see_detail(String sort) {
		if (driver.getCurrentUrl().contains("/artikel")) {
	          System.out.println("Page Artikel is displayed!");
	      } else {
	          System.out.println("Page Artikel is not displayed!");
	      }
			Assert.assertTrue(driver.getCurrentUrl().contains("/artikel"));
	}
}
