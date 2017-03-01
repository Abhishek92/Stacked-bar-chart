package com.android.chartdisplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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
    private Paint mTextPaint;

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

    public StackedBarChartView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init()
    {
        mBarPaint = new Paint();
        mBarPaint.setAntiAlias(true);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        //Default text size
        mTextPaint.setTextSize(20f);
        mTextPaint.setColor(Color.parseColor("#ffffff"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawStackedBarChart(canvas);
    }

    private void drawStackedBarChart(Canvas canvas)
    {
        float barHeight = canvas.getHeight();
        float barWidth = canvas.getWidth();
        float lastHeight = 0f;
        int textY = 0;
        float totalValue = getTotalValue();
        for (int i = 0; i <mBarData.size() ; i++) {
            StackedBarChartData stackedBarChartData = mBarData.get(i);
            mBarPaint.setStyle(Paint.Style.FILL);
            mBarPaint.setColor(stackedBarChartData.getColor());
            float percentageVal = (stackedBarChartData.getValue() / totalValue) * 100;
            float height = mBarData.size() - 1 != i ? (barHeight / 100) * percentageVal : canvas.getHeight();
            canvas.drawRect(0, lastHeight, barWidth, lastHeight + height, mBarPaint);
            textY = i == 0 ? (int) ((lastHeight + height) / 2) : (int) (((barHeight - lastHeight) / 2) + lastHeight);
            canvas.drawText(stackedBarChartData.getTextValue(), barWidth / 2, textY, mTextPaint);
            lastHeight = lastHeight + height;
        }
    }

    public void setTextSize(float textSize)
    {
        if(null != mTextPaint)
        {
            mTextPaint.setTextSize(textSize);
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
