package com.donota.donotamobileapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.model.ProductCard;
import androidx.appcompat.widget.AppCompatButton;

import java.util.List;

public class ProductGridAdapter extends RecyclerView.Adapter<ProductGridAdapter.ProductCardViewHolder> {

    private Context context;
    private List<ProductCard> productCards;

    public ProductGridAdapter(Context context, List<ProductCard> productCards) {
        this.context = context;
        this.productCards = productCards;
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        Log.d("ProductGridAdapter", "onCreateViewHolder: Creating ViewHolder");
        return new ProductCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position) {
        ProductCard productCard = productCards.get(position);

        Log.d("ProductGridAdapter", "onBindViewHolder: Binding item at position " + position);

        Glide.with(context)
                .load(productCard.getImageUrl())
                .into(holder.imvProduct);
        holder.txtProductName.setText(productCard.getProductName());
        holder.btnRating.setText(productCard.getRating());
        holder.txtPrice.setText(String.valueOf(productCard.getPrice()));
    }

    @Override
    public int getItemCount() {
        return productCards.size();
    }

    public static class ProductCardViewHolder extends RecyclerView.ViewHolder {
        ImageView imvProduct;
        TextView txtProductName;
        AppCompatButton btnRating;
        TextView txtPrice;

        public ProductCardViewHolder(@NonNull View itemView) {
            super(itemView);
            imvProduct = itemView.findViewById(R.id.imvProduct);
            Log.d("ProductCardViewHolder", "imvProduct found: " + (imvProduct != null));
            txtProductName = itemView.findViewById(R.id.txtProductName);
            Log.d("ProductCardViewHolder", "txtProductName found: " + (txtProductName != null));
            btnRating = itemView.findViewById(R.id.btnRating);
            Log.d("ProductCardViewHolder", "btnRating found: " + (btnRating != null));
            txtPrice = itemView.findViewById(R.id.txtProductPrice);
            Log.d("ProductCardViewHolder", "txtPrice found: " + (txtPrice != null));
        }

    }

}
