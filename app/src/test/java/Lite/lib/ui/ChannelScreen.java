package Lite.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ChannelScreen extends MainPageObject {

    protected static String
        NEW;

    public ChannelScreen(RemoteWebDriver driver)
    {
        super(driver);
    }
}

/*
UI плеера
    Трансляция канала
    Сообщить о проблеме
	ЕПГ
	Звезда / Избранное
	    Добавить в избранное
	    Удалить из Избранного
	Замок
	Переключение канала
	    Стрелками
	    Цифрами
	    Через карусель каналов
	Хромкаст
	Только звук
	Субтитры
	Выбор качества
	PiP
	Crop
	Карусель каналов
	Назад - вернуться в список каналов
Реклама
	Преролл
	Постролл
	Мидролл
	Межстраничка
	    Наша
	    Витрина
	Статистика по рекламе
Медиаскоп
События appMetrica
    Профиль
*/