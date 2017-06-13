package com.sushinski.examplechartapp.model;

import java.io.Serializable;
import java.util.Date;

public class Point implements Serializable {

    public Point(Date date, Double rate){
        this.mDate = date;
        this.mRate = rate;
    }

    public Date getDate(){
        return mDate;
    }

    public Double getRate(){
        return mRate;
    }

    private final Date mDate;
    private final Double mRate;
}
