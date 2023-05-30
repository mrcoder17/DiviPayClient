package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import ru.nsu.boxberger.divipay.model.ProfileData;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.service.ProfileService;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileController extends BaseController{
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Button updateButton;
    @FXML
    private ListView<String> userList;

    private ProfileService profileService;

    @FXML
    private void initialize(){
//        loadUsernames();
//        ProfileData profileData = profileService.getProfileData();
//        nameLabel.setText(profileData.getName());
    }

    private void loadUsernames(){
        List<ProfileModel> profiles = profileService.getAllUsers;
        List<String> usernames = profiles.stream()
                .map(ProfileModel::getName)
                .collect(Collectors.toList());

        userList.getItems().addAll(usernames);
    }

    @FXML
    private void goToMainPage() {
        goToPage("/ru/nsu/boxberger/divipay/mainpage/mainpage.fxml", new MainPageController());
    }

    @FXML
    private void goToRequests() {
        goToPage("/ru/nsu/boxberger/divipay/request/requests.fxml", new RequestsController());
    }

    @FXML
    private void goToPurchases() {
        goToPage("/ru/nsu/boxberger/divipay/purchase/purchases.fxml", new PurchasesController());
    }

    @FXML
    private void goToContacts() {
        goToPage("/ru/nsu/boxberger/divipay/contacts/contacts.fxml", new ContactsController());
    }
    @FXML
    private void goToAbout() {
        goToPage("/ru/nsu/boxberger/divipay/about/about.fxml", new AboutController());
    }
}
