package com.sushinski.examplechartapp.service;


import com.sushinski.examplechartapp.interfaces.IPointPicker;
import com.sushinski.examplechartapp.model.Point;
import com.sushinski.examplechartapp.utils.RandomRanger;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

public class LocalPointService implements IPointPicker{
    private double mLastValue = 0;

    @Inject
    public LocalPointService(){

    }

    @Override
    public Point getNextPoint() {
        mLastValue += RandomRanger.randDoubleRange(-1.0, 1.0);
        Date dt = Calendar.getInstance().getTime();
        return new Point(dt, mLastValue);
    }
}
