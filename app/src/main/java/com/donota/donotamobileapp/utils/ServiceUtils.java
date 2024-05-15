package com.donota.donotamobileapp.utils;

import android.content.Context;
import android.database.Cursor;

import com.donota.donotamobileapp.database.impl.TbOrderImpl;
import com.donota.donotamobileapp.models.OrderDto;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ServiceUtils {
    public static long dateConversion (Date date) {
        long converseDate = 0;
        converseDate = date.getTime();
        return converseDate;
    }
    public static String orderIdGenerator(Context context, String province, Date date) {

        String normalizedProvinceName = province.replaceAll("\\s+", "").substring(0,2).toUpperCase();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        String month = String.format("%02d", calendar.get(Calendar.MONTH) + 1);
        String year = String.valueOf(calendar.get(Calendar.YEAR)).substring(2);
        String datePattern = day + month + year;


        int totalOrder = countPreviousOrder(context, normalizedProvinceName, startOfYear(date.getTime()));
        String orderNumberPattern = "%04d";
        String orderID = "";

//        if (getLastestOrderDate(context, date.getTime())) {
            orderID = normalizedProvinceName + datePattern + String.format(orderNumberPattern, totalOrder + 1);
//        } else {
//            orderID = normalizedProvinceName + datePattern + "0001";
//        }
        return orderID;
    }
    private static int countPreviousOrder (Context context, String province, long date) {
        TbOrderImpl orderdb = new TbOrderImpl(context);
        String sql = "SELECT orderid FROM tborder WHERE orderid LIKE '%"+ province + "%' AND orderDate > " + date;
        Cursor cursor  = orderdb.queryData(sql);
        int previousOrders = cursor.getCount() ;
//        if (cursor.moveToFirst()) {
//            cursor.getInt(0);
//        }
        cursor.close();
        orderdb.close();
        return previousOrders;
    }

    private static boolean getLastestOrderDate (Context context, long date) {
        TbOrderImpl orderdb = new TbOrderImpl(context);
        String sql = "SELECT orderid FROM tborder ORDER BY orderdate DESC LIMIT 1" ;
        Cursor cursor  = orderdb.queryData(sql);
        long lastestOrderDate = 0;
        if (cursor.moveToFirst()) {
            lastestOrderDate = cursor.getLong(0);
        }
        cursor.close();
        return lastestOrderDate > date;
    }

    private static long startOfYear(long dateInLong) {
        Date date = new Date (dateInLong);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String startOfYearDate = "01/01/" + String.valueOf(calendar.get(Calendar.YEAR));

        Date date1 = new Date ();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date1 = formatter.parse(startOfYearDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        assert date1 != null;
        return date1.getTime();
    }

    private int calculateOrderValue (List<OrderDto> orderDtoList) {
        int value = 0;
        for (OrderDto orderDto : orderDtoList) {
            value = value + orderDto.getProductPrice() * orderDto.getProductQuantity();
        }
        return value;

    }
}

