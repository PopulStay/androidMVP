package com.populstay.app.base;

import android.app.Application;
import android.content.Context;

import org.xutils.x;


/**
 * Created by Jerry on 2018/6/1
 */
public class BaseApplication extends Application {

	private static Context mContext; // 全局 Context

	@Override
	public void onCreate() {
		super.onCreate();

		mContext = getApplicationContext();

		x.Ext.init(this); // 初始化 xutils
	}

	/**
	 * 获取全局 Context
	 *
	 * @return 上下文 Context
	 */
	public static Context getContext() {
		return mContext;
	}

}
