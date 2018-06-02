package com.populstay.app.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.populstay.app.R;
import com.populstay.app.base.BaseActivity;


/**
 * Created by Jerry on 2018/6/1
 */
public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

//		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//		fab.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//						.setAction("Action", null).show();
//			}
//		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_become_a_host) {
			myToast("Become a host");
			return true;
		} else if (id == R.id.action_become_a_organiser) {
			myToast("Become an organiser");
			return true;
		} else if (id == R.id.action_help) {
			myToast("Help");
			return true;
		} else if (id == R.id.action_log_in) {
			myToast("Log in");
			return true;
		} else if (id == R.id.action_sign_up) {
			myToast("Sign up");
			return true;
		}

		return super.onOptionsItemSelected(item);
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
			myToast("Click again to quit");
			mHandler.sendEmptyMessageDelayed(0, 2000);
		} else {
			finish();
			System.exit(0);
		}
	}

}
