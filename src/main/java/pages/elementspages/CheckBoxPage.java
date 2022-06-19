package pages.elementsPage;

import pages.commonpages.BasePage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class CheckBoxPage extends BasePage {

    private By homeCheckBox = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]");
    private By results = By.xpath("//*[@id=\"result\"]");
    private By homePath = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button");
    private By desktopPath = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button");
    private By notesCheckBox = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]");

    public CheckBoxPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Check Home check box
     */
    public WebElement getHomeCheckBox() {
        return getDriver().findElement(homeCheckBox);
    }

    public void clickHomeCheckBox() {
        getHomeCheckBox().click();
    }

    /**
     * Expand Home Box
     */
    public WebElement getHomePath() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver().findElement(homePath);
    }

    public void clickHomePath() {
        getHomePath().click();
    }

    /**
     * Expand Desktop Box
     */
    public WebElement getDesktopPath() {
        return getDriver().findElement(desktopPath);
    }

    public void clickDesktopPath() {
        getDesktopPath().click();
    }

    /**
     * Check Notes check box
     */
    public WebElement getNotesCheckBox() {
        return getDriver().findElement(notesCheckBox);
    }

    public void clickNotesCheckBox() {
        getNotesCheckBox().click();
    }

    /**
     * Take the text from the output message and compare it with the expected results
     */
    public String confirmationResults() {
        return getDriver().findElement(results).getText();
    }
}
