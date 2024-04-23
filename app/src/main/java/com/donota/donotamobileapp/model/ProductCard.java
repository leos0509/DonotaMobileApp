package com.donota.donotamobileapp.model;

public class ProductCard {
    private int imageResourceId;
    private String productName;
    private String rating;
    private String price;

    public ProductCard(int imageResourceId, String productName, String rating, String price) {
        this.imageResourceId = imageResourceId;
        this.productName = productName;
        this.rating = rating;
        this.price = price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getProductName() {
        return productName;
    }

    public String getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }
}

