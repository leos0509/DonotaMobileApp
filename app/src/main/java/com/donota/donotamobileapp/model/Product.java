package com.donota.donotamobileapp.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String productId;
    private String productName;
    private int productPrice;
    private String productRating;
    private String productDescription;
    private String productCategory;
    private String productCategorySub1;
    private String productCategorySub2;
    private String productCategorySub3;
    private String productCategorySub4 = "1";

    private String productImg;

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }


    public Product() {
    }

    public Product(String productId, String productName, int productPrice, String productRating,
                   String productDescription, String productCategory, String productCategorySub1,
                   String productCategorySub2, String productCategorySub3, String productCategorySub4, String productImg) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productCategorySub1 = productCategorySub1;
        this.productCategorySub2 = productCategorySub2;
        this.productCategorySub3 = productCategorySub3;
        this.productCategorySub4 = productCategorySub4;
        this.productImg = productImg;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductRating() {
        return productRating;
    }

    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCategorySub1() {
        return productCategorySub1;
    }

    public void setProductCategorySub1(String productCategorySub1) {
        this.productCategorySub1 = productCategorySub1;
    }

    public String getProductCategorySub2() {
        return productCategorySub2;
    }

    public void setProductCategorySub2(String productCategorySub2) {
        this.productCategorySub2 = productCategorySub2;
    }

    public String getProductCategorySub3() {
        return productCategorySub3;
    }

    public void setProductCategorySub3(String productCategorySub3) {
        this.productCategorySub3 = productCategorySub3;
    }

    public String getProductCategorySub4() {
        return productCategorySub4;
    }

    public void setProductCategorySub4(String productCategorySub4) {
        this.productCategorySub4 = productCategorySub4;
    }
}
