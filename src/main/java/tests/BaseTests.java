package tests;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.alertsframewindowspages.AlertsFrameWindowsPage;
import pages.alertsframewindowspages.AlertsPage;
import pages.bookstoreaplicationpages.BookStorePage;
import pages.bookstoreaplicationpages.LoginPage;
import pages.bookstoreaplicationpages.ProfilePage;
import pages.commonpages.HomePage;
import pages.elementspages.*;

import java.time.Duration;

@Getter
public class BaseTests {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homePage;
    private LoginPage loginPage;
    private BookStorePage bookPage;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;
    private RadioButtonPage radioButtonPage;
    private ProfilePage profilePage;
    private AlertsFrameWindowsPage alertsFrameWindowsPage;
    private AlertsPage alertsPage;
    private WebTablesPage webTablesPage;
    private ButtonsPage buttonsPage;
    private CheckBoxPage checkBoxPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Petar\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
        driver = new ChromeDriver();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        this.homePage = new HomePage(driver, driverWait);
        this.loginPage = new LoginPage(driver, driverWait);
        this.bookPage = new BookStorePage(driver, driverWait);
        this.elementsPage = new ElementsPage(driver, driverWait);
        this.textBoxPage = new TextBoxPage(driver, driverWait);
        this.radioButtonPage = new RadioButtonPage(driver, driverWait);
        this.profilePage = new ProfilePage(driver, driverWait);
        this.alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver, driverWait);
        this.alertsPage = new AlertsPage(driver, driverWait);
        webTablesPage = new WebTablesPage(driver, driverWait);
        this.buttonsPage = new ButtonsPage(driver, driverWait);
        this.checkBoxPage = new CheckBoxPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public BookStorePage getBookPage() {
        return bookPage;
    }

    public ElementsPage getElementsPage() {
        return elementsPage;
    }

    public TextBoxPage getTextBoxPage() {
        return textBoxPage;
    }

    public RadioButtonPage getRadioButtonPage() {
        return radioButtonPage;
    }

    public WebTablesPage getWebTablesPage() {
        return webTablesPage;
    }

    public ProfilePage getProfilePage() {
        return profilePage;
    }

    public AlertsFrameWindowsPage getAlertsFrameWindowsPage() {
        return alertsFrameWindowsPage;
    }

    public AlertsPage getAlertsPage() {
        return alertsPage;
    }

    public ButtonsPage getButtonsPage() {
        return buttonsPage;
    }

    public CheckBoxPage getCheckBoxPage() {
        return checkBoxPage;
    }

    /**
     * Click on Elements card and after that click on Check Box button
     */
    public void clickCheckBoxInElementsCard() {
        getHomePage().clickElementsCard();
        getElementsPage().clickCheckBoxButton();
    }

    /**
     * Click on Elements card and after that click on Web Tables button
     */
    public void clickWebTablesInElementsCard() {
        getHomePage().clickElementsCard();
        getElementsPage().clickWebTablesButton();
    }

    /**
     * Click on Elements card and after that click on Buttons button
     */
    public void clickButtonsInElementsCard(){
        getHomePage().clickElementsCard();
        getElementsPage().clickButtonsButton();
    }

    /**
     * Click on Alerts, Frame and Windows card and after that click on Alerts button
     */
    public void clickAlertsInAlertFrameWindowsCard(){
        getHomePage().clickAlertsFrameWindowsCard();
        getAlertsFrameWindowsPage().clickAlerts();
    }

    /**
     * Click on Book Store Application card and after that click on Login button
     */
    public void clickLoginInBookStoreApplicationCard(){
        getHomePage().clickBookStoreApplicationCard();
        getBookPage().clickLogin();
    }
}

