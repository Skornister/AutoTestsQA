package Lite.lib.ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.ui.SettingsScreen;

public class Android_SettingsScreen extends SettingsScreen {

    static {
        NEW = "id:someid";
    }

    public Android_SettingsScreen(RemoteWebDriver driver) {
        super(driver);
    }
}