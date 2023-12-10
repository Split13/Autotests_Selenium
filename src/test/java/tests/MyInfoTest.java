package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyInfoTest extends BaseTest{

    /**
     * 1. Section "My Info" opens.
     * 2. Firstname is entered.
     * 3. Click on the button "Save.
     */
    @Test
    public void editFirstName(){
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.myInfoPage.iconMyInfo.click();
        app.myInfoPage.firstName.click();
        app.myInfoPage.firstName.sendKeys(Keys.CONTROL + "a");
        app.myInfoPage.firstName.sendKeys(Keys.BACK_SPACE);
        app.myInfoPage.firstName.setValue("John");
        app.myInfoPage.firstName.shouldHave(Condition.exactValue("John"));
        app.myInfoPage.saveButton.click();

    }


    /**
     * 1. Section "My Info" opens.
     * 2. Memberships opens.
     * 3. Download Record file.
     */
    @Test
    public void fileDownload(){
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.myInfoPage.iconMyInfo.click();
        app.myInfoPage.Memberships.click();
        File report = $(byXpath("//button/i[@class='oxd-icon bi-download']")).download();
        System.out.println("Does file exist? " + report.exists());

    }
}
