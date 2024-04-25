package com.donota.donotamobileapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.model.ProductCard;
import androidx.appcompat.widget.AppCompatButton;

import java.util.List;

public class ProductCarouselAdapter extends RecyclerView.Adapter<ProductCarouselAdapter.ProductCardViewHolder> {

    private Context context;
    private List<ProductCard> productCards;
    private OnItemClickListener listener;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<ProductCard> getProductCards() {
        return productCards;
    }

    public void setProductCards(List<ProductCard> productCards) {
        this.productCards = productCards;
    }

    public OnItemClickListener getListener() {
        return listener;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ProductCarouselAdapter(Context context, List<ProductCard> productCards, OnItemClickListener listener) {
        this.context = context;
        this.productCards = productCards;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_carousel, parent, false);
        return new ProductCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position) {
        ProductCard productCard = productCards.get(position);
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
            txtProductName = itemView.findViewById(R.id.txtProductName);
            btnRating = itemView.findViewById(R.id.btnRating);
            txtPrice = itemView.findViewById(R.id.txtProductPrice);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(ProductCard productCard);
    }
}
