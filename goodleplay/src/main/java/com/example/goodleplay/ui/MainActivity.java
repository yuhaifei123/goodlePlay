package com.example.goodleplay.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.goodleplay.R;
import com.example.goodleplay.ui.activity.BaseActivity;
import com.example.goodleplay.ui.view.PagerTab;
import com.example.goodleplay.utils.UIUtils;

public class MainActivity extends BaseActivity {

	private ViewPager mViewPage;
	private myAdapter mMyAdapter;
	private PagerTab mPagerTab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.initView();
	}

	/**
	 * 初始化view
	 */
	private void initView(){
		mPagerTab = (PagerTab) findViewById(R.id.pagertab_main);
		mViewPage = (ViewPager) findViewById(R.id.viewpager_main);
		mMyAdapter = new myAdapter(getSupportFragmentManager());

		//填充 cell
		mViewPage.setAdapter(mMyAdapter);
		//在把每個viewPage，放進去
		mPagerTab.setViewPager(mViewPage);

	}

	/**
	 *  Adapter 其实是一个填充器，如tableView中cell 一样
	 */
	class myAdapter extends FragmentPagerAdapter {

		private final String[] mStringArray;

		public myAdapter(FragmentManager fm) {
			super(fm);
			//得到一个数组
			mStringArray = UIUtils.getStringArray(R.array.tab_names);
		}

		//设置标题
		@Override
		public CharSequence getPageTitle(int position) {
			return super.getPageTitle(position);
		}

		//返回当前页面位置的Feagment对象
		@Override
		public Fragment getItem(int position) {
			return null;
		}

		//要几个Fragment
		@Override
		public int getCount() {
			return mStringArray.length;
		}
	}
}
