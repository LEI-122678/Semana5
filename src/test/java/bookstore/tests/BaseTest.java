package bookstore.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    static void setUpAll() {

        Configuration.baseUrl = "https://vaadin-bookstore-example.demo.vaadin.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000; // 8 segundos

        // Integração com Allure
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );
    }
}
