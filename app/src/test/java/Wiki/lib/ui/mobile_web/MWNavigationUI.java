package Wiki.lib.ui.mobile_web;

import Wiki.lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    static {
            MY_LISTS_LINK = "css:a.menu__item--watchlist";
            OPEN_NAVIGATION = "css:#mw-mf-main-menu-button"; /* # (решетка) - поиск id  */
    }

    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}