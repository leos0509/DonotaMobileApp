package com.donota.donotamobileapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class PreferenceUtils {

    private static final String PREF_NAME = "donota_preferences";
    private static final String KEY_CUSTOMER_ID = "customerId";
    private static final String KEY_CUSTOMER_PASSWORD = "customerPassword";
    private static final String KEY_CUSTOMER_ACCOUNT = "customerAccount"; // Unique key for customer account

    private PreferenceUtils() {
        // Private constructor to prevent instantiation
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void setCustomerId(Context context, int customerId) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(KEY_CUSTOMER_ID, customerId);
        editor.apply();
    }

    public static void setCustomerAccount(Context context, String customerAccount) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        // Use the correct key for storing the customer account
        editor.putString(KEY_CUSTOMER_ACCOUNT, customerAccount);
        editor.apply();
    }

    public static int getCustomerId(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        String customerIdStr = sharedPreferences.getString(KEY_CUSTOMER_ID, null);

        if (customerIdStr!= null) {
            try {
                return Integer.parseInt(customerIdStr);
            } catch (NumberFormatException e) {
                Log.e("PreferenceUtils", "Failed to parse customer ID as integer.", e);
                return -1;
            }
        } else {
            return -1;
        }
    }

    public static String getCustomerAccount(Context context) {
        return getSharedPreferences(context).getString(KEY_CUSTOMER_ACCOUNT, null); // Use the correct key
    }
}
