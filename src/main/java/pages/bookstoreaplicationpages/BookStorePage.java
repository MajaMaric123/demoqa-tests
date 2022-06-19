package pages.bookstoreaplicationpages;

import org.openqa.selenium.*;
import pages.commonpages.BasePage;
import lombok.Data;
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

    /**
     * Click on "Login" button
     */
    public WebElement getLogin(){
        return getDriver().findElement(login);
    }

    public void clickLogin(){
        getLogin().click();
    }

    /**
     * Find logout button and confirm is Visible
     */
    public boolean isVisibleLogoutButton() {
        return getDriver().findElement(logout).isDisplayed();
    }

    /**
     * Click on "Git Pocket Guide" book
     */
   public WebElement getBook(){
        return getDriver().findElement(bookGitPocketGuide);
    }

    public void clickBook(){
        getBook().click();
    }

    /**
     * Get the text from the book name and compare it with the expected results
     */
    public String isVisibleBookName() {
        return getDriver().findElement(bookName).getText();
    }

    /**
     * Click on "Add To Your Collection" button
     */
    public WebElement getAddToYourCollection(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        return getDriver().findElement(addToYourCollectionButton);
    }

    public void clickAddToYourCollection(){
        getAddToYourCollection().click();
    }

    /**
     * Click on "Profile" button
     */
    public WebElement getProfileButton(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        return getDriver().findElement(profileButton);
    }

    public void clickProfileButton(){
        getProfileButton().click();
    }
}
