package pages.elementspages;

import pages.commonpages.BasePage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Data
public class WebTablesPage extends BasePage {

    private By addNewRecordButton = By.id("addNewRecordButton");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailFiled = By.id("userEmail");
    private By ageField = By.id("age");
    private By salaryField = By.id("salary");
    private By departmentField = By.id("department");
    private By submitButton = By.id("submit");
    private By tableRow = By.xpath("//*[@class='rt-tbody']/div[4]/div");
    private By deleteButton = By.xpath("//*[@id=\"delete-record-3\"]");
    private By editRecordButton = By.id("edit-record-1");
    private By fullNameInTable = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[1]");


    public WebTablesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAddNewRecordButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver().findElement(addNewRecordButton);
    }

    public void clickAddNewRecordButton() {
        getAddNewRecordButton().click();
    }

    public WebElement getFirstNameField() {
        return getDriver().findElement(firstNameField);
    }

    public WebElement getLastNameField() {
        return getDriver().findElement(lastNameField);
    }

    public WebElement getEmailFiled() {
        return getDriver().findElement(emailFiled);
    }

    public WebElement getAgeField() {
        return getDriver().findElement(ageField);
    }

    public WebElement getSalaryField() {
        return getDriver().findElement(salaryField);
    }

    public WebElement getDepartmentField() {
        return getDriver().findElement(departmentField);
    }

    public WebElement getTableRow() {
        return getDriver().findElement(tableRow);
    }

    public WebElement getSubmitButton() {
        return getDriver().findElement(submitButton);
    }

    public void clickSubmitButton() {
        getSubmitButton().click();
    }

    /**
     * Input new record in table
     */
    public void inputAddNewRecordForm(String firstname, String lastname, String email, String age, String salary, String department) {
        getFirstNameField().sendKeys(firstname);
        getLastNameField().sendKeys(lastname);
        getEmailFiled().sendKeys(email);
        getAgeField().sendKeys(age);
        getSalaryField().sendKeys(salary);
        getDepartmentField().sendKeys(department);
    }

    /**
     * Take the text from the output message and compare it with the expected results
     */
    public boolean checkIfNewRecordIsPartOfTheTable(String firstName, String lastName, String email, String age, String salary, String department) {
        List<WebElement> newRow = getTableRow().findElements(By.tagName("div"));
        String firstNameData = newRow.get(0).getText();
        String lastNameData = newRow.get(1).getText();
        String ageData = newRow.get(2).getText();
        String emailData = newRow.get(3).getText();
        String salaryData = newRow.get(4).getText();
        String departmentData = newRow.get(5).getText();
        if (firstNameData.equals(firstName) && lastNameData.equals(lastName) && ageData.equals(age)
                && emailData.equals(email) && salaryData.equals(salary) && departmentData.equals(department)) {
            return true;
        }
        return false;
    }


    public String confirmationFullNameInTable() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver().findElement(fullNameInTable).getText();
    }

    public WebElement getDeleteButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver().findElement(deleteButton);
    }

    public void clickDeleteButton() {
        getDeleteButton().click();
    }

    /**
     * Check if row is empty after click on delete button
     */
    public boolean checkIfRowIsEmpty() {
        List<WebElement> newRow = getTableRow().findElements(By.tagName("div"));
        String firstNameData = newRow.get(0).getText();
        String lastNameData = newRow.get(1).getText();
        String ageData = newRow.get(2).getText();
        String emailData = newRow.get(3).getText();
        String salaryData = newRow.get(4).getText();
        String departmentData = newRow.get(5).getText();
        if (firstNameData.isBlank() && lastNameData.isBlank() && ageData.isBlank()
                && emailData.isBlank() && salaryData.isBlank() && departmentData.isBlank()) {
            return true;
        }
        return false;
    }

    public WebElement getEditRecordButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver().findElement(editRecordButton);
    }

    public void clickEditRecordButton() {
        getEditRecordButton().click();
    }

    /**
     * Edit first name for the first record in the table
     */
    public void editRecordFirstName(String firstname) {
        clearField(this.firstNameField);
        getFirstNameField().sendKeys(firstname);
    }
}