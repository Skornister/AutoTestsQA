package Lite.lib.ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import Lite.lib.ui.UpApp;

public class iOS_UpApp extends UpApp {

    static {
        Lite_appPath_2UP = "id:someid";
    }

    public iOS_UpApp(RemoteWebDriver driver) {
        super(driver);
    }
}