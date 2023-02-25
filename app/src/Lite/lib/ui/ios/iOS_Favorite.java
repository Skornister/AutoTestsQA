package Lite.lib.ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.ui.Favorite;

public class iOS_Favorite extends Favorite {

    static {
        TEXT_НЕТ_КАНАЛОВ_В_ИЗБРАННОМ = "";
        ИКОНКА_ЗВЕЗДЫ_НА_КАНАЛЕ = "";
        КАРТОЧКА_КАНАЛА = "";
        КНОПКА_ПОИСК = "";
        ПОИСК_ПОЛЕ_ВВОДА = "";
        ПОИСК_УДАЛИТЬ_ЗАПРОС = "";
        ПОИСК_ВВОД_В_КАСТОМ_КЛАВИАТУРУ = "";
        KEY_Й = "";
        KEY_Ц = "";
        KEY_У = "";
        KEY_ПОИСК = "";
    }

    public iOS_Favorite(RemoteWebDriver driver) {
        super(driver);
    }
}