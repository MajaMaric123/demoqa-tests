package tests.alertsFrameWindowsTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class Tests extends BaseTests {


    //Verify that alert message appears after click on "Click Button to see alert" click me button in Alerts section
    @Test(priority = 1)
    public void verifyAlertMessageAppearsAfterClickOnClickButtonToSeeAlert() {
        getHomePage().clickAlertsFrameWindowsCard();
        getAlertsFrameWindowsPage().clickAlerts();
        getAlertsPage().clickAlertButton();
        Assert.assertTrue(getAlertsPage().isVisibleAlertMessage());
        getAlertsPage().acceptAlertMessage();
    }


    //Verify that alert message appears after click on "On button click, alert will appear after 5 seconds"
    //click me button in Alerts section and wait 5 seconds to alert show up
    @Test(priority = 2)
    public void verifyAlertMessageAppearsAfterClickOnTimerAlertButton() {
        getHomePage().clickAlertsFrameWindowsCard();
        getAlertsFrameWindowsPage().clickAlerts();
        getAlertsPage().clickTimerAlertButton();
        Assert.assertTrue(getAlertsPage().isVisibleTimerAlertMessage());
        getAlertsPage().acceptAlertMessage();
    }


    //Verify that alert message appears after click on "On button click, confirm box will appear" click me button
    //in Alerts section and confirm action
    @Test(priority = 3)
    public void verifyAlertMessageAppearsAfterClickOnConfirmBoxAlertButton() {
        getHomePage().clickAlertsFrameWindowsCard();
        getAlertsFrameWindowsPage().clickAlerts();
        getAlertsPage().clickConfirmAlertButton();
        getAlertsPage().acceptAlertMessage();
        Assert.assertEquals(getAlertsPage().confirmationConfirmResultsMessage(), "You selected Ok");
    }


    //Verify that alert message appears after click on "On button click, prompt box will appear" click me button
    //in Alerts section and send name into alerts filed
    @Test(priority = 4)
    public void verifyPromptBoxAppearsAfterClickOnClickMeButton() {
        getHomePage().clickAlertsFrameWindowsCard();
        getAlertsFrameWindowsPage().clickAlerts();
        getAlertsPage().clickPromptButton();
        getDriverWait().until(ExpectedConditions.alertIsPresent());
        getAlertsPage().enterNameInAlert("Maja");
        Assert.assertEquals(getAlertsPage().confirmationPromptResultsMessage(), "You entered Maja");
    }
}
