package com.sushinski.examplechartapp.service;

import com.sushinski.examplechartapp.interfaces.IPointPicker;
import com.sushinski.examplechartapp.model.Point;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

/**
 * Example class for dealing with remote point storage
 */
public class RemotePointService implements IPointPicker {

    public RemotePointService(){
    }

    @Override
    public Point getNextPoint() {
        Date dt = Calendar.getInstance().getTime();
        return new Point(dt, 0.d); // todo: should be replaced with actual cached points data
    }

    private void getPoints(){
        // todo: implement remote point acquiring, caching, etc
    }
}
