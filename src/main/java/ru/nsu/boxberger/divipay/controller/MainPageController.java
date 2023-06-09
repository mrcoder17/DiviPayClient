package ru.nsu.boxberger.divipay.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.model.PurchaseModel;
import ru.nsu.boxberger.divipay.model.RequestModel;
import ru.nsu.boxberger.divipay.model.UserRequest;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

public class MainPageController extends BaseController {

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
    private ObservableList<RequestModel> requests;
    private ObservableList<PurchaseModel> purchases;

    @FXML
    private ListView<UserRequest> userListView;
    @FXML
    private ListView<RequestModel> requestsListView;
    @FXML
    private ListView<PurchaseModel> purchasesListView;

    @FXML
    private void initialize() {
        BaseController.getInstance().initializeLabels(dateLabel, timeLabel);

        loadUsersFromServer(connectedUsers, userListView);
        loadPurchasesFromServer(purchases, purchasesListView);
        loadRequestsFromServer(requests, requestsListView);
        if (profileModel.getName() == null) {
            usernameField.setText(profileModel.getUsername());
        } else {
            usernameField.setText(profileModel.getName());
        }
        if (profileModel.getAvatar() != null) {
            loadImage(avatarImage, profileModel.getAvatar());
        }
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


