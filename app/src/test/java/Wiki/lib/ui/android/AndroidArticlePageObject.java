package Wiki.lib.ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import Wiki.lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        NAME_TITLE_ARTICLE = "xpath://android.widget.TextView[@text='{NAME_ARTICLE}']"; /* EX 5 */
        FOOTER_ELEMENT = "xpath://*[@text='Просмотр страницы в браузере']";
        ADD_ARTICLE_TO_MY_LIST_FROM_OPTION = "xpath://android.widget.TextView[@text='Добавить в список для чтения']"; /* EX 5 */
        NAME_FOLDER_IN_LIST_FOLDERS = "xpath://android.widget.TextView[@text='{NAME_FOLDER}']"; /* EX 5 */
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='Ещё']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Добавить в список для чтения']";
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        MY_LIST_OK_BUTTON = "xpath://*[@text='ОК']";
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Перейти вверх']";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}