package ru.nsu.boxberger.divipay;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.boxberger.divipay.service.AuthorizationService;
import ru.nsu.boxberger.divipay.controller.AuthorizationController;
//import ru.nsu.boxberger.divipay.controller.MainPageController;

public class MainApp extends Application {
    private static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainApp.primaryStage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/nsu/boxberger/divipay/login/login.fxml"));
        Parent root = fxmlLoader.load();
        AuthorizationController controller = fxmlLoader.getController();
        AuthorizationService apiClient = new AuthorizationService();
        controller.setApiClient(apiClient);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/ru/nsu/boxberger/divipay/styles/styles.css").toExternalForm());
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
