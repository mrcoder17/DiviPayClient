package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class AboutController extends BaseController{
    @FXML
    Label descriptionLabel;

    public String getDescription() {
        try {
            InputStream inputStream = getClass().getResourceAsStream(ResourcesPaths.DESCRIPTION_PATH);
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
        goToPage(ResourcesPaths.MAINPAGE_PATH, new MainPageController());
    }

    @FXML
    private void goToProfile() {
        goToPage(ResourcesPaths.PROFILE_PATH, new ProfileController());
    }

    @FXML
    private void goToRequests() {
        goToPage(ResourcesPaths.REQUESTS_PATH, new RequestsController());
    }

    @FXML
    private void goToPurchases() {
        goToPage(ResourcesPaths.PURCHASES_PATH, new PurchasesController());
    }

    @FXML
    private void goToContacts() {
        goToPage(ResourcesPaths.CONTACTS_PATH, new ContactsController());
    }
}
