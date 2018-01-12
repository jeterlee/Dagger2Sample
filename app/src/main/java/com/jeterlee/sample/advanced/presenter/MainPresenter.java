package com.jeterlee.sample.advanced.presenter;

import com.jeterlee.sample.advanced.data.UserData;

import javax.inject.Inject;

public class MainPresenter {

    public UserData mUserData;
    private IUserView mUserView;

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

    public interface IUserView {
        void setUserName(String name);
    }
}
