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

    private int barWidth;
    private int barHeight;
    private List<StackedBarChartData> mBarData = new ArrayList<>();
    private Paint mBarPaint;
    private Paint mTextPaint;

    private float lastHeight = 0f;

    public StackedBarChartView(Context context) {
        super(context);
        mBarPaint = new Paint();
        mBarPaint.setAntiAlias(true);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
    }

    public StackedBarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBarPaint = new Paint();
        mBarPaint.setAntiAlias(true);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(30f);
        mTextPaint.setColor(Color.parseColor("#ffffff"));
    }

    public StackedBarChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public StackedBarChartView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        barHeight = canvas.getHeight();
        barWidth = canvas.getWidth();
        int textY = 0;
        int totalValue = getTotalValue();
        for (int i = 0; i <mBarData.size() ; i++) {
            StackedBarChartData stackedBarChartData = mBarData.get(i);
            mBarPaint.setStyle(Paint.Style.FILL);
            mBarPaint.setColor(stackedBarChartData.getColor());
            float percentageVal = ((float)stackedBarChartData.getValue() / (float) totalValue) * 100;
            float height = mBarData.size() - 1 != i ? ((float) barHeight /100) * percentageVal : canvas.getHeight();
            canvas.drawRect(0,lastHeight, barWidth, lastHeight + height, mBarPaint);
            if(i == 0)
                textY = (int)((lastHeight + height) / 2);
            else
                textY = (int)(((barHeight - lastHeight) / 2) + lastHeight);
            canvas.drawText(stackedBarChartData.getTextValue(), barWidth/2, textY, mTextPaint);
            lastHeight = lastHeight + height;
        }
    }

    private int getTotalValue()
    {
        int total = 0;
        for (int i = 0; i <mBarData.size() ; i++) {
            total += mBarData.get(i).getValue();
        }
        return total;
    }

    public void setBarData(List<StackedBarChartData> mBarDataList)
    {
        mBarData = mBarDataList;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        barWidth = widthMeasureSpec;
        barHeight = heightMeasureSpec;
        setMeasuredDimension(barWidth, barHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
