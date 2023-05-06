package TourAndTravel;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TambahEditTourAndTravelSteps {
    WebDriver driver = null;
    private static Logger LOGGER = LoggerFactory.getLogger(TambahEditTourAndTravelSteps.class);

    @Given("User has opened the browser")
    public void user_has_opened_the_browser() {
        System.setProperty("webdriver.chrome.driver", "D:\\School\\Polban\\Course\\Smt 6\\Pengujian Perangkat Lunak\\PR\\Week 12 - 14\\GeotaraAutomationTest\\src\\test\\resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @Given("User already in home page")
    public void user_already_in_home_page() {
        driver.navigate().to("https://geotara.my.id/login");

        driver.findElement(By.id("email")).sendKeys("adminsob@geotara.com");
        driver.findElement(By.id("password")).sendKeys("adminsob");

        driver.findElement(By.id("submit_login")).click();

        By containerSelector = By.className("container-fluid");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(containerSelector));
        } catch (TimeoutException e) {
            fail("The home page did not load within 10 seconds.");
            driver.quit();
        }
    }

    @When("User clicks on sidebar with tab name {string}")
    public void user_clicks_on_sidebar_with_tab_name(String tabName) {
        if(tabName.equals("Kemitraan")) {
            By dropdownTab = By.xpath("/html/body/div/div/div[3]/div/div[1]/ul/li[4]/a");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdownTab));
                element.click();
            } catch (TimeoutException e) {
                fail("The tab " + tabName + " did not load within 10 seconds.");
                driver.quit();
            }
        }
    }

    @When("User clicks on sidebar with dropdown tab name {string}")
    public void user_clicks_on_sidebar_with_dropdown_tab_name(String dropdownTabName) {
        if(dropdownTabName.equals("Tur dan Travel")) {
            By dropdownTab = By.xpath("/html/body/div/div/div[3]/div/div[1]/ul/li[4]/ul/li[5]/a");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                wait.until(ExpectedConditions.elementToBeClickable(dropdownTab)).click();
            } catch (TimeoutException e) {
                fail("The dropdown tab " + dropdownTabName + " did not load within 10 seconds.");
                driver.quit();
            }
        }

    }

    @When("User clicks on {string} button")
    public void user_clicks_on_button(String buttonName) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By button = null;
        if(buttonName.equals("Tambah")) {
            button = By.xpath("/html/body/div/div/div[4]/div/div[2]/div/div/div[1]/a/button");
        } else if(buttonName.equals("Simpan")) {
            button = By.xpath("/html/body/div/div/div[4]/div/div/div/div/div/div[2]/div/form/fieldset/button");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(button));
