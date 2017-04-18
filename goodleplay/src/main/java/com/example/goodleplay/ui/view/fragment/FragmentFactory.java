package com.example.goodleplay.ui.view.fragment;

import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * Created by 胡玉娇 on 2017/4/17.
 */

public class FragmentFactory {

	private static HashMap<Integer,BaseFragment> mFragmentMap = new HashMap<Integer, BaseFragment>();

	//生产Fragent
	public static Fragment creatFragent(int pid){

		//进来先到集合里面去找
		BaseFragment baseFragment = mFragmentMap.get(pid);
		if (baseFragment == null){
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

			mFragmentMap.put(new Integer(pid),baseFragment);
		}

		return baseFragment;
	}
}
