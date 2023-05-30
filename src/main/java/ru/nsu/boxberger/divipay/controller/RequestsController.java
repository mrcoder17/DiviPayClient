package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

public class RequestsController extends BaseController{
    @FXML
    private void goToMainPage() {
        goToPage(ResourcesPaths.MAINPAGE_PATH, new MainPageController());
    }

    @FXML
    private void goToProfile() {
        goToPage(ResourcesPaths.PROFILE_PATH, new ProfileController());
    }

    @FXML
    private void goToPurchases() {
        goToPage(ResourcesPaths.PURCHASES_PATH, new PurchasesController());
    }

    @FXML
    private void goToContacts() {
        goToPage(ResourcesPaths.CONTACTS_PATH, new ContactsController());
    }

    @FXML
    private void goToAbout() {
        goToPage(ResourcesPaths.ABOUT_PATH, new ContactsController());
    }
}