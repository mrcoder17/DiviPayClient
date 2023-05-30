package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class AboutController extends BaseController{
    @FXML
    Label descriptionLabel;

    public String getDescription() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/ru/nsu/boxberger/divipay/about/description.txt");
            if (inputStream != null) {
                return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            } else {
                return "Failed to load description.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to load description.";
        }
    }


    @FXML
    private void goToMainPage() {
        goToPage("/ru/nsu/boxberger/divipay/mainpage/mainpage.fxml", new MainPageController());
    }

    @FXML
    private void goToRequests() {
        goToPage("/ru/nsu/boxberger/divipay/request/requests.fxml", new RequestsController());
    }

    @FXML
    private void goToPurchases() {
        goToPage("/ru/nsu/boxberger/divipay/purchase/purchases.fxml", new PurchasesController());
    }

    @FXML
    private void goToContacts() {
        goToPage("/ru/nsu/boxberger/divipay/contacts/contacts.fxml", new ContactsController());
    }

    @FXML
    private void goToProfile() {
        goToPage("/ru/nsu/boxberger/divipay/profile/profile.fxml", new ProfileController());
    }
}
