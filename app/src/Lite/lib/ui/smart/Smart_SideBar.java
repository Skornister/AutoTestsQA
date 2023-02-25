package Lite.lib.ui.smart;

import org.openqa.selenium.remote.RemoteWebDriver;

import Lite.lib.ui.SideBar;

public class Smart_SideBar extends SideBar {

    static {
        ЛОГО_БОКОВОЕ_МЕНЮ = "id:limehd.ru.lite:id/menuCtvInfo";
                ЛОГО_ОКНО_ЛОГО = "limehd.ru.lite:id/application_icon";
                НАЗВАНИЕ_ПРИЛОЖЕНИЯ_ОКНО_ЛОГО = "xpath://*[@text='Лайт HD TV']";
                ПОЛЕ_ВВОДА_ПАРОЛЯ_DEV_MODE = "limehd.ru.lite:id/edit_dev_password";
                ОК_DEV_MODE = "limehd.ru.lite:id/button_auth_dev";
                TOAST_ON_DEV_MODE = "xpath://*[@text='Вы успешно авторизовались в dev-mode!']";
                ВЫКЛ_DEV_MODE = "limehd.ru.lite:id/button_auth_dev";
                ВЕРСИЯ_ПРИЛОЖЕНИЯ_ОКНО_ЛОГО_0 = "xpath://*[contains(@text', {VERSION_APP}')]']";
                ВЕРСИЯ_ПРИЛОЖЕНИЯ_ОКНО_ЛОГО_1 = "xpath://*[@text='версия: 2.8.8LP (398)']";
                TEXT_EMAIL_ОКНО_ЛОГО = "xpath://*[@text='lite@limehd.tv']";
                ОК_ОКНО_ЛОГО = "id:limehd.ru.lite:id/buttonCtvInfo";
                TEXT_ПОЛИТИКА_ПД_ОКНО_ЛОГО = "xpath://*[@text='Политика обработки ПД']";
                TEXT_В_ПОЛИТИКЕ_ПД_ОКНО_ЛОГО = "xpath://*[@text='Политика обработки персональных данных пользователей приложения ООО «Лайм Эйч Ди» (ред. от 05.04.2022г, ред. от 04.05.2022г., ред. от 23.05.2022г.)']";
                BACK_WEB_VIEW = "id:android:id/buttonPanel";
                TEXT_ПОЛЬЗ_СОГЛ_ОКНО_ЛОГО = "xpath://*[@text='Пользовательское соглашение']";
                TEXT_В_ПОЛЬЗ_СОГЛ_ОКНО_ЛОГО = "xpath://*[@text='Пользовательское соглашение для мобильного приложения “Лайт HD TV” (редакция действует  с 22.03.2022г.)']";
        ОЦЕНИТЬ_ПРИЛОЖЕНИЕ_БОКОВОЕ_МЕНЮ = "id:limehd.ru.lite:id/menuEstimate";
        ПОДЕЛИТЬСЯ_БОКОВОЕ_МЕНЮ = "id:limehd.ru.lite:id/menuShare";
        СООБЩИТЬ_О_ПРОБЛЕМЕ_БОКОВОЕ_МЕНЮ = "id:limehd.ru.lite:id/menuSendEmail";
        НАСТРОЙКИ_БОКОВОЕ_МЕНЮ = "css:aside-settings";
        TELEGRAM_БОКОВОЕ_МЕНЮ = "id:limehd.ru.lite:id/menuTelegram";
    }

    public Smart_SideBar(RemoteWebDriver driver) {
        super(driver);
    }
}