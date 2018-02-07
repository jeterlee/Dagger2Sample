package com.jeterlee.sample.advanced;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jeterlee.sample.Config;
import com.jeterlee.sample.MainActivity;
import com.jeterlee.sample.R;
import com.jeterlee.sample.advanced.data.UserData;
import com.jeterlee.sample.advanced.di.components.MainFragmentComponent;
import com.jeterlee.sample.advanced.presenter.MainPresenter;

import javax.inject.Inject;

public class MainFragment extends Fragment implements MainPresenter.IUserView {

    /*
    * @Inject 带有此注解的属性或构造方法将参与到依赖注入中，Dagger2会实例化有此注解的类
    @Module 带有此注解的类，用来提供依赖，里面定义一些用@Provides注解的以provide开头的方法，这些方法就是所提供的依赖，Dagger2会在该类中寻找实例化某个类所需要的依赖。
    @Component 用来将@Inject和@Module联系起来的桥梁，从@Module中获取依赖并将依赖注入给@Inject
    */


    // todo...
    // 重点：结合mvp使用（MainPresenter实例没有在MainFragmentComponent和MainComponent，
    // 他会去寻找带有@Inject注解的构造类，先记住！！！） ？？？

    /*
    在MVP中的使用！！！

    这样做的原因：Activity与presenter耦合在了一起，当需要改变presenter的构造方式时，需要修改这里的代码。因此使用依赖注入。

    我们先看MainFragment里的代码，之前是直接声明MainPresenter，现在在声明的基础上加了一个注解@Inject，
    表明MainPresenter是需要注入到MainFragment中，即MainFragment依赖于MainPresenter，这里要注意的是，
    使用@Inject时，不能用private修饰符修饰类的成员属性。

    然后我们在MainPresenter的构造函数上同样加了@Inject注解。这样MainFragment里的mainPresenter与他的构造函数建立了某种联系。
    这种联系我们可以这样理解，当看到某个类被@Inject标记时，就会到他的构造方法中，如果这个构造方法也被@Inject标记的话，
    就会自动初始化这个类，从而完成依赖注入。
    */

    /* 注释 @Inject 报错：
    * Caused by: java.lang.NullPointerException: Attempt to invoke
    * virtual method 'void com.jeterlee.sample.advanced.presenter.MainPresenter.
    * setUserView(com.jeterlee.sample.advanced.presenter.MainPresenter$IUserView)' on a null object reference
       at com.jeterlee.sample.advanced.MainFragment.onActivityCreated(MainFragment.java:64)
       at android.app.Fragment.performActivityCreated(Fragment.java:2061)
       at android.app.FragmentManagerImpl.moveToState(FragmentManager.java:912)
       at android.app.FragmentManagerImpl.moveToState(FragmentManager.java:1067)
       at android.app.FragmentManagerImpl.moveToState(FragmentManager.java:1049)
       at android.app.FragmentManagerImpl.dispatchActivityCreated(FragmentManager.java:1869)
       at android.app.Activity.performCreateCommon(Activity.java:5985)
       at android.app.Activity.performCreate(Activity.java:5992)
       at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1106)
       at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2278)
       at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2387) 
       at android.app.ActivityThread.access$800(ActivityThread.java:151) 
       at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1303) 
       at android.os.Handler.dispatchMessage(Handler.java:102) 
       at android.os.Looper.loop(Looper.java:135) 
       at android.app.ActivityThread.main(ActivityThread.java:5254) 
       at java.lang.reflect.Method.invoke(Native Method) 
       at java.lang.reflect.Method.invoke(Method.java:372) 
       at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:903) 
       at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:698) 
    */

    @Inject
    MainPresenter mainPresenter;

    // todo...
    // 子component可以访问父component，类似于继承(子和父的Scope不能一样)，访问同一个component，所以是单例的

    @Inject
    ToastUtil toastUtil;

    // toastUtil 和 toastUtil2 是同一个对象

    @Inject
    ToastUtil toastUtil2;

    // todo...
    // 多个构造函数同时用@Inject进行标注 ？？？

    /*
    * 注释掉@Inject
    * Error:(15, 8) 错误: [com.jeterlee.sample.advanced.di.components.MainFragmentComponent.inject(com.jeterlee.sample.advanced.MainFragment)] com.jeterlee.sample.advanced.MultiConstruct cannot be provided without an @Inject constructor or from an @Provides- or @Produces-annotated method.
        com.jeterlee.sample.advanced.MultiConstruct is injected at
        com.jeterlee.sample.advanced.MainFragment.multiConstruct
        com.jeterlee.sample.advanced.MainFragment is injected at
        com.jeterlee.sample.advanced.di.components.MainFragmentComponent.inject(mainFragment)
    * */

    @Inject
    MultiConstruct multiConstruct;

    // 子component可以访问父component

    @Inject
    UserData mUserData1;

    // mUserData1 和 mUserData2 是同一个对象

    @Inject
    UserData mUserData2;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof MainActivity) {
            MainFragmentComponent mainFragmentComponent = ((MainActivity) getActivity()).getMainComponent().mainFragmentComponent();
            mainFragmentComponent.inject(this);
            mainPresenter.setUserView(this);// 提供实例
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        view.findViewById(R.id.get_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.getUser();
            }
        });
        view.findViewById(R.id.show_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastUtil.showToast("依赖注入获取到的toast");
                Log.i(Config.TAG, toastUtil.toString());
                Log.i(Config.TAG, toastUtil2.toString());
            }
        });

        return view;
    }

    @Override
    public void setUserName(String name) {
        ((TextView) getView().findViewById(R.id.user_info)).setText(name);
    }
}

