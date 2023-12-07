package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ClaimPage {

    /**
     * Frontend elements found by xpass
     */
    public SelenideElement iconClaim = $(byXpath("//a[@href='/web/index.php/claim/viewClaimModule']"));
    public SelenideElement fromDateTextBox = $(byXpath("(//input[@placeholder='yyyy-mm-dd'])[1]"));
    public SelenideElement dropCalendarMenu = $(byXpath("//div[@class='oxd-calendar-date --selected --today']"));
    public SelenideElement eventName = $(byXpath("//div[@class='oxd-select-text oxd-select-text--active']"));
    public SelenideElement dropMenuEventName = $(byXpath("//div[@class='oxd-select-dropdown --positon-bottom']"));
    public SelenideElement errorMessage = $(byXpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
    public SelenideElement space = $(byXpath("//div[@class='oxd-form-actions']"));

    public SelenideElement buttonSearch = $(byXpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
    public SelenideElement recordsFound = $(byXpath("//span[@class='oxd-text oxd-text--span']"));

}
