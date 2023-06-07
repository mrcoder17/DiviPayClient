package ru.nsu.boxberger.divipay.model;

public class RequestsModel {

    private Long requestID;
    private Long userID;
    private String username;
    private String itemName;
    private Long quantity;

    @Override
    public String toString() {
        return requestID +
                ". " + itemName +
                " от " + username +
                " в кол-ве: " + quantity + "у.е";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getRequestID() {
        return requestID;
    }

    public void setRequestID(Long requestsID) {
        this.requestID = requestsID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
