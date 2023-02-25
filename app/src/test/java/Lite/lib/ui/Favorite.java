package Lite.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class Favorite extends MainPageObject {

    protected static String
            TEXT_НЕТ_КАНАЛОВ_В_ИЗБРАННОМ,
            ИКОНКА_ЗВЕЗДЫ_НА_КАНАЛЕ,
            КАРТОЧКА_КАНАЛА,
                КНОПКА_ЗВЕЗДЫ_UI_PLAYER,
                КНОПКА_НАЗАД,
            КНОПКА_ПОИСК,
            ПОИСК_ПОЛЕ_ВВОДА,
            ПОИСК_УДАЛИТЬ_ЗАПРОС,
            ПОИСК_ВВОД_В_КАСТОМ_КЛАВИАТУРУ,
            KEY_Й,
            KEY_Ц,
            KEY_У,
            KEY_ПОИСК;

    public Favorite(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void Удалить_из_Избранного_playlist() /* не проверен */ {
        this.waitForAllElementsPresent(КАРТОЧКА_КАНАЛА, "Cannot find any channel in favorite", 5);
        this.waitForElementAndClick(КАРТОЧКА_КАНАЛА, "Cannot find and del channel from favorite", 5);
    }

    public void Удалить_из_Избранного_UIplayer() /* не проверен */ {
        this.waitForElementAndClick(КАРТОЧКА_КАНАЛА, "Cannot find any channel in favorite", 5);
        this.waitForElementAndClick(КНОПКА_ЗВЕЗДЫ_UI_PLAYER, "Cannot find and del channel from favorite", 5);
        this.waitForElementAndClick(КНОПКА_НАЗАД, "Cannot find and del channel from favorite", 5);
    }

    public void СОРТИРОВКА_Переместь_канал_на_место_другого() /* не проверен */ {

        this.waitForElementAndClick(КАРТОЧКА_КАНАЛА, "Cannot find any channel in favorite", 5);
        this.waitForElementAndClick(КНОПКА_ЗВЕЗДЫ_UI_PLAYER, "Cannot find and del channel from favorite", 5);
        this.waitForElementAndClick(КНОПКА_НАЗАД, "Cannot find and del channel from favorite", 5);
    }
}

/*
Удаление из Избранного
    В списке избранного
    Из UI плеера
Сортировка
    Сортируется
        Сортировка при активном поиске
    Сохраняется
Выбор канала
Вернуться в Избранное с канала
События appMetrica
    Избранные
*/