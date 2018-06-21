package com.populstay.app.base;

import android.app.Application;

import org.xutils.x;

import cn.jerryl.peach.app.Peach;


/**
 * Created by Jerry on 2018/6/1
 */
public class BaseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// 初始化 Peach
		Peach.init(this).configure();
		// 初始化 xutils
		x.Ext.init(this);
	}
}
