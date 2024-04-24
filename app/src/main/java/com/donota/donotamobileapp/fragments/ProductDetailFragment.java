package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.ProductCarouselAdapter;
import com.donota.donotamobileapp.model.ProductCard;
import com.donota.donotamobileapp.utils.CarouselItemDecoration;
import com.donota.donotamobileapp.utils.MaxWidthItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailFragment extends Fragment {

    private List<ProductCard> productCards;

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);

        productCards = new ArrayList<>();


        RecyclerView recyclerView = view.findViewById(R.id.revSimilarProduct);
        ProductCarouselAdapter adapter = new ProductCarouselAdapter(getContext(), productCards, position -> {

        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);


        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_4dp);
        recyclerView.addItemDecoration(new CarouselItemDecoration(spacingInPixels, spacingInPixels));

        return view;
    }
}
