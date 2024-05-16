package com.donota.donotamobileapp.utils;

import android.content.Context;
import android.database.Cursor;

import com.donota.donotamobileapp.database.impl.TbCustomerProfileImpl;

public class DbUtils {
    public static final String DB_NAME = "donotadb.db";
    public static final int DB_VERSION = 1;
    public static final String DB_FOLDER = "/databases/";
    public static final String TBL_CUSTOMER_PROFILE = "tbcustomerprofile";
    public static final String COL_CUSTOMER_ID = "customerid";
    public static final String COL_CUSTOMER_NAME = "customername";
    public static final String COL_CUSTOMER_PHONENUMB = "phonenumb";
    public static final String COL_CUSTOMER_PURCHASE_HISTORY = "purchasehistory";
    public static final String COL_CUSTOMER_ACCOUNT = "customeraccount";
    public static final String COL_CUSTOMER_ACCOUNT_PASSWORD = "customeraccountpassword";
    public static final String COL_CUSTOMER_DOB = "customerdob";
    public static final String COL_CUSTOMER_EMAIL = "customeremail";

    public static final String TBL_PRODUCT = "tbproduct";
    public static final String COL_PRODUCT_ID = "productid";
    public static final String COL_PRODUCT_NAME = "productname";
    public static final String COL_PRODUCT_PRICE = "productprice";
    public static final String COL_PRODUCT_QUANTITY = "productquantity";
    public static final String COL_PRODUCT_CATEGORY = "productcategory";
    public static final String COL_PRODUCT_DESCRIPTION = "productdescription";
    public static final String COL_PRODUCT_IMG = "productimg";
    public static final String COL_PRODUCT_RATING = "productrating";
    public static final String TBL_ORDER = "tborder";
    public static final String TBL_ORDER_DETAIL = "tborderdetail";
    public static final String COL_ORDER_ID = "orderid";
    public static final String COL_ORDER_VALUE = "ordervalue";
    public static final String COL_ORDER_DETAIL_ID = "customerdetailid";
    public static final String COL_ORDER_DATE = "orderdate";
    public static final String COL_DELIVERY_DATE = "deliverydate";
    public static final String COL_ORDER_QUANTITY = "orderquantity";

    public static final String TBL_CUSTOMER_CART = "tbcustomercart";
    public static final String COL_CUSTOMER_CART_QUANTITY = "quantity";
    public static final String TBL_CUSTOMER_WISHLIST = "tbcustomerwishlist";
    public static final String TBL_CUSTOMER_ADDRESS = "tbcustomeraddress";
    public static final String COL_CUSTOMER_ADDRESS = "address";
    public static int getCustomerCount(Context context) {
        int count = 0;
        String countQuery = "SELECT customerid FROM " + TBL_CUSTOMER_PROFILE;
        TbCustomerProfileImpl tbCustomerProfile = new TbCustomerProfileImpl(context);
        Cursor cursor = tbCustomerProfile.queryData(countQuery);

        while (cursor.moveToNext()) {
            count += 1;
        }
        cursor.close();
        tbCustomerProfile.close();
        return count;
    }
}