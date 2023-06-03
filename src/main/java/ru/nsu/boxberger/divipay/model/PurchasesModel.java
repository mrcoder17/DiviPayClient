package ru.nsu.boxberger.divipay.model;

public class PurchasesModel {

    private Long purchaseID;
    private Long userID;
    private String username;
    private String itemName;
    private Integer quantity;
    private Double price;



    @Override
    public String toString() {
        return  purchaseID +
                ". '" + itemName +
                "' от " + username +
                ", кол-во: " + quantity +
                ", цена за шт: " + price + " Руб.";
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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
}
