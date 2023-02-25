package Lite.tests;

import org.junit.Test;

import Lite.lib.CoreTestCase;
import Lite.lib.ui.MainScreen;
import Lite.lib.ui.SideBar;
import Lite.lib.ui.factories.MainScreen_Factory;
import Lite.lib.ui.factories.SideBar_Factory;

public class SideBarTests extends CoreTestCase {

    @Test // версия приложения
    public void test1_open_logo_screen() {
        MainScreen Lite_MainScreen = MainScreen_Factory.get(driver);
        Lite_MainScreen.set_SkipОкноВыборРегиона_ColdStart();
        SideBar Lite_SideMenu = SideBar_Factory.get(driver);
        Lite_SideMenu.open_logo_screen();
        Lite_SideMenu.wait_Сравнить_version_app("версия: 2.8.8 (397)");
    }

    @Test
    public void test_open_settings()
    {
        SideBar SideBar = SideBar_Factory.get(driver);
        SideBar.open_Settings();
        //String search_line = "qweasdqweasd123";
        //Search.typeSearchLine(search_line);

    }
}

/*
Лого
    версия приложения +
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