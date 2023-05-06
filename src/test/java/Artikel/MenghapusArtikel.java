package Artikel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MenghapusArtikel {

    WebDriver driver = null;

    @Given("browser dibuka")
    public void browserDibuka() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @And("user membuka website geotara cms")
    public void userMembukaWebsiteGeotaraCMS() {
        driver.navigate().to("https://geotara.my.id/");
    }

    @And("user menginputkan username dan password")
    public void userMenginputkanUsernameDanPassword() {
        driver.findElement(By.id("email")).sendKeys("admin@geotara.com");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("submit_login")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }

    @And("user berada di halaman artikel")
    public void userBeradaDiHalamanArtikel() {
        driver.navigate().to("https://geotara.my.id/artikel");
    }

    @When("user menekan tombol delete")
    public void userMenekanTombolDelete() {
        driver.findElement(By.xpath("/html/body/div/div/div[4]/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[2]/div[1]/div[5]/div/a[3]")).click();
    }

    @And("notifikasi penghapusan data muncul")
    public void notifikasiPenghapusanDataMuncul() {
        String titleNotif = driver.findElement(By.id("swal2-title")).getText();
        if (titleNotif.isEmpty())
            throw new RuntimeException("Error : something error");
    }

    @And("user menekan tombol hapus")
    public void userMenekanTombolHapus() {
        driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm') and contains(@class,'swal2-styled')]")).click();
    }

    @Then("sistem membari notifikasi bahwa data telah dihapus")
    public void sistemMembariNotifikasiBahwaDataTelahDihapus() {
        String textBerhasil = driver.findElement(By.id("swal2-title")).getText();
        if (textBerhasil.isEmpty())
            throw new RuntimeException("Error : something error");
    }
}
