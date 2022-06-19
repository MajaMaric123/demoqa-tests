package pages.elementspages;

import org.openqa.selenium.*;
import pages.commonpages.BasePage;
import lombok.Data;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class ElementsPage extends BasePage {

    private By textBoxButton = By.xpath("//*[@id=\"item-0\"]");
    private By checkBoxButton = By.xpath("//*[@id=\"item-1\"]");
    private By radioButton = By.xpath("//*[@id=\"item-2\"]");
    private By webTablesButton = By.xpath("//*[@id=\"item-3\"]");
    private By buttonsButton = By.xpath("//*[@id=\"item-4\"]");

    public ElementsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Select Text Box section
     */
    public WebElement getTextBoxButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        return getDriver().findElement(textBoxButton);
    }

    public void clickTextBoxButton() {
        getTextBoxButton().click();
    }

    /**
     * Select Check Box section
     */
    public WebElement getCheckBoxButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        return getDriver().findElement(checkBoxButton);
    }

    public void clickCheckBoxButton() {
        getCheckBoxButton().click();
    }

    /**
     * Select Radio Button section
     */
    public WebElement getRadioButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        return getDriver().findElement(radioButton);
    }

    public void clickRadioButton() {
        getRadioButton().click();
    }

    /**
     * Select Web Tables section
     */
    public WebElement getWebTablesButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        return getDriver().findElement(webTablesButton);
    }

    public void clickWebTablesButton() {
        getWebTablesButton().click();
    }

    /**
     * Select Buttons section
     */
    public WebElement getButtonsButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        return getDriver().findElement(buttonsButton);
    }

    public void clickButtonsButton() {
        getButtonsButton().click();
    }
}
