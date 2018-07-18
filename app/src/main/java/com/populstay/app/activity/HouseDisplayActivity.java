package com.populstay.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.populstay.app.Common.Constant;
import com.populstay.app.Common.Urls;
import com.populstay.app.R;
import com.populstay.app.adapter.HouseDisplayRecyclerViewAdapter;
import com.populstay.app.base.BaseActivity;
import com.populstay.app.bean.HouseInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.jerryl.peach.util.log.PeachLogger;

/**
 * 房源展示页面
 * Created by Jerry
 */

public class HouseDisplayActivity extends BaseActivity {

	private final List<HouseInfo> mHouseInfoList = new ArrayList<>();

	private RecyclerView mRvHouseDisplay;
	private HouseDisplayRecyclerViewAdapter mAdapter;

	private String mCity, mGuestsNum, mStartDate, mEndDate, mDistrictCode; // 搜索房源信息时（用户输入的）条件

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_house_display);

		getIntentData();
		initView();
		requestHouseInfo(mCity, mGuestsNum, mStartDate, mEndDate, mDistrictCode);
	}

	private void getIntentData() {
		Intent intentData = getIntent();
		mCity = intentData.getStringExtra(Constant.KEY_SEARCH_CITY);
		mGuestsNum = intentData.getStringExtra(Constant.KEY_SEARCH_GUESTS_NUM);
		mStartDate = intentData.getStringExtra(Constant.KEY_SEARCH_START_DATE);
		mEndDate = intentData.getStringExtra(Constant.KEY_SEARCH_END_DATE);
		mDistrictCode = intentData.getStringExtra(Constant.KEY_SEARCH_DISTRICT_CODE);

	}

	private void initView() {
		mRvHouseDisplay = findViewById(R.id.rv_house_display);
		mAdapter = new HouseDisplayRecyclerViewAdapter(mHouseInfoList);
//        mRvHouseDisplay.setLayoutManager(new LinearLayoutManager(this)); // 线性显示，类似于 ListView
		mRvHouseDisplay.setLayoutManager(new GridLayoutManager(this, 2)); // 线性宫格显示，类似于 GridView
//        mRvHouseDisplay.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL)); // 线性宫格显示，类似于瀑布流
		mRvHouseDisplay.setAdapter(mAdapter);
	}

	public void requestHouseInfo(String city, String guestsNum, String startDate, String endDate, String districtCode) {
		String url = Urls.SEARCH_HOUSE + "?place=" + city + "&gusts=" + guestsNum + "&from="
				+ startDate + "&to=" + endDate + "&districeCode=" + districtCode;
		RequestParams params = new RequestParams(url);
		PeachLogger.d("params", url);
		x.http().get(params, new Callback.CacheCallback<String>() {
			@Override
			public boolean onCache(String result) {
				return false;
			}

			@Override
			public void onSuccess(String result) {
				Log.d("result: ", result);
//                PeachLogger.d(String.valueOf(System.currentTimeMillis()));
				try {
					JSONArray jsonArray = new JSONArray(result);
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject jsHouseInfo = jsonArray.getJSONObject(i);
						HouseInfo houseInfo = new HouseInfo();
//                        houseInfo.setIvHouseCover(jsHouseInfo.getString("s"));
						houseInfo.setTvHouseName(jsHouseInfo.getString("hostAddress"));
						houseInfo.setTvHouseAddress(jsHouseInfo.getJSONObject("houseinfo").getString("location"));
						houseInfo.setTvHousePrice("￥" + jsHouseInfo.getString("price"));
						houseInfo.setTvHouseCount("$" + jsHouseInfo.getString("hostAddress"));
						mHouseInfoList.add(houseInfo);
					}
					mAdapter.notifyDataSetChanged();
				} catch (JSONException exception) {
					exception.printStackTrace();
				}
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
