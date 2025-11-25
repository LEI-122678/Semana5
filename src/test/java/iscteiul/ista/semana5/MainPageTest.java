package iscteiul.ista.semana5;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {

    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.jetbrains.com/");
        closeAllCookieBanners();
    }

    // ---- Função universal para fechar qualquer cookie banner ----
    private void closeAllCookieBanners() {

        String[] cookieSelectors = {
                "button.ch2-allow-all-btn",
                "button[data-test='footer__button-accept']",
                "button[id*='accept']",
                "button[class*='accept']",
                ".ch2-container button"
        };

        for (String sel : cookieSelectors) {
            if ($(sel).exists() && $(sel).isDisplayed()) {
                $(sel).click();
                sleep(400);
                break;
            }
        }
    }

    // -------------------- TESTES --------------------

    @Test
    public void search() {
        // Abre caixa de pesquisa
        mainPage.searchButton.shouldBe(visible).click();

        // Preenche pesquisa
        mainPage.searchInput.shouldBe(visible).setValue("Selenium");
        mainPage.searchInput.shouldHave(value("Selenium"));

        // Clica no botão de pesquisa
        $("button[data-test='full-search-button']")
                .scrollTo()
                .shouldBe(visible, enabled)
                .click();
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.shouldBe(visible).click();
        $("[data-test-marker='Developer Tools']").shouldBe(visible);
    }

    @Test
    public void navigationToAllTools() {

        mainPage.seeDeveloperToolsButton.shouldBe(visible).click();
        mainPage.findYourToolsButton.shouldBe(visible).click();

        $("#products-page").shouldBe(visible);

        assertEquals(
                "All Developer Tools and Products by JetBrains",
                title()
        );
    }
}