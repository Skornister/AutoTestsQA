package Wiki.lib.ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import Wiki.lib.ui.ArticlePageObject;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#ca-watch";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:li.page-actions-menu__list-item>a.mw-ui-icon-wikimedia-unStar-progressive";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}