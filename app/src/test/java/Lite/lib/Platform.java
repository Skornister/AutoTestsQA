package Lite.lib;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_MOBILE_WEB = "mw";
    private static final String PLATFORM_SMART = "smart";
    private static final String PLATFORM_UP_APP_ANDROID = "UpApp";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static final String USERNAME_MAKSIM_WORK = "maksim";
    private static final String USERNAME_MAKSIM_HOME = "petro";
    private static final String NAME_NEW_NAME = "";

    private static final String
            Lite_appActivity = "limehd.ru.ctv.MainActivity", //Lite
            Wiki_appActivity = ".main.MainActivity"; //Wiki
    public static final String
            Lite_appPath_work = "/home/maksim/AndroidStudioProjects/CtvAutoTest/apks/399.apk", // Lite path work
            Lite_appPath2_work = "/home/maksim/AndroidStudioProjects/CtvAutoTest/apks/399.apk", // Lite path work for UP

            Lite_appPath_home = "d:/Android/CtvAutoTest/apks/397.apk", // Lite path home
            Lite_appPath2_home = "d:/Android/CtvAutoTest/apks/399.apk", // Lite path home for UP

            Wiki_appPath_work = "/home/maksim/AndroidStudioProjects/CtvAutoTest/apks/org.wikipedia.apk", // Wiki path work
            Wiki_appPath_home = "d:/Android/CtvAutoTest/apks/org.wikipedia.apk", // Wiki path home
            Lite_appPackage = "limehd.ru.lite", //Lite nameApp
            Wiki_appPackage = "org.wikipedia"; //Wiki nameApp

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
/*        else if(this.isSmart())
            {return new ChromeDriver(this.get_Smart());}
        else if(this.isMW())
            {return new ChromeDriver(this.getMWChromeOptions());}*/
        else
            {throw new Exception("===== Cannot detect type of the Driver. Platform value: " + this.getPlatformVar());}
    }

    /* - хочу подставить вместо this.get_Android_DesiredCapabilities() в getDriver, но ошибка, нужен отдельный метод
    if(getPlatformVar(PLATFORM_UP_APP_ANDROID) {return isPlatform (this.get_UpAppAndroid_DesiredCapabilities())}; else {return isPlatform(this.get_Android_DesiredCapabilities())}
     */

    /* Распознать что указано в PLATFORM в конфигурации Android Studio для getDriver - работают на основе isPlatform */
    public boolean isAndroid() {return isPlatform(PLATFORM_ANDROID);}
    public boolean isIOS() {return isPlatform(PLATFORM_IOS);}
    public boolean isMW() {return isPlatform(PLATFORM_MOBILE_WEB);}
    public boolean isSmart() {return isPlatform(PLATFORM_SMART);}
    /* Распознать что указано в PLATFORM */

    /* Распознать что указано в HOME в конфигурации Android Studio - хочу разделить String учитывая комп - работают на основе isHome */
    public boolean is_Maksim_Work() {return isHomePath(USERNAME_MAKSIM_WORK);}
    public boolean is_Maksim_Home() {return isHomePath(USERNAME_MAKSIM_HOME);}
    public boolean is_NewName() {return isHomePath(NAME_NEW_NAME);}
    /* Распознать что указано в HOME */

    private DesiredCapabilities get_Android_DesiredCapabilities() /* android capabilities */{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android"); //Платформа Android or iOS
        capabilities.setCapability("deviceName", "and80"); //Имя устройства -для iOS обязательно
        capabilities.setCapability("platformVersion", "8"); //Версия платформы
        capabilities.setCapability("automationName", "Appium"); //Запуск через Appium
        capabilities.setCapability("appPackage", Wiki_appPackage); //Название процесса приложения
        capabilities.setCapability("appActivity", Wiki_appActivity); //Главный экран приложения -Как найти в уроке Глава 2.06.Packages and Capabilities
        if (System.getenv("USERNAME").equals(USERNAME_MAKSIM_WORK)) {
            capabilities.setCapability("app", Wiki_appPath_work);
        } else {
            capabilities.setCapability("app", Wiki_appPath_home);
        }
        return capabilities;
    }

    private DesiredCapabilities get_IOS_DesiredCapabilities() /* ios capabilities */ {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS"); //Платформа Android or iOS
        capabilities.setCapability("deviceName", "iPhone SE"); //Имя устройства -для iOS обязательно
        capabilities.setCapability("platformVersion", "11.3"); //Версия платформы
        capabilities.setCapability("app", Lite_appPath_work); //Указать путь до apk файла
        return capabilities;
    }
/*    private ChromeOptions getMWChromeOptions() {
        WebDriverManager.chromedriver()*//*driverVersion("18.0.1025.166")*//*.setup();
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
    }

    private ChromeOptions get_Smart() {
        WebDriverManager.chromedriver()*//*driverVersion("18.0.1025.166")*//*.setup();

        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 640);
        deviceMetrics.put("height", 840);
        deviceMetrics.put("pixelRadio", 3.0);

        Map<String, Object> mobileEmulator = new HashMap<>();
        mobileEmulator.put("deviceMetrics", deviceMetrics);
        mobileEmulator.put("User-Agent", "Mozilla/5.0 (Web0S; Linux/SmartTV) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36 WebAppManager");
        mobileEmulator.put("User-Agent-Smart", "{'platform':'smart','app':'lite.webos','version_name':'1.1.0','version_code':'110','device_id':'','guid':'72a656d0-8a0d-5751-5bf1-6b9c6b740b5f','name':'43UN73906LE'}");
        mobileEmulator.put("X-LHD-Agent", "{'platform':'smart','app':'lite.webos','version_name':'1.1.0','version_code':'110','device_id':'','guid':'72a656d0-8a0d-5751-5bf1-6b9c6b740b5f','name':'43UN73906LE'}");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=640,840"); *//* Не хочет работать - не меняется размер браузера под указанные - нужна помощь *//*

        return chromeOptions;
    }*/

    private boolean isPlatform(String my_platform) /* Сравниваем PLATFORM в getPlatformVar с переменной, которая приходит в этот метод из isAndroid, isIOS */ {
        String platform = this.getPlatformVar(); /* тут получаем PLATFORM из getPlatformVar */
        return my_platform.equals(platform);
    }
    public String getPlatformVar() /* взять PLATFORM из конфигурации Android Studio - нужно заранее настраивать */ {return System.getenv("PLATFORM");}

    private boolean isHomePath(String my_home_path) /* Сравниваем HOME в getHomePathVar с переменной, которая приходит в этот метод из isAndroid, isIOS */ {
        String home_path = this.getHomePathVar(); /* тут получаем HOME из getHomePathVar */
        return my_home_path.equals(home_path);
    }
    public String getHomePathVar() /* взять PLATFORM из конфигурации Android Studio - нужно заранее настраивать */ {return System.getenv("HOME");}

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
- подключить прокси
emulator -avd and80 -http-proxy 192.168.5.187:8888
- сменить TZ /не работает?
emulator -avd and80 -timezone Europe/Paris
emulator -avd and80 -timezone America/Los_Angeles
emulator -avd and80 -timezone Russia/Moscow

*/

// %ANDROID_HOME%\maven\bin