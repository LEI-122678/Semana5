package BookStore2.test;


import BookStore2.pages.AdminPage;
import BookStore2.pages.BookstoreMainPage;
import BookStore2.pages.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Epic("Bookstore")
@Feature("Gestão de Livros")
public class bookStoreAddCategoryTest {

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

    @Test
    @Story("Adicionar nova categoria com sucesso")
    void AdicionarNovaCategoria() {
        String titulo = "Teste Selenium";

        // 1) Login como admin
        LoginPage loginPage = new LoginPage().openPage();
        loginPage.loginAsAdmin();

        // 2) Abrir página admin
        BookstoreMainPage mainPage2 = new BookstoreMainPage();
        mainPage2.openAdmin();

        // 3) Preencher formulário e guardar
        AdminPage form = new AdminPage()
                .setCategoryName("Teste Selenium");
        form.save();

        // 4) Verificar se a categoria aparece na lista
        form.shouldContainCategoryWithTitle(titulo);
    }
}