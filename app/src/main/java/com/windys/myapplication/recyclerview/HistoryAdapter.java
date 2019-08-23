package com.windys.myapplication.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.windys.myapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    Context context;
    List<History> data /*= new ArrayList<>()*/;

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.history_item_layout, viewGroup, false);

        /*HistoryViewHolder historyViewHolder = new HistoryViewHolder(view);
        return historyViewHolder;*/
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder historyViewHolder, int i) {

        History history = data.get(i);

        historyViewHolder.tvTitle.setText(history.getTitle());
        historyViewHolder.tvBalance.setText(history.getBalance() + "");
        historyViewHolder.tvCode.setText(history.getCode());
        historyViewHolder.tvDate.setText(history.getCreateData());
        historyViewHolder.tvPoint.setText(history.getPoint() +"");

        Picasso.get().load(history.getIcon()).into(historyViewHolder.imgIcon);

        if(history.getPoint() > 50){
            historyViewHolder.tvPoint.setVisibility(View.VISIBLE);
        }else{
            historyViewHolder.tvPoint.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvPoint, tvCode, tvDate, tvBalance;
        //ImageView imgIcon;
        CircleImageView imgIcon;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.img_icon);
            tvTitle = itemView.findViewById(R.id.tv_title_history);
            tvBalance = itemView.findViewById(R.id.tv_balance);
            tvCode = itemView.findViewById(R.id.tv_code);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvPoint = itemView.findViewById(R.id.tv_point);
   //         imgIcon = itemView.findViewById(R.id.img_icon);
        }
    }
}
