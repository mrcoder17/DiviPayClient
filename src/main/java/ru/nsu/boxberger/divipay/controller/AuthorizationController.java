package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import ru.nsu.boxberger.divipay.service.AuthorizationService;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;


public class AuthorizationController extends BaseController{
    private final AuthorizationService authorizationService = new AuthorizationService();
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
            authorizationService.login(username, password);
            goToMainPage();
        });
        registrationButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            authorizationService.registration(username, password);
            goToMainPage();
        });
    }

    public void goToMainPage() {
        goToPage(ResourcesPaths.MAINPAGE_PATH);
    }

}

