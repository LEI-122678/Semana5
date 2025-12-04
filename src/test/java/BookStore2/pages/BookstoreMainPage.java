package BookStore2.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BookstoreMainPage {

    public BookstoreMainPage openAdmin() {
        // Botão real no Vaadin Bookstore
        SelenideElement adminButton =
                $x("//a[@class='menu-link' and contains(., 'Admin')]");

        adminButton.shouldBe(visible).click();
        return this;
    }

}