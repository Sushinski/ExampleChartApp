package com.sushinski.examplechartapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.scichart.charting.visuals.SciChartSurface;
import com.sushinski.examplechartapp.R;
import com.sushinski.examplechartapp.interfaces.IPointViewer;
import com.sushinski.examplechartapp.interfaces.RequiredPresenterOps;
import com.sushinski.examplechartapp.interfaces.RequiredViewOps;
import com.sushinski.examplechartapp.model.Point;
import com.sushinski.examplechartapp.presenter.MainPresenter;
import com.sushinski.examplechartapp.service.ChartService;


public class MainActivity extends AppCompatActivity implements RequiredViewOps{
    private SciChartSurface chartSurface;
    private IPointViewer chartViewer;
    private RequiredPresenterOps mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chartSurface = (SciChartSurface) findViewById(R.id.chartView);
       /* try{
            SciChartSurface.setRuntimeLicenseKeyFromResource(this,
                    "app\\src\\main\\res\\raw\\license.xml");
        }catch (Exception e){
            e.printStackTrace();
        }*/
        mainPresenter = new MainPresenter(this);
        chartViewer = new ChartService(this, chartSurface); // todo: di candidate
        mainPresenter.startProgress();
    }


    @Override
    public void showProgress(final Point point) {
        if(point != null){
            chartSurface.post(new Runnable() {
                @Override
                public void run() {
                    appendPoint(point);
                }
            });
        }
    }

    private void appendPoint(Point point){
        chartViewer.showPoint(point);
        chartSurface.zoomExtentsX();
    }
}
