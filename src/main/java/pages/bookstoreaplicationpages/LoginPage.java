package pages.bookstoreaplicationpages;

import pages.commonpages.BasePage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class LoginPage extends BasePage {

    private By loginButton = By.id("login");
    private By userName = By.id("userName");
    private By password = By.id("password");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Click on "Login" button
     */
    public WebElement getLoginButton(){
        return getDriver().findElement(loginButton);
    }

    public void clickLoginButton(){
        getLoginButton().click();
    }

    public WebElement getPassword(){
        return getDriver().findElement(password);
    }

    public WebElement getUserName(){
        return getDriver().findElement(userName);
    }

    /**
     * Input Login Form
     */
    public void inputLoginForm(String username, String password){
        getUserName().sendKeys(username);
        getPassword().sendKeys(password);
    }
}
