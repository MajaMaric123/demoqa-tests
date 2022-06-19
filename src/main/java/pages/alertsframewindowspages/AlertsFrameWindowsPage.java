package pages.alertsFrameWindowsPage;

import pages.commonPage.BasePage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class AlertsFrameWindowsPage extends BasePage {

    private By alerts = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]");

    public AlertsFrameWindowsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAlerts(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(alerts);
    }

    public void clickAlerts(){
        getAlerts().click();
    }
}
