package Restoran;

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

public class EditRestoranSteps {
WebDriver driver = null;
	
//	Given User restoran has opened the browser
	@Given("User restoran has opened the browser")
	public void User_restoran_has_opened_the_browser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
//	And User restoran has navigated on the landing page
	@And("User restoran has navigated on the landing page")
	public void User_restoran_has_navigated_on_the_landing_page() {
		driver.navigate().to("https://portal.geotara.my.id/");	
	}
	
//	When User restoran click on header Rencanakan Perjalanan Anda
	@When("User restoran click on header Rencanakan Perjalanan Anda")
	public void User_restoran_click_on_header_Rencanakan_Perjalanan_Anda() {
		driver.findElement(By.id("dropdownNavbarLink")).click();	}
	
//	And User restoran click on Restoran
	@And("User restoran click on Restoran")
	public void User_restoran_click_on_Restoran() {
		driver.findElement(By.cssSelector("a.block[href='/restaurant']")).click();
	}
	
//	Then User restoran should be able to see Restoran page
	@Then("User restoran should be able to see Restoran page")
	public void User_restoran_should_be_able_to_see_Restoran_page() {
		if (driver.getCurrentUrl().contains("/restaurant")) {
          System.out.println("Page Restoran is displayed!");
      } else {
          System.out.println("Page Restoran is not displayed!");
      }
		Assert.assertTrue(driver.getCurrentUrl().contains("/restaurant"));
	}
	
//	And User restoran click button Lihat Artikel on article banner
	@And("User restoran click button Lihat Artikel on article banner")
	public void User_restoran_click_button_Lihat_Artikel_on_article_banner() {
		WebElement lihatArtikelButton = driver.findElement(By.xpath("//button[contains(@class, 'flex items-center px-8 py-4 bg-yellow-300 rounded-md') and span[text()='Lihat Artikel']]"));
		if (lihatArtikelButton.isEnabled()) {
		    System.out.println("Tombol Lihat Artikel dapat diklik");
		    lihatArtikelButton.click();
		} else {
		    System.out.println("Tombol Lihat Artikel tidak dapat diklik");
		}
	}
	
//	Then User restoran should be able to see article page about Restoran
	@Then("User restoran should be able to see article page about Restoran")
	public void User_restoran_should_be_able_to_see_article_page_about_Restoran() {
		if (driver.getCurrentUrl().contains("/artikel")) {
          System.out.println("Page Artikel is displayed!");
      } else {
          System.out.println("Page Artikel is not displayed!");
      }
		Assert.assertTrue(driver.getCurrentUrl().contains("/artikel"));
	}
	
//  And User restoran click dropdown on sort by button
	@And("User restoran click dropdown on sort by button")
	public void User_restoran_click_dropdown_on_sort_by_button() {
		driver.findElement(By.xpath("//button[contains(.,'Sort By')]")).click();
	}
	
//   And User restoran click item "<item>"
	@And("User restoran click item {string}")
	public void User_restoran_item(String item) {
		if (item.equals("A-Z")) {
			driver.findElement(By.xpath("//li[contains(.,'A-Z')]"));	
		} else if (item.equals("A-Z")) {
			driver.findElement(By.xpath("//li[contains(.,'Z-A')]"));				
		} else if (item.equals("Price, Low to High")) {
			driver.findElement(By.xpath("//li[contains(.,'Price, Low To High')]"));				
		} 
	}
	
//   Then User restoran should be able to see card sort by "<sort>" on page about Restoran
	@Then("User restoran should be able to see card sort by {string} on page about Restoran")
	public void User_restoran_should_be_able_to_see_card_sort_by_on_page_about_Restoran(String sort) {
		if (sort.equals("alphabetically A-Z")) {
			Assert.assertTrue(driver.getCurrentUrl().contains("sort=a-z"));
		} else if (sort.equals("alphabetically Z-A")) {
			Assert.assertTrue(driver.getCurrentUrl().contains("sort=z-a"));
		} else if (sort.equals("Price, Low to High")) {
			Assert.assertTrue(driver.getCurrentUrl().contains("sort=low-to-high"));
		}
	}
}
