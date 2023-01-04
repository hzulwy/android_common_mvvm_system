package com.mvvm.base.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseFragment<VM extends BaseViewModel, DB extends ViewDataBinding> extends Fragment {

    protected VM viewModel = null;
    private Context mContext = null;
    protected DB bd = null;
    protected ViewModelConfig viewModelConfig = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mContext == null) {
            return null;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(savedInstanceState);

    }

    private void getViewModel() {
        Type type = this.getClass().getGenericSuperclass();
        Class viewModelClass;
        if (type instanceof ParameterizedType) {
            viewModelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
        }else{
            viewModelClass = BaseViewModel.class
        }
        viewModel = (VM) new ViewModelProvider(this).get(viewModelClass);
    }

    public abstract void init(Bundle savedInstanceState);
}
