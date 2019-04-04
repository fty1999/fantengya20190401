package com.bawei.com.a20190404moniyk.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.com.a20190404moniyk.R;
import com.bawei.com.a20190404moniyk.model.bean.ShopBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 09:22:47
 * @Description:
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder>{
private Context context;
private List<ShopBean.DataBean> mList = new ArrayList<>();

    public ShopAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<ShopBean.DataBean> list){
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item1,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView1.setText(mList.get(i).getSellerName());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myViewHolder.recyclerView2.setLayoutManager(linearLayoutManager);
        ChildAdapter childAdapter = new ChildAdapter(context);
        childAdapter.setDatae(mList.get(i).getList());
        myViewHolder.recyclerView2.setAdapter(childAdapter);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox checkBox;
        private final TextView textView1;
        private final RecyclerView recyclerView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox1);
            textView1 = itemView.findViewById(R.id.text1);
            recyclerView2 = itemView.findViewById(R.id.recyclerView2);
        }
    }
}
