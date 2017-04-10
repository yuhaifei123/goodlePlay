package com.example.goodleplay.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Process;
import android.view.View;

import com.example.goodleplay.GooglePlayApplication;

/**
 * Created by 胡玉娇 on 2017/4/6.
 */

public class UIUtils {

	/**
	 * 得到控制器
	 * @return
	 */
	public static Context getContext(){
		return GooglePlayApplication.getContext();
	}

	/**
	 * 得到handler
	 * @return
	 */
	public static Handler getHandler(){
		return GooglePlayApplication.getmHandler();
	}

	/**
	 * 得到主线程
	 * @return
	 */
	public static int getMainThreadId(){
		return GooglePlayApplication.getmI();
	}

	/**
	 * 返回字符
	 * @param id
	 * @return
	 */
	public static String getString(int id){
		return getContext().getResources().getString(id);
	}

	/**
	 * 返回字符数组
	 * @param id
	 * @return
	 */
	public static String[] getStringArray(int id){
		return getContext().getResources().getStringArray(id);
	}

	/**
	 * 得到当前图片
	 * @param id
	 * @return
	 */
	public static Drawable getDrawable(int id){
		return getContext().getResources().getDrawable(id);
	}

	/**
	 * 获得当前颜色
	 * @param id
	 * @return
	 */
	public static int getColor(int id){
		return getContext().getResources().getColor(id);
	}

	/**
	 * 得到当前尺寸
	 * @param id
	 * @return
	 */
	public static int getDimen(int id){
		return getContext().getResources().getDimensionPixelSize(id);
	}

	/**
	 * dip转px
	 * @param dip
	 * @return
	 */
	public static int dip2px(float dip){
		float dessity = getContext().getResources().getDisplayMetrics().density;
		return  (int) (dip * dessity +0.5f);
	}

	/**
	 * px转dip
	 * @param px
	 * @return
	 */
	public static float px2dip(float px){
		float dessity = getContext().getResources().getDisplayMetrics().density;
		return px/dessity;
	}

	/**
	 * 加载布局文件
	 * @param id
	 * @return
	 */
	public static View inflate(int id){

		return View.inflate(getContext(),id,null);
	}

	/**
	 * 判断是不是运行在主线程上面
	 * @return
	 */
	public static boolean isRunUIThread(){

		int i = Process.myTid();
		if (i == getMainThreadId()){
			return  true;
		}
		return false;
	}

	/**
	 * 运行到主线程
	 * @param r
	 */
	public static void runOnUIThread(Runnable r){

		//如果在主线程直接运行
		if (isRunUIThread() == true){
			r.run();
		}
		else {
			//不是主线程，直接post到主线程
			getHandler().post(r);
		}
	}
 }
