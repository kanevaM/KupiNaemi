package kupinaemitests.ui;

import kupinaemitests.util.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private PageAction action;


    @FindBy(css = "div:nth-child(2) > input")
    private WebElement emailLoginField;

    @FindBy(css = "div:nth-child(3) > input")
    private WebElement passWordLoginField;

    @FindBy(css = "input.custom-button.success-button")
    private WebElement loginButtonVlez;

    @FindBy(css = ".g-recaptcha iframe")
    private WebElement iFrameLogin;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]")

    private WebElement iFrameLogin_checkbox;

    @FindBy(css = "div > h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"logoutForm\"]/ul/li[2]/a")
    private WebElement exitButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        action = new PageAction(driver);
    }

    public void gotoPage() {
        action.gotoPage(Pages.KUPINAEMI_LOGIN_PAGE.getPath());
    }

    public void enterEmail(String randomEmail) {
        action.typeText(emailLoginField, randomEmail);
    }

    public void enterPassWord(String password) {
        action.typeText(passWordLoginField, password);
    }

    public void checkNotRobot() {
        action.switchFrame(iFrameLogin);
        action.clickButton(iFrameLogin_checkbox);
        //iFrame_checkbox.click();
    }

    public void clickOnLoginButton() {
        action.clickButton(loginButtonVlez);
    }

    public void clickOnExitButton() {
        action.clickButton(exitButton);
    }

    public String getTitleMessage() {
        return action.getText(pageTitle);
    }

    public String getExitMessage() {
        return action.getText(exitButton);
    }
}

