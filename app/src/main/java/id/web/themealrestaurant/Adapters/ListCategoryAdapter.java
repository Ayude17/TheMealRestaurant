package id.web.themealrestaurant.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import id.web.themealrestaurant.R;
import id.web.themealrestaurant.object.Category;
import id.web.themealrestaurant.object.CategoryData;

import static android.media.CamcorderProfile.get;

public class ListCategoryAdapter  extends RecyclerView.Adapter<ListCategoryAdapter.ListViewHolder>{
    private ArrayList<Category>listCategory;
    private Context context;

    public ListCategoryAdapter(ArrayList<Category>list) {
        super();
        this.listCategory = list;

    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_categorymenu, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        final Category category = listCategory.get(position);

        Glide.with(holder.itemView.getContext())
                .load(category.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(category.getName());
        holder.tvDescription.setText(category.getDescription());

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click element"+ category, Snackbar.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listCategory.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_des);


        }
    }
}

//public class ListCategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
//
//    private Context context;
//    public static ArrayList<CategoryData> data;
//
//    public ListCategoryAdapter(Context context, ArrayList<CategoryData> data1){
//        super();
//        this.context = context;
//        data = data1;
//
//    }
//    @NonNull
//    @Override
//    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
//        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_categorymenu, null);
//        return new CategoryViewHolder(layoutView);
//    }
//    @Override
//    public void onBindViewHolder(CategoryViewHolder holder, int position){
//        Category category = listCategory.get(position);
//        Glide.with(holder.itemView.getContext())
//                .load(category.getPhoto())
//                .apply(new RequestOptions().override(55, 55))
//                .into(holder.imgPhoto);
//        holder.tvName.setText(category.getName());
//        holder.tvDescription.setText(listCategory.getDescription());
//    }
//
//    @Override
//    public int getItemCount(){
//        return listCategory.size();
//    }
//    }