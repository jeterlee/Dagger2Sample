package com.jeterlee.sample.basis.model;

import android.util.Log;

import com.jeterlee.sample.basis.Config;
import com.jeterlee.sample.basis.LeatherColor;
import com.jeterlee.sample.basis.component.DaggerCarComponent;
import com.jeterlee.sample.basis.module.CarModule;

import javax.inject.Inject;

public class Car {

    @Inject
    Engine mEngine;

    @LeatherColor(color = "green")
    @Inject
    Leather mLeather;

    @Inject
    Seat mSeat;

    @Inject
    Wheel mWheel;

    // private Engine mEngine;
    // private Seat mSeat;
    // private Wheel mWheel;

    public Car() {
        // mEngine = new Engine();
        // mSeat = new Seat();
        // mWheel = new Wheel();

        // DaggerCarComponent是apt工具帮我们生成的类，实现了CarComponent接口。
        // 通过carModule()将我们的依赖提供者传入，通过inject()将我们的Car对象传入，这样就达到了中间人的目的。
        DaggerCarComponent
                .builder()
                .carModule(new CarModule())
                .build()
                .inject(this);

        Log.d(Config.TAG, "new Car()");
    }
}
