package com.jeterlee.sample;

import android.app.Application;

import com.jeterlee.sample.advanced.di.components.AppComponent;
import com.jeterlee.sample.advanced.di.components.DaggerAppComponent;
import com.jeterlee.sample.advanced.di.modules.AppModule;

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
