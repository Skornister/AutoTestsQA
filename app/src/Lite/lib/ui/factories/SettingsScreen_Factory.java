package Lite.lib.ui.factories;
import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.Platform;
import Lite.lib.ui.SettingsScreen;
import Lite.lib.ui.android.Android_SettingsScreen;
import Lite.lib.ui.ios.iOS_SettingsScreen;

public class SettingsScreen_Factory {
    public static SettingsScreen get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new Android_SettingsScreen(driver);
        } else {
            return new iOS_SettingsScreen(driver);
        }
    }
}