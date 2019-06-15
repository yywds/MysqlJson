package com.example.administrator.testapp;

import android.app.Application;

import org.xutils.x;


public class Mysqlapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
