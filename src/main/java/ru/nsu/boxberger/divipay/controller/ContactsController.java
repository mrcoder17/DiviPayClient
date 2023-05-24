package ru.nsu.boxberger.divipay.controller;

import java.io.IOException;
import javafx.fxml.FXML;

public class ContactsController extends BaseController{
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
    private void goToPurchases() throws IOException {
        goToPage("/ru/nsu/boxberger/divipay/purchases.fxml", new PurchasesController());
    }

    @FXML
    private void goToAbout() throws IOException {
        goToPage("/ru/nsu/boxberger/divipay/about.fxml", new AboutController());
    }
}
