package com.android.chartdisplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StackedBarChart stackedBarChart = (StackedBarChart) findViewById(R.id.bar_chart);
        List<ChartData> chartDatas = new ArrayList<>();
        Float[] value1 = {80f,1f,6f,5f};
        Float[] value2 = {100f,2f,7f,9f};
        chartDatas.add(new ChartData(value1, "abc"));
        chartDatas.add(new ChartData(value2, "abc"));

        List<String> labels = new ArrayList<>();
        labels.add("Sun");
        labels.add("mon");
        labels.add("tue");
        labels.add("wed");

        stackedBarChart.setLabels(labels);
        stackedBarChart.setData(chartDatas);

    }
}
