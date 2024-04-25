//package com.donota.donotamobileapp.adapter;
//
//import android.content.Context;
//import android.media.Image;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.donota.donotamobileapp.R;
//import com.donota.donotamobileapp.model.Product;
//import com.donota.donotamobileapp.model.ProductCard;
//
//import java.util.List;
//
//public class ProductDetailAdapter extends RecyclerView.Adapter<ProductDetailAdapter.ProductDetailViewHolder>{
//    private Context context;
//    private List<Product> productList;
//
//    public ProductDetailAdapter(Context context, List<Product> productList) {
//        this.context = context;
//        this.productList = productList;
//    }
//
//    public Context getContext() {
//        return context;
//    }
//
//    public void setContext(Context context) {
//        this.context = context;
//    }
//
//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }
//
//    @NonNull
//    @Override
//    public ProductDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_carousel, parent, false);
//            return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ProductDetailViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    private static class ProductDetailViewHolder extends RecyclerView.ViewHolder {
//        ImageView imvThump;
//        TextView txtProductName, txtProductPrice, txtProductRating, txtProductDescription;
//
//        ListView lvlSimilarProduct;
//        public ProductDetailViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imvThump = itemView.findViewById(R.id.imvProductThumb);
//            txtProductName = itemView.findViewById(R.id.txtProductName);
//            txtProductRating = itemView.findViewById(R.id.txtRating);
//            txtProductDescription = itemView.findViewById(R.id.txtDescriptionContent);
//            txtProductPrice = itemView.findViewById(R.id.txtProductPrice);
//            lvlSimilarProduct = itemView.findViewById(R.id.revSimilarProduct);
//        }
//    }
//}
