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
import ru.nsu.boxberger.divipay.model.PurchaseModel;
import ru.nsu.boxberger.divipay.model.RequestModel;
import ru.nsu.boxberger.divipay.model.UserRequest;
import ru.nsu.boxberger.divipay.service.BaseService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BaseController {
    private static BaseController instance;
    private Label dateLabel;
    private Label timeLabel;

    public static BaseController getInstance() {
        if (instance == null) {
            instance = new BaseController();
        }
        return instance;
    }

    public void initializeLabels(Label dateLabel, Label timeLabel) {
        this.dateLabel = dateLabel;
        this.timeLabel = timeLabel;
        startDateTimeUpdate();
    }

    void startDateTimeUpdate() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            updateTime();
            updateData();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = now.format(formatter);
        timeLabel.setText(formattedTime);
    }

    private void updateData() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE, d MMM");
        String formattedDate = now.format(formatter);
        dateLabel.setText(formattedDate);
    }

    void loadUsersFromServer(ObservableList<UserRequest> connectedUsers, ListView<UserRequest> userListView) {
        connectedUsers = FXCollections.observableArrayList();
        userListView.setItems(connectedUsers);

        List<UserRequest> userList = getUsersFromServer();
        connectedUsers.addAll(userList);

        userListView.setCellFactory(param -> new ListCell<UserRequest>() {
            @Override
            protected void updateItem(UserRequest user, boolean empty) {
                super.updateItem(user, empty);
                if (empty || user == null) {
                    setText(null);
                } else {
                    setText(user.toString());
                    setStyle("-fx-background-color: #161623");
                }
            }
        });
    }

    private List<UserRequest> getUsersFromServer() {
        try {
            return BaseService.getUsersFromServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    void loadRequestsFromServer(ObservableList<RequestModel> requests, ListView<RequestModel> requestsListView) {
        requests = FXCollections.observableArrayList();
        requestsListView.setItems(requests);

        List<RequestModel> requestList = getRequestsFromServer();
        requests.addAll(requestList);

        requestsListView.setCellFactory(param -> new ListCell<RequestModel>() {
            @Override
            protected void updateItem(RequestModel requestModel, boolean empty) {
                super.updateItem(requestModel, empty);
                if (empty || requestModel == null) {
                    setText(null);
                } else {
                    setText(requestModel.toString());
                    setStyle("-fx-background-color: #161623");
                }
            }
        });
    }

    private List<RequestModel> getRequestsFromServer() {
        try {
            return BaseService.getRequestsFromServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    void loadPurchasesFromServer(ObservableList<PurchaseModel> purchases, ListView<PurchaseModel> purchasesListView) {
        purchases = FXCollections.observableArrayList();
        purchasesListView.setItems(purchases);

        List<PurchaseModel> purchasesList = getPurchasesFromServer();
        purchases.addAll(purchasesList);

        purchasesListView.setCellFactory(param -> new ListCell<PurchaseModel>() {
            @Override
            protected void updateItem(PurchaseModel purchaseModel, boolean empty) {
                super.updateItem(purchaseModel, empty);
                if (empty || purchaseModel == null) {
                    setText(null);
                } else {
                    setText(purchaseModel.toString());
                    if (purchaseModel.isPaid() == null) {
                        setStyle("-fx-background-color: #161623");
                    } else if (purchaseModel.isPaid()) {
                        setStyle("-fx-background-color: #161623; -fx-text-fill: gray");
                    }
                }
            }
        });
    }

    private List<PurchaseModel> getPurchasesFromServer() {
        try {
            return BaseService.getPurchasesFromServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    void loadImage(ImageView avatarImage, String url) {
        Image image = new Image(url);
        avatarImage.setFitHeight(40);
        avatarImage.setFitWidth(40);
        avatarImage.setPreserveRatio(true);
        avatarImage.setImage(image);

        Circle clipCircle = new Circle(20);
        clipCircle.setCenterX(20);
        clipCircle.setCenterY(20);

        avatarImage.setClip(clipCircle);
    }

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
}
