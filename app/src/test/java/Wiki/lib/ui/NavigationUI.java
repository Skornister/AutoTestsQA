package Wiki.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;
import Wiki.lib.Platform;

abstract public class NavigationUI extends MainPageObject {

    protected static String
            MY_LISTS_LINK,
            OPEN_NAVIGATION,
            BACK_BUTTON; /* EX 5 */

    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void open_Navigation() {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 5);
        } else {
            System.out.println("Метод open_Navigation() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists() /* кликать до ошибки или до заданного количество раз - для анимации появления елемента */ {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to my list",
                    5
            );
        } else { /* EX 5 */
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to my list " + MY_LISTS_LINK,
                    5
            ); /* EX 5 */
        }
    }
    /* EX 5 */
    public void clickBackButton() {
        this.waitForElementAndClick(BACK_BUTTON,"Cannot find BACK button", 5);
    } /* EX 5 */
}