package com.populstay.app.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.jerryl.peach.util.toast.ToastUtil;

/**
 * Created by Jerry on 2018/6/1
 */
public class BaseActivity extends AppCompatActivity {
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
		super.onCreate(savedInstanceState, persistentState);
	}

	/**
	 * 显示 toast 内容
	 *
	 * @param content 需要显示的内容
	 */
	public void myToast(String content) {
		ToastUtil.showToast(content);
	}

	/**
	 * 显示 toast 内容
	 *
	 * @param resId 字符串内容的资源 id
	 */
	public void myToast(int resId) {
		ToastUtil.showToast(resId);
	}
}
