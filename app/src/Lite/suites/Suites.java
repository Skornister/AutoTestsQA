package Lite.suites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Lite.tests.ChannelTests;
import Lite.tests.FavoriteTests;
import Lite.tests.MainScreenTests;
import Lite.tests.SearchTests;
import Lite.tests.SettingsScreenTests;
import Lite.tests.SideBarTests;
import Lite.tests.UpApp;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ChannelTests.class,
        FavoriteTests.class,
        MainScreenTests.class,
        SearchTests.class,
        SettingsScreenTests.class,
        SideBarTests.class,
        UpApp.class
})
public class Suites {}