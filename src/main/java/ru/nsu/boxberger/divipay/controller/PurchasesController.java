package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
public class PurchasesController extends BaseController{
    @FXML
    private void goToMainPage() {
        goToPage("/ru/nsu/boxberger/divipay/mainpage/mainpage.fxml", new MainPageController());
    }
    @FXML
    private void goToProfile() {
        goToPage("/ru/nsu/boxberger/divipay/profile/profile.fxml", new ProfileController());
    }
    @FXML
    private void goToRequests() {
        goToPage("/ru/nsu/boxberger/divipay/request/requests.fxml", new RequestsController());
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
