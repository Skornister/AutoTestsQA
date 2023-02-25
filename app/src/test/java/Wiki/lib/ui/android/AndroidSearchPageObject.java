package Wiki.lib.ui.android;

import Wiki.lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT_mobile = "xpath://*[contains(@text, 'Поиск по Википедии')]";
        SEARCH_INPUT = "xpath://*[contains(@text, 'Поиск')]";
        SEARCH_INPUT2 = "xpath://*[contains(@text, 'Поиск по Википедии')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text, '{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='Ничего не найдено']";
        SEARCH_SAVE_ARTICLE_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{NAME_ARTICLE}']"; /* EX 5 */
        SEARCH_RESULT_TITLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']";  /* EX 4 */
        SEARCH_RESULT_TITLE_TPL = "xpath://*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text='{TITLE}']"; /* EX 9 */
        SEARCH_RESULT_DESCRIPTION_TPL = "xpath://*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[contains(@text, '{DESCRIPTION}')]"; /* EX 9 */
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}