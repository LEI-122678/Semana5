package bookstore.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BookstoreMainPage {

    public BookstoreMainPage clickNewBook() {

        // Botão real no Vaadin Bookstore
        SelenideElement newProductButton =
                $x("//vaadin-button[contains(., 'New product')]");

        newProductButton.shouldBe(visible).click();
        return this;
    }

    public void shouldContainBookWithTitle(String title) {
        $("vaadin-grid").shouldHave(text(title));
    }
}
