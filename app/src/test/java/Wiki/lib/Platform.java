package Wiki.lib;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Platform {
    private static final String
            PLATFORM_IOS = "ios",
            PLATFORM_ANDROID = "android",
            PLATFORM_MOBILE_WEB = "mw",
            APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static final String
            USERNAME_MAKSIM_WORK = "maksim",
            USERNAME_MAKSIM_HOME = "petro",
            USERNAME_MAC = "dev";

    public static final String
            WikiAnd_appPath_work = "/home/maksim/AndroidStudioProjects/CtvAutoTest/apks/org.wikipedia.apk", // Wiki andr path work
            WikiAnd_appPath_home = "d:/Android/CtvAutoTest/apks/org.wikipedia.apk", // Wiki andr path home
            WikiAnd_appPath_new_name = "", // Wiki andr path home

            WikiIOS_appPath_MAC = "/User/dev/Deskop/Wikipedia.app", // Wiki iOS path work
            WikiIOS_appPath_new_name = ""; // Wiki andr path home

    // Приватный конструктор
    private static Platform instance; /* экземпляр/пример */

    private Platform() {}

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }
    // Приватный конструктор

    public RemoteWebDriver getDriver() throws Exception /* Выбрать driver с нужными capabilities */ {
        URL URL = new URL(APPIUM_URL);
        if(this.isAndroid()) /* если PLATFORM=android в конфигурации Android Studio берем get_Android_DesiredCapabilities - конфигурацию Android Studio нужно заранее настраивать */
            {return new AndroidDriver(URL, this.get_Android_DesiredCapabilities());}
        else if(this.isIOS())
            {return new IOSDriver(URL, this.get_IOS_DesiredCapabilities());}
/*        else if(this.isMW())
            {return new ChromeDriver(this.getMWChromeOptions());}*/
        else
            {throw new Exception("===== Cannot detect type of the Driver. Platform value: " + this.getPlatformVar());}
    }

    /* Распознать что указано в PLATFORM в конфигурации Android Studio для getDriver - работают на основе isPlatform */
    public boolean isAndroid() {return isPlatform(PLATFORM_ANDROID);}
    public boolean isIOS() {return isPlatform(PLATFORM_IOS);}
    public boolean isMW() {return isPlatform(PLATFORM_MOBILE_WEB);}
    /* Распознать что указано в PLATFORM */

    private DesiredCapabilities get_Android_DesiredCapabilities() /* android capabilities */{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android"); //Платформа Android or iOS
        capabilities.setCapability("deviceName", "and80"); //Имя устройства -для iOS обязательно
        capabilities.setCapability("platformVersion", "8"); //Версия платформы
        capabilities.setCapability("automationName", "Appium"); //Запуск через Appium
        capabilities.setCapability("appPackage", "org.wikipedia"); //Название процесса приложения
        capabilities.setCapability("appActivity", ".main.MainActivity"); //Главный экран приложения -Как найти в уроке Глава 2.06. Packages and Capabilities
        if (System.getenv("USERNAME").equals(USERNAME_MAKSIM_WORK)) {
            capabilities.setCapability("app", WikiAnd_appPath_work);
        } else if (System.getenv("USERNAME").equals(USERNAME_MAKSIM_HOME)) {
            capabilities.setCapability("app", WikiAnd_appPath_home);
        } else if (System.getenv("USERNAME").equals(USERNAME_MAC)) {
            capabilities.setCapability("app", WikiAnd_appPath_new_name);
        } else {
            System.out.println("\n=====> need to set up USERNAME <=====\n NOW USERNAME - " + System.getenv("USERNAME"));
        }
        return capabilities;
    }

    private DesiredCapabilities get_IOS_DesiredCapabilities() /* ios capabilities */ {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS"); //Платформа Android or iOS
        capabilities.setCapability("deviceName", "iPhone SE"); //Имя устройства -для iOS обязательно
        capabilities.setCapability("platformVersion", "16.2"); //Версия платформы
        if (System.getenv("USERNAME").equals(USERNAME_MAC)) { //Указать путь до apk файла
            capabilities.setCapability("app", WikiIOS_appPath_MAC);
        } else if (System.getenv("USERNAME").equals(USERNAME_MAC)) {
            capabilities.setCapability("app", WikiIOS_appPath_new_name);
        } else {
            System.out.println("\n=====> need to set up setCapability appPath in Platform.get_IOS_DesiredCapabilities <=====\n");
        }
        return capabilities;
    }
/*    private ChromeOptions getMWChromeOptions() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 640);
        deviceMetrics.put("height", 840);
        deviceMetrics.put("pixelRadio", 3.0);

        Map<String, Object> mobileEmulator = new HashMap<>();
        mobileEmulator.put("deviceMetrics", deviceMetrics);
        mobileEmulator.put("User-Agent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=640,840"); *//* Не хочет работать - не меняется размер браузера под указанные - нужна помощь *//*

        return chromeOptions;
    }*/

    private boolean isPlatform(String my_platform) /* Сравниваем PLATFORM в getPlatformVar с переменной, которая приходит в этот метод из isAndroid, isIOS */ {
        String platform = this.getPlatformVar(); /* тут получаем PLATFORM из getPlatformVar */
        return my_platform.equals(platform);
    }
    public String getPlatformVar() /* взять PLATFORM из конфигурации Android Studio - нужно заранее настраивать */ {return System.getenv("PLATFORM");}
}

/* - поиск appActivity Лайт
установить apk на эмулятор
adb shell pm list packages | grep "lite" - получили package:limehd.ru.lite
запустить приложение в эмуляторе на первом экране
adb shell dumpsys window windows >> /home/maksim/'Документы'/activity.txt
в файле ищем limehd.ru.lite нашли limehd.ru.lite/limehd.ru.ctv.MainActivity
appPackage = limehd.ru.lite
appActivity = limehd.ru.ctv.MainActivity
 */

/* пример для Appium Server
{
"platformName": "Android",
"deviceName": "and80",
"platformVersion": "8",
"appPackage": "org.wikipedia",
"appActivity": ".main.MainActivity"
}
*/

/* комманды Terminal
- запуск эмулятора
emulator -avd and80
- запуск с установленным TZ
emulator -avd and80 -timezone Europe/Paris
emulator -avd and80 -timezone America/Los_Angeles
emulator -avd and80 -timezone Russia/Moscow
- соединение с android по ip
adb connect <ip>
- установка apk
adb install "$HOME/Загрузки/403.apk"
adb install "$HOME/Загрузки/org.wikipedia.apk"
adb uninstall limehd.ru.lite

*/

// %ANDROID_HOME%\maven\bin