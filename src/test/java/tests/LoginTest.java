package tests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    @Test
    public void loginWithValidCredentials() {
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        SelenideElement userNameField = $(By.name("username"));
        SelenideElement passwordField = $(By.name("password"));
        SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));

        userNameField.setValue("Admin");
        passwordField.setValue("admin123");
        loginButton.click();
    }

    /**
     * Откорректированная проверка "Отображение сообщения при вводе неверного логина или пароля"
     */

    @Test
    public void loginWithInvalidCredentials() {
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        SelenideElement userNameField = $(By.name("username"));
        SelenideElement passwordField = $(By.name("password"));
        SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));

        userNameField.setValue("dfdfdf");
        passwordField.setValue("admin123");
        loginButton.click();
        $x("//div[@role='alert']//p[text()='Invalid credentials']").shouldBe(visible);
    }


    /**
     * Проверка "Нажатие кнопки Login при незаполненном поле "Username"
     */
    @Test
    public void loginWithoutEnteringCredentialUsername() {
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        SelenideElement passwordField = $(By.name("password"));
        SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));
        loginButton.click();

        passwordField.setValue("admin123");
        $x("//div/input[@name='username']/../following-sibling::span").shouldBe(visible);
    }


    /**
     * Проверка "Нажатие кнопки Login при незаполненном поле "Password"
     */
    @Test
    public void loginWithoutEnteringCredentialPassword() {
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        SelenideElement userNameField = $(By.name("username"));
        SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));
        loginButton.click();

        userNameField.setValue("Admin");
        $x("//div/input[@name='password']/../following-sibling::span").shouldBe(visible);
    }

    /**
     * Проверка "Открытие экрана для сброса пароля"
     */
    @Test
    public void ClickOnForgotYourPassword() {
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        SelenideElement forgotPasswordBtn = $(By.xpath("//p[text()='Forgot Your Password? ']"));
        forgotPasswordBtn.click();
        $x("//h6[text()='Reset Password']").shouldBe(visible);
    }

    /**
     * Проверка "Возврат на страницу авторизации со страницы сброса пароля"
     */
    @Test
    public void ReturnToLoginPageFromResetPage() {
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        SelenideElement forgotPasswordBtn = $(By.xpath("//p[text()='Forgot Your Password? ']"));
        forgotPasswordBtn.click();
        $x("//button[contains(@class, 'forgot-password-button--cancel')]").click();
        $x("//h5[text()='Login']").shouldBe(visible);
    }
}
