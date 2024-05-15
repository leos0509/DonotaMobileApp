package com.donota.donotamobileapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.model.CarouselItem;

import java.util.List;

public class BestSellerCarouselAdapter extends RecyclerView.Adapter<BestSellerCarouselAdapter.CarouselViewHolder> {

    private Context context;
    private List<CarouselItem> items;
    private OnItemClickListener listener;

    public BestSellerCarouselAdapter(Context context, List<CarouselItem> items, OnItemClickListener listener) {
        this.context = context;
        this.items = items;
        this.listener = listener;
    }

    @Override
    public CarouselViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carousel_item, parent, false);
        return new CarouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarouselViewHolder holder, int position) {
        CarouselItem item = items.get(position);
        Glide.with(context)
                .load(item.getProductImageUrl())
                .into(holder.imvItem);
        holder.imvItem.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class CarouselViewHolder extends RecyclerView.ViewHolder {
        ImageView imvItem;

        public CarouselViewHolder(View itemView) {
            super(itemView);
            imvItem = itemView.findViewById(R.id.carousel_image);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
