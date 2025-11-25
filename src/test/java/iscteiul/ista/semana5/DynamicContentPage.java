package iscteiul.ista.semana5;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicContentPage {

    // Botão para carregar conteúdo dinamicamente
    public SelenideElement startButton = $("#start button");

    // Elemento que aparece após carregamento
    public SelenideElement loadedText = $("#finish h4");

    // Elemento de status de carregamento
    public SelenideElement loadingIndicator = $("#loading");
}
