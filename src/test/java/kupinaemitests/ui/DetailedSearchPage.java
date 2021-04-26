package kupinaemitests.ui;

import kupinaemitests.util.enums.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DetailedSearchPage {
    private PageAction action;









    public DetailedSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        action = new PageAction(driver);
    }

    public void gotoPage() {
        action.gotoPage(Pages.KUPINAEMI_DETAILED_SEARCH_PAGE.getPath());
    }


}
