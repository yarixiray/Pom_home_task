package PageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static PageFactory.Page.driver;

public class OurTeamPage {
    private WebDriver driver;
    private static String pageUrl = "http://skillsup.ua/";
    private By ourTeam = By.linkText("Наша команда");
    private By nameFieldInsideCard = By.className("name");

    public OurTeamPage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }

    public void goToCoachPage() {
        driver.findElement(ourTeam).click();
    }

    public boolean checkThatPersonIsPresented(String person) {
        return getAllCoachNames().contains(person);
    }

    private List<String> getAllCoachNames() {
        List<String> list = new ArrayList<String>();
        List<WebElement> allCoachNames = driver.findElements(nameFieldInsideCard);
        System.out.println(allCoachNames.size());
        for(WebElement element : allCoachNames){
            list.add(element.getText());
        }
        return getAllCoachNames();
    }
    public void awaitUntilNameTextHasText(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }
    public void callJavaScript(){
        ((JavascriptExecutor)driver).executeScript("alert('Hello world');");
    }
    public void pressOnAlertButton() {
        driver.switchTo().alert().accept();
    }
    public String getTextOnAlertButton() {
        return  driver.switchTo().alert().getText();
    }

    public String getAllCoachesJavaScript(){
        WebElement w = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.getElementsByClassName('name')[0];");
        return w.getText();
        }

}


