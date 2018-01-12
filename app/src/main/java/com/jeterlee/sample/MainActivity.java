package com.jeterlee.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jeterlee.sample.advanced.ToastUtil;
import com.jeterlee.sample.advanced.di.components.DaggerMainComponent;
import com.jeterlee.sample.advanced.di.components.MainComponent;
import com.jeterlee.sample.advanced.di.modules.MainModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    // 基础Sample
    // private Car mCar;

    private MainComponent mMainComponent;

    @Inject
    ToastUtil toastUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 基础Sample
        // mCar = new Car();

        // 进阶Sample
        mMainComponent = DaggerMainComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .mainModule(new MainModule())
                .build();
        mMainComponent.inject(this);

        toastUtil.showToast("依赖注入获取到的toast");
        Log.i(Config.TAG, toastUtil.toString());
    }

    public MainComponent getMainComponent() {
        return mMainComponent;
    }
}
