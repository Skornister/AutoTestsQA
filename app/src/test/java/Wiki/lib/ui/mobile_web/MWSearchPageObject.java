package Wiki.lib.ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import Wiki.lib.ui.SearchPageObject;

public class MWSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT_mobile = "css:button#searchIcon";
        SEARCH_INIT_ELEMENT_full = "css:input.search";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:div.header-action>button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://a[@data-title='Java']/div[contains(@class, 'wikidata-description')][text()='{SUBSTRING}']";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}