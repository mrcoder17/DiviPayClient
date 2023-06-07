package ru.nsu.boxberger.divipay.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.model.RequestsModel;
import ru.nsu.boxberger.divipay.model.UserRequest;
import ru.nsu.boxberger.divipay.service.RequestsService;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

public class RequestsController extends BaseController {

    private final ProfileModel profileModel = ProfileModel.getInstance();
    private final RequestsService requestsService;
    public Button addRequestButton;
    public HBox fieldPane;
    public TextField nameRequestField;
    public TextField quantityRequestField;
    public Label nameErrorLabel;
    public Label priceErrorLabel;

    public RequestsController() {
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

    private ObservableList<UserRequest> connectedUsers;
    private ObservableList<RequestsModel> requests;

    @FXML
    private ListView<UserRequest> userListView;
    @FXML
    private ListView<RequestsModel> requestsListView;

    @FXML
    private void initialize() {
        if (profileModel.getName() == null) {
            usernameField.setText(profileModel.getUsername());
        } else {
            usernameField.setText(profileModel.getName());
        }
        loadImage(avatarImage, profileModel.getAvatar());

        loadUsersFromServer(connectedUsers, userListView);
        loadRequestsFromServer(requests, requestsListView);
        BaseController.getInstance().initializeLabels(dateLabel, timeLabel);
    }

    @FXML
    public void applyNewRequest(MouseEvent mouseEvent) {
        RequestsModel newRequest = new RequestsModel();
        fillingNameField(newRequest);
        fillingQuantityField(newRequest);
        if (newRequest.getItemName() != null) {
            newRequest.setUserID(profileModel.getUserID());
            requestsService.createRequest(newRequest);
            fieldPane.setVisible(false);
            addRequestButton.setVisible(true);
            loadRequestsFromServer(requests, requestsListView);
        }
    }

    public void fillingNameField(RequestsModel Request) {
        if (!nameRequestField.getText().isEmpty()) {
            Request.setItemName(nameRequestField.getText());
            nameErrorLabel.setVisible(false);
        } else {
            nameErrorLabel.setVisible(true);
        }
    }

    public void fillingQuantityField(RequestsModel Request) {
        try {
            if (!quantityRequestField.getText().isEmpty())
                Request.setQuantity(Integer.parseInt(quantityRequestField.getText()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addNewRequest(MouseEvent mouseEvent) {
        addRequestButton.setVisible(false);
        fieldPane.setVisible(true);
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