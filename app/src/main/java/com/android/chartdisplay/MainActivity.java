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
        StackedBarChartView stackedBarChart = (StackedBarChartView) findViewById(R.id.bar_chart);
        stackedBarChart.setOrientation(StackedBarChartView.HORIZONTAL);
        stackedBarChart.setGapInBetween(4f);

        StackedBarChartData stackedBarChartData = new StackedBarChartData();
        stackedBarChartData.setValue(20);
        stackedBarChartData.setColor(getResources().getColor(R.color.colorFirst));

        StackedBarChartData stackedBarChartData2 = new StackedBarChartData();
        stackedBarChartData2.setValue(20);
        stackedBarChartData2.setColor(getResources().getColor(R.color.colorSecond));

        StackedBarChartData stackedBarChartData3 = new StackedBarChartData();
        stackedBarChartData3.setValue(60);
        stackedBarChartData3.setColor(getResources().getColor(R.color.colorThird));


        List<StackedBarChartData> mList = new ArrayList<>();
        mList.add(stackedBarChartData);
        mList.add(stackedBarChartData2);
        mList.add(stackedBarChartData3);
        stackedBarChart.setBarData(mList);

    }
}
