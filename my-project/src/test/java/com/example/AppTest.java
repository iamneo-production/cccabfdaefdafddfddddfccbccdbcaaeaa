package com.example;
import java.beans.Transient;

import org.testng.annotations.Test;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    @Test
    public void testcase_2() throws InterruptedException {
        // write Your Code here to Login

        driver.switchTo().frame(0);
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("draggable")), droppable).perform();
        String actualText = droppable.getText();
        String expectedText = "Dropped!";
        Assert.assertEquals(actualText, expectedText, "Text is not as expected");
    }
    

}
