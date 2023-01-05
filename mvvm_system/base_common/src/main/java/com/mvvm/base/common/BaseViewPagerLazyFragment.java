package com.mvvm.base.common;

import android.os.Bundle;

import androidx.databinding.ViewDataBinding;

//viewpager2+fragment专用
public abstract class BaseViewPagerLazyFragment<VM extends BaseViewModel, DB extends ViewDataBinding> extends BaseFragment<VM,DB> {

    private boolean isFirstLoad = true; // 是否第一次加载
    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    protected ViewModelConfig getViewModelConfig() {
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(isFirstLoad){
            isFirstLoad =false;
            onFirstShow();
        }
    }

    public abstract void onFirstShow();
}
