package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyInfoPage extends BasePage {

    /**
     * These are frontend elements found by xpass
     */
    public SelenideElement iconMyInfo = $(byXpath("//a[@href='/web/index.php/pim/viewMyDetails']"));
    public SelenideElement firstName = $(By.name("firstName"));
    public SelenideElement saveButton = $(byXpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
    public SelenideElement Memberships = $(byXpath("//a[@href='/web/index.php/pim/viewMemberships/empNumber/7']"));
    public SelenideElement buttonDownload = $(byXpath("//button/i[@class='oxd-icon bi-download']"));
}
