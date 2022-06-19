package pages.alertsframewindowspages;

import org.openqa.selenium.*;
import pages.commonpages.BasePage;
import lombok.Data;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class AlertsFrameWindowsPage extends BasePage {

    private By alerts = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]");

    public AlertsFrameWindowsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Click on "Alerts" section
     */
    public WebElement getAlerts(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        return getDriver().findElement(alerts);
    }

    public void clickAlerts(){
        getAlerts().click();
    }
}
