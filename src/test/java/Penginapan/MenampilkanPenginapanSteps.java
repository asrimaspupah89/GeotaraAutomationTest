package Penginapan;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

//Author : Kiki Rizqi Amelia
//Date	: 29/04/2023
//Description : Testing View Penginapan in Portal Geotara

public class MenampilkanPenginapanSteps {
	
	WebDriver driver = null;
	
//	Given user has opened the browser
	@Given("user has opened the browser")
	public void user_has_opened_the_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/kiki/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
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
	
//	And user clicks on penginapan
	@And("user clicks on penginapan")
	public void user_clicks_on_penginapan() {
		driver.findElement(By.cssSelector("a.block[href='/accomodation']")).click();
	}
	
//	And user clicks on artikel button
	@And("user clicks on artikel button")
	public void user_clicks_on_artikel_button() {
		WebElement lihatArtikelButton = driver.findElement(By.xpath("//button[contains(@class, 'flex items-center px-8 py-4 bg-yellow-300 rounded-md') and span[text()='Lihat Artikel']]"));
		
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
	
//	And user filters the penginapan list with enters kecamatan, tipe, price, and stars
	@And("user filters the penginapan list with enters kecamatan, tipe, price, and stars")
	public void user_filters_the_penginapan_list_with_enters_kecamatan_tipe_price_and_stars() {
		//Kecamatan
		driver.findElement(By.id("Ciemas1")).click(); 
		
		//Tipe
		driver.findElement(By.id("Hotel1")).click();
		
		//Harga
		driver.findElement(By.xpath("//label[contains(.,'Filter Harga')]/span")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sliderHarga = driver.findElement(By.cssSelector("input#slider[min='50000'][max='500000'][step='1000']"));
		js.executeScript("arguments[0].setAttribute('value', '290000')", sliderHarga);
		WebElement hargaLabel = driver.findElement(By.cssSelector("p.font-bold.text-green-700.inline"));
		js.executeScript("arguments[0].innerText = 'Rp 290.000'", hargaLabel);
		
		//Bintang
		driver.findElement(By.xpath("//label[contains(.,'Filter Bintang')]/span")).click();
		WebElement sliderBintang = driver.findElement(By.cssSelector("input#slider[min='1'][max='5']"));
		js.executeScript("arguments[0].setAttribute('value', '1')", sliderBintang);
		WebElement bintangLabel = driver.findElement(By.cssSelector("label[for='slider'][class='text-base']"));
		js.executeScript("arguments[0].textContent = 'Bintang : 1'", bintangLabel);
	}
	
//	And user clicks on confirm button and close button
	@And("user clicks on confirm button and close button")
	public void user_clicks_on_confirm_button_and_close_button() {
//		driver.findElement(By.cssSelector("button.button:contains('Confirm')")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Confirm') and @class='hover:bg-green-800 focus:ring-4 focus:ring-green-300 button button-small ']")).click();
		driver.findElement(By.cssSelector("button svg.w-8.h-8")).click();

	}
	
//	And user enter data on searching
	@And("user enter data on searching")
	public void user_enter_data_on_searching() {
		driver.findElement(By.id("default-search")).sendKeys("Menara Laut Hotel");
	}
	
//	Then user must be able to see the navigation bar related to the displayed penginapan
	@Then("user must be able to see the navigation bar related to the displayed penginapan")
	public void user_must_be_able_to_see_the_navigation_bar_related_to_the_displayed_penginapan() {
//		List<WebElement> berandaAndAccommodation = driver.findElements(By.xpath("//ol[contains(@class, 'inline-flex')]//a[text()='Beranda'] && //ol[contains(@class, 'inline-flex')]//div[text()='Accommodation']"));
		List<WebElement> berandaAndAccommodation = driver.findElements(By.cssSelector("ol.inline-flex li"));
		if (!berandaAndAccommodation.isEmpty()) {
			System.out.println("Navigasi bar related to the penginapan is displayed!");
		} else {
			System.out.println("Navigasi bar related to the penginapan is not displayed!");
		}
		Assert.assertTrue(!berandaAndAccommodation.isEmpty());
	}
	
//	Then user must be directed to the full information page of the penginapan artikel
	@Then("user must be directed to the full information page of the penginapan artikel")
	public void user_must_be_directed_to_the_full_information_page_of_the_penginapan_artikel() {
		// Get current URL
		String currentUrl = driver.getCurrentUrl();

		// Expected URL
		String expectedUrl = "https://portal.geotara.my.id/accomodation/artikel";

		// Check if current URL is the expected URL
		if (currentUrl.equals(expectedUrl)) {
		    System.out.println("Current URL is the expected URL: " + expectedUrl);
		} else {
		    System.out.println("Current URL is not the expected URL. Current URL is: " + currentUrl);
		}
		Assert.assertTrue(currentUrl.equals(expectedUrl));
	}
	
//	Then users can see a list of penginapan that have been filtered according to the expected choices
	@Then("users can see a list of penginapan that have been filtered according to the expected choices")
	public void users_can_see_a_list_of_penginapan_that_have_been_filtered_according_to_the_expected_choices() {
		WebElement rating = driver.findElement(By.cssSelector("p.ml-2.text-sm.font-bold")); 
		WebElement kecamatan = driver.findElement(By.cssSelector("p.text-sm.flex.items-center"));
		WebElement tipe = driver.findElement(By.cssSelector("p.text-lg.font-bold.mb-0.xl\\:text-xl.text-left"));
		WebElement price = driver.findElement(By.cssSelector("p.text-xl.font-bold.xl\\:text-2xl"));
		
		String ratings = rating.getText();
		String kecamatans = kecamatan.getText();
		String tipes = tipe.getText();
		String prices = price.getText();
//		double priceValue = Double.parseDouble(prices.replaceAll("\\$|,", ""));
		double priceValue = Double.parseDouble(prices.replaceAll("[^\\d.]", ""));

		
		if (!ratings.contains("3") || !kecamatans.contains("Ciemas") || !tipes.contains("Hotel") || priceValue < 220000 ) {
		    System.out.println("Hasil filter berdasarkan rating masih ada yang bukan bintang 3");
		    System.out.println("Hasil filter berdasarkan kecamatan masih ada yang bukan kecamatan Ciemas");
		    System.out.println("Hasil filter berdasarkan tipe masih ada yang bukan hotel");
		    System.out.println("Hasil filter berdasarkan harga masih ada yang di bawah Rp 220.000,00");
		} else {
		    System.out.println("Hasil filter berdasarkan rating sudah bintang 3 semua");
		    System.out.println("Hasil filter berdasarkan kecamatan sudah kecamatan Ciemas");
		    System.out.println("Hasil filter berdasarkan tipe sudah hotel");
		    System.out.println("Hasil filter berdasarkan harga sudah mulai dari Rp 220.000,00");
		}
		
		Assert.assertFalse(!ratings.contains("3") || !kecamatans.contains("Ciemas") || !tipes.contains("Hotel") || priceValue < 220000);
	}
	
//	Then user can see the search results as expected
	@Then("user can see the search results as expected")
	public void user_can_see_the_search_results_as_expected() {
		WebElement title = driver.findElement(By.cssSelector("p.text-lg.font-bold.mb-0.xl\\:text-xl.text-left"));
		String titles = title.getText();
		
		if (!titles.contains("Menara Laut Hotel")) {
			System.out.println("Hasil pencarian masih terdapat judul yang bukan Menara Laut Hotel");
		} else {
			System.out.println("Hasil pencarian sudah tepat");
		}
		
		Assert.assertFalse(!titles.contains("Menara Laut Hotel"));
	} 
	
//	And user directed to penginapan page
	@And("user directed to penginapan page")
	public void user_directed_to_penginapan_page() {
		// Get current URL
		String currentUrl = driver.getCurrentUrl();

		// Expected URL
		String expectedUrl = "https://portal.geotara.my.id/accomodation";

		// Check if current URL is the expected URL
		if (currentUrl.equals(expectedUrl)) {
		    System.out.println("Current URL is the expected URL: " + expectedUrl);
		} else {
		    System.out.println("Current URL is not the expected URL. Current URL is: " + currentUrl);
		}
		Assert.assertTrue(currentUrl.equals(expectedUrl));
	}
	
//	And user can view penginapan list
	@And("user can view penginapan list")
	public void user_can_view_penginapan_list() {
		List<WebElement> listPenginapan  = driver.findElements(By.xpath("//p[contains(@class, 'text-base md:text-lg xl:text-xl font-bold text-secondary') and text()='List Penginapan']"));
		List<WebElement> content = driver.findElements(By.cssSelector("div.flex.flex-wrap.gap-5.justify-center.lg\\:justify-between.xl\\:gap-10.mb-10"));
		
		if (!listPenginapan.isEmpty() && !content.isEmpty()) {
			System.out.println("Penginapan list is displayed!");
		} else {
			System.out.println("Penginapan list is not displayed!");
		}
		
		Assert.assertTrue(!listPenginapan.isEmpty() && !content.isEmpty());
	}
	
//	And user can view penginapan artikel
	@And("user can view penginapan artikel")
	public void user_can_view_penginapan_artikel() {
		List<WebElement> penginapanArtikel  = driver.findElements(By.xpath("//*[contains(text(), 'Penginapan Artikel')]"));
		
		if (!penginapanArtikel.isEmpty()) {
			System.out.println("Penginapan Artikel is displayed!");
		} else {
			System.out.println("Penginapan Artikel is not displayed!");
		}
		
		Assert.assertTrue(!penginapanArtikel.isEmpty());
	}
}
