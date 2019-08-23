package com.windys.myapplication.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.windys.myapplication.CategoryWork.Category;
import com.windys.myapplication.R;

import java.util.ArrayList;

public class CategoryAdapterFragment extends RecyclerView.Adapter<CategoryAdapterFragment.ViewHolder> {

    ArrayList<Category> data;
    Context context;
    RelativeLayout relativeLayout;

    public CategoryAdapterFragment(ArrayList<Category> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_fragment_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvCateItemLayout.setText(data.get(i).getName());
        Picasso.get().load(data.get(i).getUrlCategory()).into(viewHolder.imgCateItemLayout);

        if (data.get(i).getType() == 1) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.yello));
        } else if (data.get(i).getType() == 2) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.yello1));
        }

        if (data.get(i).getCategoryID() == 4) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.weird));
        } else if (data.get(i).getCategoryID() == -1) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.pink));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCateItemLayout;
        TextView tvCateItemLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCateItemLayout = itemView.findViewById(R.id.img_cate_item_layout);
            tvCateItemLayout = itemView.findViewById(R.id.tv_cate_item_layout);
            relativeLayout = itemView.findViewById(R.id.rl_category_root);
        }
    }
}
