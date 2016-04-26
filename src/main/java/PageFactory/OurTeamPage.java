package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        List<WebElement> allCoachNames = driver.findElements(nameFieldInsideCard);
        for(WebElement coach:allCoachNames){
            String all=coach.getText();
            System.out.println(all);
        }
        return getAllCoachNames();
    }
}


