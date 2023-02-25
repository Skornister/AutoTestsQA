package Lite.lib.ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import Lite.lib.ui.ChannelScreen;

public class Android_ChannelScreen extends ChannelScreen {

    static {
        NEW = "id:someid";
    }

    public Android_ChannelScreen(RemoteWebDriver driver) {
        super(driver);
    }
}