package com.donota.donotamobileapp.models;

public class OrderStatus {
    String statusID;

    String statusName;

    public OrderStatus(String statusID, String statusName) {
        this.statusID = statusID;
        this.statusName = statusName;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
