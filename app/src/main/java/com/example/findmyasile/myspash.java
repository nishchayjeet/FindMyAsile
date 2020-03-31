package com.example.findmyasile;

import android.app.Application;
import android.os.SystemClock;

public class myspash extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
