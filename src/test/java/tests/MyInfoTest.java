package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MyInfoTest extends BaseTest{



    /**
     * 1. Section "My Info" opens.
     * 2. Firstname is entered.
     * 3. Click on the button "SaveButton".
     */
    @Test
    public void editFirstName() {
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
     * 4. Check download file.
     */
    @Test
    public void fileDownload(){

        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.myInfoPage.iconMyInfo.click();
        app.myInfoPage.Memberships.click();
        File report = $(byXpath("//button/i[@class='oxd-icon bi-download']")).download();
        System.out.println("Does file exist? " + report.exists());

    }



    /**
     * 1. Section "My Info" opens.
     * 2. LastName is entered.
     * 3. Click on the button "SaveButton".
     */
    @Test
    public void editLastName() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.myInfoPage.iconMyInfo.click();
        app.myInfoPage.lastName.click();
        app.myInfoPage.lastName.sendKeys(Keys.CONTROL + "a");
        app.myInfoPage.lastName.sendKeys(Keys.BACK_SPACE);
        app.myInfoPage.lastName.setValue("Petrovich");
        app.myInfoPage.lastName.shouldHave(Condition.exactValue("Petrovich"));
        app.myInfoPage.saveButton.click();
    }

    /**
     * 1. Section "My Info" opens.
     * 2. MaritalStatus is entered.
     * 3. Click on the button "SaveButton".
     */
    @Test
    public void editMaritalStatus() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.myInfoPage.iconMyInfo.click();
        app.myInfoPage.maritalStatusDropdownTab.click();
        app.myInfoPage.maritalStatusDropDown.getWrappedElement().findElement(byText("Single")).click();
        app.myInfoPage.saveButton.click();
    }

    /**
     * 1. Section "My Info" opens.
     * 2. BloodType is entered.
     * 3. Click on the button "SaveButton".
     */
    @Test
    public void editBloodType() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.myInfoPage.iconMyInfo.click();
        app.myInfoPage.bloodTypeDropdownTab.click();
        app.myInfoPage.bloodTypeDropDown.getWrappedElement().findElement(byText("A+")).click();
        app.myInfoPage.saveButton2.click();
    }


}
