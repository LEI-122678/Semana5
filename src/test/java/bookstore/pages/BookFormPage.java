package bookstore.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.shadowCss;

public class BookFormPage {

    // input do primeiro vaadin-text-field => Product name
    private SelenideElement productNameInput() {
        return $$(shadowCss("input", "vaadin-text-field")).get(1);
    }

    // segundo => Price
    private SelenideElement priceInput() {
        return $$(shadowCss("input", "vaadin-text-field")).get(2);
    }

    // terceiro => In Stock
    private SelenideElement inStockInput() {
        return $$(shadowCss("input", "vaadin-text-field")).get(3);
    }

    public BookFormPage setProductName(String name) {
        productNameInput().shouldBe(visible).setValue(name);
        return this;
    }

    public BookFormPage setPrice(String price) {
        priceInput().shouldBe(visible).setValue(price);
        return this;
    }

    public BookFormPage setInStock(String qty) {
        inStockInput().shouldBe(visible).setValue(qty);
        return this;
    }

    public BookFormPage selectAvailability(String value) {
        // assume que só há um vaadin-select no formulário (o de Availability)
        SelenideElement availabilitySelect = $("vaadin-select");
        availabilitySelect.shouldBe(visible).click();

        // abre o dropdown e escolhe o vaadin-item com o texto desejado (ex: "Coming")
        $$("vaadin-item").findBy(text(value))
                .shouldBe(visible)
                .click();

        return this;
    }

    public BookFormPage selectCategory(String categoryText) {
        // assume que as categorias são vaadin-checkbox com o texto da categoria
        SelenideElement checkbox =
                $$("vaadin-checkbox").findBy(text(categoryText));
        checkbox.shouldBe(visible).click();
        return this;
    }

    public void save() {
        // Botão Save
        SelenideElement saveButton =
                $x("//vaadin-button[contains(.,'Save')]");
        saveButton.shouldBe(enabled).click();
    }
}
