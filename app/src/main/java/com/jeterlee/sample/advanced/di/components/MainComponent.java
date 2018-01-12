package com.jeterlee.sample.advanced.di.components;

import com.jeterlee.sample.MainActivity;
import com.jeterlee.sample.advanced.di.modules.MainModule;
import com.jeterlee.sample.advanced.di.scopes.PerActivity;

import dagger.Component;

/**
 * MainComponent继承了ActivityComponent，假如ActivityComponent中定义了创建类实例方法，则MainComponent中必须提供@Inject或@Provides对应的
 * 初始化类实例的方法
 */
@PerActivity
@Component(modules = {MainModule.class}, dependencies = {AppComponent.class})
public interface MainComponent {

    // 对MainActivity进行依赖注入
    void inject(MainActivity mainActivity);

    // todo...
    // 从属于MainComponent, 直接利用MainComponent的注入
    // （其中MainFragmentComponent的scope不能和MainComponent一样否则报错：）
    /* 报错
    * Error:(15, 8) 错误: [com.jeterlee.sample.advanced.di.components.MainFragmentComponent] com.jeterlee.sample.advanced.di.components.MainFragmentComponent has conflicting scopes:
        com.jeterlee.sample.advanced.di.components.MainComponent also has @com.jeterlee.sample.advanced.di.scopes.PerActivity*/
    MainFragmentComponent mainFragmentComponent();
}
