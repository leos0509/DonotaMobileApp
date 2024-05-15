package com.donota.donotamobileapp.models;

public class CustomerDto {
    private int customerId;
    private String customerName;
    private String customerEmail;
    private Integer customerPhoneNumb;
    private String customerPurchaseHistory;
    private String customerAccount;
    private String customerAccountPassword;
    private Integer customerDob;

    public CustomerDto() {};

    public CustomerDto(int customerId, String customerName, String customerEmail, Integer customerPhoneNumb, String customerPurchaseHistory, String customerAccount, String customerAccountPassword, Integer customerDob) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumb = customerPhoneNumb;
        this.customerPurchaseHistory = customerPurchaseHistory;
        this.customerAccount = customerAccount;
        this.customerAccountPassword = customerAccountPassword;
        this.customerDob = customerDob;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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

    public Integer getCustomerPhoneNumb() {
        return customerPhoneNumb;
    }

    public void setCustomerPhoneNumb(Integer customerPhoneNumb) {
        this.customerPhoneNumb = customerPhoneNumb;
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

    public String getCustomerAccountPassword() {
        return customerAccountPassword;
    }

    public void setCustomerAccountPassword(String customerAccountPassword) {
        this.customerAccountPassword = customerAccountPassword;
    }

    public Integer getCustomerDob() {
        return customerDob;
    }

    public void setCustomerDob(Integer customerDob) {
        this.customerDob = customerDob;
    }
}
