package iscteiul.ista.semana5;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class FileUploadPage {

    private final SelenideElement uploadInput = $("#file-upload");
    private final SelenideElement submitButton = $("#file-submit");
    private final SelenideElement uploadedFiles = $("#uploaded-files");

    public void uploadFile(File file) {
        uploadInput.uploadFile(file);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void verifyUploadedFile(String expectedFileName) {
        uploadedFiles.shouldHave(com.codeborne.selenide.Condition.text(expectedFileName));
    }
}