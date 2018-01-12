package com.jeterlee.sample.advanced.di.modules;

import com.jeterlee.sample.advanced.data.UserData;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    public UserData provideUserData(){
        return new UserData();
    }
}
