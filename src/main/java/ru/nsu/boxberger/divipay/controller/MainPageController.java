package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;

public class MainPageController extends BaseController{
    @FXML
    private void goToProfile() {
        goToPage("/ru/nsu/boxberger/divipay/profile/profile.fxml", new ProfileController());
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
    private void goToAbout() {
        goToPage("/ru/nsu/boxberger/divipay/about/about.fxml", new AboutController());
    }
}


