package Wiki.lib.ui.ios;

import Wiki.lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name, '{TITLE}'";
    }

    public iOSMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}