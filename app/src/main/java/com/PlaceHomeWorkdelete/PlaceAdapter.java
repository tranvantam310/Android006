package com.PlaceHomeWorkdelete;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.windys.myapplication.R;
import com.windys.myapplication.recyclerview.Place1;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    ArrayList<Place1> data;
    Context context;


    public PlaceAdapter(ArrayList<Place1> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.place_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Place1 placeWork = data.get(i);
        viewHolder.tvPlaceName.setText(placeWork.getPlaceName());

        if (placeWork.getIsMoreDetail() == 1) {
            viewHolder.tvIsmoreDetail.setVisibility(View.VISIBLE);
            viewHolder.llRoot.setBackgroundColor(context.getResources().getColor(R.color.weird));
        } else {
            viewHolder.llRoot.setBackgroundColor(context.getResources().getColor(R.color.white));
            viewHolder.tvIsmoreDetail.setVisibility(View.INVISIBLE);
        }

       /* viewHolder.tvIsmoreDetail.setText(placeWork.getIsMoreDetail());
        viewHolder.tvIspromotion.setText(placeWork.getIsPromotion());*/

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llRoot;
        TextView tvPlaceName;
        TextView tvIsmoreDetail;
        TextView tvIspromotion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPlaceName = itemView.findViewById(R.id.tv_placename);
            tvIsmoreDetail = itemView.findViewById(R.id.tv_ismoredetail);
            tvIspromotion = itemView.findViewById(R.id.tv_ispromotion);
            llRoot = itemView.findViewById(R.id.ll_root);
        }
    }
}
