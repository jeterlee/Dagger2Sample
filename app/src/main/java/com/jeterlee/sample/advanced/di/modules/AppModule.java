package com.jeterlee.sample.advanced.di.modules;

import android.content.Context;

import com.jeterlee.sample.advanced.Navigator;
import com.jeterlee.sample.advanced.ToastUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    public Navigator provideNavigator() {
        return new Navigator();
    }

    // 不加 @Singleton 是无法单例化的

    @Provides
    @Singleton
    public ToastUtil provideToastUtil() {
        return new ToastUtil(mContext);
    }

    // @Provides
    // @Singleton
    // public Test provideTest() {
    //     return new Test();
    // }
}
