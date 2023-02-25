package EX;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainClassTest extends MainClass {

    @Before
    public void textStartTest() {
        System.out.println("Start test");
    }

    @After
    public void textFinishTest() {
        System.out.println("Finish test");
    }

    @Test
    public void firstTest() {
        System.out.println("firstTest");
    }

    private MainClass mainClass = new MainClass();

    @Test
    public void testGetLocalNumber() {
        Assert.assertTrue(mainClass.getLocalNumber() + " != 14", mainClass.getLocalNumber() == 14);
    }

    @Test
    public void testGetClassNumber() {
        Assert.assertTrue(mainClass.getClassNumber() + " <= 45", mainClass.getClassNumber() > 45);
    }

    @Test
    public void testGetClassString() {
        Assert.assertTrue(
                mainClass.getClassString() + " not contains 'Hello' or 'hello'",
                mainClass.getClassString().contains("hello") || mainClass.getClassString().contains("Hello")
        );
    }
}