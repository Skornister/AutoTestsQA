package Lite.lib.ui.factories;
import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.Platform;
import Lite.lib.ui.SideBar;
import Lite.lib.ui.android.Android_SideBar;
import Lite.lib.ui.ios.iOS_SideBar;

public class SideBar_Factory {
    public static SideBar get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new Android_SideBar(driver);
        } else {
            return new iOS_SideBar(driver);
        }
    }
}