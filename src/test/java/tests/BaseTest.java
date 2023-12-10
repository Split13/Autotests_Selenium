package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import utils.*;


import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    App app = new App();

    @BeforeTest
    public void setup(){
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = PROXY;
        Configuration.downloadsFolder = ("C:\\Users\\split\\Downloads");
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }



    @AfterTest
    public void tearDown() {

    }


}