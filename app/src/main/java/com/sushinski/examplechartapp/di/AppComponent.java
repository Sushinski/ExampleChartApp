package com.sushinski.examplechartapp.di;

import com.sushinski.examplechartapp.interfaces.IPointPicker;

import dagger.Component;

@Component(modules = {PointServiceModule.class})
public interface AppComponent {
    IPointPicker getPointService();
}