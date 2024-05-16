package com.donota.donotamobileapp.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class MaxWidthItemDecoration extends RecyclerView.ItemDecoration {

    private int maxWidth;
    private int horizontalPadding;

    public MaxWidthItemDecoration(int maxWidth, int horizontalPadding) {
        this.maxWidth = maxWidth;
        this.horizontalPadding = horizontalPadding;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        // Calculate the maximum width for each item
        int itemWidth = maxWidth - 2 * horizontalPadding;

        outRect.left = horizontalPadding;
        outRect.right = horizontalPadding;

        outRect.top = 0;
        outRect.bottom = 0;
    }
}
