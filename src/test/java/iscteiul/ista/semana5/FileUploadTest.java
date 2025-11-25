package iscteiul.ista.semana5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

public class FileUploadTest {

    private final FileUploadPage fileUploadPage = new FileUploadPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void testFileUpload() {
        File testFile = new File("ficheiroTesteUpload.txt");

        if (!testFile.exists()) {
            throw new RuntimeException("Arquivo não encontrado: " + testFile.getAbsolutePath());
        }
        fileUploadPage.uploadFile(testFile);
        fileUploadPage.clickSubmitButton();
        fileUploadPage.verifyUploadedFile("ficheiroTesteUpload.txt");
    }
}