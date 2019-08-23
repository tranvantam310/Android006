package com.windys.myapplication.CategoryWork;
// https://www.codexpedia.com/android/defining-item-click-listener-for-recyclerview-in-android/

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
import com.windys.myapplication.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context content;
    ArrayList<Category> data;
    private OnItemClickListener listener;
    RelativeLayout relativeLayout;

    public CategoryAdapter(Context content, ArrayList<Category> data, OnItemClickListener listener) {
        this.content = content;
        this.data = data;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Category category);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(content).inflate(R.layout.category_item_layout, viewGroup, false);

        RecyclerView.ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Category category = data.get(i);

        Picasso.get().load(category.getUrlCategory()).into(viewHolder.img_category);
        viewHolder.tv_category.setText(category.getName());

        //  viewHolder.bind(data.get(i), listener);

        if (data.get(i).getType() == 1) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(content, R.color.yello));
        } else if (data.get(i).getType() == 2) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(content, R.color.yello1));
        }

        /*else if (data.get(i).getCategoryID() == -1){
            relativeLayout.setBackgroundColor(Color.RED);
        }else {
            //relativeLayout.setBackgroundColor(Color.RED);
        }*/

        if (data.get(i).getCategoryID() == 4) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(content, R.color.weird));
        } else if (data.get(i).getCategoryID() == -1) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(content, R.color.pink));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_category;
        TextView tv_category;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_category = itemView.findViewById(R.id.img_cate_item_layout);
            tv_category = itemView.findViewById(R.id.tv_cate_item_layout);
            relativeLayout = itemView.findViewById(R.id.rl_category_root);
        }
    }

}
