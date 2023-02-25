package Lite.lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import Lite.lib.Platform;
import Lite.lib.ui.UpApp;
import Lite.lib.ui.android.Android_UpApp;
import Lite.lib.ui.ios.iOS_UpApp;

public class UpApp_Factory {
    public static UpApp get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new Android_UpApp(driver);
        } else {
            return new iOS_UpApp(driver);
        }
    }
}