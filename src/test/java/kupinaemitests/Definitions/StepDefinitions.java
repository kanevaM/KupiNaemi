package kupinaemitests.Definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import kupinaemitests.ui.HomePage;
import kupinaemitests.ui.LoginPage;
import kupinaemitests.ui.RegistrationPage;
import kupinaemitests.util.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


import java.io.File;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;


public class StepDefinitions {
    private static final Logger LOGGER = LoggerFactory.getLogger(StepDefinitions.class);
    private WebDriver driver;

    //Page objects
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private HomePage homePage;


    private void startBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            configureBrowser(browser);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            configureBrowser(browser);
        } else {
            throw new RuntimeException("Not supported browser");
        }

    }

    private void configureBrowser(String browser) {
        LOGGER.info("==================== TEST START ====================");
        LOGGER.info("Starting browser:" + browser);
        driver.manage().deleteAllCookies(); //delete cookies
        driver.manage().window().maximize(); //To maximize browser
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);   //Implicit wait
    }

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        startBrowser("chrome");
        // startBrowser("firefox");
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot screenshotTakingDriver = (TakesScreenshot) driver;
                try {
                    File localScreenshots = new File(new File("target"), "screenshots");
                    if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
                        localScreenshots.mkdirs();
                    }
                    String fileName = scenario.getName().replace(" ", "_") + "_" + LocalTime.now().getMinute() + ".png";
                    File screenshot = new File(localScreenshots, fileName);
                    FileUtils.copyFile(screenshotTakingDriver.getScreenshotAs(OutputType.FILE), screenshot);
                    LOGGER.info("Screenshot saved with name:" + fileName);
                } catch (Exception e1) {
                    LOGGER.error("Unable to take screenshot", e1);
                }
            } else {
                LOGGER.info("Driver '{}' can't take screenshots so skipping it.", driver.getClass());
            }
        }
        driver.quit(); //close browser instance
    }

    @Given("kupinaemi page")
    public void kupiNaemiPage() {
        driver.get("https://kupinaemi.bg");
    }

    @Given("user is at the Login page")
    public void userIsAtTheLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.gotoPage();
    }

    @Given("user is at the Registration page")
    public void userIsAtTheRegistrationPage() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.gotoPage();
    }

    @Given("kupinaemi home page")
    public void kupinaemiHomePage() {
        homePage = new HomePage(driver);
    }

    @When("I click on the logo")
    public void clickOnTheLogo() {
        homePage.clickOnTheLogo();
    }

    @Then("the page should be open at the main page with {string} message")
    public void thePageShouldBeOpenAtTheMainTabWithMessage(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(homePage.getTitleMessage().contains(expectedFundTransferSuccessMessage));
        // Assert.assertEquals(driver.findElement(By.cssSelector("div.titles > h1 > span")).getText(), expectedFundTransferSuccessMessage, "WRONG PAGE");
    }

    @When("the first head nachalo is unclickable")
    public void theFirstHeadNachaloIsUnclickable() {
        homePage.firstHeadNachaloIsUnclickable();
    }

    @And("I click to dobavi obiava")
    public void clickToDobaviObiava() {
        homePage.clickToDobaviObiava();
    }

    @Then("item nachalo should be clickable")
    public void itemNachaloShouldBeClickable() {
        homePage.itemNachaloShouldBeClickable();
    }

    @And("I click on item nachalo")
    public void clickOnItemNachalo() {
        homePage.clickOnItemNachalo();
    }

    @When("I click on menu vsichki obiavi")
    public void clickOnMenuVsichkiObiavi() {
        homePage.clickOnMenuVsichkiObiavi();
    }

    @Then("Submenu items should appear below")
    public void submenuItemsShouldAppearBelow() {
        homePage.submenuItemsShouldAppearBelow();
    }

    @When("I click on Kupi imot from the submenu")
    public void clickOnKupiImotFromTheSubmenu() {
        homePage.clickOnKupiImotFromTheSubmenu();
    }

    @Then("is loaded page with properties for sale with {string} message")
    public void isLoadedPageWithPropertiesForSale(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(homePage.getTitleMessage().contains(expectedFundTransferSuccessMessage));
    }

    @When("I click on naemi imot from the submenu")
    public void clickOnNaemiImotFromTheSubmenu() {
        homePage.clickOnNaemiImotFromTheSubmenu();
    }

    @Then("is loaded page with properties for rent with {string} message")
    public void isLoadedPageWithPropertiesForRent(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(homePage.getTitleMessage().contains(expectedFundTransferSuccessMessage));
    }

    @When("I click on nameri kupuvach from the submenu")
    public void clickOnNameriKupuvachFromTheSubmenu() {
        homePage.clickOnNameriKupuvachFromTheSubmenu();
    }

    @Then("is loaded page with buyers with {string} message")
    public void isLoadedPageWithBuyers(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(homePage.getTitleMessage().contains(expectedFundTransferSuccessMessage));
    }

    @When("I click on nameri naematel from the submenu")
    public void clickOnNameriNaematelFromTheSubmenu() {
        homePage.clickOnNameriNaematelFromTheSubmenu();
    }

    @Then("is loaded page with tenants profiles with {string} message")
    public void isLoadedPageWithTenantsProfilesWithMessage(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(homePage.getTitleMessage().contains(expectedFundTransferSuccessMessage));
    }


    @Then("is loaded page with options to add obiava with {string} message")
    public void isLoadedPageWithOptionsToAddObiavaWithMessage(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(homePage.getTitleMessage().contains(expectedFundTransferSuccessMessage));
    }

    @When("I click to specialni oferti")
    public void clickToSpecialniOferti() {
        homePage.clickToSpecialniOferti();
    }

    @Then("is loaded page with special offers with {string} message")
    public void isLoadedPageWithSpecialOffersWithMessage(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(homePage.getTitleMessage().contains(expectedFundTransferSuccessMessage));
    }

    @And("the item kupi should be selected by default")
    public void theItemKupiShouldBeSelectedByDefault() {
        homePage.theItemKupiShouldBeSelected();
    }

    @When("I click on naemi and select the item")
    public void clickOnNaemiAndSelectTheItem() {
        homePage.clickOnNaemiAndSelectTheItem();
    }

    @Then("the item kupi should be deselected")
    public void theItemKupiShouldBeDeselected() {
        homePage.theItemKupiShouldBeDeselected();
    }

    @When("I click on kupi and select the item")
    public void clickOnKupiAndSelectTheItem() {
        homePage.clickOnKupiAndSelectTheItem();
    }

    @And("I click on tyrsi")
    public void clickOnTyrsi() {
        homePage.clickOnTyrsi();
    }

    @And("an option for changing the searching")
    public void optionForChangingTheSearching() {
        homePage.optionForChangingTheSearching();
    }

    @When("I click on nameri kupuvach and select the item")
    public void clickOnNameriKupuvachAndSelectTheItem() {
        homePage.clickOnNameriKupuvachAndSelectTheItem();
    }

    @When("I click on nameri naematel and select the item")
    public void clickOnNameriNaematelAndSelectTheItem() {
        homePage.clickOnNameriNaematelAndSelectTheItem();
    }

    @And("I click on podrobno tyrsene")
    public void clickOnPodrobnoTyrsene() {
        homePage.clickOnPodrobnoTyrsene();
    }

    @Then("is loaded page with detail search and title {string}")
    public void isLoadedPageWithDetailSearchAndTitle(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(homePage.getTitleMessage().contains(expectedFundTransferSuccessMessage));
    }

    @When("I click on registration")
    public void clickOnRegistration() {
        homePage.clickOnRegistration();
    }

    @And("page {string} is loaded")
    public void pageIsLoaded(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(registrationPage.getConfirmationMessage().contains(expectedFundTransferSuccessMessage));
    }

    @And("I enter firstname \"([^\"]*)\"")
    public void iEnterFirstname(String firstName) {
        registrationPage.enterFirstName(firstName);
    }

    @And("I enter middleName \"([^\"]*)\"")
    public void enterMiddleName(String middleName) {
        registrationPage.enterMiddleName(middleName);
    }

    @And("I enter surName \"([^\"]*)\"")
    public void enterSurName(String surName) {
        registrationPage.enterSurName(surName);
    }

    @And("I enter email \"([^\"]*)\"")
    public void enterEmail(String randomEmail) {
        registrationPage.enterEmail(randomEmail = RandomStringUtils.randomAlphanumeric(10) + "@email.com");
    }

    @And("I enter phoneNumber \"([^\"]*)\"")
    public void enterPhoneNumber(String phoneNumber) {
        registrationPage.enterPhoneNumber(phoneNumber);
    }

    @And("I enter otherNumber \"([^\"]*)\"")
    public void enterOtherNumber(String otherNumber) {
        registrationPage.enterOtherNumber(otherNumber);
    }

    @And("I enter password \"([^\"]*)\"")
    public void enterPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @And("I enter confirmPassword \"([^\"]*)\"")
    public void enterConfirmPassword(String confirmPassword) {
        registrationPage.enterConfirmPassword(confirmPassword);
    }


    @And("agree with terms and conditions")
    public void agreeWithTermsAndConditions() {
        registrationPage.agreeWithTermsAndConditions();
//        WebElement agreeCheckBox = driver.findElement(By.cssSelector("div:nth-child(9) > label"));
//        Actions checker = new Actions(driver);
//        checker.click(agreeCheckBox).perform();
        // assertTrue(agreeCheckBox.isSelected());
    }

    @And("check not robot")
    public void checkNotRobot() {
        registrationPage.checkNotRobot();
    }

    @And("I click to send data")
    public void clickToSendData() {
        registrationPage.sendDataButton();
    }

    @Then("confirmation message is loaded {string}")
    public void confirmationMessageIsLoaded(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(registrationPage.getConfirmationMessage().contains(expectedFundTransferSuccessMessage));
    }

    @When("I click on login button")
    public void clickOnLogin() {
        homePage.clickOnLogin();
    }

    @And("login page with title {string} is loaded")
    public void loginPageWithTitleIsLoaded(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(loginPage.getTitleMessage().contains(expectedFundTransferSuccessMessage));
    }

    @And("I enter emailAddress \"([^\"]*)\"")
    public void enterEmailAddress(String randomEmail) {
        loginPage.enterEmail(randomEmail = RandomStringUtils.randomAlphanumeric(10) + "@email.com");
    }

    @And("I enter passWord {string}")
    public void enterPassWord(String password) {
        loginPage.enterPassWord(password);
    }

    @And("check not robot for login page")
    public void checkNotRobotForLoginPage() {
        loginPage.checkNotRobot();
    }

    @And("I click on {string} button")
    public void clickOnButton(String log) {
        loginPage.clickOnLoginButton();
    }

    @Then("page with {string} button is loaded")
    public void pageWithExitButtonIsLoaded(String expectedFundTransferSuccessMessage) {
        Assert.assertTrue(loginPage.getExitMessage().contains(expectedFundTransferSuccessMessage));
    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        loginPage = new LoginPage(driver);
        loginPage.gotoPage();
        loginPage.enterEmail(Constants.USERNAME);
        loginPage.enterPassWord(Constants.PASSWORD);
        loginPage.checkNotRobot();
        loginPage.clickOnLoginButton();
    }

    @When("I click on exit button {string}")
    public void clickOnExitButton(String log) {
        loginPage.clickOnExitButton();
    }

}