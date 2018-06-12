package com.populstay.app.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.populstay.app.R;
import com.populstay.app.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * fragment 基类
 * 懒加载
 * Created by Jerry
 */
public abstract class BaseFragment extends Fragment {

	protected Activity mActivity;
	private View mRootView;

	/**
	 * 页面顶部 tab 栏相关
	 */
	public List<TextView> mTabs; // tab 栏显示的文字
	public List<TextView> mLines; // tab 栏底部指示条

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mTabs = new ArrayList<>();
		mLines = new ArrayList<>();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.mActivity = activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ViewGroup parent = (ViewGroup) mRootView.getParent();
		if (parent != null) {
			parent.removeView(mRootView);
		}
		parent = null;
		return mRootView;
	}

	/**
	 * 切换页面顶部 tab 栏的显示状态
	 *
	 * @param tabIndex 要显示的 tab 栏位置索引
	 */
	public void changePageTabState(int tabIndex) {
		for (int i = 0; i < mTabs.size(); i++) {
			if (tabIndex == i) {
				mTabs.get(i).setTextColor(getResources().getColor(R.color.colorPrimary));
				mLines.get(i).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
			} else {
				mTabs.get(i).setTextColor(getResources().getColor(R.color.text_gray_dark));
				mLines.get(i).setBackgroundColor(getResources().getColor(R.color.white));
			}
		}
	}

	/**
	 * Toast 提醒
	 * 直接传入要提醒的硬编码字符串文字
	 *
	 * @param text 要提醒的硬编码字符串文字
	 */
	public void myToast(String text) {
		ToastUtil.showToast(text);
	}

	/**
	 * Toast 提醒
	 * 传入在 strings.xml 中定义的字符串文字的 id 引用
	 *
	 * @param id 在 strings.xml 中定义的字符串文字的 id 引用
	 */
	public void myToast(int id) {
		ToastUtil.showToast(id);
	}

	/**
	 * 跳转至新的 activity 页面
	 *
	 * @param clazz 要启动的 activity 类名
	 */
	public void goToNewActivity(Class clazz) {
		Intent intent = new Intent(getActivity(), clazz);
		startActivity(intent);
	}
}
