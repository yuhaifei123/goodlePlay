package com.example.goodleplay.ui.view.fragment;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.example.goodleplay.R;
import com.example.goodleplay.utils.UIUtils;

import java.util.HashMap;

import javax.sql.RowSetReader;

/**
 * 创建布局
 * 初始化加载界面
 * Created by yuhaifei on 2017/5/8.
 */

public abstract class LoadingPage extends FrameLayout {

    /**
     * 加载为空
     */
    private View mPage_empty;
    /**
     * 加载错误
     */
    private View mPage_error;

    /**
     * STATE_LOAD_UNOD  == 没有加载
     * STATE_LOAD_LOADING ==加载中
     * STATE_LOAD_ERROR == 加载失败
     * STATE_LOAD_EMPTY == 数据为空
     * STATE_LOAD_SUCCESS == 加载成功
     */
    public enum STATE_LOAD {
        STATE_LOAD_UNOD,
        STATE_LOAD_LOADING,
        STATE_LOAD_ERROR,
        STATE_LOAD_EMPTY,
        STATE_LOAD_SUCCESS
    }

    private View mPageLoading;//加载界面
    private View mSussesssPag;//加载数据揭秘

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
    private void initView() {

        if (mPageLoading == null) {
            mPageLoading = UIUtils.inflate(R.layout.page_loading);
            addView(mPageLoading);
        }

        if (mPage_error == null) {
            mPage_error = (View) UIUtils.inflate(R.layout.page_error);
            addView(mPage_error);
        }


        if (mPage_empty == null) {
            mPage_empty = (View) UIUtils.inflate(R.layout.page_empty);
            addView(mPage_empty);
        }

        this.showRightPage();
    }

    /**
     * 根据当前状态加载那过布局
     */
    public void showRightPage() {

        Log.e("sdfsfs", mCurrentState);

        //判断是不是在加载
        if (mCurrentState.equals(STATE_LOAD.STATE_LOAD_UNOD.name()) || mCurrentState.equals(STATE_LOAD.STATE_LOAD_LOADING.name())) {

            mPageLoading.setVisibility(View.VISIBLE);
        } else {
            mPageLoading.setVisibility(View.GONE);
        }

        //加载错误的情况
        if (mCurrentState.equals(STATE_LOAD.STATE_LOAD_ERROR.name())) {
            mPage_error.setVisibility(View.VISIBLE);
        } else {
            mPage_error.setVisibility(View.GONE);
        }

        if (mCurrentState.equals(STATE_LOAD.STATE_LOAD_EMPTY.name())) {

            mPage_empty.setVisibility(View.VISIBLE);
        } else {
            mPage_empty.setVisibility(View.GONE);
        }

        /**
         * 如果加载状态是正确的，而且展示界面是null，就加载而这个界面
         */
        if (mCurrentState.equals(STATE_LOAD.STATE_LOAD_SUCCESS.name()) && mSussesssPag == null) {

            mSussesssPag = onCreateSuccessView();
            if (mSussesssPag != null){
                addView(mSussesssPag);
            }
        }

        /**
         * 如果这个界面有，要控制是不是，要显示和隐藏
         */
        if (mSussesssPag != null){
            if (mCurrentState.equals(STATE_LOAD.STATE_LOAD_SUCCESS.name())){
                mSussesssPag.setVisibility(View.VISIBLE);
            }
            else {
                mSussesssPag.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 加载数据
     * 请求网络加载数据
     */
    public void  loadData(){

        new Thread(){

            @Override
            public void run() {
                super.run();
                 final ResulState resulState = initData();

                UIUtils.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        if (resulState != null){
                            // 网络加载数据状态，把状态转化成加载界面状态
                            mCurrentState = resulState.getState();
                        }
                        showRightPage();
                    }
                });

            }
        }.start();
    }

    /**
     * 加载成功后展示数据的页面
     *
     * @return
     */
    public abstract View onCreateSuccessView();

    /**
     * 加载数据，返回服务器请求数据的状态
     * @return
     */
    public abstract ResulState initData();

    /**
     * 枚举，其实是一个类，STATE_SUCCESS 好比一个方法  STATE_SUCCESS AA = new STATE_SUCCESS(String data)
     */
    public enum ResulState{
        STATE_SUCCESS(STATE_LOAD.STATE_LOAD_SUCCESS.name()),
        STATE_EMPTY(STATE_LOAD.STATE_LOAD_EMPTY.name()),
        STATE_ERROR(STATE_LOAD.STATE_LOAD_ERROR.name());

        //添加数据属性  给枚举赋值
        private String state;
        ResulState(String state){
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }
}
