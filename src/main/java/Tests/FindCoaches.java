package Tests;

import PageFactory.OurTeamPage;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FindCoaches extends BaseTest{

    private OurTeamPage coachPageView;

    @Test
    public void checkThatBokhanIsPresented() throws Exception {
        coachPageView = new OurTeamPage(driver);
        coachPageView.goToCoachPage();
        coachPageView.checkThatPersonIsPresented("Евгения Бохан");
    }

    @Test
    public void checkThatGalkovskiyIsPresented() throws Exception {
        coachPageView = new OurTeamPage(driver);
        coachPageView.goToCoachPage();
        assertTrue(coachPageView.checkThatPersonIsPresented("Александр Галковский"));
    }

    @Test
    public void checkThatKarpovIsNotPresented() throws Exception {
        coachPageView = new OurTeamPage(driver);
        coachPageView.goToCoachPage();
        assertFalse(coachPageView.checkThatPersonIsPresented("Артем Карпов"));
    }
    @Test
    public void awaitNameFieldHasText() throws Exception {
        coachPageView = new OurTeamPage(driver);
        coachPageView.goToCoachPage();
        coachPageView.awaitUntilNameTextHasText();
    }
    @Test
    public void callJsAlert() throws Exception {
        coachPageView = new OurTeamPage(driver);
        coachPageView.goToCoachPage();
        coachPageView.callJavaScript();
        coachPageView.awaitUntilNameTextHasText();
    }
    @Test
    public void callListJavaScript() throws Exception {
        coachPageView = new OurTeamPage(driver);
        coachPageView.goToCoachPage();
        coachPageView.getAllCoachesJavaScript();
        Assert.assertEquals("Ольга Симчак", coachPageView.getAllCoachesJavaScript());
    }
    @Test
    public void testAlertJavaScript() throws Exception {
        coachPageView = new OurTeamPage(driver);
        coachPageView.goToCoachPage();
        coachPageView.callJavaScript();
        assertEquals("Hello world", coachPageView.getTextOnAlertButton());
        //coachPageView.getTextOnAlertButton();
        coachPageView.pressOnAlertButton();
    }
}

