package com.donota.donotamobileapp.adapters;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.models.ProductOrder;
import com.donota.donotamobileapp.models.SettingOptions;

import java.util.List;

public class ProductOrderAdapter extends BaseAdapter {
    Activity activity;

    int item_confirmation_layout;
    List<ProductOrder> productOrderList;

    public ProductOrderAdapter(Activity activity, int item_confirmation_layout, List<ProductOrder> productOrderList) {
        this.activity = activity;
        this.item_confirmation_layout = item_confirmation_layout;
        this.productOrderList = productOrderList;
    }

    @Override
    public int getCount() {
        return productOrderList.size();
    }

    @Override
    public Object getItem(int position) {
        return productOrderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ProductOrderAdapter.ViewHolder holder;
        if (view == null){
            holder = new ProductOrderAdapter.ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(item_confirmation_layout, null);
            holder.imvProductThumb = view.findViewById(R.id.imvProductThumb);
            holder.txtProductName = view.findViewById(R.id.txtProductName);
            holder.txtQuantity = view.findViewById(R.id.txtQuantity);
            holder.txtProductPrice = view.findViewById(R.id.txtProductPrice);
            holder.txtTotal = view.findViewById(R.id.txtTotalPayment);
            holder.txtTotalPayment = view.findViewById(R.id.txtOrderTotalPayment);
            view.setTag(holder);
        }else{
            holder = (ProductOrderAdapter.ViewHolder) view.getTag();
        }
        ProductOrder productOrder = productOrderList.get(position);
        Glide.with(activity)
                .load(productOrder.getProductThumb())
                .into(holder.imvProductThumb);
        holder.txtProductName.setText(productOrder.getProductName());
        holder.txtQuantity.setText(String.valueOf(productOrder.getProductQuantity()));
        holder.txtProductPrice.setText(String.valueOf( Math.round(productOrder.getProductPrice())) + "VND");


        return view;
    }

    public static class ViewHolder{
        ImageView imvProductThumb;
        TextView txtProductName, txtProductPrice, txtQuantity, txtTotal, txtTotalPayment;
    }
}
