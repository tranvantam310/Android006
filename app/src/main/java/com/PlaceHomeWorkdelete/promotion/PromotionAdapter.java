package com.PlaceHomeWorkdelete.promotion;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.windys.myapplication.R;
import com.windys.myapplication.fragment.MainActivity;

import java.util.ArrayList;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder> {

    ArrayList<Result> data;
    Context context;
    View view;
    RelativeLayout relativeLayout;


    public PromotionAdapter(ArrayList<Result> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {

        view = LayoutInflater.from(context).inflate(R.layout.promotion_item_layout, viewGroup, false);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                context.startActivity(intent);
            }
        });

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Result result = data.get(i);
        viewHolder.rvPromotionName.setText(result.promotionName);
//        viewHolder.tvPlaceName.setText(result.placeDetail.placeName);

        viewHolder.tvPlaceName.setText(result.getPlaceDetail().getPlaceName());
        Picasso.get().load(result.getUrlImage()).into(viewHolder.imgUrlImage);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgUrlImage;
        TextView tvPlaceName, rvPromotionName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // onclicklistener
            itemView.setOnClickListener(this);

            imgUrlImage = itemView.findViewById(R.id.img_urlImage);
            tvPlaceName = itemView.findViewById(R.id.tv_placeName);
            rvPromotionName = itemView.findViewById(R.id.tv_promotionName);
            relativeLayout = itemView.findViewById(R.id.rl_promotion);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            context.startActivity(intent);
        }
    }


   /* public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }*/
}
