package Lite.tests;

import org.junit.Test;

import Lite.lib.CoreTestCase;
import Lite.lib.Platform;
import Lite.lib.ui.MainScreen;
import Lite.lib.ui.SideBar;
import Lite.lib.ui.factories.MainScreen_Factory;
import Lite.lib.ui.factories.SideBar_Factory;
import io.appium.java_client.AppiumDriver;

public class UpApp extends CoreTestCase {

    @Test
    public void test1_Обновлениие() {
        if (driver instanceof AppiumDriver) {
            MainScreen Lite_MainScreen = MainScreen_Factory.get(driver);
            Lite_MainScreen.set_SkipОкноВыборРегиона_ColdStart();
            SideBar Lite_SideMenu = SideBar_Factory.get(driver);
            Lite_SideMenu.open_logo_screen();
            Lite_SideMenu.wait_Сравнить_version_app("версия: 2.8.9 (399)");
            ((AppiumDriver)driver).installApp("/home/maksim/AndroidStudioProjects/JavaAppiumAutomation/apks/403.apk");
            ((AppiumDriver)driver).launchApp();
            Lite_MainScreen.waitForElementNotPresent("id:limehd.ru.lite:id/button_ok","2",5);
            Lite_SideMenu.open_logo_screen();
            Lite_SideMenu.wait_Сравнить_version_app("версия: 2.9.0 (403)");
        } else {
            System.out.println("Метод test1_Обновлениие() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }
}