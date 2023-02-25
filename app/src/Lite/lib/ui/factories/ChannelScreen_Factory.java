package Lite.lib.ui.factories;
import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.Platform;
import Lite.lib.ui.ChannelScreen;
import Lite.lib.ui.android.Android_ChannelScreen;
import Lite.lib.ui.ios.iOS_ChannelScreen;

public class ChannelScreen_Factory {
    public static ChannelScreen get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new Android_ChannelScreen(driver);
        } else {
            return new iOS_ChannelScreen(driver);
        }
    }
}