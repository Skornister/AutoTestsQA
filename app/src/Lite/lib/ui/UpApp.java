package Lite.lib.ui;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class UpApp extends MainPageObject {

    protected static String
            Lite_appPath_2UP;

    public UpApp(RemoteWebDriver driver)
    {
        super(driver);
    }
}