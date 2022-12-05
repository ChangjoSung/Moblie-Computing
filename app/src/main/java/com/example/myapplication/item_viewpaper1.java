package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Debug;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class item_viewpaper1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    ToggleButton toggleButton;
    public item_viewpaper1() {
        // Required empty public constructor
    }

    public static item_viewpaper1 newInstance(String param1, String param2) {
        item_viewpaper1 fragment = new item_viewpaper1();
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.item_viewpaper1, container, false);

        //게임 이미지
        ImageView imageView[] = new ImageView[10];
        Integer imageViewId[] = {R.id.GameImage_1,R.id.GameImage_2,R.id.GameImage_3,R.id.GameImage_4,R.id.GameImage_5,
                R.id.GameImage_6,R.id.GameImage_7,R.id.GameImage_8,R.id.GameImage_9,R.id.GameImage_10};
        final Integer imageSource[] = {R.drawable.google_1,R.drawable.google_2,R.drawable.google_3,R.drawable.google_4,R.drawable.google_5,
                R.drawable.google_6,R.drawable.google_7,R.drawable.google_8,R.drawable.google_9,R.drawable.google_10};
        final Integer imageSource_2[] = {R.drawable.un_google_1,R.drawable.un_google_2,R.drawable.un_google_3,R.drawable.un_google_4,R.drawable.un_google_5,
                R.drawable.un_google_6,R.drawable.un_google_7,R.drawable.un_google_8,R.drawable.un_google_9,R.drawable.un_google_10};

        //게임 이름
        TextView gameName[] = new TextView[10];
        Integer gameNameId[] = {R.id.ChartName_1, R.id.ChartName_2, R.id.ChartName_3, R.id.ChartName_4, R.id.ChartName_5,
                R.id.ChartName_6, R.id.ChartName_7, R.id.ChartName_8, R.id.ChartName_9, R.id.ChartName_10};
        final String gameNameStr[] = { "원펀맨: 영웅의 길", "달토끼 키우기", "드래곤라자 오리진:국산 MMORPG",
                "언더토피아", "탕탕특공대", "파이널 헌터", "쩐의세계", "피파모바일",
                "후회하게 해주마", "문명: Reign of Power" };
        final String gameNameStr_2[] = { "Minecraft", "Football Manager 2023 Mobile", "스타듀 밸리 Stardew Valley",
                "A Dance Of Fire and Ice", "데드 셀 - Dead Cells", "Papers, Please", "Geometry Dash", "던전 스쿼드",
                "Slay the Spire", "The Past Within" };

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

        //정보 버튼
        Button button[] = new Button[10];
        Integer buttonId[] = {R.id.Button_1, R.id.Button_2, R.id.Button_3, R.id.Button_4, R.id.Button_5,
                R.id.Button_6, R.id.Button_7, R.id.Button_8, R.id.Button_9, R.id.Button_10};

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