package com.donota.donotamobileapp.model;

public class CarouselItem {
    private String productImageUrl;
    private String productId;

    public CarouselItem(String productImageUrl, String productId) {
        this.productImageUrl = productImageUrl;
        this.productId = productId;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
