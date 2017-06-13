package com.sushinski.examplechartapp;


import android.app.Application;

import com.sushinski.examplechartapp.di.AppComponent;
import com.sushinski.examplechartapp.di.DaggerAppComponent;


public class ExampleChartApplication extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public static AppComponent getComponent(){
        return appComponent;
    }
}

