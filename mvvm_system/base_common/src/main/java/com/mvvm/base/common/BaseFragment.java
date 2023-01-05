package com.mvvm.base.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseFragment<VM extends BaseViewModel, DB extends ViewDataBinding> extends Fragment {

    protected VM viewModel = null;
    private Context mContext = null;
    protected DB bd = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewModelConfig config = getViewModelConfig();
        bd = DataBindingUtil.inflate(getLayoutInflater(), config.getLayout(), container, false);
        if (config != null) {
            int variableId = config.getVmVariableId();
            getViewModel();
            if (variableId != ViewModelConfig.VM_NO_BIND) {
                bd.setVariable(variableId, viewModel);
            }
            SparseArray bindindParams = config.getBindingParams();
            int i = 0;
            int length = bindindParams.size();
            while (i < length) {
                bd.setVariable(bindindParams.keyAt(i), bindindParams.valueAt(i));
                i++;
            }
        }

        return bd.getRoot();
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
        } else {
            viewModelClass = BaseViewModel.class;
        }
        viewModel = (VM) new ViewModelProvider(this).get(viewModelClass);
    }

    public abstract void init(Bundle savedInstanceState);

    protected abstract ViewModelConfig getViewModelConfig();
}
