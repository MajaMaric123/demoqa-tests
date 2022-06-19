package tests.elementsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

import java.time.Duration;

public class Tests extends BaseTests {

    //Verify that valid output message appears after input valid credentials in Text Box form
    @Test(priority = 1)
    public void verifyConfirmationMessageAppearsAfterFillingTextBoxForm() {
        getHomePage().clickElementsCard();
        getElementsPage().clickTextBoxButton();
        getTextBoxPage().inputTextBoxForm("Maja Maric", "maja@gmail.com", "Safarikova 10", "Danila Kisa 20");
        getTextBoxPage().clickSubmitButton();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals(getTextBoxPage().confirmationFullNameOutput(), "Name:Maja Maric");
        Assert.assertEquals(getTextBoxPage().confirmationEmailOutput(), "Email:maja@gmail.com");
        Assert.assertEquals(getTextBoxPage().confirmationCurrentAddressOutput(), "Current Address :Safarikova 10");
        Assert.assertEquals(getTextBoxPage().confirmationPermanentAddressOutput(), "Permananet Address :Danila Kisa 20");
    }

    //Verify that all check box are selected after selecting Home check box in Check Box section
    @Test(priority = 2)
    public void verifyConfirmationMessageAppearsAfterSelectingHomeCheckBox() {
        getHomePage().clickElementsCard();
        getElementsPage().clickCheckBoxButton();
        getCheckBoxPage().clickHomeCheckBox();
        Assert.assertEquals(getCheckBoxPage().confirmationResults(), "You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile");
    }

    //Verify that notes check box is selected after click on Notes check box in Check Box section
    @Test(priority = 3)
    public void verifyConfirmationMessageAppearsAfterSelectingNotesCheckBox() {
        getHomePage().clickElementsCard();
        getElementsPage().clickCheckBoxButton();
        getCheckBoxPage().clickHomePath();
        getCheckBoxPage().clickDesktopPath();
        getCheckBoxPage().clickNotesCheckBox();
        Assert.assertEquals(getCheckBoxPage().confirmationResults(), "You have selected :\n" + "notes");
    }

    //Verify that "Yes" and "Impressive" radio buttons can be selected in Radio Buttons section
    @Test(priority = 4)
    public void verifyThatUserGetsConfirmationMessageAfterClickOnRadioButton() {
        getHomePage().clickElementsCard();
        getElementsPage().clickRadioButton();
        getRadioButtonPage().clickOnYesRadioButton();
        Assert.assertEquals(getRadioButtonPage().confirmationMessageForYesRadioButton(), "Yes");
        Assert.assertFalse(getRadioButtonPage().isImpressiveRadioButtonSelected());
        getRadioButtonPage().clickOnImpressiveRadioButton();
        Assert.assertEquals(getRadioButtonPage().confirmationMessageForImpressiveRadioButton(), "Impressive");
        Assert.assertFalse(getRadioButtonPage().isYesRadioButtonSelected());
    }

    //Verify that new record exists in the table after filling add new record form in Web Tables section
    @Test(priority = 5)
    public void verifyNewRecordExistsInTableAfterFillingAddNewRecordForm() {
        getHomePage().clickElementsCard();
        getElementsPage().clickWebTablesButton();
        getWebTablesPage().clickAddNewRecordButton();
        getWebTablesPage().inputAddNewRecordForm("Maja", "Maric", "maja@gmail.com", "25", "150000", "IT sector");
        getWebTablesPage().clickSubmitButton();
        Assert.assertTrue(getWebTablesPage().checkIfNewRecordIsPartOfTheTable("Maja", "Maric", "maja@gmail.com",
                "25", "150000", "IT sector"));
    }

    //Verify that record is deleted from Table after click on Delete button in Web Tables section
    @Test(priority = 6)
    public void verifyRecordIsDeletedAfterClickOnDeleteButton(){
        getHomePage().clickElementsCard();
        getElementsPage().clickWebTablesButton();
        getWebTablesPage().clickDeleteButton();
        Assert.assertTrue(getWebTablesPage().checkIfRowIsEmpty());
    }

    //Verify that confirmation message appears after double-click on Double Click Me button in Buttons section
    @Test(priority = 7)
    public void verifyConfirmationMessageAppearsAfterDoubleClickOnDoubleClickMeButton() {
        getHomePage().clickElementsCard();
        getElementsPage().clickButtonsButton();
        getButtonsPage().clickDoubleClickMeButton();
        Assert.assertEquals(getButtonsPage().confirmationDoubleClickMessage(), "You have done a double click");
    }

    //Verify that confirmation message appears after right click on Right Click Me button in Buttons section
    @Test(priority = 8)
    public void verifyConfirmationMessageAppearsAfterRightClickOnRightClickMeButton() {
        getHomePage().clickElementsCard();
        getElementsPage().clickButtonsButton();
        getButtonsPage().clickRightClickMeButton();
        Assert.assertEquals(getButtonsPage().confirmationRightClickMessage(), "You have done a right click");
    }

    //Verify that confirmation message appears after click on Click Me button in Buttons section
    @Test(priority = 9)
    public void verifyConfirmationMessageAppearsAfterClickOnClickMeButton() {
        getHomePage().clickElementsCard();
        getElementsPage().clickButtonsButton();
        getButtonsPage().clickClickMeButton();
        Assert.assertEquals(getButtonsPage().confirmationDynamicClickMessage(), "You have done a dynamic click");
    }
}
