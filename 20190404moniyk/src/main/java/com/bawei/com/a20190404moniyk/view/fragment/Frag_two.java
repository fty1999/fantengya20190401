package com.bawei.com.a20190404moniyk.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.com.a20190404moniyk.R;
import com.bawei.com.a20190404moniyk.view.activity.LoginActivity;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 09:10:23
 * @Description:
 */
public class Frag_two extends Fragment {

    private ImageView imageView_tx;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_two,container,false);
        imageView_tx = view.findViewById(R.id.image_tx);
        imageView_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        return view;
    }
}
