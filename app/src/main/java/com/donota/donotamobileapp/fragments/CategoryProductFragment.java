package com.donota.donotamobileapp.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.ProductGridAdapter;
import com.donota.donotamobileapp.database.impl.TbProductImpl;
import com.donota.donotamobileapp.databinding.FragmentCategoryProductBinding;
import com.donota.donotamobileapp.model.ProductCard;
import com.donota.donotamobileapp.utils.SpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class CategoryProductFragment extends Fragment {

    private FragmentCategoryProductBinding binding;
    private TbProductImpl tbProduct;

    public CategoryProductFragment() {}

    public static CategoryProductFragment newInstance() {
        return new CategoryProductFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryProductBinding.inflate(inflater, container, false);
        setupProductGrid();
        return binding.getRoot();
    }

    private void setupProductGrid() {
        List<ProductCard> productCards = loadProductDataForCategory();
        ProductGridAdapter productGridAdapter = new ProductGridAdapter(requireContext(), productCards, productCard -> {});
        binding.revProduct.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        binding.revProduct.setAdapter(productGridAdapter);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_4dp);
        binding.revProduct.addItemDecoration(new SpacingItemDecoration(spacingInPixels, spacingInPixels));
    }

    private List<ProductCard> loadProductDataForCategory() {
        List<ProductCard> productList = new ArrayList<>();
        tbProduct = new TbProductImpl(requireContext());
        String queryProduct = "SELECT productimg, productname, productrating, productprice, productId from tbproduct ";
        Cursor cursor = tbProduct.queryData(queryProduct);
        while (cursor != null && cursor.moveToNext()) {
            String[] imgUrls = cursor.getString(0).split(";");
            String firstImg = imgUrls[0].trim();
            productList.add(new ProductCard(firstImg, cursor.getString(1),cursor.getString(2),cursor.getInt(3), cursor.getString(4)));
        }
        cursor.close();
        tbProduct.close();
        return productList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

