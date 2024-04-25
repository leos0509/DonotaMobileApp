package com.donota.donotamobileapp.adapter;

import android.content.Context;
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

public class ProductCarouselAdapter extends RecyclerView.Adapter<ProductCarouselAdapter.ProductCardViewHolder> {

    private Context context;
    private List<ProductCard> productCards;
    private OnItemClickListener listener;

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

    public interface OnItemClickListener {
        void onItemClick(ProductCard productCard);
    }
}