package com.android.chartdisplay;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StackedBarChartView stackedBarChart = (StackedBarChartView) findViewById(R.id.bar_chart);
        StackedBarChartData stackedBarChartData = new StackedBarChartData();
        stackedBarChartData.setTextValue("60");
        stackedBarChartData.setValue(60);
        stackedBarChartData.setColor(Color.parseColor("#00ffff"));

        StackedBarChartData stackedBarChartData2 = new StackedBarChartData();
        stackedBarChartData2.setTextValue("40");
        stackedBarChartData2.setValue(40);
        stackedBarChartData2.setColor(Color.parseColor("#00ff00"));

        StackedBarChartData stackedBarChartData3 = new StackedBarChartData();
        stackedBarChartData3.setTextValue("10");
        stackedBarChartData3.setValue(10);
        stackedBarChartData3.setColor(Color.parseColor("#000000"));

        List<StackedBarChartData> mList = new ArrayList<>();
        mList.add(stackedBarChartData);
        mList.add(stackedBarChartData2);
        //mList.add(stackedBarChartData3);
        stackedBarChart.setBarData(mList);
        /*StackedBarChart stackedBarChart = (StackedBarChart) findViewById(R.id.bar_chart);
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
        stackedBarChart.setData(chartDatas);*/

    }
}
