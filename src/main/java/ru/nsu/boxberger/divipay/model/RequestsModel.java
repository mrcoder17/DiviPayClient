package ru.nsu.boxberger.divipay.model;

public class RequestsModel {
    ProfileModel profileModel = ProfileModel.getInstance();

    private Long requestsID;
    private String itemName;
    private Integer quantity;

    @Override
    public String toString() {
        return  requestsID +
                ". " + itemName + '\'' +
                " от " + profileModel.getUsername() +
                " в кол-ве: " + quantity  + "у.е";
    }

    public Long getRequestsID() {
        return requestsID;
    }

    public void setRequestsID(Long requestsID) {
        this.requestsID = requestsID;
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
}
