package Lite.lib.ui.smart;

import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.ui.MainScreen;

public class Smart_MainScreen extends MainScreen {

    static {
        КНОПКА_ОК_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК = "xpath://button[contains(text(), 'ОК')]";
            ТЕКСТ_регион_не_определен_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК = "xpath://*[@text='Ваш регион не определен']";
            ТЕКСТ_подсказка_кнопки_Выбрать_регион = "id:limehd.ru.lite:id/text_view_hint_help";
            Выбор_Региона = "xpath://android.widget.ListView";
            ТЕКСТ_регион_Чувашия_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК = "xpath://android.widget.TextView[@text='Чувашская Респ.']";
            BACK_Выбрать_регион = "id:android:id/buttonPanel";
        КНОПКА_ПОИСК = "id:limehd.ru.lite:id/search_view";
        ИКОНКА_ИЗБРАННОЕ = "id:limehd.ru.lite:id/favouriteButton";
        ИКОНКА_ЗВЕЗДЫ_НА_КАНАЛЕ = "id:limehd.ru.lite:id/imageStar";
        КАРТОЧКА_КАНАЛА = "id:limehd.ru.lite:id/channelName";
        НАЗАД_СИСТЕМНАЯ_КНОПКА = "1";
    }

    public Smart_MainScreen(RemoteWebDriver driver) {
        super(driver);
    }
}