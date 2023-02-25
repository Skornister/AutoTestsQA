package Lite.lib.ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import Lite.lib.ui.Search;

public class iOS_Search extends Search {

    static {
        КНОПКА_ПОИСК = "";
        ПОИСК_ПОЛЕ_ВВОДА = "";
        ПОИСК_УДАЛИТЬ_ЗАПРОС = "";
        ПОИСК_ВВОД_В_КАСТОМ_КЛАВИАТУРУ = "";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "";
        SEARCH_RESULT_ELEMENT = "";
        SEARCH_EMPTY_RESULT_ELEMENT = "";
        KEY_Й = "";
        KEY_Ц = "";
        KEY_У = "";
        KEY_ПОИСК = "";
    }


    public iOS_Search(RemoteWebDriver driver) {
        super(driver);
    }
}