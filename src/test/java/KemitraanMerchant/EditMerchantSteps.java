package KemitraanMerchant;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import TheDriver.TheDriver;

public class EditMerchantSteps {
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
	
	@And("clicks on merchant menu")
	public void clicks_on_merchant_menu() {
		WebElement merchantBtn = driver.findElement(By.id("merchant-menu"));
		merchantBtn.click();
	}
	
	@Then("user is navigated to the merchant page")
	public void user_is_navigated_to_the_merchant_page() {		
		WebElement merchantPage = driver.findElement(By.id("merchant-page"));
		Assert.assertTrue(merchantPage.isDisplayed());
	}
	
	@When("user clicks on btn edit")
	public void user_clicks_on_btn_edit() {
		WebElement editMerchantBtn = driver.findElement(By.className("fa-pen"));
		WebElement editBtn = editMerchantBtn.findElement(By.xpath(".."));
		editBtn.click();
	}
	
	@Then("user is navigated to edit merchant page")
	public void userIsNavigatedToEditMerchantPage() {
		WebElement formMerchant = driver.findElement(By.id("merchant-form"));
		Assert.assertTrue(formMerchant.isDisplayed());
	}
	
	@When("user enters merchant info {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void userEntersMerchantInfo(String nama, String thumbnail, String provinsi, String kota, String distrik, String desa, String alamat, String longitude, String latitude, String jam_buka, String jam_tutup) throws InterruptedException {
		WebElement formInputNama = driver.findElement(By.name("nama"));
		WebElement formInputThumbnail = driver.findElement(By.name("thumbnail"));
		WebElement formInputProvinsi = driver.findElement(By.id("react-select-6-input"));
		WebElement formInputKota = driver.findElement(By.name("react-select-7-input"));
		WebElement formInputDistrik = driver.findElement(By.name("react-select-8-input"));
		WebElement formInputDesa = driver.findElement(By.name("react-select-9-input"));
		WebElement formInputAlamat = driver.findElement(By.name("alamat"));
		WebElement formInputLongitude = driver.findElement(By.name("longitude"));
		WebElement formInputLatitude = driver.findElement(By.name("latitude"));
		WebElement formInputJamBuka = driver.findElement(By.name("jam_buka"));
		WebElement formInputJamTutup = driver.findElement(By.name("jam_tutup"));
		
		Thread.sleep(4000);
		formInputNama.clear();
		formInputNama.sendKeys(nama);
		formInputThumbnail.sendKeys(thumbnail);
		formInputProvinsi.sendKeys(provinsi+"\n");
		formInputKota.sendKeys(kota+"\n");
		formInputDistrik.sendKeys(distrik+"\n");
		formInputDesa.sendKeys(desa+"\n");
		formInputAlamat.sendKeys(alamat);
		formInputLongitude.sendKeys(longitude);
		formInputLatitude.sendKeys(latitude);
		formInputJamBuka.sendKeys(jam_buka);
		formInputJamTutup.sendKeys(jam_tutup);		
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
	
	@When("user clicks btn add")
	public void userClickAddBtn() {
		WebElement addBtn = driver.findElement(By.className("btn-info"));
		addBtn.clear();
	}
	
	@And("user enters produk info {string} and {string} and {string} and {string} and {string} and {string}")
	public void userEntersProdukInfo(String nama, String harga, String rating, String deskripsi, String varian, String thumbnail) {
	    WebElement formInputNama = driver.findElement(By.name("nama-produk"));
	    formInputNama.sendKeys(nama);
	    
	    WebElement formInputHarga = driver.findElement(By.name("harga-produk"));
	    formInputHarga.sendKeys(harga);
	    
	    WebElement formInputRating = driver.findElement(By.name("rating-produk"));
	    formInputRating.sendKeys(rating);
	    
	    WebElement formInputDeskripsi = driver.findElement(By.name("deskripsi-produk"));
	    formInputDeskripsi.sendKeys(deskripsi);
	    
	    WebElement formInputVarian = driver.findElement(By.name("varian-produk"));
	    formInputVarian.sendKeys(varian);
	    
	    WebElement formInputThumbnail = driver.findElement(By.name("thumbnail-produk"));
	    formInputThumbnail.sendKeys(thumbnail);
	}
	
}
