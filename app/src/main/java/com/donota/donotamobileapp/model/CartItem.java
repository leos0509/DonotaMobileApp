package com.donota.donotamobileapp.model;

public class CartItem {
    private String name;
    private double price;
    private int quantity;
    private String img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public CartItem(String name, double price, int quantity, String img) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.img = img;
    }

}
