package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link item_viewpaper2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class item_viewpaper2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ToggleButton toggleButton;

    public item_viewpaper2() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static item_viewpaper2 newInstance(String param1, String param2) {
        item_viewpaper2 fragment = new item_viewpaper2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.item_viewpaper2, container, false);

        ImageView imageView[] = new ImageView[10];
        Integer imageViewId[] = {R.id.AppGameImage_1,R.id.AppGameImage_2,R.id.AppGameImage_3,R.id.AppGameImage_4,R.id.AppGameImage_5,
                R.id.AppGameImage_6,R.id.AppGameImage_7,R.id.AppGameImage_8,R.id.AppGameImage_9,R.id.AppGameImage_10};

        final Integer imageSource[] = {R.drawable.appstore_1,R.drawable.appstore_2,R.drawable.appstore_3,R.drawable.appstore_4,R.drawable.appstore_5,
                R.drawable.appstore_6,R.drawable.appstore_7,R.drawable.appstore_8,R.drawable.appstore_9,R.drawable.appstore_10};
        final Integer imageSource_2[] = {R.drawable.un_appstore_1,R.drawable.un_appstore_2,R.drawable.un_appstore_3,R.drawable.un_appstore_4,R.drawable.un_appstore_5,
                R.drawable.un_appstore_6,R.drawable.un_appstore_7,R.drawable.un_appstore_8,R.drawable.un_appstore_9,R.drawable.un_appstore_10};


        TextView gameName[] = new TextView[10];
        Integer gameNameId[] = {R.id.AppChartName_1, R.id.AppChartName_2, R.id.AppChartName_3, R.id.AppChartName_4, R.id.AppChartName_5,
                R.id.AppChartName_6, R.id.AppChartName_7, R.id.AppChartName_8, R.id.AppChartName_9, R.id.AppChartName_10};

        final String gameNameStr[] = { "원펀맨: 영웅의 길", "Valor Legends: 이터널 서머너", "언더토피아",
                "탕탕특공대", "Makeover Studio: Makeup Games", "피파모바일", "갓물주 키우기", "FIFA ONLINE 4 M by EA SPORTS™",
                "마이티 파워: 배틀 히어로즈", "텐텐 (TenTen)" };
        final String gameNameStr_2[] = { "Minecraft", "Football Manager 2023 Mobile", "A Dance of Fire and Ice",
                "Tank Hero", "The Past Within", "Stardew Vally", "Pocket Build", "Slay the Spire",
                "Pou", "Geometry Dash" };


        Button button[] = new Button[10];
        Integer buttonId[] = {R.id.AppButton_1, R.id.AppButton_2, R.id.AppButton_3, R.id.AppButton_4, R.id.AppButton_5,
                R.id.AppButton_6, R.id.AppButton_7, R.id.AppButton_8, R.id.AppButton_9, R.id.AppButton_10};

        //무료 / 유료 앱 전환
        toggleButton = (ToggleButton) rootView.findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean bool = ((ToggleButton)v).isChecked();

                if(bool){
                    for (int i = 0; i < imageViewId.length; i++) {
                        final int index; // 주의! 꼭 필요함..
                        index = i;

                        imageView[index] = (ImageView) rootView.findViewById(imageViewId[index]);
                        imageView[index].setImageResource(imageSource_2[index]);
                    }

                    for (int i = 0; i < gameNameId.length; i++) {
                        final int index; // 주의! 꼭 필요함..
                        index = i;
                        gameName[index] = (TextView) rootView.findViewById(gameNameId[index]);
                        gameName[index].setText(gameNameStr_2[index]);
                    }
                }

                else{
                    for (int i = 0; i < imageViewId.length; i++) {
                        final int index; // 주의! 꼭 필요함..
                        index = i;

                        imageView[index] = (ImageView) rootView.findViewById(imageViewId[index]);
                        imageView[index].setImageResource(imageSource[index]);
                    }

                    for (int i = 0; i < gameNameId.length; i++) {
                        final int index; // 주의! 꼭 필요함..
                        index = i;
                        gameName[index] = (TextView) rootView.findViewById(gameNameId[index]);
                        gameName[index].setText(gameNameStr[index]);
                    }
                }
            }
        });

        for (int i = 0; i < buttonId.length; i++) {
            final int index; // 주의! 꼭 필요함..
            index = i;
            button[index] = (Button) rootView.findViewById(buttonId[index]);
            button[index].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        button[index].setBackgroundColor(Color.LTGRAY);
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        button[index].setBackgroundColor(Color.GRAY);
                    }

                    return false;
                }
            });
        }

        button[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext() , item_1.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}