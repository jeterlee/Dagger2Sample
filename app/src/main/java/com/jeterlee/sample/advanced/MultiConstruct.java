package com.jeterlee.sample.advanced;

import javax.inject.Inject;

/**
 * 该类用来测试多个构造函数同时用@Inject进行标注，看dagger2是否能正常工作
 */
public class MultiConstruct {

    /*
    * 注释掉@Inject
    * Error:(15, 8) 错误: [com.jeterlee.sample.advanced.di.components.MainFragmentComponent.inject(com.jeterlee.sample.advanced.MainFragment)] com.jeterlee.sample.advanced.MultiConstruct cannot be provided without an @Inject constructor or from an @Provides- or @Produces-annotated method.
        com.jeterlee.sample.advanced.MultiConstruct is injected at
        com.jeterlee.sample.advanced.MainFragment.multiConstruct
        com.jeterlee.sample.advanced.MainFragment is injected at
        com.jeterlee.sample.advanced.di.components.MainFragmentComponent.inject(mainFragment)
    * */

    // 构造函数被标记@Inject，自动初始化MultiConstruct构造函数，因此即使在Module中不提供MultiConstruct对象
    // 也不会报错，此种方式适合自己创建的类，第三方库，工具类不要这样使用。

    @Inject
    MultiConstruct() {
    }


    /*
    * 当有多个构造函数时，注意使用限定符或修饰符，进行区分，否则不知道改调用那个。
    *
    * 下面两行不注释掉则会报错！！！
    *
    * Error:(20, 5) 错误: Types may only contain one @Inject constructor.
    * Error:(25, 5) 错误: Types may only contain one @Inject constructor.
    * Error:(30, 5) 错误: Types may only contain one @Inject constructor.
    *
    * Error:Execution failed for task ':app:compileDebugJavaWithJavac'.
>       java.lang.IllegalStateException: Found multiple @Inject constructors: [MultiConstruct(), MultiConstruct(int), MultiConstruct(java.lang.String)]
    * */

    // @Inject
    // MultiConstruct(int a) {
    //
    // }

    // @Inject
    // MultiConstruct(String s) {
    //
    // }
}
