package com.example.goodleplay.ui.view.fragment;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.goodleplay.R;
import com.example.goodleplay.utils.UIUtils;

/**
 *  创建布局
 *  初始化加载界面
 * Created by yuhaifei on 2017/5/8.
 */

public class LoadingPage extends FrameLayout {

    /**
     * STATE_LOAD_UNOD  == 没有加载
     * STATE_LOAD_LOADING ==加载中
     * STATE_LOAD_ERROR == 加载失败
     * STATE_LOAD_EMPTY == 数据为空
     * STATE_LOAD_SUCCESS == 加载成功
     */
    public enum STATE_LOAD{
        STATE_LOAD_UNOD,
        STATE_LOAD_LOADING,
        STATE_LOAD_ERROR,
        STATE_LOAD_EMPTY,
        STATE_LOAD_SUCCESS
    }

    private View mPageLoading;//加载界面

    private String mCurrentState = STATE_LOAD.STATE_LOAD_UNOD.name();//默认的状态

    public LoadingPage(@NonNull Context context) {
        super(context);
        this.initView();
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.initView();
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView();
    }

    /**
     * 初始化界面
     */
    private void initView(){

        if (mPageLoading == null){
            mPageLoading = UIUtils.inflate(R.layout.page_loading);
            addView(mPageLoading);
        }

    }
}
