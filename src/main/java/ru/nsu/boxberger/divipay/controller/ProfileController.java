package ru.nsu.boxberger.divipay.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ru.nsu.boxberger.divipay.model.ProfileData;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.service.ProfileService;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class ProfileController extends BaseController{
    @FXML
    private Label nameLabel;
    @FXML
    private Button updateButton;
    @FXML
    private ListView<String> userList;

    @FXML
    private ImageView avatarImage;

    private ProfileService profileService;

    @FXML
    private void initialize() {
        Image image = new Image(ServerUrls.DEFAULT_PROFILE_IMAGE_URL);
        avatarImage.setImage(image);
        avatarImage.setFitHeight(400);
        avatarImage.setFitWidth(400);
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
        goToPage(ResourcesPaths.MAINPAGE_PATH, new MainPageController());
    }

    @FXML
    private void goToRequests() {
        goToPage(ResourcesPaths.REQUESTS_PATH, new RequestsController());
    }

    @FXML
    private void goToPurchases() {
        goToPage(ResourcesPaths.PURCHASES_PATH, new PurchasesController());
    }

    @FXML
    private void goToContacts() {
        goToPage(ResourcesPaths.CONTACTS_PATH, new ContactsController());
    }

    @FXML
    private void goToAbout() {
        goToPage(ResourcesPaths.ABOUT_PATH, new ContactsController());
    }
}
