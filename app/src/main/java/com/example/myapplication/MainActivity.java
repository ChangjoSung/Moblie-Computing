package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //뷰페이저 객체생성
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);

        //페이지 갯수지정
        pager.setOffscreenPageLimit(2);

        //어뎁터 객체생성
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        //뷰페이저에 프레그먼트 등록
        item_viewpaper1 fragment1 = new item_viewpaper1();
        adapter.addItem(fragment1);

        item_viewpaper2 fragment2 = new item_viewpaper2();
        adapter.addItem(fragment2);

        pager.setAdapter(adapter);

    }


    class MyPagerAdapter extends FragmentStatePagerAdapter{

        ArrayList<Fragment> items = new ArrayList<Fragment>();
        ArrayList<TextView> textViews = new ArrayList<TextView>();

        public void addText(TextView textView){
            textViews.add(textView);
        }


        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "페이지" + position;
        }
    }
}