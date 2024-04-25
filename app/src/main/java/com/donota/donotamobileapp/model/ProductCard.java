package com.donota.donotamobileapp.model;

public class ProductCard {
    private String imageUrl;
    private String productName;
    private String rating;
    private int price;
    private String productId;

    public ProductCard(String imageUrl, String productName, String rating, int price, String productId) {
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.rating = rating;
        this.price = price;
        this.productId = productId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}

