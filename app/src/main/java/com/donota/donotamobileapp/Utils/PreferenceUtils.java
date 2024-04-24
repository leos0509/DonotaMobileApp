package com.donota.donotamobileapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {

    private static final String PREF_NAME = "donota_preferences";
    private static final String KEY_CUSTOMER_ID = "customerId";
    private static final String KEY_CUSTOMER_PASSWORD = "customerPassword";

    private static final String KEY_CUSTOMER_ACCOUNT = "customerAccount";

    private PreferenceUtils() {
        // Private constructor to prevent instantiation
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void setCustomerId(Context context, String customerId) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_CUSTOMER_ID, customerId);
        editor.apply();
    }
    public static void setCustomerAccount(Context context, String customerAccount) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_CUSTOMER_ID, customerAccount);
        editor.apply();
    }

    public static String getCustomerId(Context context) {
        return getSharedPreferences(context).getString(KEY_CUSTOMER_ID, null);
    }
    public static String getCustomerAccount(Context context) {
        return getSharedPreferences(context).getString(KEY_CUSTOMER_ACCOUNT, null);
    }
}