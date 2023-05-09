package ru.nsu.boxberger.divipay.requests;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.nsu.boxberger.divipay.MainApp;
import ru.nsu.boxberger.divipay.about.AboutController;
import ru.nsu.boxberger.divipay.contacts.ContactsController;
import ru.nsu.boxberger.divipay.purchases.PurchasesController;
import ru.nsu.boxberger.divipay.mainpage.MainPageController;
import ru.nsu.boxberger.divipay.profile.ProfileController;

public class RequestsController {

    @FXML
    private Label aboutButton;

    @FXML
    private Label contactsButton;

    @FXML
    private Label mainpageButton;

    @FXML
    private Label profileButton;

    @FXML
    private Label purchasesButton;

    @FXML
    private Label requestsButton;

    @FXML
    void initialize() {
        assert aboutButton != null : "fx:id=\"aboutButton\" was not injected: check your FXML file 'requests.fxml'.";
        assert contactsButton != null : "fx:id=\"contactsButton\" was not injected: check your FXML file 'requests.fxml'.";
        assert mainpageButton != null : "fx:id=\"mainpageButton\" was not injected: check your FXML file 'requests.fxml'.";
        assert profileButton != null : "fx:id=\"profileButton\" was not injected: check your FXML file 'requests.fxml'.";
        assert purchasesButton != null : "fx:id=\"purchasesButton\" was not injected: check your FXML file 'requests.fxml'.";
        assert requestsButton != null : "fx:id=\"requestsButton\" was not injected: check your FXML file 'requests.fxml'.";

    }
    @FXML
    private void goToMainPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/nsu/boxberger/divipay/mainpage.fxml"));
        Parent root = fxmlLoader.load();
        MainPageController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = MainApp.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToProfile() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/nsu/boxberger/divipay/profile.fxml"));
        Parent root = fxmlLoader.load();
        ProfileController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = MainApp.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToPurchases() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/nsu/boxberger/divipay/purchases.fxml"));
        Parent root = fxmlLoader.load();
        PurchasesController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = MainApp.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToContacts() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/nsu/boxberger/divipay/contacts.fxml"));
        Parent root = fxmlLoader.load();
        ContactsController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = MainApp.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToAbout() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/nsu/boxberger/divipay/about.fxml"));
        Parent root = fxmlLoader.load();
        AboutController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = MainApp.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }

}
