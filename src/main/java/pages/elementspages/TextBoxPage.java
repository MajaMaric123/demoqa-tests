package pages.elementsPage;

import pages.commonpages.BasePage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class TextBoxPage extends BasePage {

    private By fullNameField = By.id("userName");
    private By emailField = By.id("userEmail");
    private By currentAddressField = By.id("currentAddress");
    private By permanentAddressField = By.id("permanentAddress");
    private By submitButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div/button");
    private By fullNameOutput = By.xpath("//*[@id=\"name\"]");
    private By emailOutput = By.xpath("//*[@id=\"email\"]");
    private By currentAddressOutput = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]");
    private By permanentAddressOutput = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]");

    public TextBoxPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Select all input fields
     */
    public WebElement getFullNameField() {
        return getDriver().findElement(fullNameField);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getCurrentAddressField() {
        return getDriver().findElement(currentAddressField);
    }

    public WebElement getPermanentAddressField() {
        return getDriver().findElement(permanentAddressField);
    }

    /**
     * Scroll down and find submit button
     */
    public WebElement getSubmitButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(submitButton);
    }

    public void clickSubmitButton() {
        getSubmitButton().click();
    }

    /**
     * Input Text Box Form with full name, email, current address, permanent address
     */
    public void inputTextBoxForm(String fullname, String email, String currentaddress, String permanentaddress) {
        getFullNameField().sendKeys(fullname);
        getEmailField().sendKeys(email);
        getCurrentAddressField().sendKeys(currentaddress);
        getPermanentAddressField().sendKeys(permanentaddress);
    }

    /**
     * Take the text from the output message and compare them with the expected results
     */
    public String confirmationFullNameOutput() {
        return getDriver().findElement(fullNameOutput).getText();
    }

    public String confirmationEmailOutput() {
        return getDriver().findElement(emailOutput).getText();
    }

    public String confirmationCurrentAddressOutput() {
        return getDriver().findElement(currentAddressOutput).getText();
    }

    public String confirmationPermanentAddressOutput() {
        return getDriver().findElement(permanentAddressOutput).getText();
    }
}
