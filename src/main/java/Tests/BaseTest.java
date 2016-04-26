package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;
    protected static String pageUrl = "http://skillsup.ua/";

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        //driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
