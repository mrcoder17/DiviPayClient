package ru.nsu.boxberger.divipay.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.model.RequestsModel;
import ru.nsu.boxberger.divipay.service.RequestsService;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

public class RequestsController extends BaseController{

    private final ProfileModel profileModel = ProfileModel.getInstance();
    private final RequestsService requestsService;

    public RequestsController (){
        this.requestsService = new RequestsService();
    }

    @FXML
    private Label usernameField;
    @FXML
    private ImageView avatarImage;
    @FXML
    private Label timeLabel;
    @FXML
    private Label dateLabel;

    private ObservableList<String> connectedUsers;
    private ObservableList<RequestsModel> requests;

    @FXML
    private ListView<String> userListView;
    @FXML
    private ListView<RequestsModel> requestsListView;

    @FXML
    private void initialize() {
        usernameField.setText(profileModel.getUsername());

        loadUsersFromServer(connectedUsers, userListView);
        loadRequestsFromServer(requests, requestsListView);
        loadDefaultImage(avatarImage);
        loadDateTime(dateLabel, timeLabel);
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
    private void goToPurchases() {
        goToPage(ResourcesPaths.PURCHASES_PATH);
    }

    @FXML
    private void goToContacts() {
        goToPage(ResourcesPaths.CONTACTS_PATH);
    }

    @FXML
    private void goToAbout() {
        goToPage(ResourcesPaths.ABOUT_PATH);
    }
}