package pages.commonPage;

import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class BasePage {

    private WebDriver driver;
    private WebDriverWait driverWait;

    private static final String HOME_URL = "https://demoqa.com/";

    public BasePage() {
    }

    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public void setDriverWait(WebDriverWait driverWait) {
        this.driverWait = driverWait;
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void skipAlert() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void openHomePage(){
        driver.navigate().to(HOME_URL);
    }
}

