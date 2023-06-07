package ru.nsu.boxberger.divipay.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.model.PurchasesModel;
import ru.nsu.boxberger.divipay.model.RequestsModel;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class MainPageController extends BaseController{

    private final ProfileModel profileModel = ProfileModel.getInstance();

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
    private ObservableList<PurchasesModel> purchases;

    @FXML
    private ListView<String> userListView;
    @FXML
    private ListView<RequestsModel> requestsListView;
    @FXML
    private ListView<PurchasesModel> purchasesListView;

    @FXML
    private void initialize() {

        loadUsersFromServer(connectedUsers, userListView);
        loadPurchasesFromServer(purchases, purchasesListView);
        loadRequestsFromServer(requests, requestsListView);
        loadDateTime(dateLabel, timeLabel);
        if (profileModel.getName() == null) {
            usernameField.setText(profileModel.getUsername());
        } else {
            usernameField.setText(profileModel.getName());
        }
        if (profileModel.getAvatar() != null)
            loadImage(avatarImage, profileModel.getAvatar());
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

    @FXML
    private void goToAbout() {
        goToPage(ResourcesPaths.ABOUT_PATH);
    }
}


