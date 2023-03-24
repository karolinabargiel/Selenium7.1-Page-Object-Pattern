package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInput;

    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;

    @FindBy(css = "#inputAge3")
    private WebElement ageInput;

    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> genders;

    @FindBy(css = "[name*='gridRadiosExperience']")
    private List<WebElement> yearOfExperience;

    @FindBy(css = "#gridCheckAutomationTester")
    private WebElement professionAutomationTester;

    @FindBy(css = "#selectContinents > :not(:first-child)")
    private List<WebElement> continents;

    @FindBy(css = "option[value='switch-commands']")
    private WebElement switchCommand;

    @FindBy(css = "#validator-message")
    private WebElement validationMsg;

    @FindBy(css = "button[type='submit']")
    private WebElement sendFormBtn;

    @FindBy(css = "#chooseFile")
    private WebElement fileInput;

    public FormPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public FormPage setAge(int age) {
        ageInput.sendKeys(String.valueOf(age));
        return this;
    }

    public FormPage selectMale() {
        genders.get(0).click();
        return this;
    }

    public FormPage selectFemale() {
        genders.get(1).click();
        return this;
    }

    public FormPage selectRandomGender() {
        getRandomElement(genders).click();
        return this;
    }

    public FormPage selectRandomYearOfExperience() {
        getRandomElement(yearOfExperience).click();
        return this;
    }

    public FormPage selectProfessionAutTester() {
        professionAutomationTester.click();
        return this;
    }

    public FormPage selectRandomContinent() {
        getRandomElement(continents).click();
        return this;
    }

    public FormPage selectSwitchCommand() {
        switchCommand.click();
        return this;
    }

    public FormPage sendForm() {
        sendFormBtn.click();
        return this;
    }

    public String getValidationMsg() {
        return validationMsg.getText();
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

    public FormPage uploadFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }
}
