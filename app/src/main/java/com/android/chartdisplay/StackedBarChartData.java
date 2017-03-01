package com.android.chartdisplay;

import android.graphics.Color;
/**
 * Created by hp pc on 28-02-2017.
 */

public class StackedBarChartData {
    private float value;
    private String color;

    public float getValue()
    {
        return value;
    }

    public void setValue(float value)
    {
        this.value = value;
    }

    public int getColor()
    {
        return Color.parseColor(color);
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getTextValue()
    {
        return String.valueOf(value);
    }
}
