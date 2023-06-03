package ru.nsu.boxberger.divipay.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import ru.nsu.boxberger.divipay.MainApp;
import ru.nsu.boxberger.divipay.model.PurchasesModel;
import ru.nsu.boxberger.divipay.model.RequestsModel;
import ru.nsu.boxberger.divipay.service.BaseService;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BaseController {

    protected void goToPage(String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = MainApp.getPrimaryStage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadUsersFromServer(ObservableList<String> connectedUsers, ListView<String> userListView) {
        connectedUsers = FXCollections.observableArrayList();
        userListView.setItems(connectedUsers);

        List<String> userList = getUsersFromServer();
        connectedUsers.addAll(userList);

        userListView.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String username, boolean empty) {
                super.updateItem(username, empty);
                if (empty || username == null) {
                    setText(null);
                } else {
                    setText(username);
                    setStyle("-fx-background-color: #161623");
                }
            }
        });
    }

    private List<String> getUsersFromServer(){
        try {
            return BaseService.getUsernamesFromServer();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    void loadRequestsFromServer(ObservableList<RequestsModel> requests, ListView<RequestsModel> requestsListView) {
        requests = FXCollections.observableArrayList();
        requestsListView.setItems(requests);

        List<RequestsModel> requestList = getRequestsFromServer();
        requests.addAll(requestList);

        requestsListView.setCellFactory(param -> new ListCell<RequestsModel>() {
            @Override
            protected void updateItem(RequestsModel requestsModel, boolean empty) {
                super.updateItem(requestsModel, empty);
                if (empty || requestsModel == null) {
                    setText(null);
                } else {
                    setText(requestsModel.toString());
                    setStyle("-fx-background-color: #161623");
                }
            }
        });
    }

    private List<RequestsModel> getRequestsFromServer(){
        try {
            return BaseService.getRequestsFromServer();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    void loadPurchasesFromServer(ObservableList<PurchasesModel> purchases, ListView<PurchasesModel> purchasesListView) {
        purchases = FXCollections.observableArrayList();
        purchasesListView.setItems(purchases);

        List<PurchasesModel> purchasesList = getPurchasesFromServer();
        purchases.addAll(purchasesList);

        purchasesListView.setCellFactory(param -> new ListCell<PurchasesModel>() {
            @Override
            protected void updateItem(PurchasesModel purchasesModel, boolean empty) {
                super.updateItem(purchasesModel, empty);
                if (empty || purchasesModel == null) {
                    setText(null);
                } else {
                    setText(purchasesModel.toString());
                    setStyle("-fx-background-color: #161623");
                }
            }
        });
    }

    private List<PurchasesModel> getPurchasesFromServer(){
        try {
            return BaseService.getPurchasesFromServer();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    void loadDateTime(Label dateLabel, Label timeLabel){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            updateTime(timeLabel);
            updateData(dateLabel);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateTime(Label timeLabel){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = now.format(formatter);
        timeLabel.setText(formattedTime);
    }

    private void updateData(Label dateLabel){
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE, d MMM");
        String formattedDate = now.format(formatter);
        dateLabel.setText(formattedDate);
    }

    void loadDefaultImage(ImageView avatarImage){
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
}
