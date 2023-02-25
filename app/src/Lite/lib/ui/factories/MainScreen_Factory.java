package Lite.lib.ui.factories;
import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.Platform;
import Lite.lib.ui.MainScreen;
import Lite.lib.ui.android.Android_MainScreen;
import Lite.lib.ui.ios.iOS_MainScreen;

public class MainScreen_Factory {
    public static MainScreen get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new Android_MainScreen(driver);
        } else {
            return new iOS_MainScreen(driver);
        }
    }
}