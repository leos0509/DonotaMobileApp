package com.donota.donotamobileapp.model;

public class ProductCard {
    private String imageUrl;
    private String productName;
    private String rating;
    private int price;

    public ProductCard(String imageUrl, String productName, String rating, int price) {
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.rating = rating;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

