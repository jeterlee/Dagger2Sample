package com.jeterlee.sample.advanced.di.components;

import com.jeterlee.sample.advanced.MainFragment;
import com.jeterlee.sample.advanced.di.scopes.PerFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent
public interface MainFragmentComponent {

    void inject(MainFragment mainFragment);
}
