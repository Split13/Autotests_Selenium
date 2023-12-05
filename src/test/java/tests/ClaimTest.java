package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byXpath;

public class ClaimTest extends BaseTest{
    /**
     * 1. Open section Claim.
     * 2. Click on cell From Date.
     * 3. Input incorrect data format.
      */
    @Test
    public void foundRecords() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.claimPage.iconClaim.click();
        app.claimPage.fromDateTextBox.click();
        app.claimPage.fromDateTextBox.setValue("2023-06-18");
        app.claimPage.buttonSearch.click();
        int records = app.claimPage.recordsFound.findElements(byXpath("//div[@class='oxd-table-card']")).size();
        System.out.println(records);

    }



}
