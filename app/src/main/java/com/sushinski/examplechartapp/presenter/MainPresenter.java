package com.sushinski.examplechartapp.presenter;

import android.os.SystemClock;

import com.sushinski.examplechartapp.ExampleChartApplication;
import com.sushinski.examplechartapp.interfaces.IPointPicker;
import com.sushinski.examplechartapp.interfaces.RequiredPresenterOps;
import com.sushinski.examplechartapp.interfaces.RequiredViewOps;

public class MainPresenter implements RequiredPresenterOps{
    private final RequiredViewOps view;
    private final IPointPicker mPointService;

    public MainPresenter(RequiredViewOps view){
        this.view = view;
        this.mPointService = ExampleChartApplication.getComponent().getPointService();
    }

    public void startProgress() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                while(true) {
                    SystemClock.sleep(1000);
                    view.showProgress(mPointService.getNextPoint());
                }
            }
        };
        new Thread(runnable).start();
    }

    @Override
    public void stopProgress() {
        // todo: catch activity lifecycle
    }
}
