package Lite.lib.ui.factories;
import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.Platform;
import Lite.lib.ui.Favorite;
import Lite.lib.ui.android.Android_Favorite;
import Lite.lib.ui.ios.iOS_Favorite;

public class Favorite_Factory {
    public static Favorite get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new Android_Favorite(driver);
        } else {
            return new iOS_Favorite(driver);
        }
    }
}