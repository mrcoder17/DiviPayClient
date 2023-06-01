package ru.nsu.boxberger.divipay.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.model.ProfileRequest;
import ru.nsu.boxberger.divipay.service.MainPageService;
import ru.nsu.boxberger.divipay.utils.ResourcesPaths;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainPageController extends BaseController{

    private final ProfileModel profileModel = ProfileModel.getInstance();
    private final MainPageService mainPageService;

    public MainPageController (){
        this.mainPageService = new MainPageService();
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
    private ListView<String> userListView;

    private ObservableList<String> connectedUsers;



    @FXML
    private void initialize() {
        connectedUsers = FXCollections.observableArrayList();
        userListView.setItems(connectedUsers);

        List<String> userList = getUsersFromServer();
        connectedUsers.addAll(userList);

        userListView.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String username, boolean empty){
                super.updateItem(username, empty);
                if (empty || username == null){
                    setText(null);
                } else {
                    setText(username);
                }
            }
        });

        usernameField.setText(profileModel.getUsername());
        loadDefaultImage();
        loadDateTime();
    }

    private List<String>  getUsersFromServer(){
        try {
            return mainPageService.getUsernamesFromServer();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void loadDateTime(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            updateTime();
            updateData();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = now.format(formatter);
        timeLabel.setText(formattedTime);
    }

    private void updateData(){
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE, d MMM");
        String formattedDate = now.format(formatter);
        dateLabel.setText(formattedDate);
    }

    private void loadDefaultImage (){
        Image image = new Image(ServerUrls.DEFAULT_PROFILE_IMAGE_URL);
        avatarImage.setFitHeight(40);
        avatarImage.setFitWidth(40);
        avatarImage.setPreserveRatio(true);
        avatarImage.setImage(image);

        Circle clipCircle = new Circle (20);
        clipCircle.setCenterX(20);
        clipCircle.setCenterY(20);

        avatarImage.setClip(clipCircle);
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


