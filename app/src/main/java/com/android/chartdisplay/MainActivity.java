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

        StackedBarChartData stackedBarChartData = new StackedBarChartData();
        stackedBarChartData.setValue(60);
        stackedBarChartData.setColor("#00ffff");

        StackedBarChartData stackedBarChartData2 = new StackedBarChartData();
        stackedBarChartData2.setValue(40);
        stackedBarChartData2.setColor("#00ff00");

        StackedBarChartData stackedBarChartData3 = new StackedBarChartData();
        stackedBarChartData3.setValue(10);
        stackedBarChartData3.setColor("#000000");

        StackedBarChartData stackedBarChartData4 = new StackedBarChartData();
        stackedBarChartData4.setValue(5);
        stackedBarChartData4.setColor("#0000ff");

        List<StackedBarChartData> mList = new ArrayList<>();
        mList.add(stackedBarChartData);
        mList.add(stackedBarChartData2);
        mList.add(stackedBarChartData3);
        mList.add(stackedBarChartData4);
        stackedBarChart.setBarData(mList);

        stackedBarChart.invalidate();
    }
}
