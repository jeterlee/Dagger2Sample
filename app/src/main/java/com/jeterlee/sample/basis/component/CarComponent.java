package com.jeterlee.sample.basis.component;

import com.jeterlee.sample.basis.model.Car;
import com.jeterlee.sample.basis.module.CarModule;

import dagger.Component;

/**
 * <pre>
 *     desc: 桥梁
 *     email: xqlee120@yeah.net
 *     date: 2018/2/6 0006
 *     @author jeterlee
 * </pre><pre>
 *     桥梁（连接@Inject和@Module，里面存在着依赖提供者和依赖需求者）
 *     本例中连接Module和你的Car。
 *     '@Component - 这个注解只能用于接口或抽象类。
 * </pre>
 */
@Component(modules = CarModule.class)
public interface CarComponent {
    /**
     * 这个方法是抽象的，表示需要将这些依赖应用到Car类。说白了就是Car类需要CarModule来提供依赖。
     *
     * @param car car
     */
    void inject(Car car);
}
