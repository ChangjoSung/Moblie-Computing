package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class item_1 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PieChart pieChart = findViewById(R.id.pieChart);

        //샘플데이터
        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(594, "별 5"));
        visitors.add(new PieEntry(45 , "별 4"));
        visitors.add(new PieEntry(51 , "별 3"));
        visitors.add(new PieEntry(21 , "별 2"));
        visitors.add(new PieEntry(190, "별 1"));

        PieDataSet pieDataSet = new PieDataSet(visitors, "평점");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(15f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("평점\n3.9");
        pieChart.setCenterTextSize(20f);
        pieChart.animate();
    }

}