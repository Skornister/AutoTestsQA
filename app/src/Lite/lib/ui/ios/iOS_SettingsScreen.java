package Lite.lib.ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.ui.SettingsScreen;

public class iOS_SettingsScreen extends SettingsScreen {

    static {
        NEW = "id:someid";
    }

    public iOS_SettingsScreen(RemoteWebDriver driver) {
        super(driver);
    }
}