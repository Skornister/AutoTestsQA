package Lite.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SideBar extends MainPageObject {

    protected static String
        ЛОГО_БОКОВОЕ_МЕНЮ,
            ЛОГО_ОКНО_ЛОГО,
            НАЗВАНИЕ_ПРИЛОЖЕНИЯ_ОКНО_ЛОГО,
            ПОЛЕ_ВВОДА_ПАРОЛЯ_DEV_MODE,
            ОК_DEV_MODE,
            TOAST_ON_DEV_MODE,
            ВЫКЛ_DEV_MODE,
            ВЕРСИЯ_ПРИЛОЖЕНИЯ_ОКНО_ЛОГО_0,
            ВЕРСИЯ_ПРИЛОЖЕНИЯ_ОКНО_ЛОГО_1,
            TEXT_EMAIL_ОКНО_ЛОГО,
            ОК_ОКНО_ЛОГО,
            TEXT_ПОЛИТИКА_ПД_ОКНО_ЛОГО,
            TEXT_В_ПОЛИТИКЕ_ПД_ОКНО_ЛОГО,
            BACK_WEB_VIEW,
            TEXT_ПОЛЬЗ_СОГЛ_ОКНО_ЛОГО,
            TEXT_В_ПОЛЬЗ_СОГЛ_ОКНО_ЛОГО,
        ОЦЕНИТЬ_ПРИЛОЖЕНИЕ_БОКОВОЕ_МЕНЮ,
        ПОДЕЛИТЬСЯ_БОКОВОЕ_МЕНЮ,
        СООБЩИТЬ_О_ПРОБЛЕМЕ_БОКОВОЕ_МЕНЮ,
        НАСТРОЙКИ_БОКОВОЕ_МЕНЮ,
        TELEGRAM_БОКОВОЕ_МЕНЮ;

    public SideBar(RemoteWebDriver driver) {
        super(driver);
    }

    private static String подставитьВерсиюПриложения(String version_app) {
        return ВЕРСИЯ_ПРИЛОЖЕНИЯ_ОКНО_ЛОГО_0.replace("{VERSION_APP}", version_app);
    }

    public void wait_Сравнить_version_app(String version_app) {
        String search_result_xpath = подставитьВерсиюПриложения(version_app);
        this.waitForElementPresent(search_result_xpath, "version_app not " + version_app);
    }

  /*  public void clickByArticleWithSubstring(String version_app) {
        String search_result_xpath = СравнитьВерсиюПриложения(version_app);
        this.waitForElementAndClick(search_result_xpath, "version_app not " + version_app,10);
    }
*/
    public void open_logo_screen() {
        this.waitForElementPresent(ЛОГО_БОКОВОЕ_МЕНЮ, "logo not found on side menu", 5);
        this.waitForElementAndClick(ЛОГО_БОКОВОЕ_МЕНЮ, "logo not found and click on side menu",5);
    }

    public void open_Settings() {
        this.waitForElementAndClick(НАСТРОЙКИ_БОКОВОЕ_МЕНЮ, "Cannot find settings button on sidebar", 15);
    }
}

/*
Лого
    версия приложения
    dev mode
    email
    политики
Оценить приложение
    1-3 звезды
    4-5 звезды
Поделиться
Сообщить о проблеме
Перейти в Настроки
Telegram
*/