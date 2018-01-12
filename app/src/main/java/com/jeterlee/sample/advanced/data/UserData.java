package com.jeterlee.sample.advanced.data;


public class UserData {

    public UserData() {

    }

    private String mUserName;

    public String getUserName() {
        mUserName = "lee";
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }
}
