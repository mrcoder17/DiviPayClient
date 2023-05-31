package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import ru.nsu.boxberger.divipay.service.AuthorizationService;
import ru.nsu.boxberger.divipay.model.AuthorizationRequest;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

import java.io.IOException;

public class AuthorizationController extends BaseController{
    private AuthorizationService apiClient = new AuthorizationService();
    public AuthorizationController(){}
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registrationButton;
    @FXML
    private void initialize() {
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            AuthorizationRequest authorizationRequest = new AuthorizationRequest(username, password);
            apiClient.login(authorizationRequest);
            goToMainPage();
        });
        registrationButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            AuthorizationRequest authorizationRequest = new AuthorizationRequest(username, password);
            apiClient.registration(authorizationRequest);
            goToMainPage();
        });
        setApiClient(apiClient);
    }

    public void goToMainPage() {
        goToPage(ResourcesPaths.MAINPAGE_PATH, new MainPageController());
    }

    public void setApiClient(AuthorizationService apiClient) {
        this.apiClient = apiClient;
    }
}

