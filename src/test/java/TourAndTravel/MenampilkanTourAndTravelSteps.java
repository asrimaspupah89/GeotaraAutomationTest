package TourAndTravel;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//Author : Kiki Rizqi Amelia
//Date	: 30/04/2023
//Description : Testing in Tour And Travel View in Portal Geotara

public class MenampilkanTourAndTravelSteps {
	
	WebDriver driver = null;
	
//	Given user has opened the browser
	@Given("user has opened the browser")
	public void user_has_opened_the_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/lamda/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
//	And user already in home page
	@And("user already in home page")
	public void user_already_in_home_page() {
		driver.navigate().to("https://portal.geotara.my.id/");	
	}
	
//	When user clicks on rencana perjalanan anda
	@When("user clicks on rencana perjalanan anda")
	public void user_clicks_on_rencana_perjalanan_anda() {
		driver.findElement(By.id("dropdownNavbarLink")).click();
		
	}
	
//	And user clicks on travel and tour
	@And("user clicks on travel and tour")
	public void user_clicks_on_travel_and_tour() {
		driver.findElement(By.cssSelector("a.block[href='/tour-travel']")).click();
	}
	
//	And user clicks on artikel button
	@And("user clicks on artikel button")
	public void user_clicks_on_artikel_button() {
//		<button class="flex items-center px-8 py-4 bg-yellow-300 rounded-md"><a href="https://projectarsal.my.id/Detail/" class="font-semibold text-black">Lihat Artikel</a></button>
		WebElement lihatArtikelButton = driver.findElement(By.xpath("//button[contains(@class, 'flex items-center px-8 py-4 bg-yellow-300 rounded-md') and a[text()='Lihat Artikel']]"));
		
		if (lihatArtikelButton.isEnabled()) {
		    System.out.println("Tombol Lihat Artikel dapat diklik");
		    lihatArtikelButton.click();
		} else {
		    System.out.println("Tombol Lihat Artikel tidak dapat diklik");
		}
	}
	
//	And user clicks on filter
	@And("user clicks on filter")
	public void user_clicks_on_filter() {
		driver.findElement(By.xpath("//button[contains(., 'Filter')]")).click();	
	}
	
//	And user filters the tour and travel list with enters city, tipe, price, and ratings
	@And("user filters the tour and travel list with enters city, tipe, price, and ratings")
	public void user_filters_the_tour_and_travel_list_with_enters_city_tipe_price_and_ratings() {
		//City
		driver.findElement(By.id("Bandung1")).click(); 
		
		//Tipe
		driver.findElement(By.id("Minibus2")).click();
		
		//Harga
		driver.findElement(By.xpath("//label[contains(.,'Filter Harga')]/span")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sliderHarga = driver.findElement(By.cssSelector("input#slider[min='50000'][max='500000'][step='1000']"));
		js.executeScript("arguments[0].setAttribute('value', '50000')", sliderHarga);
		WebElement hargaLabel = driver.findElement(By.cssSelector("p.font-bold.text-green-700.inline"));
		js.executeScript("arguments[0].innerText = 'Rp 50.000'", hargaLabel);
		
		//Bintang
		driver.findElement(By.xpath("//label[contains(.,'Filter Bintang')]/span")).click();
		WebElement sliderBintang = driver.findElement(By.cssSelector("input#slider[min='1'][max='5']"));
		js.executeScript("arguments[0].setAttribute('value', '5')", sliderBintang);
		WebElement bintangLabel = driver.findElement(By.cssSelector("label[for='slider'][class='text-base']"));
		js.executeScript("arguments[0].textContent = 'Bintang : 5'", bintangLabel);
	}
	
//	And user clicks on confirm button and close button
	@And("user clicks on confirm button and close button")
	public void user_clicks_on_confirm_button_and_close_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Confirm') and @class='hover:bg-green-800 focus:ring-4 focus:ring-green-300 button button-small ']")).click();
		driver.findElement(By.cssSelector("button svg.w-8.h-8")).click();
	}
	
//	And user enter data on searching
	@And("user enter data on searching")
	public void user_enter_data_on_searching() {
		driver.findElement(By.id("default-search")).sendKeys("Travel Putri Munggaran Pangandaran");
	}
	
//	Then user must be able to see the navigation bar related to the displayed tour and travel
	@Then("user must be able to see the navigation bar related to the displayed tour and travel")
	public void user_must_be_able_to_see_the_navigation_bar_related_to_the_displayed_tour_and_travel() {  
		List<WebElement> berandaAndTourTravel = driver.findElements(By.cssSelector("ol.inline-flex li"));
		if (!berandaAndTourTravel.isEmpty()) {
			System.out.println("Navigasi bar related to the tour and travel is displayed!");
		} else {
			System.out.println("Navigasi bar related to the tour and travel is not displayed!");
		}
		Assert.assertTrue(!berandaAndTourTravel.isEmpty());
	}
	
//	Then user must be directed to the full information page of the tour and travel artikel
	@Then("user must be directed to the full information page of the tour and travel artikel")
	public void user_must_be_directed_to_the_full_information_page_of_the_tour_and_travel_artikel() {
		// Get current URL
		String currentUrl = driver.getCurrentUrl();

		// Expected URL
		String expectedUrl = "https://portal.geotara.my.id/tour-travel/artikel";

		// Check if current URL is the expected URL
		if (currentUrl.equals(expectedUrl)) {
		    System.out.println("Current URL is the expected URL: " + expectedUrl);
		} else {
		    System.out.println("Current URL is not the expected URL. Current URL is: " + currentUrl);
		}
		Assert.assertTrue(currentUrl.equals(expectedUrl));
	}
	
//	Then users can see a list of tour and travel that have been filtered according to the expected choices
	@Then("users can see a list of tour and travel that have been filtered according to the expected choices")
	public void users_can_see_a_list_of_tour_and_travel_that_have_been_filtered_according_to_the_expected_choices() {
		WebElement rating = driver.findElement(By.cssSelector("p.ml-2.text-sm.font-bold")); 
		WebElement city = driver.findElement(By.cssSelector("p.text-sm.flex.items-center"));
		WebElement tipe = driver.findElement(By.cssSelector("p.text-lg.font-bold.mb-0.xl\\:text-xl.text-left"));
		WebElement price = driver.findElement(By.cssSelector("p.text-xl.font-bold.xl\\:text-2xl"));
		
		String ratings = rating.getText();
		String cities = city.getText();
		String tipes = tipe.getText();
		String prices = price.getText();
		double priceValue = Double.parseDouble(prices.replaceAll("[^\\d.]", ""));

		
		if (!ratings.contains("5") || !cities.contains("Bandung") || !tipes.contains("Minibus") || priceValue < 50000 ) {
		    System.out.println("Hasil filter berdasarkan rating masih ada yang bukan bintang 5");
		    System.out.println("Hasil filter berdasarkan kecamatan masih ada yang bukan kota Bandung");
		    System.out.println("Hasil filter berdasarkan tipe masih ada yang bukan Minibus");
		    System.out.println("Hasil filter berdasarkan harga masih ada yang di bawah Rp 50.000,00");
		} else {
		    System.out.println("Hasil filter berdasarkan rating sudah bintang 5 semua");
		    System.out.println("Hasil filter berdasarkan kecamatan sudah kota Bandung");
		    System.out.println("Hasil filter berdasarkan tipe sudah Minibus");
		    System.out.println("Hasil filter berdasarkan harga sudah mulai dari Rp 50.000,00");
		}
		
		Assert.assertFalse(!ratings.contains("5") || !cities.contains("Bandung") || !tipes.contains("Minibus") || priceValue < 50000);
	}
	
//	Then user can see the search results as expected
	@Then("user can see the search results as expected")
	public void user_can_see_the_search_results_as_expected() {
		WebElement title = driver.findElement(By.cssSelector("p.text-lg.font-bold.mb-0.xl\\:text-xl.text-left"));
		String titles = title.getText();
		
		if (!titles.contains("Travel Putri Munggaran Pangandaran")) {
			System.out.println("Hasil pencarian masih terdapat judul yang bukan Travel Putri Munggaran Pangandaran");
		} else {
			System.out.println("Hasil pencarian sudah tepat");
		}
		
		Assert.assertFalse(!titles.contains("Travel Putri Munggaran Pangandaran"));
	} 
	
//	And user directed to tour and travel page
	@And("user directed to tour and travel page")
	public void user_directed_to_tour_and_travel_page() {
		// Get current URL
		String currentUrl = driver.getCurrentUrl();

		// Expected URL
		String expectedUrl = "https://portal.geotara.my.id/tour-travel";

		// Check if current URL is the expected URL
		if (currentUrl.equals(expectedUrl)) {
		    System.out.println("Current URL is the expected URL: " + expectedUrl);
		} else {
		    System.out.println("Current URL is not the expected URL. Current URL is: " + currentUrl);
		}
		Assert.assertTrue(currentUrl.equals(expectedUrl));
	}

//	And user can view tour and travel list
	@And("user can view tour and travel list")
	public void user_can_view_tour_and_travel_list() {
		List<WebElement> listTourAndTravel  = driver.findElements(By.xpath("//p[contains(@class, 'text-base md:text-lg xl:text-xl font-bold text-secondary') and text()='List Tour & Travel']"));
		List<WebElement> content = driver.findElements(By.cssSelector("div.flex.flex-wrap.gap-5.justify-center.lg\\:justify-between.xl\\:gap-10.mb-10"));
		
		if (!listTourAndTravel.isEmpty() && !content.isEmpty()) {
			System.out.println("Tour and Travel list is displayed!");
		} else {
			System.out.println("Tour and Travel list is not displayed!");
		}
		
		Assert.assertTrue(!listTourAndTravel.isEmpty() && !content.isEmpty());
	}
	
//	And user can view tour and travel artikel
	@And("user can view tour and travel artikel")
	public void user_can_view_tour_and_travel_artikel() {
		List<WebElement> tourAndTravelArtikel  = driver.findElements(By.xpath("//*[contains(text(), 'Tour & Travel Artikel')]"));
		
		if (!tourAndTravelArtikel.isEmpty()) {
			System.out.println("Tour & Travel Artikel is displayed!");
		} else {
			System.out.println("Tour & Travel Artikel is not displayed!");
		}
		
		Assert.assertTrue(!tourAndTravelArtikel.isEmpty());
	}
}






