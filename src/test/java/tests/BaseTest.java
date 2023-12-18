package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.*;


import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    App app = new App();

    @BeforeTest
    public void setup(){
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        Configuration.downloadsFolder = ("C:\\Автотесты\\Скаченные файлы\\");
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }



    @AfterTest
    public void tearDown() {
        closeWebDriver();
    }


}