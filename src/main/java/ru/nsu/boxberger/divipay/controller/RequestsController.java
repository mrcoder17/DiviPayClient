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
import ru.nsu.boxberger.divipay.model.PurchasesModel;
import ru.nsu.boxberger.divipay.model.RequestsModel;
import ru.nsu.boxberger.divipay.model.UserRequest;
import ru.nsu.boxberger.divipay.service.RequestsService;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

public class RequestsController extends BaseController {

    private final ProfileModel profileModel = ProfileModel.getInstance();
    private final RequestsService requestsService;

    @FXML
    private Button addNewRequestButton;

    @FXML
    private TextField nameNewRequestField;

    @FXML
    private TextField quantityNewRequestField;

    @FXML
    private Label nameErrorLabel;

    @FXML
    private Label priceErrorLabel;

    @FXML
    private HBox fieldNewPurchasePane;

    @FXML
    private HBox updateFieldsPane;

    @FXML
    private TextField requestIdField;

    @FXML
    private TextField requestPriceField;

    @FXML
    private Button createPurchaseButton;

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
    public void applyNewRequest() {
        RequestsModel newRequest = new RequestsModel();
        newRequest.setItemName(checkNameField(nameNewRequestField.getText()));
        newRequest.setQuantity(checkLongField(quantityNewRequestField.getText()));

        if (newRequest.getItemName() != null) {
            newRequest.setUserID(profileModel.getUserID());
            requestsService.createRequest(newRequest);
            fieldNewPurchasePane.setVisible(false);
            addNewRequestButton.setVisible(true);
            loadRequestsFromServer(requests, requestsListView);
        }
    }

    public void applyCreatingPurchase(){
        PurchasesModel newPurchase = new PurchasesModel();

        RequestsModel delRequest = requestsService.getRequestById(checkLongField(requestIdField.getText()));

        newPurchase.setItemName(delRequest.getItemName());
        newPurchase.setPrice(checkDoubleField(requestPriceField.getText()));
        newPurchase.setUserID(profileModel.getUserID());

        if ((newPurchase.getItemName() != null) && (newPurchase.getPrice() != null)) {
            requestsService.deleteRequest(delRequest);
            requestsService.createPurchaseFromRequest(newPurchase);

            fieldNewPurchasePane.setVisible(false);
            createPurchaseButton.setVisible(true);

            loadRequestsFromServer(requests, requestsListView);
        }
    }


    public String checkNameField(String field) {
        if (!field.isEmpty()) {
            return field;
        } else {
            return null;
        }
    }

    public Long checkLongField(String field) {
        try {
            if (!field.isEmpty()) return Long.parseLong(field);
        } catch (NumberFormatException e) {
            return null;
        }
        return null;
    }

    public Double checkDoubleField(String field) {
        try {
            if (!field.isEmpty()) return Double.parseDouble(field);
        } catch (NumberFormatException e) {
            return null;
        }
        return null;
    }

    @FXML
    public void addNewRequest() {
        addNewRequestButton.setVisible(false);
        fieldNewPurchasePane.setVisible(true);
    }

    @FXML
    public void createPurchaseFromRequest() {
        createPurchaseButton.setVisible(false);
        updateFieldsPane.setVisible(true);
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