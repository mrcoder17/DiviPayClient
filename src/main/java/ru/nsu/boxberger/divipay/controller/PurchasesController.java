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
import ru.nsu.boxberger.divipay.service.PurchasesService;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;

public class PurchasesController extends BaseController{

    private final ProfileModel profileModel = ProfileModel.getInstance();
    private final PurchasesService purchasesService;
    public Button addPurchaseButton;
    public HBox fieldPane;


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
    @FXML
    private TextField nameNewPurchasesField;
    @FXML
    private TextField priceNewPurchasesField;
    @FXML
    private TextField quantityNewPurchasesField;

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
        usernameField.setText(profileModel.getUsername());
        loadImage(avatarImage, profileModel.getAvatar());

        loadUsersFromServer(connectedUsers, userListView);
        loadPurchasesFromServer(purchases, purchasesListView);
        loadDateTime(dateLabel, timeLabel);
    }


    @FXML
    public void applyNewPurchase(MouseEvent mouseEvent) {
        PurchasesModel newPurchase = new PurchasesModel();
        fillingNameField(newPurchase);
        fillingPriceField(newPurchase);
        fillingQuantityField(newPurchase);
        if ((newPurchase.getItemName() != null) && (newPurchase.getPrice() != null)){
            newPurchase.setUserID(profileModel.getUserID());
            purchasesService.createPurchase(newPurchase);
            fieldPane.setVisible(false);
            addPurchaseButton.setVisible(true);
            loadPurchasesFromServer(purchases, purchasesListView);
        }
    }

    public void fillingNameField(PurchasesModel purchase){
        if (!nameNewPurchasesField.getText().isEmpty()){
            purchase.setItemName(nameNewPurchasesField.getText());
            nameErrorLabel.setVisible(false);
        } else {
            nameErrorLabel.setVisible(true);
        }
    }

    public void fillingPriceField(PurchasesModel purchase){
        try {
            if (!priceNewPurchasesField.getText().isEmpty())
                purchase.setPrice(Double.parseDouble(priceNewPurchasesField.getText()));
            nameErrorLabel.setVisible(false);
        } catch (NumberFormatException e) {
            priceErrorLabel.setVisible(true);
        }
    }

    public void fillingQuantityField(PurchasesModel purchase){
        try {
            if (!quantityNewPurchasesField.getText().isEmpty())
                purchase.setQuantity(Integer.parseInt(quantityNewPurchasesField.getText()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addNewPurchase(MouseEvent mouseEvent) {
        addPurchaseButton.setVisible(false);
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
