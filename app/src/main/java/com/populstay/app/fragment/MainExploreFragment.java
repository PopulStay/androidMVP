package com.populstay.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.populstay.app.R;
import com.populstay.app.base.BaseFragment;

/**
 * 底部导航栏“探索” Fragment
 * Created by Jerry
 */

public class MainExploreFragment extends BaseFragment implements View.OnClickListener {

	private EditText mEtStartDate;
	private EditText mEtEndDate;
	private EditText mEtAdults;
	private EditText mEtChildren;
	private Button mBtnSearch;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main_explore, null);

		initView(view);
		setListener();
		return view;
	}

	private void initView(View view) {
		mEtStartDate = view.findViewById(R.id.et_start_date);
		mEtEndDate = view.findViewById(R.id.et_end_date);
		mEtAdults = view.findViewById(R.id.et_adults);
		mEtChildren = view.findViewById(R.id.et_children);
		mBtnSearch = view.findViewById(R.id.btn_search_home);
	}

	private void setListener() {
		mBtnSearch.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		myToast("Search Home");
	}
}
