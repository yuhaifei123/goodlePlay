package com.example.goodleplay.ui.view.fragment;

import android.graphics.Color;
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

	private LoadingPage mLoadingPage;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		mLoadingPage = new LoadingPage(UIUtils.getContext()) {
            @Override
            public View onCreateSuccessView() {
                return null;
            }
        };
		return mLoadingPage;
	}
}
