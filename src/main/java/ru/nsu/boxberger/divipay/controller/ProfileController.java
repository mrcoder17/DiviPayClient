package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.service.ProfileService;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class ProfileController extends BaseController{

    private final ProfileService profileService;

    private ProfileModel profileModel = ProfileModel.getInstance();

    public ProfileController (){
        this.profileService = new ProfileService();
    }

    @FXML
    public TextField updateNameFiled;
    @FXML
    public TextField updateUsernameFiled;
    @FXML
    public TextField updatePhoneFiled;
    @FXML
    public TextField avatarField;
    @FXML
    public PasswordField updatePasswordField;
    @FXML
    public PasswordField confirmPasswordField;

    @FXML
    public Label timeLabel;
    @FXML
    public Label dateLabel;

    @FXML
    public Label nameField;
    @FXML
    public Label usernameField;
    @FXML
    public Label phoneField;
    @FXML
    public Label passwordNotCorrects;

    @FXML
    private ImageView avatarImage;

    @FXML
    private Button applyNameButton;
    @FXML
    private Button applyUsernameButton;
    @FXML
    private Button applyPhoneButton;

    @FXML
    private Button updateNameButton;
    @FXML
    private Button updatePhoneButton;
    @FXML
    private Button updateUsernameButton;

    @FXML
    private void initialize() {
        loadProfileData();
        loadDateTime(dateLabel, timeLabel);
    }

    private void loadProfileData() {
        nameField.setText(profileModel.getName());
        phoneField.setText(profileModel.getPhone());
        usernameField.setText(profileModel.getUsername());
        loadImage(avatarImage, profileModel.getAvatar());
    }

    public void loadImage (ImageView avatarImage, String url){
        Image image = new Image(url);
        avatarImage.setFitHeight(390);
        avatarImage.setFitWidth(390);
        avatarImage.setPreserveRatio(true);
        avatarImage.setImage(image);
    }

    @FXML
    public void updateName(MouseEvent mouseEvent) {
        nameField.setVisible(false);
        updateNameButton.setVisible(false);
        updateNameFiled.setText(profileModel.getName());
        updateNameFiled.setVisible(true);
        applyNameButton.setVisible(true);
    }

    @FXML
    private void updateUsername(MouseEvent mouseEvent) {
        usernameField.setVisible(false);
        updateUsernameButton.setVisible(false);
        updateUsernameFiled.setText(profileModel.getUsername());
        updateUsernameFiled.setVisible(true);
        applyUsernameButton.setVisible(true);
    }

    @FXML
    private void updatePhone(MouseEvent mouseEvent) {
        phoneField.setVisible(false);
        updatePhoneButton.setVisible(false);
        updatePhoneFiled.setText(profileModel.getPhone());
        updatePhoneFiled.setVisible(true);
        applyPhoneButton.setVisible(true);
    }

    @FXML
    public void applyName(MouseEvent mouseEvent) {
        String newName = updateNameFiled.getText();
        profileModel.setName(newName);
        profileService.updateProfileData(profileModel.getUserID(), profileModel);
        updateNameFiled.setVisible(false);
        updateNameFiled.setText("");
        nameField.setVisible(true);
        updateNameButton.setVisible(true);
        applyNameButton.setVisible(false);
        nameField.setText(newName);
    }

    @FXML
    public void applyUsername(MouseEvent mouseEvent) {
        String newUsername = updateUsernameFiled.getText();
        profileModel.setUsername(newUsername);
        profileService.updateProfileData(profileModel.getUserID(), profileModel);
        updateUsernameFiled.setVisible(false);
        applyUsernameButton.setVisible(false);
        updateUsernameFiled.setText("");
        usernameField.setVisible(true);
        updateUsernameButton.setVisible(true);
        usernameField.setText(newUsername);
    }

    @FXML
    public void applyPhone(MouseEvent mouseEvent) {
        String newPhone = updatePhoneFiled.getText();
        profileModel.setPhone(newPhone);
        profileService.updateProfileData(profileModel.getUserID(), profileModel);
        updatePhoneFiled.setVisible(false);
        applyPhoneButton.setVisible(false);
        updatePhoneFiled.setText("");
        phoneField.setVisible(true);
        updatePhoneButton.setVisible(true);
        phoneField.setText(newPhone);
//        loadProfileData();
    }

    @FXML
    public void applyNewPassword(MouseEvent mouseEvent) {
        String newPassword = updatePasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (newPassword.equals(confirmPassword)){
            profileModel.setPassword(newPassword);
            profileService.updateProfileData(profileModel.getUserID(), profileModel);
            passwordNotCorrects.setVisible(false);
            updatePasswordField.setText("");
            confirmPasswordField.setText("");
        } else {
            passwordNotCorrects.setVisible(true);
        }
    }
    public void applyNewAvatar(MouseEvent mouseEvent) {
        String newAvatar = avatarField.getText();
        loadImage(avatarImage, newAvatar);
        profileModel.setAvatar(newAvatar);
        profileService.updateProfileData(profileModel.getUserID(), profileModel);
        avatarField.setText("");
    }

    @FXML
    private void goToMainPage() {
        goToPage(ResourcesPaths.MAINPAGE_PATH);
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
