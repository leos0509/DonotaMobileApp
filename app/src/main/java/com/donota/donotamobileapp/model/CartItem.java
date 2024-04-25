package com.donota.donotamobileapp.model;

public class CartItem {
    private String productimg;
    private String name;
    private double price;
    private int quantity;

    private boolean isChecked;

    public CartItem(String productimg, String name, double price, int quantity) {
        this.productimg = productimg;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isChecked = false;
    }

    public String getProductimg() {
        return productimg;
    }

    public void setProductimg(String productimg) {
        this.productimg = productimg;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

}
