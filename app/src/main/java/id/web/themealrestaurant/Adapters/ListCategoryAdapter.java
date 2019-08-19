package id.web.themealrestaurant.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.web.themealrestaurant.R;
import id.web.themealrestaurant.object.Category;

public class ListCategoryAdapter  extends RecyclerView.Adapter<ListCategoryAdapter.ListViewHolder>{
    private ArrayList<Category>listCategory;


    public ListCategoryAdapter(ArrayList<Category>list) {
        this.listCategory = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_categorymenu, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Category hero = listCategory.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(hero.getName());
        holder.tvDescription.setText(hero.getDescription());
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
