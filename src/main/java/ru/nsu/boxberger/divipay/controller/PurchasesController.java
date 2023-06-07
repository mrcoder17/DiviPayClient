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
import ru.nsu.boxberger.divipay.model.PaymentModel;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.model.PurchasesModel;
import ru.nsu.boxberger.divipay.service.PurchasesService;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

public class PurchasesController extends BaseController{

    private final ProfileModel profileModel = ProfileModel.getInstance();
    private final PurchasesService purchasesService;
    public Button addPurchaseButton;
    public HBox fieldNewPurchasePane;
    public TextField newNameField;
    public TextField newPriceField;
    public TextField newQuantityField;
    public HBox updateFieldsPane;
    public TextField updateIdField;
    public TextField updateNameField;
    public TextField updatePriceField;
    public TextField updateQuantityField;
    public HBox payingFieldsPane;
    public TextField payingIdField;
    public HBox buttonsPane;
    public Button editPurchaseButton;
    public Button payingPurchaseButton;


    public PurchasesController (){
        this.purchasesService = new PurchasesService();
    }

    @FXML
    private Label usernameField;
    @FXML
    private ImageView avatarImage;
    @FXML
    private Label timeLabel;
    @FXML
    private Label dateLabel;

    public Label nameErrorLabel;
    public Label priceErrorLabel;

    private ObservableList<String> connectedUsers;
    private ObservableList<PurchasesModel> purchases;

    @FXML
    private ListView<String> userListView;
    @FXML
    private ListView<PurchasesModel> purchasesListView;

    @FXML
    private void initialize() {
        if (profileModel.getName() == null) {
            usernameField.setText(profileModel.getUsername());
        } else {
            usernameField.setText(profileModel.getName());
        }
        loadImage(avatarImage, profileModel.getAvatar());

        loadUsersFromServer(connectedUsers, userListView);
        loadPurchasesFromServer(purchases, purchasesListView);
        loadDateTime(dateLabel, timeLabel);
    }


    @FXML
    public void applyNewPurchase(MouseEvent mouseEvent) {
        PurchasesModel newPurchase = new PurchasesModel();
        newPurchase.setItemName(checkNameField(newNameField.getText()));
        newPurchase.setPrice(checkDoubleField(newPriceField.getText()));
        newPurchase.setQuantity(checkLongField(newQuantityField.getText()));

        if ((newPurchase.getItemName() != null) && (newPurchase.getPrice() != null)){
            newPurchase.setUserID(profileModel.getUserID());
            purchasesService.createPurchase(newPurchase);
            fieldNewPurchasePane.setVisible(false);
            addPurchaseButton.setVisible(true);
            loadPurchasesFromServer(purchases, purchasesListView);
        }
    }

    public void applyUpdatePurchase(MouseEvent mouseEvent) {
        PurchasesModel updatePurchase = new PurchasesModel();
        updatePurchase.setPurchaseID(checkLongField(updateIdField.getText()));
        updatePurchase.setItemName(checkNameField(updateNameField.getText()));
        updatePurchase.setPrice(checkDoubleField(updatePriceField.getText()));
        updatePurchase.setQuantity(checkLongField(updateQuantityField.getText()));

        if ((updatePurchase.getPurchaseID() != null) && (updatePurchase.getItemName() != null) && (updatePurchase.getPrice() != null)){
            updatePurchase.setUserID(profileModel.getUserID());
            purchasesService.updatePurchase(updatePurchase);
            updateFieldsPane.setVisible(false);
            editPurchaseButton.setVisible(true);
            loadPurchasesFromServer(purchases, purchasesListView);
        }
    }

    public void applyBuyingPurchase(MouseEvent mouseEvent) {
        PaymentModel payment = new PaymentModel();
        payment.setPurchaseID(checkLongField(payingIdField.getText()));

        if (payment.getPurchaseID() != null){
            payment.setUserID(profileModel.getUserID());
            purchasesService.createPayment(payment);
            payingFieldsPane.setVisible(false);
            payingPurchaseButton.setVisible(true);
            loadPurchasesFromServer(purchases, purchasesListView);
        }
    }

    public void editPurchase(MouseEvent mouseEvent) {
        editPurchaseButton.setVisible(false);
        updateFieldsPane.setVisible(true);
    }

    public void payingPurchase(MouseEvent mouseEvent) {
        payingPurchaseButton.setVisible(false);
        payingFieldsPane.setVisible(true);
    }

    public void addNewPurchase(MouseEvent mouseEvent) {
        addPurchaseButton.setVisible(false);
        fieldNewPurchasePane.setVisible(true);
    }

    public String checkNameField(String field){
        if (!field.isEmpty()){
            return field;
        } else {
            return null;
        }
    }

    public Double checkDoubleField(String field){
        try {
            if (!field.isEmpty())
                return Double.parseDouble(field);
        } catch (NumberFormatException e) {
            return null;
        }
        return null;
    }

    public Long checkLongField(String field){
        try {
            if (!field.isEmpty())
                return Long.parseLong(field);
        } catch (NumberFormatException e) {
            return null;
        }
        return null;
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
    private void goToContacts() {
        goToPage(ResourcesPaths.CONTACTS_PATH);
    }

    @FXML
    private void goToAbout() {
        goToPage(ResourcesPaths.ABOUT_PATH);
    }
}
