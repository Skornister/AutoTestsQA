package Wiki.lib.ui.mobile_web;

import Wiki.lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'content-unstyled')]//h3[contains(text(), '{TITLE}')]"; /* [contains(text(), '***')] - поиск неточного текста в контейнере, *** - указываем текст через метод */
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'content-unstyled')]//h3[contains(text(), '{TITLE}')]/../../*[contains(@class,'unStar')]"; /* /../../ - поднялись вверх на 2 пункта */
    }

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}