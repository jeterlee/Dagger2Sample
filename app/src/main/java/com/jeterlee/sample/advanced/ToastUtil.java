package com.jeterlee.sample.advanced;

import android.content.Context;
import android.widget.Toast;

/**
 * 管理toast的类，整个app用该类来显示toast
 */
public class ToastUtil {

    private Context mContext;

    public ToastUtil() {

    }

    public ToastUtil(Context context) {
        this.mContext = context;
    }

    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }
}
