package ru.nsu.boxberger.divipay.model;

public class PurchasesModel {

    private Boolean isPaid;
    private Long purchaseID;
    private Long userID;
    private String username;
    private String itemName;
    private Long quantity;
    private Double price;



    @Override
    public String toString() {
        return  purchaseID +
                ". '" + itemName +
                "' от " + username +
                ", кол-во: " + quantity +
                ", общая цена: " + price + " Руб.";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(Long purchaseID) {
        this.purchaseID = purchaseID;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Boolean isPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}
