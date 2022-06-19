package pages.elementspages;

import pages.commonpages.BasePage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class ButtonsPage extends BasePage {

    private By doubleClickMeButton = By.id("doubleClickBtn");
    private By rightClickMeButton = By.id("rightClickBtn");
    private By clickMeButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button");
    private By dynamicClickMessage = By.id("dynamicClickMessage");
    private By doubleClickMessage = By.id("doubleClickMessage");
    private By rightClickMessage = By.id("rightClickMessage");

    public ButtonsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getDoubleClickMeButton(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver().findElement(doubleClickMeButton);
    }

    /**
    *Double-click on Double Click Me button*/
    public void clickDoubleClickMeButton(){
        Actions doubleClick = new Actions(getDriver());
        doubleClick.moveToElement(getDoubleClickMeButton()).doubleClick().build().perform();
    }

    public WebElement getRightClickMeButton(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        return getDriver().findElement(rightClickMeButton);
    }

    /**
     * Right click on Right Click Me button
     */
    public void clickRightClickMeButton(){
        Actions rightClick = new Actions(getDriver());
        rightClick.moveToElement(getRightClickMeButton()).contextClick().build().perform();
    }

    /**
     * Click on Click Me Button
     */
    public WebElement getClickMeButton(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver().findElement(clickMeButton);
    }

    public void clickClickMeButton(){
        getClickMeButton().click();
    }

    /**
     * Get the text from the output message and compare it with the expected results
     */
    public String confirmationDynamicClickMessage() {
        return getDriver().findElement(dynamicClickMessage).getText();
    }

    public String confirmationDoubleClickMessage() {
        return getDriver().findElement(doubleClickMessage).getText();
    }

    public String confirmationRightClickMessage() {
        return getDriver().findElement(rightClickMessage).getText();
    }
}
