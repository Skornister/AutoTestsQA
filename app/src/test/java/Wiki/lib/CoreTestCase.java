package Wiki.lib;

import Wiki.lib.ui.WelcomePageObject;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.time.Duration;
import io.appium.java_client.AppiumDriver;

public class CoreTestCase {

    protected RemoteWebDriver driver; //Подключение драйвера Appium

    @Before
    public void setUp() throws Exception {
        System.out.println("Start test");
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait(); /* EX 7 */
        //this.skipWelcomePageForIOSApp();
        if (Platform.getInstance().isMW()) {
            this.openWebPageFromMobileWeb("https://ru.m.wikipedia.org/");}

    }
    @After
    public void tearDown()/* Действия после теста */ {
        //driver.close(); /* Закрыть приложение */
        driver.quit(); /* Выход из приложения */ /* дома выдает ошибку почему-то, поэтому использовал close */
        System.out.println("Finish test");
    }

    /* EX 7 */
    protected void rotateScreenPortrait() /* Сменить ориентацию на вертикальную */ {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("===== Метод rotateScreenPortrait() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }/* EX 7 */

    protected void rotateScreenLandscape() /* Сменить ориентацию на горизонтальную */ {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("===== Метод rotateScreenLandscape() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }
    protected void backgroundApp(int seconds) /* Свернуть приложение на n-сек */ {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(Duration.ofSeconds(seconds));
        } else {
            System.out.println("===== Метод backgroundApp() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void openWebPageFromMobileWeb(String WebSite) {
        if (Platform.getInstance().isMW()) {
            driver.get(WebSite);
        } else {
            System.out.println("===== Метод openWebPageFromMobileWeb() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }

    private void skipWelcomePageForIOSApp() {
        if (driver instanceof AppiumDriver) {
            if(Platform.getInstance().isIOS()) {
                WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
                WelcomePageObject.clickSkip();
            }
        } else {
            System.out.println("===== Метод skipWelcomePageForIOSApp() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }
}