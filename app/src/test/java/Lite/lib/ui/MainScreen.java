package Lite.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MainScreen extends MainPageObject {

    protected static String
            КНОПКА_ОК_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК,
                ТЕКСТ_регион_не_определен_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК,
                ТЕКСТ_подсказка_кнопки_Выбрать_регион,
                Выбор_Региона,
                ТЕКСТ_регион_Чувашия_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК,
                BACK_Выбрать_регион,
            КНОПКА_ПОИСК,
            ИКОНКА_ИЗБРАННОЕ,
            ИКОНКА_ЗВЕЗДЫ_НА_КАНАЛЕ,
            КАРТОЧКА_КАНАЛА,
            НАЗАД_СИСТЕМНАЯ_КНОПКА;

    public MainScreen(RemoteWebDriver driver) {
        super(driver);
    }

    public void wait_ТекстВашРегионНеОпределен_ColdStart() {
        this.waitForElementPresent(
                ТЕКСТ_регион_не_определен_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК,
                "Кнопка выбора региона не найдена - Region selection button not found",
                5
        );
    }

    public void wait_ПодсказкаКакВыбратьРегион_ColdStart() {
        this.waitForElementPresent(
                ТЕКСТ_подсказка_кнопки_Выбрать_регион,
                "Подсказка не найдена как выбрать регион - Tooltip not found how to select the region",
                5
        );
    }

    public void клик_ВыборРегиона_ColdStart() {
        this.waitForElementAndClick(
                ТЕКСТ_подсказка_кнопки_Выбрать_регион,
                "Подсказка как выбрать регион не найдена и не нажимается - Tooltip on how to select the region is not found and is not clicked",
                5
        );
    }

    public void wait_ВыборРегиона() {
        this.waitForElementPresent(
                Выбор_Региона,
                "Не найдена кнопка выбора региона - Not find choose region button",
                5
        );
    }

    public void swipe_ВыборРегиона_ColdStart() {
        this.swipeUpToFindElement(
                ТЕКСТ_регион_Чувашия_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК,
                "Регион Чувашия не найден в окне ВыборРегиона",
                10
        );
    }

    public void клик_ВыбратьРегионЧувашия() {
        this.waitForElementAndClick(
                ТЕКСТ_регион_Чувашия_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК,
                "Регион Чувашия не найден и не нажимается в окне ВыборРегиона",
                5
        );
    }

    public void клик_ОтменаВыборРегиона() {
        this.waitForElementAndClick(
                НАЗАД_СИСТЕМНАЯ_КНОПКА,
                "Системная кнопка Назад Не найдена",
                5
        );
    }
    // Пожождать кнопку ОК в окне выбора региона в холодном старте
    public void wait_ОК_ОкноВыбораРегиона_ColdStart() {
        this.waitForElementAndClick(
                КНОПКА_ОК_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК,
                "Кнопка ОК не найдена - Cannot find OK",
                15
        );
    } // Пожождать кнопку ОК в окне выбора региона в холодном старте
    // Нажать ОК в окне выбора региона в холодном старте
    public void клик_ОК_ОкноВыбораРегиона_ColdStart() {
        this.waitForElementNotPresent(
                КНОПКА_ОК_ОКНО_ВЫБОРА_РЕГИОНА_1Й_ЗАПУСК,
                "Кнопка ОК все еще на экране - Ok still present",
                5
        );
    } // Нажать ОК в окне выбора региона в холодном старте
    // Набор - Пропустить окно выбора региона при холодном старте
    public void set_SkipОкноВыборРегиона_ColdStart() {
        wait_ТекстВашРегионНеОпределен_ColdStart();
        wait_ПодсказкаКакВыбратьРегион_ColdStart();
        wait_ОК_ОкноВыбораРегиона_ColdStart();
        клик_ОК_ОкноВыбораРегиона_ColdStart();
    } // Набор - Пропустить окно выбора региона при холодном старте
}

/*
Сплешскрин
ВПН
Выбор региона при 1м запуске
Плейлист
    ру/загран/не загрузился
    на каналах название, епг, прогресс-бар
Выбор канала
Добавить в Избранное
Удалить из Избранного
Переход в Избранное
Поиск
Банерная реклама в списке каналов
*/