package Wiki.lib.ui.factories;

import Wiki.lib.Platform;
import Wiki.lib.ui.mobile_web.MWArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import Wiki.lib.ui.ArticlePageObject;
import Wiki.lib.ui.android.AndroidArticlePageObject;
import Wiki.lib.ui.ios.iOSArticlePageObject;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidArticlePageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new iOSArticlePageObject(driver);
        } else {
            return new MWArticlePageObject(driver);
        }
    }
}