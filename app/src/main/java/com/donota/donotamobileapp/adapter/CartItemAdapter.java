package com.donota.donotamobileapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.model.CartItem;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {
    private Context context;
    private List<CartItem> cartItems;
    private OnCheckedItemCountChangedListener listener;

    public CartItemAdapter(Context context, List<CartItem> cartItems, OnCheckedItemCountChangedListener listener) {
        this.context = context;
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
        void onCheckedItemPriceSumChanged(double sum);
    }

    public double getCheckedItemPriceSum() {
        int sum = 0;
        for (CartItem item : cartItems) {
            if (item.isChecked()) {
                sum += item.getPrice() * item.getQuantity();
            }
        }
        return sum;
    }

    public void setItemChecked(int position, boolean isChecked) {
        cartItems.get(position).setChecked(isChecked);
        notifyItemChanged(position);
        if (listener != null) {
            listener.onCheckedItemCountChanged(getCheckedItemCount());
            listener.onCheckedItemPriceSumChanged(getCheckedItemPriceSum());
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
        AppCompatButton btnAdd, btnRemove, btnRemoveItem;

        public void bind(CartItem item) {
            Glide.with(context)
                    .load(item.getProductimg())
                    .into(imvThumb);
            txtName.setText(item.getName());
            txtPrice.setText(formatCurrency(item.getPrice()));
            txtQuantity.setText(String.valueOf(item.getQuantity()));

            // Update the quantity in the TextView
            txtQuantity.setText(String.valueOf(item.getQuantity()));
        }

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            checkboxSelect = itemView.findViewById(R.id.checkboxSelect);
            imvThumb = itemView.findViewById(R.id.imvThumb);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtQuantity = itemView.findViewById(R.id.txtQuantity);
            btnAdd = itemView.findViewById(R.id.btnAdd);
            btnRemove = itemView.findViewById(R.id.btnRemove);
            btnRemoveItem = itemView.findViewById(R.id.btnRemoveItem);

            checkboxSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isChecked = checkboxSelect.isChecked();
                    int position = getAdapterPosition();
                    if (position!= RecyclerView.NO_POSITION) {
                        setItemChecked(position, isChecked);
                    }
                }
            });

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position!= RecyclerView.NO_POSITION) {
                        CartItem item = cartItems.get(position);
                        item.setQuantity(item.getQuantity() + 1);
                        notifyItemChanged(position);
                    }
                }
            });

            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position!= RecyclerView.NO_POSITION) {
                        CartItem item = cartItems.get(position);
                        if (item.getQuantity() > 1) {
                            item.setQuantity(item.getQuantity() - 1);
                            notifyItemChanged(position);
                        }
                    }
                }
            });

            btnRemoveItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        private String formatCurrency(double amount) {
            NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            return format.format(amount);
        }
    }
}
