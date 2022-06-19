package pages.elementsPage;

import pages.commonpages.BasePage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class RadioButtonPage extends BasePage {

    private By yesRadioButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label");
    private By impressiveRadioButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label");
    private By results = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span");

    public RadioButtonPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getYesRadioButton(){
        return getDriver().findElement(yesRadioButton);
    }

    public void clickOnYesRadioButton(){
        getYesRadioButton().click();
    }

    public WebElement getImpressiveRadioButton(){
        return getDriver().findElement(impressiveRadioButton);
    }

    public void clickOnImpressiveRadioButton(){
        getImpressiveRadioButton().click();
    }

    /**
     * Confirm that "Yes" radio button is selected
     */
    public boolean isYesRadioButtonSelected(){
        return getYesRadioButton().isSelected();
    }

    /**
     * Confirm that "Impressive" radio button is selected
     */
    public boolean isImpressiveRadioButtonSelected(){
        return getImpressiveRadioButton().isSelected();
    }

    /**
     * Take the text from the output message and compare it with the expected results
     */
    public String confirmationMessageForRadioButton() {
        return getDriver().findElement(results).getText();
    }
}
