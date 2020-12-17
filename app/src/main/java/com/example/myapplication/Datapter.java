package com.example.myapplication;

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
import com.example.myapplication.bean.Bean;

import java.util.ArrayList;

public class Datapter extends RecyclerView.Adapter {
    private ArrayList<Bean.DataBean> list;
    private Context context;
    private ImageView mIv;
    private TextView mTv;

    public Datapter(ArrayList<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderone(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolderone viewHolderone = (ViewHolderone) holder;
            viewHolderone.mTv.setText(list.get(position).get_id());
            Glide.with(context).load(list.get(position)).apply(new RequestOptions().circleCrop()).into(viewHolderone.mIv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolderone extends RecyclerView.ViewHolder{
        View view;
        ImageView mIv;
        TextView mTv;

        ViewHolderone(View view) {
            super(view);
            this.view = view;
            this.mIv = (ImageView) view.findViewById(R.id.iv);
            this.mTv = (TextView) view.findViewById(R.id.tv);
        }
    }
}
