package ru.nsu.boxberger.divipay.model;

public class PurchasesModel {

    private Long purchaseID;
    private ProfileModel profileModel = ProfileModel.getInstance();
    private String itemName;
    private Integer quantity;
    private Double price;

    @Override
    public String toString() {
        return  purchaseID +
                ". " + itemName + '\'' +
                "от " + profileModel.getUsername() +
                ", кол-во: " + quantity +
                ", цена за шт: " + price + "Руб.";
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
}
