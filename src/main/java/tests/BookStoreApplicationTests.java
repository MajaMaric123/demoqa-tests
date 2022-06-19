package tests.bookStoreApplicationTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class Tests extends BaseTests {

    //Verify that logout button is visible after filling login form with valid credentials in Login section
    @Test(priority = 1)
    public void verifyLogoutButtonIsVisibleAfterFillingLoginForm() {
        getHomePage().clickBookStoreApplicationCard();
        getBookPage().clickLogin();
        getLoginPage().inputLoginForm("Maki123", "Ma123(76z@");
        getLoginPage().clickLoginButton();
        Assert.assertTrue(getBookPage().isVisibleLogoutButton());
    }

    //Verify that book is visible on profile after click on "AddToCollection" button in Book store section
    @Test(priority = 2)
    public void verifyIsBookInVisibleOnProfileAfterAddingToCollection() {
        getHomePage().clickBookStoreApplicationCard();
        getBookPage().clickLogin();
        getLoginPage().inputLoginForm("Maki123", "Ma123(76z@");
        getLoginPage().clickLoginButton();
        getBookPage().clickBook();
        Assert.assertEquals(getBookPage().isVisibleBookName(), "Git Pocket Guide");
        getBookPage().clickAddToYourCollection();
        getBookPage().skipAlert();
        //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getBookPage().clickProfileButton();
        Assert.assertEquals(getProfilePage().confirmationBookName(), "Git Pocket Guide");
    }
}
