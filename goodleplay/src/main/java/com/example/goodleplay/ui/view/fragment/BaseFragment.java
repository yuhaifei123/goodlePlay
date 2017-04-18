package com.example.goodleplay.ui.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goodleplay.utils.UIUtils;

/**
 * Created by 胡玉娇 on 2017/4/17.
 */

/**
 * 最大的Fragment,其他的fragment继承与他
 */
public class BaseFragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		TextView textView = new TextView(UIUtils.getContext());
		textView.setText(this.getClass().getSimpleName());
		return textView;
	}
}
