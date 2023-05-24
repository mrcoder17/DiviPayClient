package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.nsu.boxberger.divipay.api.LoginApiClient;
import ru.nsu.boxberger.divipay.model.LoginRequest;

import java.io.IOException;

public class LoginController extends BaseController{
    private LoginApiClient apiClient;
    public LoginController(){}
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private void initialize() {
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            LoginRequest loginRequest = new LoginRequest(username, password);
            apiClient.login(loginRequest);
            try {
                goToMainPage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void goToMainPage() throws IOException {
        goToPage("/ru/nsu/boxberger/divipay/mainpage.fxml", new MainPageController());
    }

    public void setApiClient(LoginApiClient apiClient) {
        this.apiClient = apiClient;
    }
}

