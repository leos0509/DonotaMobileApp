package com.donota.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.donota.donotamobileapp.R;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    int images [] = {
            R.drawable.src_2,
            R.drawable.src_3
    };

    int headings[] = {
            R.string.heading_1,
            R.string.heading_2
    };
    int description[] = {
            R.string.desc_1,
            R.string.desc_2
    };
    public ViewPagerAdapter(Context context) {
        this.context = context;

    }
    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);
        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.imv_bst);
        TextView slideheading = (TextView) view.findViewById(R.id.txt_title);
        TextView slideDescription = (TextView) view.findViewById(R.id.txt_content);

        slidetitleimage.setImageResource(images[position]);
        slideheading.setText(headings[position]);
        slideDescription.setText(description[position]);
        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);

    }
}
