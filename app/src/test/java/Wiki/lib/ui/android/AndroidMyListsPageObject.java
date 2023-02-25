package Wiki.lib.ui.android;

import Wiki.lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject {
    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
        REMOVE_FROM_SAVED_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{TITLE}']"; /* EX 5 */
        NAME_TITLE_ARTICLE = "xpath://android.widget.TextView[@text='{TITLE}']"; /* EX 5 */
    }

    public AndroidMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}