package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;

public class TimeTest extends BaseTest{

    /**
     * Section "Time" opens.
     * Click on dropmeny, choose "Timesheets".
     * Click in button "Edit".
     * Enter data for the Project cell, select an item from the drop menu.
     * Select a "QA Testing" from the drop menu of Activity.
     * Check the data to ensure it matches.
     * @throws InterruptedException
     */
    @Test
    public void selectFromActivityDropMenu() throws InterruptedException {
        loginPage.login();
        timePage.iconTime.click();
        timePage.timesheets.click();
        timePage.dropMenu.click();
        timePage.editButton.click();
        timePage.cellProject.sendKeys(Keys.CONTROL + "a");
        timePage.cellProject.sendKeys(Keys.BACK_SPACE);
        timePage.cellProject.setValue("w");
        Thread.sleep(2000);
        timePage.chooseProject.click();
        timePage.activitySelect.click();
        Thread.sleep(1000);
        timePage.dropMenuActivity.getWrappedElement().findElement(byText("QA Testing")).click();
        timePage.selectedActivity.shouldHave(Condition.exactText("QA Testing"));


    }
}