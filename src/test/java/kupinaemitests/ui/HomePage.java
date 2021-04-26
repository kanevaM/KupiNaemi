package kupinaemitests.ui;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import kupinaemitests.util.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    private PageAction action;

    @FindBy(css = "div.container.horizontal-center.row > div")
    private WebElement logoKupiNaemi;

    @FindBy(css = "nav.col-xs-12.col-md-8.col-md-pull-2.hidden-xs.menu-top > ul > li:nth-child(4) > a")
    private WebElement dobaviObiava;

    @FindBy(css = "nav.col-xs-12.col-md-8.col-md-pull-2.hidden-xs.menu-top > ul > li:nth-child(1) > a")
    private WebElement nachaloItem;

    @FindBy(css = "nav.col-xs-12.col-md-8.col-md-pull-2.hidden-xs.menu-top > ul > li:nth-child(2) > a")
    private WebElement menuVsichkiObiavi;

    @FindBy(css = ".sub-menu-wrapper > ul")
    private WebElement submenuItems;

    @FindBy(css = ".sub-menu-wrapper > ul > li:first-child > a")
    private WebElement kupiImotFromTheSubmenu;

    @FindBy(css = ".sub-menu-wrapper > ul > li:nth-child(2) > a")
    private WebElement naemiImotFromTheSubmenu;

    @FindBy(css = ".sub-menu-wrapper > ul > li:nth-child(3) > a")
    private WebElement nameriKupuvachFromTheSubmenu;

    @FindBy(css = ".sub-menu-wrapper > ul > li:nth-child(4) > a")
    private WebElement nameriNaematelFromTheSubmenu;

    @FindBy(css = "nav.col-xs-12.col-md-8.col-md-pull-2.hidden-xs.menu-top > ul > li:nth-child(5) > a")
    private WebElement specialniOfertiItem;

    @FindBy(css = "nav.col-xs-12.col-sm-6.col-md-2.col-md-push-8.hidden-xs.menu-login > ul > li:nth-child(1) > a")
    private WebElement registrationItem;

    @FindBy(css = "nav.col-xs-12.col-sm-6.col-md-2.col-md-push-8.hidden-xs.menu-login > ul > li:nth-child(2)")
    private WebElement vhodItem;

    @FindBy(css = ".search-wrapper > nav > a:nth-child(1)")
    private WebElement kupiItem;

    @FindBy(css = ".search-wrapper > nav > a:nth-child(2)")
    private WebElement naemiItem;

    @FindBy(css = ".search-wrapper > nav > a:nth-child(3)")
    private WebElement nameriKupuvachItem;

    @FindBy(css = ".search-wrapper > nav > a:nth-child(4)")
    private WebElement nameriNaematelItem;

    @FindBy(id = "search_button")
    private WebElement tyrsiItem;

    @FindBy(id = "advanced-search")
    private WebElement podrobnoTyrseneItem;

    @FindBy(css = ".correction-button-wrapper > a")
    private WebElement changeSearch;

    @FindBy(css = ".main-area h1")
    private WebElement mainTitle;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        action = new PageAction(driver);
    }

    public void clickOnTheLogo() {
        action.clickButton(logoKupiNaemi);
    }

    public void clickToDobaviObiava() {
        action.clickButton(dobaviObiava);
    }

    public void clickOnItemNachalo() {
        action.clickButton(nachaloItem);
    }

    public void firstHeadNachaloIsUnclickable() {
        action.isSelected(nachaloItem);
    }

    public void clickOnMenuVsichkiObiavi() {
        action.clickButton(menuVsichkiObiavi);
    }

    public void itemNachaloShouldBeClickable() {
        action.isEnabled(nachaloItem);
    }

    public void submenuItemsShouldAppearBelow() {
        action.isVisible(submenuItems);
        //driver.findElement(By.cssSelector("")).isDisplayed();
    }

    public void clickOnKupiImotFromTheSubmenu() {
        action.clickButton(kupiImotFromTheSubmenu);
    }

    public void clickOnNaemiImotFromTheSubmenu() {
        action.clickButton(naemiImotFromTheSubmenu);
    }

    public void clickOnNameriKupuvachFromTheSubmenu() {
        action.clickButton(nameriKupuvachFromTheSubmenu);
    }


    public void clickOnNameriNaematelFromTheSubmenu() {
        action.clickButton(nameriNaematelFromTheSubmenu);
    }

    public void clickToSpecialniOferti() {
        action.clickButton(specialniOfertiItem);
    }

    public void theItemKupiShouldBeSelected() {
        action.isSelected(kupiItem);
    }

    public void theItemKupiShouldBeDeselected() {
        action.isEnabled(kupiItem);
    }

    public void clickOnNaemiAndSelectTheItem() {
        action.clickButton(naemiItem);
    }

    public void clickOnKupiAndSelectTheItem() {
        action.clickButton(kupiItem);
    }

    public void clickOnNameriKupuvachAndSelectTheItem() {
        action.clickButton(nameriKupuvachItem);
    }

    public void clickOnNameriNaematelAndSelectTheItem() {
        action.clickButton(nameriNaematelItem);
    }

    public void clickOnPodrobnoTyrsene() {
        action.clickButton(podrobnoTyrseneItem);
    }

    public void clickOnTyrsi() {
        action.clickButton(tyrsiItem);
    }

    public void optionForChangingTheSearching() {
        action.isVisible(changeSearch);
    }

    public void clickOnRegistration() {
       action.clickButton(registrationItem);
    }

    public void clickOnLogin() {
       action.clickButton(vhodItem);
    }

    public String getTitleMessage() {
        return action.getText(mainTitle);
    }
}
