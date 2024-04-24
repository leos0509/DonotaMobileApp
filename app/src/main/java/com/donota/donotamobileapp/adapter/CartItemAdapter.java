package com.donota.donotamobileapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.model.CartItem;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {
    Context context;
    private List<CartItem> cartItems;
    private OnCheckedItemCountChangedListener listener;

    public CartItemAdapter(List<CartItem> cartItems, OnCheckedItemCountChangedListener listener) {
        this.cartItems = cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {
        CartItem item = cartItems.get(position);
        holder.bind(item);
    }

    public interface OnCheckedItemCountChangedListener {
        void onCheckedItemCountChanged(int count);
        void onCheckedItemPriceSumChanged(double sum); // New method for price sum change
    }

    public double getCheckedItemPriceSum() {
        double sum = 0;
        for (CartItem item : cartItems) {
            if (item.isChecked()) {
                sum += item.getPrice() * item.getQuantity(); // Assuming each item has a quantity
            }
        }
        return sum;
    }

    public void setItemChecked(int position, boolean isChecked) {
        cartItems.get(position).setChecked(isChecked);
        notifyItemChanged(position);
        if (listener != null) {
            listener.onCheckedItemCountChanged(getCheckedItemCount());
            listener.onCheckedItemPriceSumChanged(getCheckedItemPriceSum()); // Notify about the price sum change
        }
    }

    public int getCheckedItemCount() {
        int count = 0;
        for (CartItem item : cartItems) {
            if (item.isChecked()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkboxSelect;
        ImageView imvThumb;
        TextView txtName, txtPrice, txtQuantity;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            checkboxSelect = itemView.findViewById(R.id.checkboxSelect);
            imvThumb = itemView.findViewById(R.id.imvThumb);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtQuantity = itemView.findViewById(R.id.txtQuantity);

            if (checkboxSelect.getTag() == null) {
                checkboxSelect.setTag("initialized");
                checkboxSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isChecked = checkboxSelect.isChecked();
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            setItemChecked(position, isChecked);
                        }
                    }
                });
            }

            checkboxSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isChecked = checkboxSelect.isChecked();
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        setItemChecked(position, isChecked);
                    }
                }
            });
        }

        public void bind(CartItem item) {
            txtName.setText(item.getName());
            txtPrice.setText(String.valueOf(item.getPrice()));
            txtQuantity.setText(String.valueOf(item.getQuantity()));
        }
    }
}
