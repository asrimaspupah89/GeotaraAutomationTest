package KemitraanRestoran;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TheDriver.TheDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditRestoranSteps {
	WebDriver driver = null;
	
	@Given("user in dashboard page")
	public void userInDashboardPage() {
		driver = TheDriver.getInstance();
		try {
			WebElement homePage = driver.findElement(By.id("dashboard-page"));
			Assert.assertTrue(homePage.isDisplayed());
		}catch(Exception e){
			System.out.println(e.getMessage());
			driver.navigate().to("https://geotara.my.id");
			this.userInDashboardPage();
		}			
	}	
	
	@When("user clicks on kemitraan tab")
	public void user_clicks_on_kemitraan_tab() {
		WebElement kemitraanBtn = driver.findElement(By.id("kemitraan-tab"));
		kemitraanBtn.click();				
	}
	
	@And("clicks on restaurant menu")
	public void clicks_on_restaurant_menu() {
		WebElement merchantBtn = driver.findElement(By.id("restaurant-menu"));
		merchantBtn.click();
	}
	
	@Then("user is navigated to the restaurant page")
	public void user_is_navigated_to_the_restaurant_page() {		
		WebElement merchantPage = driver.findElement(By.id("restaurant-page"));
		Assert.assertTrue(merchantPage.isDisplayed());
	}
	
	@When("user clicks on btn edit")
	public void user_clicks_on_btn_edit() {
		WebElement editMerchantBtn = driver.findElement(By.className("fa-pen"));
		WebElement editBtn = editMerchantBtn.findElement(By.xpath(".."));
		editBtn.click();
	}
	
	@Then("user is navigated to edit restaurant page")
	public void userIsNavigatedToEditAccomdoationPage() {
		WebElement formMerchant = driver.findElement(By.id("restaurant-form"));
		Assert.assertTrue(formMerchant.isDisplayed());
	}
	
	@When("user enters restaurant info {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void userEntersAccomodationInfo(String nama, String thumbnail, String provinsi, String kota, String distrik, String desa, String alamat, String longitude, String latitude, String no_telp, String email, String rating, String jam_buka, String jam_tutup) throws InterruptedException {
		WebElement formInputNama = driver.findElement(By.name("nama"));
		WebElement formInputThumbnail = driver.findElement(By.name("thumbnail"));
		WebElement formInputProvinsi = driver.findElement(By.id("react-select-2-input"));
		WebElement formInputKota = driver.findElement(By.id("react-select-3-input"));
		WebElement formInputDistrik = driver.findElement(By.id("react-select-4-input"));
		WebElement formInputDesa = driver.findElement(By.id("react-select-5-input"));
		WebElement formInputAlamat = driver.findElement(By.name("alamat"));
		WebElement formInputLongitude = driver.findElement(By.name("longitude"));
		WebElement formInputLatitude = driver.findElement(By.name("latitude"));
		WebElement formInputNoTelp = driver.findElement(By.name("no_telp"));
		WebElement formInputEmail = driver.findElement(By.name("email"));
		WebElement formInputRating = driver.findElement(By.name("rating"));
		WebElement formJamBuka = driver.findElement(By.name("jam_buka"));
		WebElement formJamTutup= driver.findElement(By.name("jam_tutup"));
		
		Thread.sleep(4000);
		formInputNama.clear();
		formInputNama.sendKeys(nama);
		formInputThumbnail.sendKeys(thumbnail);
		formInputProvinsi.sendKeys(provinsi+"\n");
		formInputKota.sendKeys(kota+"\n");
		formInputDistrik.sendKeys(distrik+"\n");
		formInputDesa.sendKeys(desa+"\n");
		formInputAlamat.clear();
		formInputAlamat.sendKeys(alamat);
		formInputLongitude.sendKeys(longitude);
		formInputLatitude.sendKeys(latitude);	
		formInputNoTelp.sendKeys(no_telp);
		formInputEmail.sendKeys(email);
		formInputRating.sendKeys(rating);
		formJamBuka.sendKeys(jam_buka);
		formJamTutup.sendKeys(jam_tutup);	
	}
	
	@And("clicks submit btn")
	public void clickSubmitBtn() {
		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();
	}
	
	@Then("user see message {string}")
	public void seeMessage(String message) {
		System.out.println(message);
	}
}
