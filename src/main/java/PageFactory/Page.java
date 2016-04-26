package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    protected static WebDriver driver;


    public Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
