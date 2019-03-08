package com.android.chartdisplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp pc on 28-02-2017.
 */

public class StackedBarChartView extends View {

    private List<StackedBarChartData> mBarData = new ArrayList<>();
    private Paint mBarPaint;
    public static int HORIZONTAL = 1;
    public static int VERTICAL = 2;

    private int orientation;

    public StackedBarChartView(Context context) {
        super(context);
        init();
    }

    public StackedBarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public StackedBarChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        mBarPaint = new Paint();
        mBarPaint.setAntiAlias(true);

    }

    public void setOrientation(int orientation){
        this.orientation = orientation;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(orientation == HORIZONTAL) {
            drawHorizontalStackedBarChart(canvas);
        }
        else{
            drawVerticalStackedBarChart(canvas);
        }
    }

    private void drawHorizontalStackedBarChart(Canvas canvas) {
        float barHeight = canvas.getHeight();
        float barWidth = canvas.getWidth();
        float lastWidth = 0f;
        float totalValue = getTotalValue();
        for (int i = 0; i < mBarData.size() ; i++) {
            StackedBarChartData stackedBarChartData = mBarData.get(i);
            mBarPaint.setStyle(Paint.Style.FILL);
            mBarPaint.setColor(stackedBarChartData.getColor());
            float percentageVal = (stackedBarChartData.getValue() / totalValue) * 100;
            float width = mBarData.size() - 1 != i ? (barWidth / 100) * percentageVal : canvas.getWidth();
            canvas.drawRect(lastWidth, 0, lastWidth + width, barHeight, mBarPaint);
            lastWidth = lastWidth + width;
        }
    }

    private void drawVerticalStackedBarChart(Canvas canvas) {
        float barHeight = canvas.getHeight();
        float barWidth = canvas.getWidth();
        float lastHeight = 0f;
        float totalValue = getTotalValue();
        for (int i = 0; i <mBarData.size() ; i++) {
            StackedBarChartData stackedBarChartData = mBarData.get(i);
            mBarPaint.setStyle(Paint.Style.FILL);
            mBarPaint.setColor(stackedBarChartData.getColor());
            float percentageVal = (stackedBarChartData.getValue() / totalValue) * 100;
            float height = mBarData.size() - 1 != i ? (barHeight / 100) * percentageVal : canvas.getHeight();
            canvas.drawRect(0, lastHeight, barWidth, lastHeight + height, mBarPaint);
            lastHeight = lastHeight + height;
        }
    }



    private float getTotalValue()
    {
        float total = 0;
        for (int i = 0; i <mBarData.size() ; i++) {
            total += mBarData.get(i).getValue();
        }
        return total;
    }

    public void setBarData(List<StackedBarChartData> mBarDataList)
    {
        mBarData = mBarDataList;
    }
}
