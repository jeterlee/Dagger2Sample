package com.jeterlee.sample.advanced.di.components;

import com.jeterlee.sample.advanced.MainFragment;
import com.jeterlee.sample.advanced.di.scopes.PerFragment;

import dagger.Subcomponent;

/**
 * <pre>
 *     desc: 其中MainFragmentComponent的scope不能和MainComponent一样否则报错
 *     email: xqlee120@yeah.net
 *     date: 2018/2/7 0007
 *     @author jeterlee
 * </pre>
 */
@PerFragment
@Subcomponent
public interface MainFragmentComponent {

    void inject(MainFragment mainFragment);
}
