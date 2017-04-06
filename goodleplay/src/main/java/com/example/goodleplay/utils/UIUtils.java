package com.example.goodleplay.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;

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
 }
