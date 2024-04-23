package com.donota.donotamobileapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.donota.donotamobileapp.R;

public class CategoryGridAdapter extends RecyclerView.Adapter<CategoryGridAdapter.ViewHolder> {

    private Context context;
    private String[] items;

    public CategoryGridAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemText.setText(items[position]);
        holder.imvThumb.setImageResource(R.drawable.dining_table);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemText;
        ImageView imvThumb;

        public ViewHolder(View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.txtCategoryName);
            imvThumb = itemView.findViewById(R.id.imvCategory);
        }
    }
}
