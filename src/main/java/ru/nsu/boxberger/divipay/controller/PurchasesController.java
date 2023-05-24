package ru.nsu.boxberger.divipay.controller;

import java.io.IOException;
import javafx.fxml.FXML;
public class PurchasesController extends BaseController{
    @FXML
    private void goToMainPage() throws IOException {
        goToPage("/ru/nsu/boxberger/divipay/mainpage.fxml", new MainPageController());
    }
    @FXML
    private void goToProfile() throws IOException {
        goToPage("/ru/nsu/boxberger/divipay/profile.fxml", new ProfileController());
    }
    @FXML
    private void goToRequests() throws IOException {
        goToPage("/ru/nsu/boxberger/divipay/requests.fxml", new RequestsController());
    }

    @FXML
    private void goToContacts() throws IOException {
        goToPage("/ru/nsu/boxberger/divipay/contacts.fxml", new ContactsController());
    }
    @FXML
    private void goToAbout() throws IOException {
        goToPage("/ru/nsu/boxberger/divipay/about.fxml", new AboutController());
    }
}
