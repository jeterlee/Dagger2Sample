package com.jeterlee.sample.basis.model;

import android.util.Log;

import com.jeterlee.sample.Config;

/**
 * <pre>
 *     desc: 车座
 *     email: xqlee120@yeah.net
 *     date: 2018/2/6 0006
 *     @author jeterlee
 * </pre>
 */
public class Seat {

    Leather mLeather;

    /**
     * 默认无车套车座
     */
    public Seat() {
        Log.d(Config.TAG, "new Seat()");
    }

    /**
     * 提供有车套车座
     *
     * @param str 构造参数
     */
    public Seat(String str) {
        Log.d(Config.TAG, str);
    }

    /**
     * 存在依赖链
     *
     * @param leather 提供皮革依赖注入
     */
    public Seat(Leather leather) {
        this.mLeather = leather;
        Log.d(Config.TAG, "new Seat(Leather)");
    }
}
