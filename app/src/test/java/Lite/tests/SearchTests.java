package Lite.tests;

import org.junit.Test;
import Lite.lib.CoreTestCase;
import Lite.lib.ui.MainScreen;
import Lite.lib.ui.SideBar;
import Lite.lib.ui.factories.MainScreen_Factory;
import Lite.lib.ui.factories.SideBar_Factory;

public class SearchTests extends CoreTestCase {

    @Test
    public void testAmountOfEmptySearch()
    {
        MainScreen MainScreen = MainScreen_Factory.get(driver);
        MainScreen.wait_ОК_ОкноВыбораРегиона_ColdStart();
        SideBar SideBar = SideBar_Factory.get(driver);
        SideBar.open_Settings();
        //String search_line = "qweasdqweasd123";
        //Search.typeSearchLine(search_line);

    }
}

/*
Поиск
    в списке каналов
    в Избранном
Поиск цифрами
    в списке каналов
    в Избранном
    на канале
    на другом экране
*/