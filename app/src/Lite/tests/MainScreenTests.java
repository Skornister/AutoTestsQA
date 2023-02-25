package Lite.tests;

import org.junit.Test;

import Lite.lib.CoreTestCase;
import Lite.lib.ui.MainScreen;
import Lite.lib.ui.factories.MainScreen_Factory;

public class MainScreenTests extends CoreTestCase {
    @Test
    public void test1_Нажать_ОК_Выбор_региона_1й_запуск() {
        MainScreen Lite_MainScreen = MainScreen_Factory.get(driver);
        Lite_MainScreen.set_SkipОкноВыборРегиона_ColdStart();
    }
}

/*
Сплешскрин
ВПН
    sdk 26+
    $ adb shell am start-foreground-service --user 0 -n io.appium.settings/.LocationService --es longitude {longitude-value} --es latitude {latitude-value} [--es altitude {altitude-value}]
    sdk 26-
    $ adb shell am startservice --user 0 -n io.appium.settings/.LocationService --es longitude {longitude-value} --es latitude {latitude-value} [--es altitude {altitude-value}]
    есть атрибут speed
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