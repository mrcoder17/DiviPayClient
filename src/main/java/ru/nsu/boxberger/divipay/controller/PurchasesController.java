package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

public class PurchasesController extends BaseController{
    @FXML
    private void goToMainPage() {
        goToPage(ResourcesPaths.MAINPAGE_PATH);
    }

    @FXML
    private void goToProfile() {
        goToPage(ResourcesPaths.PROFILE_PATH);
    }

    @FXML
    private void goToRequests() {
        goToPage(ResourcesPaths.REQUESTS_PATH);
    }

    @FXML
    private void goToContacts() {
        goToPage(ResourcesPaths.CONTACTS_PATH);
    }

    @FXML
    private void goToAbout() {
        goToPage(ResourcesPaths.ABOUT_PATH);
    }
}
