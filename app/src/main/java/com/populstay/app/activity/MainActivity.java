package com.populstay.app.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.populstay.app.R;
import com.populstay.app.base.BaseActivity;
import com.populstay.app.fragment.MainExploreFragment;
import com.populstay.app.fragment.MainFavoritesFragment;
import com.populstay.app.fragment.MainJourneyFragment;
import com.populstay.app.fragment.MainMeFragment;
import com.populstay.app.fragment.MainMessageFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jerry on 2018/6/1
 */
public class MainActivity extends BaseActivity implements OnTabSelectListener, OnTabReselectListener {

	private static final int TAB_EXPLORE = 0;
	private static final int TAB_FAVORITES = 1;
	private static final int TAB_JOURNEY = 2;
	private static final int TAB_MESSAGE = 3;
	private static final int TAB_ME = 4;

	private BottomBar mBottomNavBar;
	private List<Fragment> mFragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//		setSupportActionBar(toolbar);

		initView();
		setListener();

//		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//		fab.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//						.setAction("Action", null).show();
//			}
//		});
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.menu_main, menu);
//		return true;
//	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//
//		//noinspection SimplifiableIfStatement
//		if (id == R.id.action_become_a_host) {
//			myToast("Become a host");
//			return true;
//		} else if (id == R.id.action_become_a_organiser) {
//			myToast("Become an organiser");
//			return true;
//		} else if (id == R.id.action_help) {
//			myToast("Help");
//			return true;
//		} else if (id == R.id.action_log_in) {
//			myToast("Log in");
//			return true;
//		} else if (id == R.id.action_sign_up) {
//			myToast("Sign up");
//			return true;
//		}
//
//		return super.onOptionsItemSelected(item);
//	}

	private void initView() {
		mBottomNavBar = (BottomBar) findViewById(R.id.bottom_nav_bar);

		mFragments = new ArrayList<>();
		mFragments.add(new MainExploreFragment());
		mFragments.add(new MainFavoritesFragment());
		mFragments.add(new MainJourneyFragment());
		mFragments.add(new MainMessageFragment());
		mFragments.add(new MainMeFragment());
		replaceFragment(mFragments.get(TAB_EXPLORE));
	}

	private void setListener() {
		mBottomNavBar.setOnTabSelectListener(this);
		mBottomNavBar.setOnTabReselectListener(this);
	}

	/**
	 * 点击底部导航栏（非当前 tab）
	 *
	 * @param tabId 底部导航栏 bottom_nav_tabs.xml 中每个 tab 的 id
	 */
	@Override
	public void onTabSelected(@IdRes int tabId) {
		int index = mBottomNavBar.getCurrentTabPosition();
		switch (tabId) {
			case R.id.bottom_nav_explore:
				index = TAB_EXPLORE;
				break;

			case R.id.bottom_nav_favorites:
				index = TAB_FAVORITES;
				break;

			case R.id.bottom_nav_journey:
				index = TAB_JOURNEY;
				break;

			case R.id.bottom_nav_message:
				index = TAB_MESSAGE;
				break;

			case R.id.bottom_nav_me:
				index = TAB_ME;
				break;

			default:
				break;
		}
		replaceFragment(mFragments.get(index));
	}

	/**
	 * 替换 FrameLayout 中 所显示的 Fragment
	 *
	 * @param fragment 要显示的 Fragment
	 */
	private void replaceFragment(Fragment fragment) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		if (!fragment.isAdded()) {
			transaction.replace(R.id.fl_content_main, fragment).commit();
		} else {
			transaction.show(fragment).commit();
		}
	}

	/**
	 * 点击底部导航栏（当前 tab）
	 *
	 * @param tabId 底部导航栏 bottom_nav_tabs.xml 中每个 tab 的 id
	 */
	@Override
	public void onTabReSelected(@IdRes int tabId) {

	}

	private static boolean mIsExit = false;
	@SuppressLint("HandlerLeak")
	private static Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			mIsExit = false;
		}
	};

	@Override
	public void onBackPressed() {
		exit();
	}

	private void exit() {
		if (!mIsExit) {
			mIsExit = true;
			myToast(getResources().getString(R.string.msg_double_click_to_exit));
			mHandler.sendEmptyMessageDelayed(0, 2000);
		} else {
			finish();
			System.exit(0);
		}
	}

}
