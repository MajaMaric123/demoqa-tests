package pages.commonPage;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class HomePage extends BasePage {

    private By elementsCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    private By alertsFrameWindowsCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div");
    private By bookStoreApplicationCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]/div");


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Select Elements Card
     */
    public WebElement getElementsCard(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(elementsCard);
    }

    public void clickElementsCard(){
        getElementsCard().click();
    }

    /**
     * Select Alerts Frame & Windows card
     */
    public WebElement getAlertsFrameWindowsCard(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(alertsFrameWindowsCard);
    }

    public void clickAlertsFrameWindowsCard(){
        getAlertsFrameWindowsCard().click();
    }

    /**
     * Select Book Store Application card
     */
    public WebElement getBookStoreApplicationCard(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(bookStoreApplicationCard);
    }

    public void clickBookStoreApplicationCard(){
        getBookStoreApplicationCard().click();
    }
}
