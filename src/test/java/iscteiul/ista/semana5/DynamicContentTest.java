package iscteiul.ista.semana5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicContentTest {
    DynamicContentPage dynamicPage = new DynamicContentPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("https://the-internet.herokuapp.com/dynamic_loading/1"); // Exemplo 1: Element appears after load
    }

    @Test
    public void dynamicContentLoadTest() {
        dynamicPage.startButton.click();

        // Esperar que o indicador de loading desapareça (até 10s)
        dynamicPage.loadingIndicator.shouldBe(Condition.hidden, Duration.ofSeconds(10));

        // Verificar se o texto carregado está visível
        dynamicPage.loadedText.shouldBe(Condition.visible, Duration.ofSeconds(10));

        // Validar o conteúdo
        assertEquals("Hello World!", dynamicPage.loadedText.getText());
    }

}
