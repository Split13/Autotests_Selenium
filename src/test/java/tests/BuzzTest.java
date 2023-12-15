package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

public class BuzzTest extends BaseTest {

    /**
     * Section "Buzz" opens.
     */
    @Test
    public void openBuzz() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.buzzPage.iconBuzz.click();
        app.buzzPage.headerBuzz.shouldHave(Condition.exactText("Buzz"));
        Configuration.holdBrowserOpen = true;


    }

    /**
     * Section "Buzz" opens
     * MostLikedPosts opens.
     */
    @Test
    public void openMostLikedPosts() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.buzzPage.iconBuzz.click();
        app.buzzPage.mostLikedPosts.click();
    }

}
