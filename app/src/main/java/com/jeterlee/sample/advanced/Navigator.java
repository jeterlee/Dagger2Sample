package com.jeterlee.sample.advanced;

import javax.inject.Singleton;

// todo 类上使用@Singleton（此类是单例不了？？？）
// todo module不提供对象，而是通过与外界的类建立联系，通过外面的类提供对象，能否实现（即通过外面类替代Provides）？？？
// @Singleton在component中使用，使用条件：module中使用，则component中必须使用；否则，component中用于不用，不影响。
@Singleton
public class Navigator {

    public Navigator() {

    }
}
