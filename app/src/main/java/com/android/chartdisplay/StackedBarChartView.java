package com.android.chartdisplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
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
    private float gapInDp;

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

    public void setMarginInBetween(float gapInDp){
        this.gapInDp = gapInDp;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
        gapInDp = convertDpToPixel(gapInDp, getContext());
        for (int i = 0; i < mBarData.size() ; i++) {
            StackedBarChartData stackedBarChartData = mBarData.get(i);
            mBarPaint.setStyle(Paint.Style.FILL);
            mBarPaint.setColor(stackedBarChartData.getColor());
            float percentageVal = (stackedBarChartData.getValue() / totalValue) * 100;
            float width = mBarData.size() - 1 != i ? (barWidth / 100) * percentageVal : canvas.getWidth();
            int radius = getRadius(i, mBarData.size());
            canvas.drawRect(lastWidth, 0, lastWidth + width, barHeight, mBarPaint);
            lastWidth = lastWidth + width + gapInDp;
        }
    }

    private void drawVerticalStackedBarChart(Canvas canvas) {
        float barHeight = canvas.getHeight();
        float barWidth = canvas.getWidth();
        float lastHeight = 0f;
        float totalValue = getTotalValue();
        gapInDp = convertDpToPixel(gapInDp, getContext());
        for (int i = 0; i <mBarData.size() ; i++) {
            StackedBarChartData stackedBarChartData = mBarData.get(i);
            mBarPaint.setStyle(Paint.Style.FILL);
            mBarPaint.setColor(stackedBarChartData.getColor());
            float percentageVal = (stackedBarChartData.getValue() / totalValue) * 100;
            float height = mBarData.size() - 1 != i ? (barHeight / 100) * percentageVal : canvas.getHeight();
            int radius = getRadius(i, mBarData.size());
            canvas.drawRect(0, lastHeight, barWidth, lastHeight + height,mBarPaint);
            lastHeight = lastHeight + height + gapInDp;
        }
    }

    public static float convertDpToPixel(float dp, Context context){
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }


    private int getRadius(int position, int size){
        return position == 0 || position == size - 1 ? 10 : 0;
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
        invalidate();
    }
}
