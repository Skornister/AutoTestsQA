package Wiki.lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import Wiki.lib.Platform;
import Wiki.lib.ui.MyListsPageObject;
import Wiki.lib.ui.android.AndroidMyListsPageObject;
import Wiki.lib.ui.ios.iOSMyListsPageObject;
import Wiki.lib.ui.mobile_web.MWMyListsPageObject;

public class MyListsPageObjectFactory {
    public static MyListsPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new iOSMyListsPageObject(driver);
        } else {
            return new MWMyListsPageObject(driver);
        }
    }
}