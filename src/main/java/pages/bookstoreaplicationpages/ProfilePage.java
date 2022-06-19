package pages.bookstoreaplicationpages;

import pages.commonpages.BasePage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class ProfilePage extends BasePage {

    private By bookNameOnProfile = By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a");

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Get text from book name and compare it with the expected results
     */
    public String confirmationBookName() {
        return getDriver().findElement(bookNameOnProfile).getText();
    }
}
