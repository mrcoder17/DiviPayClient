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
    public PasswordField updatePasswordField;
    @FXML
    public PasswordField confirmPasswordField;

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
        loadDefaultImage();
    }

    private void loadProfileData() {
        profileModel = profileService.getProfileData(profileModel.getUsername());
        if (profileModel.getName() != null){
            nameField.setText(profileModel.getName());
        }
        if (profileModel.getPhone() != null){
            phoneField.setText(profileModel.getPhone());
        }
        if (profileModel.getUsername() != null){
            usernameField.setText(profileModel.getUsername());
        }
    }

    private void loadDefaultImage (){
        Image image = new Image(ServerUrls.DEFAULT_PROFILE_IMAGE_URL);
        avatarImage.setImage(image);
        avatarImage.setFitHeight(400);
        avatarImage.setFitWidth(400);
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
        profileService.updateProfileData(profileModel);
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
        profileService.updateProfileData(profileModel);
        updateUsernameFiled.setVisible(false);
        applyUsernameButton.setVisible(false);
        updateUsernameFiled.setText("");
        usernameField.setVisible(true);
        updateUsernameButton.setVisible(true);
        usernameField.setText(newUsername);
//        loadProfileData();
    }

    @FXML
    public void applyPhone(MouseEvent mouseEvent) {
        String newPhone = updatePhoneFiled.getText();
        profileModel.setPhone(newPhone);
        profileService.updateProfileData(profileModel);
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
            profileService.updateProfileData(profileModel);
            passwordNotCorrects.setVisible(false);
            updatePasswordField.setText("");
            confirmPasswordField.setText("");
        } else {
            passwordNotCorrects.setVisible(true);
        }
//        loadProfileData();
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
