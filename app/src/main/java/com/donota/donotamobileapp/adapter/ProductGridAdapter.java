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

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductGridAdapter extends RecyclerView.Adapter<ProductGridAdapter.ProductCardViewHolder> {

    private Context context;
    private List<ProductCard> productCards;
    private OnProductClickListener onProductClickListener;

    public ProductGridAdapter(Context context, List<ProductCard> productCards, OnProductClickListener onProductClickListener) {
        this.context = context;
        this.productCards = productCards;
        this.onProductClickListener = onProductClickListener;
    }

    public interface OnProductClickListener {
        void onProductClick(ProductCard productCard);
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
        holder.itemView.setOnClickListener(v -> onProductClickListener.onProductClick(productCard));
        holder.txtProductName.setText(productCard.getProductName());
        holder.btnRating.setText(productCard.getRating());
        
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String formattedPrice = format.format(productCard.getPrice());
        holder.txtPrice.setText(formattedPrice);
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
            txtProductName = itemView.findViewById(R.id.txtProductName);
            btnRating = itemView.findViewById(R.id.btnRating);
            txtPrice = itemView.findViewById(R.id.txtProductPrice);
        }

    }

}
