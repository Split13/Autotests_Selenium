package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.testng.Tag;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;

public class ClaimTest extends BaseTest{
    /**
     * 1. Open section Claim.
     * 2. Click on cell From Date.
     * 3. Input incorrect data format.
     */
    @Test
    @Description("")
    @Tag("")
    public void fromDateSelecting() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.claimPage.iconClaim.click();
        app.claimPage.fromDateTextBox.click();
        app.claimPage.dropCalendarMenu.click();

    }

    /**
     * 1. Open section Claim.
     * 2. Click on Event Name.
     * 3. Choose Accommodation.
     */
    @Test
    @Description("")
    @Tag("")
    public void selectEventName() throws InterruptedException {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.claimPage.iconClaim.click();
        app.claimPage.eventName.click();
        Thread.sleep(1000);
        app.claimPage.dropMenuEventName.getWrappedElement().findElement(byText("Accommodation")).click();

    }





}
