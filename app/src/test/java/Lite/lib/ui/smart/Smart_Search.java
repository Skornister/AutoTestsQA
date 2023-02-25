package Lite.lib.ui.smart;

import org.openqa.selenium.remote.RemoteWebDriver;
import Lite.lib.ui.Search;

public class Smart_Search extends Search {

    static {
        КНОПКА_ПОИСК = "id:limehd.ru.lite:id/search_view";
        ПОИСК_ПОЛЕ_ВВОДА = "xpath://*[contains(@text, 'Поиск по избранному')]";
        ПОИСК_УДАЛИТЬ_ЗАПРОС = "id:limehd.ru.lite:id/search_close_btn";
        ПОИСК_ВВОД_В_КАСТОМ_КЛАВИАТУРУ = "xpath://*[@resource-id='limehd.ru.lite:id/keyboard_view']//*[@text='{key}']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text', {SUBSTRING}')]']";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='Ничего не найдено']";
        KEY_Й = "id:limehd.ru.lite:id/keyboard_view//*[@text='Й']";
        KEY_Ц = "id:limehd.ru.lite:id/keyboard_view//*[@text='Ц']";
        KEY_У = "id:limehd.ru.lite:id/keyboard_view//*[@text='У']";
        KEY_ПОИСК = "id:limehd.ru.lite:id/fifthLine//*[@index='2']";
    }

    public Smart_Search(RemoteWebDriver driver) {
        super(driver);
    }
}