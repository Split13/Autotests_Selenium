package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;

public class AdminTest extends BaseTest {


    @Test
    public void adminTabClick() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.adminPage.adminTab.click();
        app.adminPage.userRoleButton.click();
        app.adminPage.userRoleDropDown.getWrappedElement().findElement(byText("Admin")).click();
        app.adminPage.userRoleInput.shouldHave(Condition.exactText("Admin"));

    }

    /**
     * 1. Open Admin.
     * 2. Choose User Role Admin.
     * 3. Choose status Enabled.
     * 4. Click on Search.
     * 5. Show records result.
     */
    @Test
    public void roleAdminFind(){
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.adminPage.adminTab.click();
        app.adminPage.userRoleButton.click();
        app.adminPage.userRoleDropDown.getWrappedElement().findElement(byText("Admin")).click();
        app.adminPage.selectStatus.click();
        app.adminPage.statusDropMenu.getWrappedElement().findElement(byText("Enabled")).click();
        app.adminPage.searchButton.click();
        app.adminPage.searchButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        int adminRecords = app.claimPage.recordsFound.findElements(byXpath("//div[@class='oxd-table-card']")).size();
        System.out.println(adminRecords);
        Configuration.holdBrowserOpen = true;

    }

    /**
     * Open  "Admin" Page
     * Click on the DropDownMenue
     * Get UserRole "Admin"
     * Click on the Button "Search".
     */
    @Test
    public void systemUsersSearchButton() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.adminPage.adminTab.click();
        app.adminPage.userRoleButton.click();
        app.adminPage.userRoleDropDown.getWrappedElement().findElement(byText("Admin")).click();
        app.adminPage.userRoleInput.shouldHave(Condition.exactText("Admin"));
        app.adminPage.searchButton.click();
    }

    /**
     * Open "Admin" Page
     * Click on the Button "+Add".
     */
    @Test
    public void addButtonClick() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.adminPage.adminTab.click();
        app.adminPage.addButton.click();
    }



}
