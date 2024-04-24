package com.donota.donotamobileapp.fragments;

import android.database.Cursor;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.CategoryGridAdapter;
import com.donota.donotamobileapp.utils.SpacingItemDecoration;
import com.donota.donotamobileapp.database.impl.TbProductImpl;
import com.donota.donotamobileapp.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryPageFragment extends Fragment {

    private List<CategoryItem> itemList;

    private TbProductImpl tbProduct;

    private RecyclerView categoryRoomsRecyclerView;
    private RecyclerView categoryTypesRecyclerView;
    private RecyclerView categoryCollectionsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_page, container, false);

        categoryTypesRecyclerView = view.findViewById(R.id.revCateType);
        categoryRoomsRecyclerView = view.findViewById(R.id.revCateRoom);
        categoryCollectionsRecyclerView = view.findViewById(R.id.revCateCollection);

        initAdapter();
        loadFragment();

        categoryTypesRecyclerView.setNestedScrollingEnabled(false);
        categoryRoomsRecyclerView.setNestedScrollingEnabled(false);
        categoryCollectionsRecyclerView.setNestedScrollingEnabled(false);
        return view;
    }

    private void initAdapter() {
        categoryRoomsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        CategoryGridAdapter adapterRooms = new CategoryGridAdapter(requireContext(), loadCategoryRoomsData(), position -> {

        });
        categoryRoomsRecyclerView.setAdapter(adapterRooms);

        categoryCollectionsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        CategoryGridAdapter adapterCollections = new CategoryGridAdapter(requireContext(), loadCategoryCollectionsData(), position -> {

        });
        categoryCollectionsRecyclerView.setAdapter(adapterCollections);


        categoryTypesRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        CategoryGridAdapter adapterTypes = new CategoryGridAdapter(requireContext(), loadCategoryTypesData(), position -> {

        });
        categoryTypesRecyclerView.setAdapter(adapterTypes);
    }


    private List<CategoryItem> loadCategoryRoomsData() {
        List<CategoryItem> items = new ArrayList<>();
        tbProduct = new TbProductImpl(getContext());
        String queryCategoryRooms = "SELECT productid, productimg, productcategorysub3 FROM tbproduct AS t1 \n" +
                                    "WHERE productcategorysub3  LIKE (SELECT DISTINCT t2.productcategorysub3 FROM tbproduct AS t2 );";
        Cursor cursor = tbProduct.queryData(queryCategoryRooms);
        Log.d("Van vao duoc load room", "mung ghe");
        while (cursor!= null && cursor.moveToNext()) {
            String[] imgUrls = cursor.getString(1).split(";");
            String firstImg = imgUrls[0].trim();
            Log.d("Danh muc phong", cursor.getString(2));

            items.add(new CategoryItem(cursor.getString(1), firstImg ,cursor.getString(2)));
        }
        cursor.close();
        tbProduct.close();
        return items;
    }
    private List<CategoryItem> loadCategoryCollectionsData() {
        List<CategoryItem> items = new ArrayList<>();
        tbProduct = new TbProductImpl(getContext());
        String queryCategoryRooms = "SELECT productid, productimg, productcategorysub4 \n" +
                                    "FROM tbproduct AS t1\n" +
                                    "WHERE productid = (\n" +
                                    "    SELECT MAX(productid)\n" +
                                    "    FROM tbproduct AS t2\n" +
                                    "    WHERE (t2.productcategorysub4 NOT LIKE '1') AND (t2.productcategorysub4 = t1.productcategorysub4));";
        Cursor cursor = tbProduct.queryData(queryCategoryRooms);
        while (cursor!= null && cursor.moveToNext()) {
            String[] imgUrls = cursor.getString(1).split(";");
            String firstImg = imgUrls[0].trim();
            items.add(new CategoryItem(cursor.getString(1), firstImg ,cursor.getString(2)));
        }
        cursor.close();
        tbProduct.close();
        return items;
    }
    private List<CategoryItem> loadCategoryTypesData() {
        List<CategoryItem> items = new ArrayList<>();
        tbProduct = new TbProductImpl(getContext());
        String queryCategoryRooms = "SELECT productid, productimg, productcategorysub1\n" +
                                    "FROM tbproduct AS t1\n" +
                                    "WHERE productid = (\n" +
                                    "    SELECT MIN(productid)\n" +
                                    "    FROM tbproduct AS t2\n" +
                                    "    WHERE t2.productcategorysub1 = t1.productcategorysub1);";
        Cursor cursor = tbProduct.queryData(queryCategoryRooms);
        while (cursor.moveToNext()) {
            String[] imgUrls = cursor.getString(1).split(";");
            String firstImg = imgUrls[0].trim();
            items.add(new CategoryItem(cursor.getString(1), firstImg ,cursor.getString(2)));
        }
        cursor.close();
        tbProduct.close();
        return items;
    }

    private void loadFragment() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.navigation_bar, new NavigationBarFragment());
        transaction.commit();
    }
}
