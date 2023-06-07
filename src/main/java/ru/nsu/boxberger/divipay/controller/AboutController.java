package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class AboutController extends BaseController {

    private final ProfileModel profileModel = ProfileModel.getInstance();

    @FXML
    private Label usernameField;
    @FXML
    private ImageView avatarImage;
    @FXML
    private Label timeLabel;
    @FXML
    private Label dateLabel;

    @FXML
    Label descriptionLabel;

    public String getDescription() {
        try {
            InputStream inputStream = getClass().getResourceAsStream(ResourcesPaths.DESCRIPTION_PATH);
            if (inputStream != null) {
                return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            } else {
                return "Failed to load description.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to load description.";
        }
    }

    @FXML
    private void initialize() {
        BaseController.getInstance().initializeLabels(dateLabel, timeLabel);
        if (profileModel.getName() == null) {
            usernameField.setText(profileModel.getUsername());
        } else {
            usernameField.setText(profileModel.getName());
        }
        if (profileModel.getAvatar() != null)
            loadImage(avatarImage, profileModel.getAvatar());
    }

    @FXML
    private void goToMainPage() {
        goToPage(ResourcesPaths.MAINPAGE_PATH);
    }

    @FXML
    private void goToProfile() {
        goToPage(ResourcesPaths.PROFILE_PATH);
    }

    @FXML
    private void goToRequests() {
        goToPage(ResourcesPaths.REQUESTS_PATH);
    }

    @FXML
    private void goToPurchases() {
        goToPage(ResourcesPaths.PURCHASES_PATH);
    }

    @FXML
    private void goToContacts() {
        goToPage(ResourcesPaths.CONTACTS_PATH);
    }
}
