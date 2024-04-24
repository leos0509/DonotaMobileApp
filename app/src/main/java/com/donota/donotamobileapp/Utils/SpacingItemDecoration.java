package com.donota.donotamobileapp.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int verticalSpaceHeight;
    private int horizontalSpaceWidth;

    public SpacingItemDecoration(int verticalSpaceHeight, int horizontalSpaceWidth) {
        this.verticalSpaceHeight = verticalSpaceHeight;
        this.horizontalSpaceWidth = horizontalSpaceWidth;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int position = parent.getChildAdapterPosition(view);
        int totalColumns = 2;

        int columnIndex = position % totalColumns;

        outRect.top = verticalSpaceHeight;
        outRect.bottom = verticalSpaceHeight;

        if (columnIndex == 0) {
            outRect.left = 0;
        } else {
            outRect.left = horizontalSpaceWidth;
        }

        if (columnIndex == totalColumns - 1) {
            outRect.right = 0;
        } else {
            outRect.right = horizontalSpaceWidth;
        }
    }

}
