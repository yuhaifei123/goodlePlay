package com.example.goodleplay;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * Created by 胡玉娇 on 2017/4/5.
 */
public class GooglePlayApplication extends Application{

	private  static Context context;
	private Handler mHandler;
	private int mI;

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
		mHandler = new Handler();
		mI = Process.myPid();//当前主线程

	}
}
