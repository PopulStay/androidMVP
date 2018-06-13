package com.populstay.app.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.populstay.app.R;
import com.populstay.app.base.BaseFragment;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

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
	private TextView mTvResult;
	private TextView mTvUrl;

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
		mTvResult = view.findViewById(R.id.tv_result);
		mTvUrl = view.findViewById(R.id.tv_url);
	}

	private void setListener() {
		mBtnSearch.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {

		String url = "https://server.populstay.com/HouseInformation?place=Tokyo&guests=1&to=1539550000000&from=1529550000000&districeCode=0x3333322d30303332000000000000000000000000000000000000000000000000";
		mTvUrl.setText(url);
		RequestParams params = new RequestParams(url);
		x.http().get(params, new Callback.CacheCallback<String>() {
			@Override
			public boolean onCache(String result) {
				return false;
			}

			@Override
			public void onSuccess(String result) {
//				mTvResult.setText(result);
				Log.d("result: ",  result);
			}

			@Override
			public void onError(Throwable ex, boolean isOnCallback) {
				Log.d("FAIL", ex + " " + isOnCallback);
			}

			@Override
			public void onCancelled(CancelledException cex) {

			}

			@Override
			public void onFinished() {

			}
		});
	}
}
