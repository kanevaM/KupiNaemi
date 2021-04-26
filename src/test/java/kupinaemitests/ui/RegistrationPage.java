package kupinaemitests.ui;

import kupinaemitests.util.enums.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    private PageAction action;

    @FindBy(css = "div:nth-child(1) > input")
    private WebElement firstNameRegistrationField;

    @FindBy(css = "div:nth-child(2) > input")
    private WebElement middleNameRegistrationField;

    @FindBy(css = "div:nth-child(3) > input")
    private WebElement surNameRegistrationField;

    @FindBy(css = "div:nth-child(4) > input")
    private WebElement emailRegistrationField;

    @FindBy(css = "div:nth-child(5) > input")
    private WebElement phoneNumberRegistrationField;

    @FindBy(css = "div:nth-child(6) > input")
    private WebElement otherNumberRegistrationField;

    @FindBy(css = "div:nth-child(7) > input")
    private WebElement passwordRegistrationField;

    @FindBy(css = "div:nth-child(8) > input")
    private WebElement confirmPasswordRegistrationField;

    @FindBy(css = "div:nth-child(9) > label")
    private WebElement agreeWithTermsAndConditionsRegistrationCheckBox;

    @FindBy(xpath = "//*[@id=\"registration-form\"]/div/div[10]/div/div/div/iframe")
    private WebElement iFrameRegistration;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]")
    private WebElement iFrameRegistration_checkbox;

    @FindBy(xpath = "//*[@id=\"registration-form\"]/div/input")
    private WebElement sendDataRegistrationButton;

    @FindBy(css = "div > h1")
    private WebElement confirmationMessage;


    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        action = new PageAction(driver);
    }

    public void gotoPage() {
        action.gotoPage(Pages.KUPINAEMI_REGISTRATION_PAGE.getPath());
    }

    public void enterFirstName(String firstName) {
        action.typeText(firstNameRegistrationField, firstName);
    }

    public void enterMiddleName(String middleName) {
        action.typeText(middleNameRegistrationField, middleName);
    }

    public void enterSurName(String surName) {
        action.typeText(surNameRegistrationField, surName);
    }

    public void enterEmail(String randomEmail) {
        action.typeText(emailRegistrationField, randomEmail);
    }

    public void enterPhoneNumber(String phoneNumber) {
        action.typeText(phoneNumberRegistrationField, phoneNumber);
    }

    public void enterOtherNumber(String otherNumber) {
        action.typeText(otherNumberRegistrationField, otherNumber);
    }

    public void enterPassword(String password) {
        action.typeText(passwordRegistrationField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        action.typeText(confirmPasswordRegistrationField, confirmPassword);
    }

    public void agreeWithTermsAndConditions() {
        action.clickButton(agreeWithTermsAndConditionsRegistrationCheckBox);
        // Actions checker = new Actions(driver);
        //  checker.click(agreeWithTermsAndConditionsRegistrationCheckBox).perform();
    }

    public void checkNotRobot() {
        action.switchFrame(iFrameRegistration);
        action.clickButton(iFrameRegistration_checkbox);
        //iFrame_checkbox.click();
    }

    public void sendDataButton() {
        action.clickButton(sendDataRegistrationButton);
    }

    public String getConfirmationMessage() {
        return action.getText(confirmationMessage);
    }

}
