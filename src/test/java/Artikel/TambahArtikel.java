package Artikel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TambahArtikel {
    WebDriver driver = null;
    @Given("user has opened the browser")
    public void userHasOpenedTheBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @And("user has opened geotara cms")
    public void userHasOpenedGeotaraCms() {
        driver.navigate().to("https://geotara.my.id/");
    }

    @And("user enter email and password")
    public void userEnterEmailAndPassword() {
        driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("submit_login")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }
    @And("user already in dashboard")
    public void userAlreadyInDashboard() {
        driver.findElement(By.className("dashboard_bar")).isDisplayed();
    }

    @And("user is navigated to artikel page")
    public void userIsNavigatedToArtikelPage() {
        driver.findElement(By.id("publikasi-btn")).click();
        driver.findElement(By.id("artikel-link-btn")).click();
    }
    @When("user menekan tombol tambah artikel")
    public void userMenekanTombolTambahArtikel() {
        driver.findElement(By.xpath("//button[contains(@class, 'btn-primary') and contains(text(), 'Tambah')]")).click();
    }

    @Then("Halaman pindah ke form penambahan artikel")
    public void halamanPindahKeFormPenambahanArtikel() {
        driver.findElement(By.className("dashboard_bar")).isDisplayed();
    }

    @When("user mengupload foto {}")
    public void userMenguploadFoto(String thumbnail) {
        driver.findElement(By.xpath("//input[@type='file' and contains(@class, 'custom-file-input') and @accept='image/*']")).sendKeys(thumbnail);

    }

    @And("user menginputkan {} untuk title artikel")
    public void userMenginputkanUntukTitleArtikel(String title) {
        driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Masukkan judul artikel']")).sendKeys(title);
    }

    @And("user megninputkan {} untuk tags artikel")
    public void userMegninputkanUntukTagsArtikel(String tags) {
        driver.findElement(By.xpath("//div[contains(@class, 'form-group')]//input[@id='react-select-2-input']")).sendKeys(tags + "\n");
    }

    @And("user menginputkan {} untuk konten artikel")
    public void userMenginputkanUntukKontenArtikel(String content) {
        driver.findElement(By.xpath("//div[@data-element='root']/p[contains(@data-id,'p')][1]")).sendKeys(content);
    }

    @And("user menekan tombol submit")
    public void userMenekanTombolSubmit() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary me-2' and text()='Tambah']")).click();
    }

    @Then("menampilkan notifikasi bahwa artikel sudah dibuat")
    public void menampilkanNotifikasiBahwaArtikelSudahDibuat() {
        String titleNotif = driver.findElement(By.id("swal2-title")).getText();
        Assert.assertEquals("Berhasil!", titleNotif);
    }
}
