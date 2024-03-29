package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.testng.Tag;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;

public class AdminTest extends BaseTest {


    @Test
    @Description("Admin tab click")
    @Tag("smoke")
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
    @Description("")
    @Tag("")
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

    }

    /**
     * Open  "Admin" Page
     * Click on the DropDownMenue
     * Get UserRole "Admin"
     * Click on the Button "Search".
     */
    @Test
    @Description("Click on the Button Search")
    @Tag("smoke")
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
    @Description("Click on the Button Add")
    @Tag("smoke")
    public void addButtonClick() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.adminPage.adminTab.click();
        app.adminPage.addButton.click();
    }

    @Test
    @Description("Click on the enabled tab")
    @Tag("smoke")
    public void enabledTabClick() {
        app.loginPage.login("Admin", "admin123");
        app.adminPage.adminTab.click();
        app.adminPage.statusRoleButton.click();
        app.adminPage.statusRoleDropDown.getWrappedElement().findElement(byText("Enable")).click();
        app.adminPage.statusRoleInput.shouldHave(Condition.exactText("Enable"));
    }



}
