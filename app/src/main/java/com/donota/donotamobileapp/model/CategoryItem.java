package com.donota.donotamobileapp.model;

public class CategoryItem {
    private int imgResId;
    String categoryName;

    public CategoryItem(int imgResId, String categoryName) {
        this.imgResId = imgResId;
        this.categoryName = categoryName;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
