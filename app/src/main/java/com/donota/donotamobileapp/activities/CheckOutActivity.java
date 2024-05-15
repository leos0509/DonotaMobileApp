package com.donota.donotamobileapp.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapters.ProductOrderAdapter;
import com.donota.donotamobileapp.database.impl.TbCartImpl;
import com.donota.donotamobileapp.database.impl.TbProductImpl;
import com.donota.donotamobileapp.databinding.ActivityOrderConfirmationBinding;
import com.donota.donotamobileapp.models.ProductOrder;
import com.donota.donotamobileapp.utils.PreferenceUtils;
import com.donota.donotamobileapp.utils.ServiceUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckOutActivity extends AppCompatActivity {
    ActivityOrderConfirmationBinding binding;

    List<ProductOrder> productOrderList;

    ProductOrderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityOrderConfirmationBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initAdapter();
        addEvents();
    }

    private void addEvents() {
        Date date = new Date();
        String productOrderId = ServiceUtils.orderIdGenerator(this, "DN", date);
        double orderValue = orderValueCalculating(productOrderList);
        int customerId = PreferenceUtils.getCustomerId(this);
        long orderDate = ServiceUtils.dateConversion(date);
        TbProductImpl tbProduct = new TbProductImpl(this);
        Intent intent = new Intent(this, OrderSuccessActivity.class);

        binding.buttonCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("order id", productOrderId);
                String update = "INSERT INTO tborder (\n" +
                        "                        orderid,\n" +
                        "                        ordervalue,\n" +
                        "                        customerid,\n" +
                        "                        orderdate\n" +
                        "                    )\n" +
                        "                    VALUES ( '" + productOrderId +"', " + orderValue + ", " + customerId+ ", " + orderDate +");";
                boolean commitTransaction = tbProduct.execSql(update);
                if (commitTransaction) {startActivity(intent);}
                else {
                    Toast.makeText(CheckOutActivity.this, "Failed to place order", Toast.LENGTH_SHORT).show();}
            }
        });
        tbProduct.close();
    }

    private double orderValueCalculating( List<ProductOrder> productOrderList) {
        double sum = 0;
        for (ProductOrder productOrder : productOrderList) {
            double productValue = productOrder.getProductPrice() * productOrder.getProductQuantity();
            sum += productValue;
        }
        return sum;
    }
    private void attachTotal (List<ProductOrder> productOrderList) {
        binding.txtOrderTotalDelivery.setText(String.valueOf(productOrderList.size() *100000));
        binding.txtOrderDeliveryMethodPrice.setText(String.valueOf(productOrderList.size() *100000));
        binding.txtTotalPayment.setText(String.valueOf(Math.round(orderValueCalculating(productOrderList) + productOrderList.size() * 100000) + "VND"));
        binding.txtOrderTotalPayment.setText(String.valueOf(Math.round(orderValueCalculating(productOrderList)) + "VND"));
    }


    private void initAdapter() {
        productOrderList = loadData(getCheckItems());
        adapter = new ProductOrderAdapter(this, R.layout.item_confirmation_layout, productOrderList);
        binding.lvOrderProduct.setAdapter(adapter);
        attachTotal(productOrderList);
    }

    private List<String> getCheckItems() {
        List<String> checkedItems = getIntent().getStringArrayListExtra("checkedItems");
        if (checkedItems != null) {
            // Handle the received checked items data
            for (String productId : checkedItems) {

            }
        }
        return checkedItems;
    }

    private List<ProductOrder> loadData(List<String> productIdList){
        List<ProductOrder> productOrderList = new ArrayList<>();
        int customerid = PreferenceUtils.getCustomerId(this);
        TbCartImpl tbCart = new TbCartImpl(this);
        for (String productId : productIdList) {
            String sql = "SELECT tbc.customerid,\n" +
                    "       tbc.productid,\n" +
                    "       tbc.quantity, \n" +
                    "       tbp.productprice,\n" +
                    "       tbp.productname,\n" +
                    "       tbp.productimg\n" +
                    "FROM tbcustomercart tbc\n" +
                    "JOIN tbproduct tbp\n" +
                    "ON tbc.productid = tbp.productid\n" +
                    "WHERE tbc.customerid = " + customerid + " AND tbc.productid LIKE '" +productId+"';" ;
            Cursor cursor = tbCart.queryData(sql);
            if (cursor.moveToFirst()) {
                String[] imgUrls = cursor.getString(5).split(";");
                String itemImg = imgUrls[0].trim();
                productOrderList.add(new ProductOrder(itemImg, cursor.getString(4), cursor.getInt(2), cursor.getDouble(3)));
            }
            cursor.close();
        }
        tbCart.close();
        return productOrderList;
    }

}