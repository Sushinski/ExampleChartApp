package com.sushinski.examplechartapp.service;


import android.content.Context;
import android.support.annotation.NonNull;

import com.scichart.charting.model.AxisCollection;
import com.scichart.charting.model.ChartModifierCollection;
import com.scichart.charting.model.RenderableSeriesCollection;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.modifiers.PinchZoomModifier;
import com.scichart.charting.modifiers.ZoomExtentsModifier;
import com.scichart.charting.modifiers.ZoomPanModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AutoRange;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.CategoryDateAxis;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.data.model.DoubleRange;
import com.scichart.drawing.common.PenStyle;
import com.scichart.drawing.utility.ColorUtil;
import com.sushinski.examplechartapp.interfaces.IPointViewer;
import com.sushinski.examplechartapp.model.Point;

import java.util.Date;

public class ChartService implements IPointViewer{
    private final SciChartSurface chartSurface;
    private final Context context;
    private XyDataSeries<Date, Double> dataSeries;


    public ChartService(@NonNull Context context, @NonNull SciChartSurface surface){
        this.context = context;
        this.chartSurface = surface;
        initSurface();
    }

    /**
     * inits surface representation
     */
    private void initSurface(){
        IAxis xAxis = new CategoryDateAxis(this.context);
        xAxis.setAutoRange(AutoRange.Always);
        xAxis.setGrowBy(new DoubleRange(0.1d, 0.1d));
        AxisCollection xAxes = chartSurface.getXAxes();
        xAxes.add(xAxis);
        xAxis.setAxisTitle("Time");

        NumericAxis yAxis = new NumericAxis(this.context);
        yAxis.setVisibleRange(new DoubleRange(-2.0d, 2.0d));
        AxisCollection yAxes = chartSurface.getYAxes();
        yAxes.add(yAxis);
        yAxis.setAxisAlignment(AxisAlignment.Right);
        yAxis.setAxisTitle("Value");

        FastLineRenderableSeries lineSeries = new FastLineRenderableSeries();

        RenderableSeriesCollection renderableSeries = chartSurface.getRenderableSeries();

        renderableSeries.add(lineSeries);
        PenStyle penStyle = new PenStyle(ColorUtil.Blue, true, 3f);
        lineSeries.setStrokeStyle(penStyle);

        dataSeries = new XyDataSeries<>(Date.class, Double.class);
        lineSeries.setDataSeries(dataSeries);

        chartSurface.zoomExtents();

        PinchZoomModifier zoomModifier = new PinchZoomModifier();
        ZoomPanModifier panModifier = new ZoomPanModifier();

        ChartModifierCollection chartModifiers = chartSurface.getChartModifiers();
        chartModifiers.add(zoomModifier);
        chartModifiers.add(panModifier);

        ZoomExtentsModifier zoomExtentsModifier = new ZoomExtentsModifier();
        chartModifiers.add(zoomExtentsModifier);

    }


    @Override
    public void showPoint(Point point) {
        dataSeries.append(point.getDate(), point.getRate());
    }
}
