package com.jeterlee.sample.basis.module;

import com.jeterlee.sample.basis.LeatherColor;
import com.jeterlee.sample.basis.model.Engine;
import com.jeterlee.sample.basis.model.Leather;
import com.jeterlee.sample.basis.model.Seat;
import com.jeterlee.sample.basis.model.Wheel;

import dagger.Module;
import dagger.Provides;

/**
 * 管理并提供依赖
 * '@Provides - 通过返回类型进行匹配
 *
 * @author jeterlee
 * @date 2017/12/11 0011
 * @email xqlee120@yeah.net
 */
@Module
public class CarModule {

    @Provides
    public Engine provideEngine() {
        return new Engine();
    }


    // 一个类只能提供一个构造器作为依赖(@Inject can apply to at most one constructor per class)

    /* Error:(23, 10) 错误: cn.jeterlee.dagger2demo.basis.model.Seat is bound multiple times:
       @Provides cn.jeterlee.dagger2demo.basis.model.Seat cn.jeterlee.dagger2demo.basis.module.CarModule.provideSeat()
       @Provides cn.jeterlee.dagger2demo.basis.model.Seat cn.jeterlee.dagger2demo.basis.module.CarModule.provideSeat2()
       错误显示Seat类被绑定了多次 */

    // @Provides
    // public Seat provideSeat() {
    //     return new Seat();
    // }

    // @Provides
    // public Seat provideSeat2() {
    //     return new Seat("有车套");
    // }



    /*
      总结一下上面使用步骤：
        1 首先使用@Qualifier自定义注解，在这个例子中我们自定义的是@LeatherColor
        2 然后在@Inject的地方添加自定义注解限制；如 @LeatherColor（color="black"）
        3 最后在提供依赖的Module类中添加相关依赖限制；在这个例子中，如果我们@Inject注解带有@LeatherColor并且它的color="black",就会执行
        new Leather("black"),否则就会执行默认provides。*/

    // 默认

    @Provides
    public Leather provideLeather() {
        return new Leather();
    }

    // 选择

    @LeatherColor(color = "black")
    @Provides
    public Leather provideIntLeather1() {
        return new Leather("black");
    }

    // 选择

    @LeatherColor(color = "green")
    @Provides
    public Leather provideIntLeather2() {
        return new Leather("green");
    }


    // 自动找到Leather依赖

    @Provides
    public Seat provideSeat3(Leather leather) {
        return new Seat(leather);
    }


    @Provides
    public Wheel provideWheel() {
        return new Wheel();
    }
}
