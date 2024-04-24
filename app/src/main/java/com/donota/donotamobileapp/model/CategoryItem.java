package com.donota.donotamobileapp.model;

public class CategoryItem {
    private  String productId;
    private String productImageUrl;
    String categoryName;

    public CategoryItem(String productId, String productImageUrl, String categoryName) {
        this.productId = productId;
        this.productImageUrl = productImageUrl;
        this.categoryName = categoryName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
