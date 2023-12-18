package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.testng.Tag;
import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MyInfoTest extends BaseTest{

    /**
     * 1. Section "My Info" opens.
     * 2. Firstname is entered.
     * 3. Click on the button "SaveButton".
     */
    @Test
    @Description("")
    @Tag("")
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
     * 1. Login.
     * 2. Help Page open
     * 3. Switch to Window Help Page
     * 4. Check URL
     * @throws InterruptedException
     */
    @Test
    public void openHelp() throws InterruptedException {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.myInfoPage.iconHelp.click();
        Selenide.switchTo().window(1);
        getWebDriver().manage().timeouts().pageLoadTimeout(02, TimeUnit.SECONDS);
        webdriver().shouldHave(url("https://starterhelp.orangehrm.com/hc/en-us"));

    }


    /**
     * 1. Section "My Info" opens.
     * 2. LastName is entered.
     * 3. Click on the button "SaveButton".
     */
    @Test
    @Description("")
    @Tag("")
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
    @Description("")
    @Tag("")
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
    @Description("")
    @Tag("")
    public void editBloodType() {
        app.loginPage.login(app.userCredentials.adminLogin, app.userCredentials.adminPassword);
        app.myInfoPage.iconMyInfo.click();
        app.myInfoPage.bloodTypeDropdownTab.click();
        app.myInfoPage.bloodTypeDropDown.getWrappedElement().findElement(byText("A+")).click();
        app.myInfoPage.saveButton2.click();
    }


}
