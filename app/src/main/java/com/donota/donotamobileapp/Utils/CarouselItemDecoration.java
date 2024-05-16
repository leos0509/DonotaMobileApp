package com.donota.donotamobileapp.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class CarouselItemDecoration extends RecyclerView.ItemDecoration {
    private int verticalSpaceHeight;
    private int horizontalSpaceWidth;

    public CarouselItemDecoration(int verticalSpaceHeight, int horizontalSpaceWidth) {
        this.verticalSpaceHeight = verticalSpaceHeight;
        this.horizontalSpaceWidth = horizontalSpaceWidth;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int position = parent.getChildAdapterPosition(view);
        outRect.top = verticalSpaceHeight;
        outRect.bottom = verticalSpaceHeight;

        if (position == 0) {
            outRect.left = 0;
            outRect.right = horizontalSpaceWidth;
        } else {
            outRect.left = horizontalSpaceWidth;
            outRect.right = horizontalSpaceWidth;
        }
    }

}
