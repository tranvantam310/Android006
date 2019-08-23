package com.windys.myapplication.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.windys.myapplication.R;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    ArrayList<Place1> data;
    private Context context;

    public PlaceAdapter(ArrayList<Place1> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.place_item_1, viewGroup, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder placeViewHolder,int i) {
        Place1 placeWork = data.get(i);
        placeViewHolder.tv_placeName.setText(placeWork.getPlaceName());

/*
        Place placeWork = data.get(i);
        viewHolder.tvPlaceName.setText(placeWork.getPlaceName());*/

        //placeViewHolder.tv_isPromotion.setText(data.get(i).getIsPromotion() + ""); // ??? "  "

        if (data.get(i).getIsMoreDetail() == 1) {
            placeViewHolder.tv_isMoreDetail.setVisibility(View.VISIBLE);
            placeViewHolder.linearLayout.setBackground(context.getDrawable(R.color.yello));

        } else {
            placeViewHolder.tv_isMoreDetail.setVisibility(View.GONE);
            placeViewHolder.linearLayout.setBackground(context.getDrawable(R.color.white));
        }

        if (data.get(i).getIsPromotion() == 1) {
            placeViewHolder.tv_isPromotion.setVisibility(View.VISIBLE);
        } else {
            placeViewHolder.tv_isPromotion.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {

        TextView tv_placeName, tv_isPromotion, tv_isMoreDetail;
        LinearLayout linearLayout;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_placeName = itemView.findViewById(R.id.tv_placename);
            tv_isMoreDetail = itemView.findViewById(R.id.tv_ismoredetail);
            tv_isPromotion = itemView.findViewById(R.id.tv_ispromotion);
            linearLayout = itemView.findViewById(R.id.ll_root);
        }
    }
}
