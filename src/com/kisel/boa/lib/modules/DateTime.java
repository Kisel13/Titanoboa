package com.kisel.boa.lib.modules;

import com.kisel.boa.lib.StringValue;
import com.kisel.boa.lib.Functions;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateTime implements Module {

    @Override
    public void init() {
        Functions.set("currentDate", args -> new StringValue(getCurrentDate()));
        Functions.set("currentTime", args -> new StringValue(getCurrentTime()));
    }
    
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(new Date());
    }
    
    private String getCurrentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.format(new Date());
    }
}
