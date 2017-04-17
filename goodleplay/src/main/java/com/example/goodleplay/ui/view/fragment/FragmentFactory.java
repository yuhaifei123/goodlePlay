package com.example.goodleplay.ui.view.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by 胡玉娇 on 2017/4/17.
 */

public class FragmentFactory {

	//生产Fragent
	public static Fragment creatFragent(int pid){

		BaseFragment baseFragment = null;
		switch (pid){
			case 0:
				baseFragment = new HomeFragment();
				break;
			case 1:
				baseFragment = new AppFragment();//应用
				break;
			case 2:
				baseFragment = new GameFragment();//游戏
				break;
			case 3:
				baseFragment = new SubjectFrament();//专题
				break;
			case 4:
				baseFragment = new RecommendFragment();//推荐Fragment
				break;
			case 5:
				baseFragment = new CategoryFragment();//分类
				break;
			case 6:
				baseFragment = new HotFragment();//热门
				break;
			default:
				break;
		}

		return baseFragment;
	}
}
