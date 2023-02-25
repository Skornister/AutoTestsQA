package Wiki.suites;

import Wiki.tests.ArticleTests;
import Wiki.tests.GetStartedTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import Wiki.tests.ChangeAppConditionTests;
import Wiki.tests.MyListsTests;
import Wiki.tests.SearchTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ArticleTests.class,
        ChangeAppConditionTests.class,
        GetStartedTests.class,
        MyListsTests.class,
        SearchTests.class
})
public class Suites {}