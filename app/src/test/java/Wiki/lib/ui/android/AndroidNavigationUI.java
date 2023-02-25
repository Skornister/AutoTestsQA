package Wiki.lib.ui.android;

import Wiki.lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI {
    static {
        MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='Мои списки']";
        BACK_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/search_toolbar']//*[@class='android.widget.ImageButton']"; /* EX 5 */
    }

    public AndroidNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}