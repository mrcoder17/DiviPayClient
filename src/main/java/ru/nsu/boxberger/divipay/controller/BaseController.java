package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.boxberger.divipay.MainApp;

import java.io.IOException;

public class BaseController {
    protected void goToPage(String fxmlFile, Object controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = MainApp.getPrimaryStage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
