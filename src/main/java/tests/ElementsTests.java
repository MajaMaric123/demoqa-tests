package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementsTests extends BaseTests {

    /**
     * Verify that valid output message appears after input valid credentials in Text Box form in Text Box section
     */
    @Test
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

    /**
     * Verify that all check box are selected after selecting Home check box in Check Box section
     */
    @Test
    public void verifyConfirmationMessageAppearsAfterSelectingHomeCheckBox() {
        clickCheckBoxInElementsCard();
        getCheckBoxPage().clickHomeCheckBox();
        Assert.assertEquals(getCheckBoxPage().confirmationResults(), "You have selected :\n"
                + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n"
                + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n"
                + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile");
    }

    /**
     * Verify that notes check box is selected after click on Notes check box in Check Box section
     */
    @Test
    public void verifyConfirmationMessageAppearsAfterSelectingNotesCheckBox() {
        clickCheckBoxInElementsCard();
        getCheckBoxPage().clickHomePath();
        getCheckBoxPage().clickDesktopPath();
        getCheckBoxPage().clickNotesCheckBox();
        Assert.assertEquals(getCheckBoxPage().confirmationResults(), "You have selected :\n" + "notes");
    }

    /**
     * Verify that "Yes" and "Impressive" radio buttons can be selected in Radio Buttons section
     */
    @Test
    public void verifyThatUserGetsConfirmationMessageAfterClickOnRadioButton() {
        getHomePage().clickElementsCard();
        getElementsPage().clickRadioButton();
        getRadioButtonPage().clickOnYesRadioButton();
        Assert.assertEquals(getRadioButtonPage().confirmationMessageForRadioButton(), "Yes");
        Assert.assertFalse(getRadioButtonPage().isImpressiveRadioButtonSelected());
        getRadioButtonPage().clickOnImpressiveRadioButton();
        Assert.assertEquals(getRadioButtonPage().confirmationMessageForRadioButton(), "Impressive");
        Assert.assertFalse(getRadioButtonPage().isYesRadioButtonSelected());
    }

    /**
     * Verify that new record exists in the table after filling add new record form in Web Tables section
     */
    @Test
    public void verifyNewRecordExistsInTableAfterFillingAddNewRecordForm() {
        clickWebTablesInElementsCard();
        getWebTablesPage().clickAddNewRecordButton();
        getWebTablesPage().inputAddNewRecordForm("Maja", "Maric", "maja@gmail.com", "25", "150000", "IT sector");
        getWebTablesPage().clickSubmitButton();
        Assert.assertTrue(getWebTablesPage().checkIfNewRecordIsPartOfTheTable("Maja", "Maric", "maja@gmail.com",
                "25", "150000", "IT sector"));
    }

    /**
     * Verify that record is deleted from Table after click on Delete button in Web Tables section
     */
    @Test
    public void verifyRecordIsDeletedAfterClickOnDeleteButton() {
        clickWebTablesInElementsCard();
        getWebTablesPage().clickDeleteButton();
        Assert.assertTrue(getWebTablesPage().checkIfRowIsEmpty());
    }

    /**
     * Verify that first record in the table is edited after click on Edit button and send keys in Web Tables section
     */
    @Test
    public void verifyRecordIsEditedAfterClickOnEditButton() {
        clickWebTablesInElementsCard();
        getWebTablesPage().clickEditRecordButton();
        getWebTablesPage().editRecordFirstName("Maja");
        getWebTablesPage().clickSubmitButton();
        Assert.assertEquals(getWebTablesPage().confirmationFirstNameInTable(), "Maja");
    }

    /**
     * Verify that confirmation message appears after double-click on Double Click Me button in Buttons section
     */
    @Test
    public void verifyConfirmationMessageAppearsAfterDoubleClickOnDoubleClickMeButton() {
        clickButtonsInElementsCard();
        getButtonsPage().clickDoubleClickMeButton();
        Assert.assertEquals(getButtonsPage().confirmationDoubleClickMessage(), "You have done a double click");
    }

    /**
     * Verify that confirmation message appears after right click on Right Click Me button in Buttons section
     */
    @Test
    public void verifyConfirmationMessageAppearsAfterRightClickOnRightClickMeButton() {
        clickButtonsInElementsCard();
        getButtonsPage().clickRightClickMeButton();
        Assert.assertEquals(getButtonsPage().confirmationRightClickMessage(), "You have done a right click");
    }

    /**
     * Verify that confirmation message appears after click on Click Me button in Buttons section
     */
    @Test
    public void verifyConfirmationMessageAppearsAfterClickOnClickMeButton() {
        clickButtonsInElementsCard();
        getButtonsPage().clickClickMeButton();
        Assert.assertEquals(getButtonsPage().confirmationDynamicClickMessage(), "You have done a dynamic click");
    }
}
