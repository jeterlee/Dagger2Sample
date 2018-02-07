package com.jeterlee.sample.advanced.data;

/**
 * <pre>
 *     desc: model层
 *     email: xqlee120@yeah.net
 *     date: 2018/2/5 0005
 *     @author jeterlee
 * </pre>
 */
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
