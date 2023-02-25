package Lite.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SettingsScreen extends MainPageObject {

    protected static String
            NEW;

    public SettingsScreen(RemoteWebDriver driver)
    {
        super(driver);
    }
}

/*
Выбор региона
Скрыть каналы других регионов
Жесты Громкость
Жесты Яркость
Настройки качества видео
Запомнить качество
Повышенная стабильность
Открывать ППК
Звук при ППК
Время в телепрограмме
Тема
Обновить плейлист
Экономия трафика мобильной сети
Таймер сна
Назад - вернуться
*/