//            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (ElementClickInterceptedException e) {
            fail(e.getMessage());
            driver.quit();
        } catch (TimeoutException e) {
            fail("The button " + buttonName + " did not load within 10 seconds.");
            driver.quit();
        }
    }

    @When("User fill form")
    public void user_fill_form(DataTable testData) throws ParseException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);

            Map<String, String> data = testData.asMap(String.class, String.class);

            driver.findElement(By.name("nama")).sendKeys(data.get("nama_tur"));

            // Select Provinsi
            wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-2-input")));
            driver.findElement(By.id("react-select-2-input")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + data.get("provinsi").toUpperCase() + "']")));
            WebElement optionProvinsi = driver.findElement(By.xpath("//*[text()='" + data.get("provinsi").toUpperCase() + "']"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", optionProvinsi);
            optionProvinsi.click();

            // Select Kota
            wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-3-input")));
            driver.findElement(By.id("react-select-3-input")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + data.get("kota").toUpperCase() + "']")));
            WebElement optionKota = driver.findElement(By.xpath("//*[text()='" + data.get("kota").toUpperCase() + "']"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", optionKota);
            optionKota.click();

            // Select Distrik
            wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-4-input")));
            driver.findElement(By.id("react-select-4-input")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + data.get("distrik").toUpperCase() + "']")));
            WebElement optionDistrik = driver.findElement(By.xpath("//*[text()='" + data.get("distrik").toUpperCase() + "']"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", optionDistrik);
            optionDistrik.click();

            // Select Desa
            wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-5-input")));
            driver.findElement(By.id("react-select-5-input")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + data.get("desa").toUpperCase() + "']")));
            WebElement optionDesa = driver.findElement(By.xpath("//*[text()='" + data.get("desa").toUpperCase() + "']"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", optionDesa);
            optionDesa.click();

            driver.findElement(By.name("alamat")).sendKeys(data.get("alamat"));
            driver.findElement(By.name("long")).sendKeys(data.get("longitude"));
            driver.findElement(By.name("lat")).sendKeys(data.get("latitude"));
            driver.findElement(By.name("no_telp")).sendKeys(data.get("no_telp"));
            driver.findElement(By.name("email")).sendKeys(data.get("email"));
            driver.findElement(By.name("rating")).sendKeys(data.get("rating"));
            driver.findElement(By.name("fasilitas")).sendKeys(data.get("fasilitas"));
            driver.findElement(By.name("tipe")).sendKeys(data.get("tipe_1"));
            driver.findElement(By.name("harga")).sendKeys(data.get("harga_1"));
            driver.findElement(By.name("keberangkatan")).sendKeys(data.get("keberangkatan_1"));
            driver.findElement(By.name("tujuan")).sendKeys(data.get("tujuan_1"));

            // Config Jam
            SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm a");
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");

            // Jam Keberangkatan
            Date date = inputFormat.parse(data.get("jam_keberangkatan_1"));
            String formattedTime = outputFormat.format(date);
            Date formattedDate = outputFormat.parse(formattedTime);
            int hour = formattedDate.getHours();
            int minute = formattedDate.getMinutes();
            String ampm = hour >= 12 ? "PM" : "AM";
            hour = hour % 12;
            hour = hour != 0 ? hour : 12;

            // Set Hour
            driver.findElement(By.name("jam_keberangkatan")).sendKeys(data.get("jam_keberangkatan_1"));
            List<WebElement> clockMask = driver.findElements(By.cssSelector(".MuiTypography-root.MuiPickersClockNumber-clockNumber.MuiTypography-body1"));
            wait.until(ExpectedConditions.visibilityOfAllElements(clockMask));
            for (WebElement clockNumber : clockMask) {
                String number = clockNumber.getText();
                if (number.equals(Integer.toString(hour))) {
                    actions.moveToElement(clockNumber).click().build().perform();
                    // JavascriptExecutor executor = (JavascriptExecutor) driver;
                    // executor.executeScript("arguments[0].click();", clockNumber);
                    break;
                }
            }

            // Set Minute
            clockMask = driver.findElements(By.cssSelector(".MuiTypography-root.MuiPickersClockNumber-clockNumber.MuiTypography-body1"));
            wait.until(ExpectedConditions.visibilityOfAllElements(clockMask));

            for (WebElement clockNumber : clockMask) {
                String number = clockNumber.getText();
                if (number.equals(Integer.toString(minute))) {
                    actions.moveToElement(clockNumber).click().build().perform();
                    break;
                }
            }

            // Set AMPM
            WebElement ampmSelection = driver.findElement(By.className("MuiPickersTimePickerToolbar-ampmSelection"));

            List<WebElement> ampmOptions = ampmSelection.findElements(By.tagName("button"));
            for (WebElement option : ampmOptions) {
                if (option.getText().equals(ampm)) {
                    option.click();
                    break;
                }
            }

            // OK
            WebElement buttonOk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]")));
            buttonOk.click();

            // Estimasi Sampai
            date = inputFormat.parse(data.get("estimasi_sampai_1"));
            formattedTime = outputFormat.format(date);
            formattedDate = outputFormat.parse(formattedTime);
            hour = formattedDate.getHours();
            minute = formattedDate.getMinutes();
            ampm = hour >= 12 ? "PM" : "AM";
            hour = hour % 12;
            hour = hour != 0 ? hour : 12;

            // Set Hour
            driver.findElement(By.name("estimasi_sampai")).sendKeys(data.get("estimasi_sampai_1"));
            clockMask = driver.findElements(By.cssSelector(".MuiTypography-root.MuiPickersClockNumber-clockNumber.MuiTypography-body1"));
            wait.until(ExpectedConditions.visibilityOfAllElements(clockMask));
            for (WebElement clockNumber : clockMask) {
                String number = clockNumber.getText();
                if (number.equals(Integer.toString(hour))) {
                    actions.moveToElement(clockNumber).click().build().perform();
                    break;
                }
            }

            // Set Minute
            clockMask = driver.findElements(By.cssSelector(".MuiTypography-root.MuiPickersClockNumber-clockNumber.MuiTypography-body1"));
            wait.until(ExpectedConditions.visibilityOfAllElements(clockMask));

            for (WebElement clockNumber : clockMask) {
                String number = clockNumber.getText();
                if (number.equals(Integer.toString(minute))) {
                    actions.moveToElement(clockNumber).click().build().perform();
                    break;
                }
            }

            // Set Meridiem
            ampmSelection = driver.findElement(By.className("MuiPickersTimePickerToolbar-ampmSelection"));

            ampmOptions = ampmSelection.findElements(By.tagName("button"));
            for (WebElement option : ampmOptions) {
                if (option.getText().equals(ampm)) {
                    option.click();
                    break;
                }
            }

            // OK
            buttonOk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]")));
            buttonOk.click();

            // Upload Thumbnail
            if(data.get("thumbnail") != "") {
                driver.findElements(By.name("thumbnail")).get(0).sendKeys("D:\\School\\Polban\\Course\\Smt 6\\Pengujian Perangkat Lunak\\PR\\Week 12 - 14\\GeotaraAutomationTest\\src\\test\\resources\\datas\\" + data.get("thumbnail"));
            }
            if(data.get("thumbnail_1") != "") {
                driver.findElements(By.name("thumbnail")).get(1).sendKeys("D:\\School\\Polban\\Course\\Smt 6\\Pengujian Perangkat Lunak\\PR\\Week 12 - 14\\GeotaraAutomationTest\\src\\test\\resources\\datas\\" + data.get("thumbnail_1"));
            }

            try {
                TimeUnit.SECONDS.sleep(1); // menghentikan eksekusi selama 1 detik
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (TimeoutException e) {
            LOGGER.info("Timeout exception occurred.");
            driver.quit();
        }
    }

    @Then("User is navigated to the tour and travel list page")
    public void user_is_navigated_to_the_tour_and_travel_list_page() {
        By containerSelector = By.className("card-title");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(containerSelector));
            String actualText = element.getText();
            Assert.assertEquals("The actual text does not match the expected text.", "Daftar Tour", actualText);
            driver.quit();
        } catch (TimeoutException e) {
            fail("The tour and travel list page did not load within 10 seconds.");
            driver.quit();
        }
    }

    @Then("User should be able to see success notification with message {string}")
    public void user_should_be_able_to_see_success_notification_with_message(String message) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-content")));
                String actualText = element.getText();
                Assert.assertEquals("The actual text does not match the expected text.", message, actualText);
                driver.quit();
            } catch (TimeoutException e) {
                fail("The success notification did not load within 10 seconds.");
                driver.quit();
            }
        } catch (TimeoutException e) {
            LOGGER.info("Timeout exception occurred.");
            driver.quit();
        }
    }

    @Then("User should be able to see error notification with message {string}")
    public void user_should_be_able_to_see_error_notification_with_message(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-content")));
            String actualText = element.getText();
            Assert.assertEquals("The actual text does not match the expected text.", message, actualText);
            driver.quit();
        } catch (TimeoutException e) {
            fail("The error notification did not load within 10 seconds.");
            driver.quit();
        }
    }

    @And("User clicks on {string} button on specific tur")
    public void user_clicks_on_button_on_specific_tur(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if(buttonName.equals("Edit")) {
            WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[4]/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[2]/div[2]/div[6]/div/div/a[2]")));
            editButton.click();
        }
    }

    @And("User edit form")
    public void user_edit_form(DataTable testData) throws ParseException {
        try {
            TimeUnit.SECONDS.sleep(3); // menghentikan eksekusi selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);
            Map<String, String> data = testData.asMap(String.class, String.class);

            if(data.containsKey("nama_tur")) {
                driver.findElement(By.name("nama")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("nama_tur") != null) driver.findElement(By.name("nama")).sendKeys(data.get("nama_tur"));
            }
            if(data.containsKey("alamat")) {
                driver.findElement(By.name("alamat")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("alamat") != null) driver.findElement(By.name("alamat")).sendKeys(data.get("alamat"));
            }
            if(data.containsKey("longitude")) {
                driver.findElement(By.name("long")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("longitude") != null) driver.findElement(By.name("long")).sendKeys(data.get("longitude"));
            }
            if(data.containsKey("latitude")) {
                driver.findElement(By.name("lat")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("latitude") != null) driver.findElement(By.name("lat")).sendKeys(data.get("latitude"));
            }
            if(data.containsKey("no_telp")) {
                driver.findElement(By.name("no_telp")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("no_telp") != null) driver.findElement(By.name("no_telp")).sendKeys(data.get("no_telp"));
            }
            if(data.containsKey("email")) {
                driver.findElement(By.name("email")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("email") != null) driver.findElement(By.name("email")).sendKeys(data.get("email"));
            }
            if(data.containsKey("rating")) {
                driver.findElement(By.name("rating")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("rating") != null) driver.findElement(By.name("rating")).sendKeys(data.get("rating"));
            }
            if(data.containsKey("fasilitas"))  {
                driver.findElement(By.name("fasilitas")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("fasilitas") != null) driver.findElement(By.name("fasilitas")).sendKeys(data.get("fasilitas"));
            }
            if(data.containsKey("tipe_1")) {
                driver.findElement(By.name("tipe")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("tipe_1") != null) driver.findElement(By.name("tipe")).sendKeys(data.get("tipe_1"));
            }
            if(data.containsKey("harga_1")) {
                driver.findElement(By.name("harga")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("harga_1") != null) driver.findElement(By.name("harga")).sendKeys(data.get("harga_1"));
            }
            if(data.containsKey("keberangkatan_1")) {
                driver.findElement(By.name("keberangkatan")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("keberangkatan_1") != null) driver.findElement(By.name("keberangkatan")).sendKeys(data.get("keberangkatan_1"));
            }
            if(data.containsKey("tujuan_1")) {
                driver.findElement(By.name("tujuan")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                if(data.get("tujuan_1") != null) driver.findElement(By.name("tujuan")).sendKeys(data.get("tujuan_1"));
            }

            // Config Jam
            SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm a");
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");

            if(data.containsKey("jam_keberangkatan_1")) {
                // Jam Keberangkatan
                Date date = inputFormat.parse(data.get("jam_keberangkatan_1"));
                String formattedTime = outputFormat.format(date);
                Date formattedDate = outputFormat.parse(formattedTime);
                int hour = formattedDate.getHours();
                int minute = formattedDate.getMinutes();
                String ampm = hour >= 12 ? "PM" : "AM";
                hour = hour % 12;
                hour = hour != 0 ? hour : 12;

                // Set Hour
                driver.findElement(By.name("jam_keberangkatan")).sendKeys(data.get("jam_keberangkatan_1"));
                List<WebElement> clockMask = driver.findElements(By.cssSelector(".MuiTypography-root.MuiPickersClockNumber-clockNumber.MuiTypography-body1"));
                wait.until(ExpectedConditions.visibilityOfAllElements(clockMask));
                for (WebElement clockNumber : clockMask) {
                    String number = clockNumber.getText();
                    if (number.equals(Integer.toString(hour))) {
                        actions.moveToElement(clockNumber).click().build().perform();
                        // JavascriptExecutor executor = (JavascriptExecutor) driver;
                        // executor.executeScript("arguments[0].click();", clockNumber);
                        break;
                    }
                }

                // Set Minute
                clockMask = driver.findElements(By.cssSelector(".MuiTypography-root.MuiPickersClockNumber-clockNumber.MuiTypography-body1"));
                wait.until(ExpectedConditions.visibilityOfAllElements(clockMask));

                for (WebElement clockNumber : clockMask) {
                    String number = clockNumber.getText();
                    if (number.equals(Integer.toString(minute))) {
                        actions.moveToElement(clockNumber).click().build().perform();
                        break;
                    }
                }

                // Set AMPM
                WebElement ampmSelection = driver.findElement(By.className("MuiPickersTimePickerToolbar-ampmSelection"));

                List<WebElement> ampmOptions = ampmSelection.findElements(By.tagName("button"));
                for (WebElement option : ampmOptions) {
                    if (option.getText().equals(ampm)) {
                        option.click();
                        break;
                    }
                }

                // OK
                WebElement buttonOk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]")));
                buttonOk.click();
            }

            if(data.containsKey("estimasi_sampai_1")) {
                // Estimasi Sampai
                Date date = inputFormat.parse(data.get("estimasi_sampai_1"));
                String formattedTime = outputFormat.format(date);
                Date formattedDate = outputFormat.parse(formattedTime);
                int hour = formattedDate.getHours();
                int minute = formattedDate.getMinutes();
                String ampm = hour >= 12 ? "PM" : "AM";
                hour = hour % 12;
                hour = hour != 0 ? hour : 12;

                // Set Hour
                driver.findElement(By.name("estimasi_sampai")).sendKeys(data.get("estimasi_sampai_1"));
                List<WebElement> clockMask = driver.findElements(By.cssSelector(".MuiTypography-root.MuiPickersClockNumber-clockNumber.MuiTypography-body1"));
                wait.until(ExpectedConditions.visibilityOfAllElements(clockMask));
                for (WebElement clockNumber : clockMask) {
                    String number = clockNumber.getText();
                    if (number.equals(Integer.toString(hour))) {
                        actions.moveToElement(clockNumber).click().build().perform();
                        break;
                    }
                }

                // Set Minute
                clockMask = driver.findElements(By.cssSelector(".MuiTypography-root.MuiPickersClockNumber-clockNumber.MuiTypography-body1"));
                wait.until(ExpectedConditions.visibilityOfAllElements(clockMask));

                for (WebElement clockNumber : clockMask) {
                    String number = clockNumber.getText();
                    if (number.equals(Integer.toString(minute))) {
                        actions.moveToElement(clockNumber).click().build().perform();
                        break;
                    }
                }

                // Set Meridiem
                WebElement ampmSelection = driver.findElement(By.className("MuiPickersTimePickerToolbar-ampmSelection"));

                List<WebElement> ampmOptions = ampmSelection.findElements(By.tagName("button"));
                for (WebElement option : ampmOptions) {
                    if (option.getText().equals(ampm)) {
                        option.click();
                        break;
                    }
                }

                // OK
                WebElement buttonOk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]")));
                buttonOk.click();
            }

            // Upload Thumbnail
            if(data.containsKey("thumbnail")) {
                driver.findElements(By.name("thumbnail")).get(0).sendKeys("D:\\School\\Polban\\Course\\Smt 6\\Pengujian Perangkat Lunak\\PR\\Week 12 - 14\\GeotaraAutomationTest\\src\\test\\resources\\datas\\" + data.get("thumbnail"));
            }
            if(data.containsKey("thumbnail_1")) {
                driver.findElements(By.name("thumbnail")).get(1).sendKeys("D:\\School\\Polban\\Course\\Smt 6\\Pengujian Perangkat Lunak\\PR\\Week 12 - 14\\GeotaraAutomationTest\\src\\test\\resources\\datas\\" + data.get("thumbnail_1"));
            }

            try {
                TimeUnit.SECONDS.sleep(3); // menghentikan eksekusi selama 3 detik
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (TimeoutException e) {
            LOGGER.info("Timeout exception occurred.");
            driver.quit();
        }
    }
}
