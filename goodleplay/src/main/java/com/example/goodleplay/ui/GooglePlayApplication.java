package com.example.goodleplay.ui;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * Created by 胡玉娇 on 2017/4/5.
 */
public class GooglePlayApplication extends Application{

	private  static Context context;
	private static Handler mHandler;
	private static int mI;

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
		mHandler = new Handler();
		mI = Process.myPid();//当前主线程
	}

	public static Context getContext() {
		return context;
	}

	public static Handler getmHandler() {
		return mHandler;
	}

	public static int getmI() {
		return mI;
	}
}
