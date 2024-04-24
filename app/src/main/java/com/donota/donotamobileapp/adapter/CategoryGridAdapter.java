package com.donota.donotamobileapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.model.CarouselItem;
import com.donota.donotamobileapp.model.CategoryItem;

import java.util.List;

public class CategoryGridAdapter extends RecyclerView.Adapter<CategoryGridAdapter.ViewHolder> {

    private Context context;
    private List<CategoryItem> items;

    private OnItemClickListener listener;

    public CategoryGridAdapter(Context context, List<CategoryItem> items, OnItemClickListener listener) {
        this.context = context;
        this.items = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryItem item = items.get(position);
        Glide.with(context)
                .load(item.getProductImageUrl())
                .into(holder.imvCateThumb);
        holder.imvCateThumb.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemCategory;
        ImageView imvCateThumb;

        public ViewHolder(View itemView) {
            super(itemView);
            itemCategory = itemView.findViewById(R.id.txtCategoryName);
            imvCateThumb = itemView.findViewById(R.id.imvCategory);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
