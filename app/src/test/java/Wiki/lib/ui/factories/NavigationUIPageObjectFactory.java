package Wiki.lib.ui.factories;

import Wiki.lib.Platform;
import Wiki.lib.ui.NavigationUI;
import Wiki.lib.ui.android.AndroidNavigationUI;
import Wiki.lib.ui.ios.iOSNavigationUI;
import Wiki.lib.ui.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIPageObjectFactory {
    public static NavigationUI get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUI(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new iOSNavigationUI(driver);
        } else {
            return new MWNavigationUI(driver);
        }
    }
}