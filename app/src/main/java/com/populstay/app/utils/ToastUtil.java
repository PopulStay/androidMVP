package com.populstay.app.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;

import com.populstay.app.base.BaseApplication;

/**
 * Toast 工具类
 * Created by Jerry on 2017/3/22.
 */

public class ToastUtil {

	private static Toast mToast = null;
	private static Handler mHandler = new Handler(Looper.getMainLooper());

	/**
	 * 显示 Toast，多次调用此函数时，Toast 显示的时间不会累计，并且显示内容为最后一次调用时传入的内容
	 *
	 * @param content 要显示的内容
	 */
	public static void showToast(final String content) {
		if (TextUtils.isEmpty(content)) {
			return;
		}
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				if (mToast == null) {
					mToast = Toast.makeText(BaseApplication.getContext(), content, Toast.LENGTH_SHORT);
				} else {
					//mToast.cancel();
					//mToast.setView(mToast.getView());
					mToast.setText(content);
					mToast.setDuration(Toast.LENGTH_SHORT);
				}
				mToast.show();
			}
		});
	}

	/**
	 * 显示 Toast，多次调用此函数时，Toast 显示的时间不会累计，并且显示内容为最后一次调用时传入的内容
	 *
	 * @param resId 要显示的内容在 strings.xml 中所定义的字符串文字的资源 id
	 */
	public static void showToast(final int resId) {
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				if (mToast == null) {
					mToast = Toast.makeText(BaseApplication.getContext(), resId, Toast.LENGTH_SHORT);
				} else {
					//mToast.cancel();
					//mToast.setView(mToast.getView());
					mToast.setText(resId);
					mToast.setDuration(Toast.LENGTH_SHORT);
				}
				mToast.show();
			}
		});
	}
}
