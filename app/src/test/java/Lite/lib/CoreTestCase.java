package Lite.lib;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.time.Duration;
import io.appium.java_client.AppiumDriver;

public class CoreTestCase {
    protected RemoteWebDriver driver; /* Подключение драйвера Appium */

    @Before
    public void setUp() throws Exception /* Действия перед тестом */ {
        driver = Platform.getInstance().getDriver(); /* Выбрать driver по условиям из Platform */
        //this.rotateScreenPortrait(); /* Сменить ориентацию на вертикальную */
        //MainScreen MainScreen = MainScreen_Factory.get(driver);
        //MainScreen.set_SkipОкноВыборРегиона_ColdStart();
        //this.openWebPageFromMobileWeb("http://localhost:35335/ares_cli/ares.html");
    }

    @After
    public void tearDown() /* Действия после теста */ {
        if (Platform.getInstance().isSmart()) {
            return;
        } else {
            driver.quit(); /* Выход из приложения */
        }
    }
    protected void rotateScreenPortrait() /* Сменить ориентацию на вертикальную */ {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Метод rotateScreenPortrait() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }
    protected void rotateScreenLandscape() /* Сменить ориентацию на горизонтальную */ {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Метод rotateScreenLandscape() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void backgroundApp(int seconds) /* Свернуть приложение на n-сек */ {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(Duration.ofSeconds(seconds));
        } else {
            System.out.println("Метод backgroundApp() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }
    protected void openWebPageFromMobileWeb(String WebSite) {
        if ((Platform.getInstance().isMW()) || (Platform.getInstance().isSmart())) {
            driver.get(WebSite);
        } else {
            System.out.println("Метод openWebPageFromMobileWeb() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }
}