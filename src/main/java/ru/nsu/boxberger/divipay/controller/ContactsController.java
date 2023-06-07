package ru.nsu.boxberger.divipay.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.model.UserRequest;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

public class ContactsController extends BaseController{
    private final ProfileModel profileModel = ProfileModel.getInstance();

    @FXML
    private Label usernameField;
    @FXML
    private ImageView avatarImage;
    @FXML
    private Label timeLabel;
    @FXML
    private Label dateLabel;


    private ObservableList<UserRequest> connectedUsers;
    @FXML
    private ListView<UserRequest> contactsListView;

    @FXML
    private void initialize() {
        if (profileModel.getName() == null) {
            usernameField.setText(profileModel.getUsername());
        } else {
            usernameField.setText(profileModel.getName());
        }        loadImage(avatarImage, profileModel.getAvatar());

        loadUsersFromServer(connectedUsers, contactsListView);
        BaseController.getInstance().initializeLabels(dateLabel, timeLabel);
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
    private void goToAbout() {
        goToPage(ResourcesPaths.ABOUT_PATH);
    }
}
