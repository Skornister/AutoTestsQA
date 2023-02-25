package Wiki.lib.ui.factories;

import Wiki.lib.Platform;
import Wiki.lib.ui.SearchPageObject;
import Wiki.lib.ui.mobile_web.MWSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import Wiki.lib.ui.android.AndroidSearchPageObject;
import Wiki.lib.ui.ios.iOSSearchPageObject;

public class SearchPageObjectFactory {
    public static SearchPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSearchPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new iOSSearchPageObject(driver);
        } else {
            return new MWSearchPageObject(driver);
        }
    }
}