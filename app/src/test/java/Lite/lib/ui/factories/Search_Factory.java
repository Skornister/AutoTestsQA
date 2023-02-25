package Lite.lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import Lite.lib.Platform;
import Lite.lib.ui.Search;
import Lite.lib.ui.android.Android_Search;
import Lite.lib.ui.ios.iOS_Search;

public class Search_Factory {
    public static Search get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new Android_Search(driver);
        } else {
            return new iOS_Search(driver);
        }
    }
}