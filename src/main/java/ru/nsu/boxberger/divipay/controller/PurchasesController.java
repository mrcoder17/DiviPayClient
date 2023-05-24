package ru.nsu.boxberger.divipay.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.nsu.boxberger.divipay.MainApp;

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
