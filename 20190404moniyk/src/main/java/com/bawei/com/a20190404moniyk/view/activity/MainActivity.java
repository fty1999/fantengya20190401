package com.bawei.com.a20190404moniyk.view.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawei.com.a20190404moniyk.R;
import com.bawei.com.a20190404moniyk.view.fragment.Frag_one;
import com.bawei.com.a20190404moniyk.view.fragment.Frag_two;

public class MainActivity extends FragmentActivity {

    private FrameLayout frameLayout;
    private RadioGroup radioGroup;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fram);
        radioGroup = findViewById(R.id.radioGroup);

        manager = getSupportFragmentManager();
        final Frag_one one = new Frag_one();
        final Frag_two two = new Frag_two();

        manager.beginTransaction()
                .add(R.id.fram,one)
                .add(R.id.fram,two)
                .commit();

        manager.beginTransaction().hide(two).show(one).commit();
        radioGroup.check(radioGroup.getChildAt(0).getId());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio0:
                        manager.beginTransaction().hide(two).show(one).commit();
                        break;
                    case R.id.radio1:
                        manager.beginTransaction().hide(one).show(two).commit();
                        break;
                }
            }
        });
    }
}
