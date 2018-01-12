package com.jeterlee.sample.advanced.di.components;

import android.content.Context;

import com.jeterlee.sample.advanced.Navigator;
import com.jeterlee.sample.advanced.ToastUtil;
import com.jeterlee.sample.advanced.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})// 由AppModule提供依赖
public interface AppComponent {
    // 桥接（抽取AppModule的常用部分到Component，再提供子类用，分类问题）

    Context getContext();

    Navigator getNavigator();

    ToastUtil getToastUtil();

    // Test test();
}
