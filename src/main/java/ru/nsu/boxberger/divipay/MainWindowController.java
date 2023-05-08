package ru.nsu.boxberger.divipay;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {
    @FXML
    private Label aboutButton;

    @FXML
    private void aboutButtonClick (ActionEvent event) throws IOException {
        goToAbout();
    }

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
        assert aboutButton != null : "fx:id=\"aboutButton\" was not injected: check your FXML file 'mainwindow.fxml'.";
        assert contactsButton != null : "fx:id=\"contactsButton\" was not injected: check your FXML file 'mainwindow.fxml'.";
        assert mainpageButton != null : "fx:id=\"mainpageButton\" was not injected: check your FXML file 'mainwindow.fxml'.";
        assert profileButton != null : "fx:id=\"profileButton\" was not injected: check your FXML file 'mainwindow.fxml'.";
        assert purchasesButton != null : "fx:id=\"purchasesButton\" was not injected: check your FXML file 'mainwindow.fxml'.";
        assert requestsButton != null : "fx:id=\"requestsButton\" was not injected: check your FXML file 'mainwindow.fxml'.";

    }
    @FXML
    private void goToProfile() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile.fxml"));
        Parent root = fxmlLoader.load();
        ProfileController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = MainApp.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToRequests() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("requests.fxml"));
        Parent root = fxmlLoader.load();
        RequestsController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = MainApp.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToPurchases() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("purchases.fxml"));
        Parent root = fxmlLoader.load();
        PurchasesController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = MainApp.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToContacts() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("contacts.fxml"));
        Parent root = fxmlLoader.load();
        ContactsController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = MainApp.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToAbout() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("about.fxml"));
        Parent root = fxmlLoader.load();
        AboutController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = MainApp.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }
}


