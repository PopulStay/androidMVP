package com.populstay.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.populstay.app.R;
import com.populstay.app.base.BaseFragment;

/**
 * 底部导航栏“旅程” Fragment
 * Created by Jerry
 */

public class MainJourneyFragment extends BaseFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main_journey, null);

		initView(view);
		return view;
	}

	private void initView(View view) {

	}
}
