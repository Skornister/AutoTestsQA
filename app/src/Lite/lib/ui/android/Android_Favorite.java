package Lite.lib.ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.ui.Favorite;

public class Android_Favorite extends Favorite {

    static {
        TEXT_НЕТ_КАНАЛОВ_В_ИЗБРАННОМ = "xpath://*[@text='В данный момент в избранном нет каналов. Для добавления каналов в избранное нажмите на выбранный канал и удерживайте.']";
        ИКОНКА_ЗВЕЗДЫ_НА_КАНАЛЕ = "id:limehd.ru.lite:id/imageStar";
        КАРТОЧКА_КАНАЛА = "limehd.ru.lite:id/channelName";
            КНОПКА_ЗВЕЗДЫ_UI_PLAYER = "";
            КНОПКА_НАЗАД = "";
        КНОПКА_ПОИСК = "id:limehd.ru.lite:id/search_view";
        ПОИСК_ПОЛЕ_ВВОДА = "xpath://*[contains(@text, 'Поиск по избранному')]";
        ПОИСК_УДАЛИТЬ_ЗАПРОС = "id:limehd.ru.lite:id/search_close_btn";
        ПОИСК_ВВОД_В_КАСТОМ_КЛАВИАТУРУ = "xpath://*[@resource-id='limehd.ru.lite:id/keyboard_view']//*[@text='{key}']";
        KEY_Й = "id:limehd.ru.lite:id/keyboard_view//*[@text='Й']";
        KEY_Ц = "id:limehd.ru.lite:id/keyboard_view//*[@text='Ц']";
        KEY_У = "id:limehd.ru.lite:id/keyboard_view//*[@text='У']";
        KEY_ПОИСК = "id:limehd.ru.lite:id/fifthLine//*[@index='2']";
    }

    public Android_Favorite(RemoteWebDriver driver) {
        super(driver);
    }
}