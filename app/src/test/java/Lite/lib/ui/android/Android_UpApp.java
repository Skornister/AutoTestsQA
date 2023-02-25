package Lite.lib.ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import Lite.lib.ui.UpApp;

public class Android_UpApp extends UpApp {

    static {
        Lite_appPath_2UP = "/home/maksim/AndroidStudioProjects/JavaAppiumAutomation/apks/399.apk";
    }

    public Android_UpApp(RemoteWebDriver driver) {
        super(driver);
    }
}