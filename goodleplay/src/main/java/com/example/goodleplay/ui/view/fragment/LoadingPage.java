package com.example.goodleplay.ui.view.fragment;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 *  创建布局
 *  初始化加载界面
 * Created by yuhaifei on 2017/5/8.
 */

public class LoadingPage extends FrameLayout {

    public LoadingPage(@NonNull Context context) {
        super(context);
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
