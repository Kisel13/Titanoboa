package com.kisel.boa.lib.modules;

import com.kisel.boa.lib.StringValue;
import com.kisel.boa.lib.Functions;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateTime implements Module {

    @Override
    public void init() {
        Functions.set("currentDate", args -> new StringValue(getCurrentDate()));
        Functions.set("getYear", args -> new StringValue(getYear()));
        Functions.set("getMonth", args -> new StringValue(getMonth()));
        Functions.set("getDay", args -> new StringValue(getDay()));
        Functions.set("currentTime", args -> new StringValue(getCurrentTime()));
        Functions.set("getHour", args -> new StringValue(getHour()));
        Functions.set("getMin", args -> new StringValue(getMin()));
        Functions.set("getSec", args -> new StringValue(getSec()));
    }
    
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(new Date());
    }
    private String getYear() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        return dateFormat.format(new Date());
    }
    private String getMonth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm");
        return dateFormat.format(new Date());
    }
    private String getDay() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        return dateFormat.format(new Date());
    }
    private String getCurrentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.format(new Date());
    }
    private String getHour() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH");
        return timeFormat.format(new Date());
    }
    private String getMin() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("mm");
        return timeFormat.format(new Date());
    }
    private String getSec() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("ss");
        return timeFormat.format(new Date());
    }
}
