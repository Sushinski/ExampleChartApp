package com.sushinski.examplechartapp.di;

import com.sushinski.examplechartapp.interfaces.IPointPicker;
import com.sushinski.examplechartapp.service.LocalPointService;

import dagger.Module;
import dagger.Provides;

@Module
public class PointServiceModule {
    @Provides
    IPointPicker providePointService(){
        return new LocalPointService();
    }
}
