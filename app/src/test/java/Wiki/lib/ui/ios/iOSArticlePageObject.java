package Wiki.lib.ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import Wiki.lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:Java";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
    }

    public iOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}