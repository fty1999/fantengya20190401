package com.bawei.com.a20190404moniyk.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.com.a20190404moniyk.R;
import com.bawei.com.a20190404moniyk.model.bean.ShopBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 09:51:16
 * @Description:
 */
public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.MyChildViewHolder>{

    private Context mcontext;
    private List<ShopBean.DataBean.ListBean> MList = new ArrayList<>();

    public ChildAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    public void setDatae(List<ShopBean.DataBean.ListBean> list){
        MList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item2,null);
        MyChildViewHolder myChildViewHolder = new MyChildViewHolder(view);
        return myChildViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyChildViewHolder myChildViewHolder, int i) {
        myChildViewHolder.textView_title.setText(MList.get(i).getTitle());
        myChildViewHolder.textView_price.setText(MList.get(i).getPrice());
        Glide.with(mcontext).load(MList.get(i).getDetailUrl()).into(myChildViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return MList.size();
    }

    public class MyChildViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox checkBox_id;
        private final ImageView imageView;
        private final TextView textView_title;
        private final TextView textView_price;

        public MyChildViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox_id = itemView.findViewById(R.id.checkbox_id);
            imageView = itemView.findViewById(R.id.image);
            textView_title = itemView.findViewById(R.id.text_title);
            textView_price = itemView.findViewById(R.id.text_price);
        }
    }
}
