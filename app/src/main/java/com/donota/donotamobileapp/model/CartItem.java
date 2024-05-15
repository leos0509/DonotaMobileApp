package com.donota.donotamobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CartItem implements Parcelable {
    private String productId;
    private String productimg;
    private String name;
    private double price;
    private int quantity;
    private boolean isChecked;

    // Constructor
    public CartItem(String productId, String productimg, String name, double price, int quantity) {
        this.productId = productId;
        this.productimg = productimg;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isChecked = false;
    }

    // Parcel constructor
    protected CartItem(Parcel in) {
        productId = in.readString();
        productimg = in.readString();
        name = in.readString();
        price = in.readDouble();
        quantity = in.readInt();
        isChecked = in.readByte()!= 0;
    }

    // Parcelable creator
    public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
        @Override
        public CartItem createFromParcel(Parcel in) {
            return new CartItem(in);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
        }
    };

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    // Additional method to calculate total price of the item
    public double getTotalPrice() {
        return price * quantity;
    }

    // Describe the kind of special objects contained in this Parcelable's marshalled representation.
    @Override
    public int describeContents() {
        return 0;
    }

    // Flatten this object to a Parcel.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productId);
        dest.writeString(productimg);
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeInt(quantity);
        dest.writeByte((byte) (isChecked? 1 : 0));
    }
}