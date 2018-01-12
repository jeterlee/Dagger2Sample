package com.jeterlee.sample.basis.model;

import android.util.Log;

import com.jeterlee.sample.Config;

public class Leather {

    public Leather() {
        Log.d(Config.TAG, "new Leather()");
    }

    public Leather(String color) {
        Log.d(Config.TAG, "new Leather() color : " + color);
    }
}
