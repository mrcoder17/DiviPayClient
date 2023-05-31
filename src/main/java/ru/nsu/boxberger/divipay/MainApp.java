package ru.nsu.boxberger.divipay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.boxberger.divipay.controller.AuthorizationController;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

public class MainApp extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainApp.primaryStage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ResourcesPaths.LOGIN_PATH));
        Parent root = fxmlLoader.load();

        AuthorizationController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(ResourcesPaths.STYLES_PATH).toExternalForm());
        primaryStage.setTitle("DiviPay");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
