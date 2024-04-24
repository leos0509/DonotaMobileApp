package com.donota.donotamobileapp.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.BestSellerCarouselAdapter;
import com.donota.donotamobileapp.adapter.CategoryCarouselAdapter;
import com.donota.donotamobileapp.adapter.ProductGridAdapter;
import com.donota.donotamobileapp.database.impl.TbProductImpl;
import com.donota.donotamobileapp.databinding.FragmentHomepageBinding;
import com.donota.donotamobileapp.model.CarouselItem;
import com.donota.donotamobileapp.model.ProductCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class HomePageFragment extends Fragment {

    private FragmentHomepageBinding binding;

    private TbProductImpl tbProduct;

    private RecyclerView carouselBestSellerRecyclerView;
    private RecyclerView carouselCategoryRecyclerView;
    private RecyclerView productRecyclerView;
    private List<CarouselItem> carouselItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        carouselBestSellerRecyclerView = view.findViewById(R.id.revCarouselBestSeller);
        carouselCategoryRecyclerView = view.findViewById(R.id.revCarouselCategory);
        productRecyclerView = view.findViewById(R.id.revProduct);

        setupCarousels();
        setupProducts();
        loadFragment();

        ImageView imageView = view.findViewById(R.id.imvSlider);

        String imageUrl = "https://mocshop.com.vn/library/module_new/bao-gia-thiet-ke---thi-cong-noi-that_s2030.jpg";
        Glide.with(getContext()) // Use getContext() instead of this
                .load(imageUrl)
                .override(200, 100)
                .centerCrop()
                .into(imageView);

        return view;
    }
    private void setupCarousels() {
        List<CarouselItem> bestSellerItems = loadBestSellerCarouselData();
        // Setup for the first carousel
        carouselBestSellerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        // Handle item click for the first carousel
        BestSellerCarouselAdapter carouselBestSellerAdapter = new BestSellerCarouselAdapter(getContext(), bestSellerItems, new BestSellerCarouselAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click for the first carousel
            }
        });
        carouselBestSellerRecyclerView.setAdapter(carouselBestSellerAdapter);

        List<CarouselItem> categoryItems = loadCategoryCarouselData();
        carouselCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        CategoryCarouselAdapter carouselCategoryAdapter = new CategoryCarouselAdapter(getContext(), categoryItems, new CategoryCarouselAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        carouselCategoryRecyclerView.setAdapter(carouselCategoryAdapter);
    }
    private List<CarouselItem> loadBestSellerCarouselData() {
        carouselItems = new ArrayList<>();
        tbProduct = new TbProductImpl(getContext());
        String sql = "SELECT productid, productimg FROM tbproduct WHERE productprice > 17500000 ";
        Cursor cursor = tbProduct.queryData(sql);
        while (cursor.moveToNext()) {
            String[] imgUrls = cursor.getString(1).split(";");
            String itemImg = imgUrls[0].trim();
            carouselItems.add(new CarouselItem(itemImg, cursor.getString(0)));
        }
        cursor.close();
        tbProduct.close();
        return carouselItems;
    }
    private List<CarouselItem> loadCategoryCarouselData() {
        carouselItems = new ArrayList<>();
        tbProduct = new TbProductImpl(getContext());
        String sql = "SELECT productid, productimg, productcategorysub1\n" +
                "FROM tbproduct AS t1\n" +
                "WHERE productid = (\n" +
                "    SELECT MIN(productid)\n" +
                "    FROM tbproduct AS t2\n" +
                "    WHERE t2.productcategorysub1 = t1.productcategorysub1);";
        Cursor cursor = tbProduct.queryData(sql);
        while (cursor.moveToNext()) {
            String[] imgUrls = cursor.getString(1).split(";");
            String itemImg = imgUrls[0].trim();
            Log.d("sub1", cursor.getString(2));
            carouselItems.add(new CarouselItem(itemImg, cursor.getString(0)));
        }
        cursor.close();
        tbProduct.close();
        return carouselItems;
    }

    private void setupProducts() {
        List<ProductCard> productCards = loadProductData();
        ProductGridAdapter productGridAdapter = new ProductGridAdapter(getContext(), productCards);
        productRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        productRecyclerView.setAdapter(productGridAdapter);
    }

    private List<ProductCard> loadProductData() {
        List<ProductCard> productList = new ArrayList<>();
        tbProduct = new TbProductImpl(getContext());
        String queryProduct = "SELECT productimg, productname, productrating, productprice from tbproduct ";
        Cursor cursor = tbProduct.queryData(queryProduct);
        while (cursor!= null && cursor.moveToNext()) {
            String[] imgUrls = cursor.getString(0).split(";");
            String firstImg = imgUrls[0].trim();
            productList.add(new ProductCard(firstImg, cursor.getString(1),cursor.getString(2),cursor.getInt(3)));
        }
        cursor.close();
        tbProduct.close();
        return productList;
    }

    private List<String> getFirstCategory() {
        tbProduct = new TbProductImpl(getContext());

        String sql = "SELECT productcategory FROM tbproduct WHERE ";
        Cursor cursor = tbProduct.queryData(sql);
        List<String> listWithDuplicates = new ArrayList<>(); // Danh sách có các phần tử trùng
        while (cursor.moveToNext()) {
            String categoriesString = cursor.getString(0);
            String[] categories = categoriesString.split(";");
            listWithDuplicates.add(categories[0].trim());
//            for (String category : categories) {
//                listWithDuplicates.add(category.trim());
        }
        cursor.close();
        tbProduct.close();
        Set<String> setWithoutDuplicates = new HashSet<>(listWithDuplicates);
        return new ArrayList<>(setWithoutDuplicates);
    }

    private void loadFragment() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.navigation_bar, new NavigationBarFragment());
        transaction.commit();
    }

}
