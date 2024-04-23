package com.donota.donotamobileapp.models;

public class Customers {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerUsername;
    private Integer customerPhoneNumb;
    private String customerAddress;
    private String customerPurchaseHistory;
    private String customerAccount;
    private String customerPassword;
    private String customerCart;
    private String customerWishlist;
    private Integer customerDob;

    public Customers(String customerId, String customerName, String customerEmail, String customerUsername, Integer customerPhoneNumb, String customerAddress, String customerPurchaseHistory, String customerAccount, String customerPassword, String customerCart, String customerWishlist, Integer customerDob) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerUsername = customerUsername;
        this.customerPhoneNumb = customerPhoneNumb;
        this.customerAddress = customerAddress;
        this.customerPurchaseHistory = customerPurchaseHistory;
        this.customerAccount = customerAccount;
        this.customerPassword = customerPassword;
        this.customerCart = customerCart;
        this.customerWishlist = customerWishlist;
        this.customerDob = customerDob;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public Integer getCustomerPhoneNumb() {
        return customerPhoneNumb;
    }

    public void setCustomerPhoneNumb(Integer customerPhoneNumb) {
        this.customerPhoneNumb = customerPhoneNumb;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPurchaseHistory() {
        return customerPurchaseHistory;
    }

    public void setCustomerPurchaseHistory(String customerPurchaseHistory) {
        this.customerPurchaseHistory = customerPurchaseHistory;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(String customerCart) {
        this.customerCart = customerCart;
    }

    public String getCustomerWishlist() {
        return customerWishlist;
    }

    public void setCustomerWishlist(String customerWishlist) {
        this.customerWishlist = customerWishlist;
    }

    public Integer getCustomerDob() {
        return customerDob;
    }

    public void setCustomerDob(Integer customerDob) {
        this.customerDob = customerDob;
    }
}
