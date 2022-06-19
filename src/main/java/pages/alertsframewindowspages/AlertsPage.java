package pages.alertsframewindowspages;

import pages.commonpages.BasePage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class AlertsPage extends BasePage {

    private By alertButton = By.id("alertButton");
    private By timerAlertButton = By.id("timerAlertButton");
    private By confirmAlertButton = By.id("confirmButton");
    private By confirmButtonResult = By.id("confirmResult");
    private By promptAlertButton = By.id("promtButton");
    private By promptButtonResults = By.id("promptResult");

    public AlertsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Click on "Click Button to see alert" click me button
     */
    public WebElement getAlertButton(){
        return getDriver().findElement(alertButton);
    }

    public void clickAlertButton(){
        getAlertButton().click();
    }

    /**
     * Verify is alert presented
     */
    public boolean isVisibleAlertMessage() {
        return getDriverWait().until(ExpectedConditions.alertIsPresent()) != null;
    }

    /**
     * Accept alert after is visible
     */
    public void acceptAlertMessage(){
        getDriver().switchTo().alert().accept();
    }

    /**
     * Click on "On button click, alert will appear after 5 seconds"
     * click me button
     */
    public WebElement getTimerAlertButton(){
        return getDriver().findElement(timerAlertButton);
    }

    public void clickTimerAlertButton(){
        getTimerAlertButton().click();
    }

    /**
     * Verify is time alert presented
     */
    public boolean isVisibleTimerAlertMessage() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return getDriverWait().until(ExpectedConditions.alertIsPresent()) != null;
    }

    /**
     * Click on "On button click, confirm box will appear" click me button
     */
    public WebElement getConfirmAlertButton(){
        return getDriver().findElement(confirmAlertButton);
    }

    public void clickConfirmAlertButton(){
        getConfirmAlertButton().click();
    }

    /**
     *  Take the text from the output message and compare it with the expected results
     */
    public String confirmationConfirmResultsMessage() {
        return getDriver().findElement(confirmButtonResult).getText();
    }

    /**
     * Click on "On button click, prompt box will appear" click me button
     */
    public WebElement getPromptButton(){
        return getDriver().findElement(promptAlertButton);
    }

    public void clickPromptButton(){
        getPromptButton().click();
    }

    /**
     * Enter name in alerts filed and click Ok button
     */
    public void enterNameInAlert(String name){
        getDriver().switchTo().alert().sendKeys(name);
        getDriver().switchTo().alert().accept();
    }

    /**
     * Take the text from the output message and compare it with the expected results
     */
    public String confirmationPromptResultsMessage() {
        return getDriver().findElement(promptButtonResults).getText();
    }
}
