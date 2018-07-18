package com.populstay.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.populstay.app.Common.Constant;
import com.populstay.app.R;
import com.populstay.app.activity.HouseDisplayActivity;
import com.populstay.app.base.BaseFragment;

/**
 * 底部导航栏“探索” Fragment
 * Created by Jerry
 */

public class MainExploreFragment extends BaseFragment implements View.OnClickListener {

	private EditText mEtStartDate;
	private EditText mEtEndDate;
	private EditText mEtGuestsNum;
	private EditText mEtCity;
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
		mEtGuestsNum = view.findViewById(R.id.et_guests_num);
		mEtCity = view.findViewById(R.id.et_city);
		mBtnSearch = view.findViewById(R.id.btn_search_home);
	}

	private void setListener() {
		mBtnSearch.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		Intent intent = new Intent(getActivity(), HouseDisplayActivity.class);
		intent.putExtra(Constant.KEY_SEARCH_CITY, mEtCity.getText().toString());
		intent.putExtra(Constant.KEY_SEARCH_GUESTS_NUM, mEtGuestsNum.getText().toString());
//        intent.putExtra(Constant.KEY_SEARCH_START_DATE,mEtStartDate.getText().toString());
//        intent.putExtra(Constant.KEY_SEARCH_END_DATE,mEtEndDate.getText().toString());
		intent.putExtra(Constant.KEY_SEARCH_START_DATE, String.valueOf(System.currentTimeMillis()));
		intent.putExtra(Constant.KEY_SEARCH_END_DATE, String.valueOf(System.currentTimeMillis() + 864000000));
		intent.putExtra(Constant.KEY_SEARCH_DISTRICT_CODE, Constant.VAL_SEARCH_DISTRICT_CODE);
		startActivity(intent);
	}
}
