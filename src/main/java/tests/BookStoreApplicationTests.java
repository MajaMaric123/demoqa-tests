package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreApplicationTests extends BaseTests {

    /**
     * Verify that logout button is visible after filling login form with valid credentials in Login section
     */
    @Test(priority = 1)
    public void verifyLogoutButtonIsVisibleAfterLogin() {
        clickLoginInBookStoreApplicationCard();
        getLoginPage().inputLoginForm("Maki123", "Ma123(76z@");
        getLoginPage().clickLoginButton();
        Assert.assertTrue(getBookPage().isVisibleLogoutButton());
    }

    /**
     * Verify that book is visible on profile after click on "AddToCollection" button in Book store section
     */
    @Test(priority = 2)
    public void verifyIsBookInVisibleOnProfileAfterAddingBookToCollection() {
        clickLoginInBookStoreApplicationCard();
        getLoginPage().inputLoginForm("Maki123", "Ma123(76z@");
        getLoginPage().clickLoginButton();
        getBookPage().clickBook();
        Assert.assertEquals(getBookPage().isVisibleBookName(), "Git Pocket Guide");
        getBookPage().clickAddToYourCollection();
        getBookPage().skipAlert();
        getBookPage().clickProfileButton();
        Assert.assertEquals(getProfilePage().confirmationBookName(), "Git Pocket Guide");
    }
}
