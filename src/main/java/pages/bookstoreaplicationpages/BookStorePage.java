package pages.bookStoreApplicationPage;

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
public class BookStorePage extends BasePage {

    private By login = By.id("login");
    private By logout = By.id("submit");
    private By bookGitPocketGuide = By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a");
    private By bookName = By.xpath("//*[@id=\"title-wrapper\"]/div[2]");
    private By addToYourCollectionButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button");
    private By profileButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]");


    public BookStorePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLogin(){
        return getDriver().findElement(login);
    }

    public void clickLogin(){
        getLogin().click();
    }

    public boolean isVisibleLogoutButton() {
        return getDriver().findElement(logout).isDisplayed();
    }

   public WebElement getBook(){
        return getDriver().findElement(bookGitPocketGuide);
    }

    public void clickBook(){
        getBook().click();
    }

    public String isVisibleBookName() {
        return getDriver().findElement(bookName).getText();
    }

    public WebElement getAddToYourCollection(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(addToYourCollectionButton);
    }

    public void clickAddToYourCollection(){
        getAddToYourCollection().click();
    }

    public WebElement getProfileButton(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(profileButton);
    }

    public void clickProfileButton(){
        getProfileButton().click();
    }
}
