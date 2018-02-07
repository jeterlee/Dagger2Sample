package com.jeterlee.sample.advanced.presenter;

import com.jeterlee.sample.advanced.data.UserData;

import javax.inject.Inject;

public class MainPresenter {

    public UserData mUserData;
    
    // MainContract是个接口，View是他的内部接口，这里看做View接口即可
    private IUserView mUserView;

    /*
    我们先看MainFragment里的代码，之前是直接声明MainPresenter，现在在声明的基础上加了一个注解@Inject，
    表明MainPresenter是需要注入到MainFragment中，即MainFragment依赖于MainPresenter，这里要注意的是，
    使用@Inject时，不能用private修饰符修饰类的成员属性。

    然后我们在MainPresenter的构造函数上同样加了@Inject注解。这样MainFragment里的mainPresenter与他的构造函数建立了某种联系。
    这种联系我们可以这样理解，当看到某个类被@Inject标记时，就会到他的构造方法中，如果这个构造方法也被@Inject标记的话，
    就会自动初始化这个类，从而完成依赖注入。
    */

    @Inject
    public MainPresenter(UserData userData) {
        this.mUserData = userData;
    }

    public void getUser() {
        this.mUserView.setUserName(this.mUserData.getUserName());
    }

    public void setUserView(IUserView userView) {
        this.mUserView = userView;
    }

    /**
     * <pre>
     *     desc: view层
     *     email: xqlee120@yeah.net
     *     date: 2018/2/5 0005
     *     @author jeterlee
     * </pre>
     */
    public interface IUserView {
        void setUserName(String name);
    }
}
