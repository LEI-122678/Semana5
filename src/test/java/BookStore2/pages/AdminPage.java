package BookStore2.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.*;



import java.util.Objects;

public class AdminPage {

    public AdminPage setCategoryName(String name) {
        // Clique no botão para adicionar nova categoria
        SelenideElement addButton = $x("//vaadin-button[contains(.,'Add New Category')]");
        addButton.shouldBe(visible, enabled).click();

        SelenideElement categoryNameInput = $$(shadowCss("input", "vaadin-text-field"))
                .filter(visible)  // Somente visíveis
                .filter(enabled)  // Somente habilitados
                .last();         // Seleciona o ultimo campo encontrado

        categoryNameInput.setValue(name); // Insere o valor no campo

        return this;
    }

    public void save() {
        // Clique no corpo da tela para confirmar a ação
        $("body").click();
    }

    public void shouldContainCategoryWithTitle(String title) {

        ElementsCollection fields = $$("iron-list vaadin-text-field");

        boolean found = fields.stream()
                .map(f -> f.getAttribute("value"))
                .filter(Objects::nonNull)
                .anyMatch(v -> v.equalsIgnoreCase(title));

        if (!found) {
            throw new AssertionError("Categoria '" + title + "' não encontrada.");
        }
    }

}